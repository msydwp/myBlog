package com.uy.contfig;

import com.uy.inter.LoginInterception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Autowired
    public LoginInterception LoginInterception(){
        return new LoginInterception();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加不拦截路径
//        List<String> excludeList = new ArrayList<String>();
//        excludeList.add("/cs/**");
//        excludeList.add("/user/**");
//        excludeList.add("/figps/**");
//
//        //注册拦截器
//        registry.addInterceptor(LoginInterception())
//                .addPathPatterns("/**")
//                .excludePathPatterns(excludeList);
    }
}