package com.uy.deviceService;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Vehicle {

    private String imei;    //设备号
    private String status;  //车辆状态说明 第三方接口的状态
    private String statusTimeDesc; //状态时长
    private String lng ;    //经度
    private String lat ;    //纬度
    private String speed;   //速度
    private String gpsTime; //定位时间

    private double[] latitudeAndLongitude; //经纬度

    private String vehicleStatus;   //车辆状态 0 未用，1 在线 -1 脱控  -2 所有
    private String vehicleStatus_name;   //车辆状态 0 未用，1 在线 -1 脱控  -2 所有

    private String licenseNumber;   //车牌号
    private String vin; //车架号
    private String opeartTime;  //操作时间
    private String opeart;  //操作人

    public Vehicle() {

    }

    public Vehicle(String vehicleStatus, String licenseNumber) {
        this.vehicleStatus = vehicleStatus;
        this.licenseNumber = licenseNumber;
        this.statusTimeDesc = "未绑定GPS设备";
        this.vehicleStatus_name = "未用";
        this.imei = "";
    }

}
