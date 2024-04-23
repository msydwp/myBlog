package com.uy.deviceService;

import lombok.Data;

import java.util.List;

@Data
public class VehicleStatisticalItems {

    private String count;       //所有车辆数
    private String onlineCount;     //在线车辆数
    private String offlineCount;    //脱控车辆数
    private String unusedCount;    //未用车辆数

    private List<Vehicle> vehicleList;  //车辆列表


}
