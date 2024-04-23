package com.uy.controller;

import com.uy.pojo.Characters;
import com.uy.pojo.TUser;
import com.uy.service.impl.CharactesServicesImpl;
import com.uy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characterData")
public class CharactesController {

    @Autowired
    private CharactesServicesImpl charactesServices;

    @RequestMapping(value = "/getInfoData",method = RequestMethod.POST)
    public Result getInfoData(@RequestBody Characters characters){

        charactesServices.getCharacterInfo(characters);

        return null;
//        return charactesServices.userRegister(tUser);
    }
}
