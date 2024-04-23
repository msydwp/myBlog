package com.uy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uy.pojo.Holdactivities;
import com.uy.util.Result;

/**
* @author my
* @description 针对表【holdActivities】的数据库操作Service
* @createDate 2023-01-19 20:02:04
*/
public interface HoldactivitiesService extends IService<Holdactivities> {

    Result queryData(Holdactivities holdactivities);

}
