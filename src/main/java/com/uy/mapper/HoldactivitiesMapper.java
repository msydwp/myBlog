package com.uy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uy.pojo.Holdactivities;

import java.util.List;
import java.util.Map;

/**
* @author my
* @description 针对表【holdActivities】的数据库操作Mapper
* @createDate 2023-01-19 20:02:04
* @Entity generator.domain.Holdactivities
*/
public interface HoldactivitiesMapper extends BaseMapper<Holdactivities> {

    List<Holdactivities> queryHoldData(Map<String,Object> map);

}




