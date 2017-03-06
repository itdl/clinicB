package com.mgr.controller;

import com.mgr.config.ParamCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主页
 * @author song
 * @time 2017/3/2
 */
@Controller
public class LoginCtl {
    @Autowired
    private ParamCfg paramCfg;

    @RequestMapping(value="/login",method= RequestMethod.GET )
    public String login(){
        System.out.println("Welcome to login!");
        return "login";
    }
    @RequestMapping(value="/index",method= RequestMethod.GET )
    public String index(){
        System.out.println("Welcome to index!");
        return "index";
    }
}