package com.uy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uy.pojo.TUser;
import org.springframework.stereotype.Repository;

/**
* @author my
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-11-29 10:41:39
* @Entity generator.domain.TUser
*/
@Repository
public interface TUserMapper extends BaseMapper<TUser> {

    Integer selectUserCount( TUser tUser);

}




