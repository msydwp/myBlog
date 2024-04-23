package com.uy.otherController;

import com.uy.pojo.Holdactivities;
import com.uy.service.impl.HoldactivitiesServiceImpl;
import com.uy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otherBlog")
public class otherController {

    @Autowired
    private HoldactivitiesServiceImpl holdactivitiesService ;

    @RequestMapping(value = "/cashGift",method = RequestMethod.POST)
    public Result giftMoney(@RequestBody Holdactivities holdactivities){

        return null;
    }

}
