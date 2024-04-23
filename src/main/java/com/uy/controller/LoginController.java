package com.uy.controller;

import com.uy.pojo.TUser;
import com.uy.service.impl.TUserServiceImpl;
import com.uy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private TUserServiceImpl tUserService ;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result userLogin(@RequestBody TUser tUser){
        Result result = tUserService.userLogin(tUser) ;
//        System.out.println("result:"+result);
        return  result;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result userRegister(@RequestBody TUser tUser){
        System.out.println("tUser:"+tUser);

        return tUserService.userRegister(tUser);
    }

}
