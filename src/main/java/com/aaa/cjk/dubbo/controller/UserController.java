package com.aaa.cjk.dubbo.controller;

import com.aaa.cjk.dubbo.model.User;
import com.aaa.cjk.dubbo.service.IUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author 陈佳康
 * @date 2019-09-06 18:58
 * 登陆界面
 * 以及与用户有关的配置
 */
@Controller
public class UserController {
    
    /**
    * @author  陈佳康
    * @description 不能使用autowrie注入，因为该接口没有对应的实现类
    * @params 需要使用dubbo所提供的@Reference
    */
    @Reference
    private IUserService userService;

    @RequestMapping("/")
    public String turnLoginPage(){
        return "login";
    }


    /**
    * @author  陈佳康
    * @description 处理用户登录信息
    * @params [user]
    * @return  
    * @date  
    */
    @RequestMapping("/userLogin")
    public String login(User user){

        Map<String, Object> resultMap = userService.getOneUser(user);
        int code = (Integer) resultMap.get("code");

        if (200 == code){
            return "book_index";
        }
        return "404";
    }

}
