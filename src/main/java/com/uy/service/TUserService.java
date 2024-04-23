package com.uy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uy.pojo.TUser;
import com.uy.util.Result;

/**
* @author my
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-11-29 10:41:39
*/
public interface TUserService extends IService<TUser> {

    Result userLogin(TUser tUser);

    Result userRegister(TUser tUser);


}
