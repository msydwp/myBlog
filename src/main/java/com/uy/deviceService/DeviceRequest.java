package com.uy.deviceService;

import lombok.Data;

@Data
public class DeviceRequest {

    private String isRefresh;   //是否刷新
    private String vehicleStatus;       //车辆状态 0 未用，1 启用 -1 脱控 -2全部
    private String params;      //查询参

}
