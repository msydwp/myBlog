package com.uy.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cs")
public class TestController {

    @RequestMapping(value = "/cs1",method = RequestMethod.POST)
    public void cs(){
        System.out.println("spring boot 项目 开始。。。");
    }


}
