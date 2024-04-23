package com.uy.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uy.mapper.HoldactivitiesMapper;
import com.uy.pojo.Holdactivities;
import com.uy.pojo.TUser;
import com.uy.redis.RedisTemplateUtils;
import com.uy.service.HoldactivitiesService;
import com.uy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author my
* @description 针对表【holdActivities】的数据库操作Service实现
* @createDate 2023-01-19 20:02:04
*/
@Service
public class HoldactivitiesServiceImpl extends ServiceImpl<HoldactivitiesMapper, Holdactivities>
    implements HoldactivitiesService {

    @Autowired
    private RedisTemplateUtils redisTemplateUtils ;

    @Override
    public Result queryData(Holdactivities holdactivities) {
        Map<String,Object> map = new HashMap<>() ;

        if(ObjectUtils.isEmpty(holdactivities)){
            return Result.<TUser>builder()
                    .code(HttpStatus.FORBIDDEN.value())
                    .message("请先登陆再操作！！")
                    .data(null)
                    .build();
        }

        String uid = holdactivities.getSponsor();
        List<Integer> statusList = new ArrayList<>();
        statusList.add(1);
//        map.put("statusList",statusList);
//        map.put("userName",holdactivities.);


//        TUser user =
        return null;
    }
}




