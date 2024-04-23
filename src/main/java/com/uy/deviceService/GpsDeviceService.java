package com.uy.deviceService;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.uy.redis.RedisTemplateUtils;
import com.uy.util.CoordinateUtils;
import com.uy.util.HttpUtils;
//import io.lettuce.core.cluster.ClusterConnectionProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GpsDeviceService {

    @Autowired
    private GpsTokenService gpsTokenService;

    @Autowired
    private RedisTemplateUtils redisTemplateUtils;

    private final String REDISRESFRESHKEY = "jshwchj_vehicleStatisticalItems";

    /**
     * Construct
     * @param deviceRequest
     * @return
     */
    public VehicleStatisticalItems getGpsDeviceList(DeviceRequest deviceRequest){
        VehicleStatisticalItems result = new VehicleStatisticalItems();

        String isRefresh = deviceRequest.getIsRefresh();

        //刷新  如果该字段为0  redis中有数据则直接返回
        if( "0".equals(isRefresh) ){
            return getRedisGpsDeviceList(deviceRequest);    //从redis中获取数据
        }

        List<Map<String,Object>> devices = TestData.getTestC02Data();

        //获取所有设备号
        List<String> imeiList = devices.stream()
                .filter(e -> !ObjectUtils.isEmpty(e.get("c02014")))
                .map(e -> e.get("c02014").toString())
                .collect(Collectors.toList());

        //没有对应设备号的车辆
        List<Vehicle> vehicleList = devices.stream()
                .filter(e -> ObjectUtils.isEmpty(e.get("c02014")))
                .map(e -> { return new Vehicle("0",e.get("c02002").toString());})
                .collect(Collectors.toList());

        if(imeiList.size() > 0){
            List<Vehicle> vehicleList2 = getAllImelStatus(imeiList);
            vehicleList.addAll(vehicleList2);
        }

        //将设备状态统计项与车辆列表信息合并
        result = getVehicleStatisticalItems(vehicleList);

        //将本次数据临时存储在reids中
        redisTemplateUtils.set(REDISRESFRESHKEY, result,60*30);


        return result;
    }

    /**
     * 获取所有对应设备
     * @param deviceRequest
     * @return
     */
    public VehicleStatisticalItems getRedisGpsDeviceList(DeviceRequest deviceRequest) {
        List<Vehicle> vehicleList = new ArrayList<>();


        VehicleStatisticalItems vehicleStatisticalItems = (VehicleStatisticalItems) redisTemplateUtils.get(REDISRESFRESHKEY);
        vehicleList = vehicleStatisticalItems.getVehicleList();

        String params = deviceRequest.getParams();

        //如果查询参数不为空 则过滤车辆
        if(StringUtils.isNotEmpty(params)){
            vehicleList = vehicleList.stream()
                    .filter(e -> e.getLicenseNumber().contains(params) ||  e.getImei().contains(params))
                    .collect(Collectors.toList());
        }

        String vehicleStatus = deviceRequest.getVehicleStatus();

        //如果车辆状态为-2 则返回所有车辆
        if(!StringUtils.isEmpty(vehicleStatus) && "-2".equals(vehicleStatus)){
            vehicleStatisticalItems.setVehicleList(vehicleList);
            return vehicleStatisticalItems;
        }

        //过滤车辆状态
        vehicleList = vehicleList.stream().filter(e -> vehicleStatus.equals(e.getVehicleStatus())).collect(Collectors.toList());
        vehicleStatisticalItems.setVehicleList(vehicleList);

        return  vehicleStatisticalItems ;
    }

        /**
         * 将车辆信息和统计项合并
         * @param vehicleList
         * @return
         */
    public VehicleStatisticalItems getVehicleStatisticalItems(List<Vehicle> vehicleList){
        VehicleStatisticalItems result = new VehicleStatisticalItems();

//        List<Vehicle> vehicleList = vehicle.getVehicleList();

        //车辆总数
        result.setCount(String.valueOf(vehicleList.size()));

        //在线车辆数
        long onlineCount = vehicleList.stream().filter(e -> "1".equals(e.getVehicleStatus())).count();
        result.setOnlineCount(String.valueOf(onlineCount));

        //脱控车辆数
        long offlineCount = vehicleList.stream().filter(e -> "-1".equals(e.getVehicleStatus())).count();
        result.setOfflineCount(String.valueOf(offlineCount));

        //未用车辆数
        long unusedCount = vehicleList.stream().filter(e -> "0".equals(e.getVehicleStatus())).count();
        result.setUnusedCount(String.valueOf(unusedCount));

        result.setVehicleList(vehicleList);
        return result;
    }

    /**
     * 按车查询设备状态
     * @return
     */
    public List<Vehicle> getAllImelStatus(List<String> imeiList) {
        List<Vehicle> result = new ArrayList<>();

        String imels = imeiList.stream().collect(Collectors.joining(","));

        String url = "https://open.figps.com/api/device/status";

        String token = gpsTokenService.getToken();

        String params = "?accessToken="+token+"&imei="+imels;

        log.info("url:"+url+",设备状态查询参数："+params+",url+params:"+url+params);
//
//        try {
//            String json = HttpUtils.sendGetRequest(url+params);
//            JSONObject jsonObject = JSONObject.parseObject(json);
//
//            String code = jsonObject.getString("code");
//
//            if(code == null || !"0".equals(code)){
//                log.error("设备状态查询失败,错误码为："+code+",错误信息为："+jsonObject.getString("result"));
//            }
//
//            List<Map<String,Object>> dataList = (List<Map<String, Object>>) jsonObject.get("data");
//
//            // 使用 Stream 进行处理
//            result = dataList.stream()
//                    .map(map -> {
//                        Vehicle vehicle = new Vehicle();
//                        vehicle.setImei(map.get("imei").toString());  //imei
//                        String speed = map.get("speed").toString();
//                        vehicle.setSpeed(speed); //速度
//                        vehicle.setLicenseNumber(map.get("licenseNumber").toString());  //车牌号
//                        String status = map.get("status").toString();//status 状态说明：静止，行驶，休眠, 未启用，离线
//                        String vehicleStatus = "0";
//                        String vehicleStatus_name = "未用";
//
//                        if("静止".equals(status) || "行驶".equals(status) || "休眠".equals(status)){
//                            vehicleStatus = "1";
//                            vehicleStatus_name = "在线";
//                        }else if("未启用".equals(status)){
//                            vehicleStatus = "0";
//                        }else if("离线".equals(status) && !"0".equals(speed)){
//                            vehicleStatus = "-1";
//                            vehicleStatus_name = "脱控";
//                        }
//                        vehicle.setStatus(map.get("status").toString());  //imei
//                        vehicle.setVehicleStatus(vehicleStatus);
//                        vehicle.setVehicleStatus_name(vehicleStatus_name);
//
//                        String statusTimeDesc = map.get("statusTimeDesc").toString();
//                        if(StringUtils.isEmpty(statusTimeDesc)){
//                            statusTimeDesc = "暂无定位信息";
//                        }
//
//                        vehicle.setStatusTimeDesc(statusTimeDesc);//状态时长
//                        String lng = map.get("lng").toString();
//                        String lat = map.get("lat").toString();
//                        vehicle.setLng(lng); //经度
//                        vehicle.setLat(lat); //纬度
//
//                        vehicle.setGpsTime(map.get("gpsTime").toString());
//
//                        double[] lngAndLat = new double[2];
//                        lngAndLat[0] = Double.valueOf(lng);
//                        lngAndLat[1] = Double.valueOf(lat);
//
//                        vehicle.setLatitudeAndLongitude(lngAndLat);
//
//                        return vehicle;
//                    })
//                    .collect(Collectors.toList());
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }

        return result;
    }


//    /**
//     * 按车查询设备位置
//     * @return
//     */
//    @Scheduled(fixedRate = 15000) // 定义定时任务，每隔15秒执行一次
//    public void checkIn(){
//        // 打卡地点的经度和纬度范围
//        double checkInLongitude = 40.7128;  // 打卡地点的经度
//        double checkInLatitude = -74.0060; // 打卡地点的纬度
//        double range = 0.01;                // 接受范围
//
//        double checkInLongitude2 = 121.400505;
//        double checkInLatitude2 = 30.797647;
//
//
//        // 判断是否在范围内
//        if(CoordinateUtils.isWithinRange(lng,lat,checkInLongitude,checkInLatitude,range){
//
//        }
//    }
//
//    /**
//     * 查询车辆设备位置
//     */
//    public Vehicle getVehicleAddress(){
//
//        List<Map<String,Object>> vehicleData = TestData.getTestC02Data();
//
//        if(vehicleData == null || vehicleData.size() == 0){
//            return null;
//        }
//
//
//
//    }


    public void getVehileHistory(){


        String url = "https://open.figps.com/api/device/track/history?accessToken=b6322604253811eea90b0242c0482194&imei=863014541340758&onlyGps=1&coordType=gcj02&startTime=1689430701&endTime=1689689901";

        String token = gpsTokenService.getToken();


        try {
            String json = HttpUtils.sendGetRequest(url);
            JSONObject jsonObject = JSONObject.parseObject(json);

            String code = jsonObject.getString("code");

            if(code == null || !"0".equals(code)){
                log.error("设备状态查询失败,错误码为："+code+",错误信息为："+jsonObject.getString("result"));
            }

            List<Map<String,Object>> dataList = (List<Map<String, Object>>) jsonObject.get("data");

            if(dataList == null){
                return;
            }



            double[] datas = new double[2];
            List<double[]> row = new ArrayList<double[]>();

            ListIterator<Map<String,Object>> listIterator = dataList.listIterator();
            while(listIterator.hasNext()){
                Map<String,Object> data = listIterator.next();

                datas = new double[2];

                double lng = Double.valueOf(data.get("lng").toString());
                double lat = Double.valueOf(data.get("lat").toString());

                System.out.println(lat+","+lng);
                datas[0] = lng;
                datas[1] = lat;

                row.add(datas);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }


        return;
    }



}
