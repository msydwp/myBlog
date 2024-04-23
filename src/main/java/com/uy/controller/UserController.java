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
@RequestMapping("/UserBlog")
public class UserController {

    @Autowired
    private TUserServiceImpl tUserService ;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public Result userLogin(@RequestBody TUser tUser){

        return  tUserService.queryUser(tUser);
    }

}
