package com.uy.deviceController;

import com.uy.deviceService.DeviceRequest;
import com.uy.deviceService.GpsDeviceService;
import com.uy.deviceService.GpsTokenService;
import com.uy.deviceService.VehicleStatisticalItems;
import com.uy.pojo.TUser;
import com.uy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/figps")
public class FigpsDeviceController {

    @Autowired
    private GpsTokenService gpsTokenService;

    @Autowired
    private GpsDeviceService gpsDeviceService;

    @RequestMapping("/token")
    public Result getToken() {

//        String token = gpsTokenService.getToken();
        gpsDeviceService.getVehileHistory();

        return Result.<Object>builder()
                .code(HttpStatus.OK.value())
                .message("身份令牌获取成功 ")
                .data("")
                .build();
    }

    /**
     *  车辆监控列表和统计项
     * @param deviceRequest
     * @return
     */
    @RequestMapping(value = "/deviceList",method = RequestMethod.POST)
    public Result getGpsDeviceList(@RequestBody DeviceRequest deviceRequest){

        VehicleStatisticalItems vehicleStatisticalItems = gpsDeviceService.getGpsDeviceList(deviceRequest);

        return Result.<VehicleStatisticalItems>builder()
                .code(HttpStatus.OK.value())
                .message("车辆监控列表和统计项获取成功")
                .data(vehicleStatisticalItems)
                .build();
    }

    /**
     *  车辆历史轨迹回放
     * @param deviceRequest
     * @return
     */
    @RequestMapping(value = "/history11111",method = RequestMethod.POST)
    public Result getGpsDeviceHistoryList(@RequestBody DeviceRequest deviceRequest){

//        VehicleStatisticalItems vehicleStatisticalItems = gpsDeviceService.getGpsDeviceList(deviceRequest);

        gpsDeviceService.getVehileHistory();
        return Result.<VehicleStatisticalItems>builder()
                .code(HttpStatus.OK.value())
                .message("车辆监控列表和统计项获取成功")
                .data(null)
                .build();
    }

//    /**
//     *  车辆实时打卡
//     * @return
//     */
//    @RequestMapping(value = "/checkin",method = RequestMethod.POST)
//    public Result checkIn(){
//
//        VehicleStatisticalItems vehicleStatisticalItems = gpsDeviceService.getGpsDeviceList(deviceRequest);
//
//        return Result.<VehicleStatisticalItems>builder()
//                .code(HttpStatus.OK.value())
//                .message("车辆监控列表和统计项获取成功")
//                .data(vehicleStatisticalItems)
//                .build();
//    }


}
