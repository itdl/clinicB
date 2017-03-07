package com.mgr.controller;

import com.mgr.config.ParamCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主页
 * @author
 * @time 2017/3/2
 */
@Controller
public class LoginCtl {
    @Autowired
    private ParamCfg paramCfg;

    @RequestMapping(value={"/login","/"},method= RequestMethod.GET )
    public String login(){
        int a = paramCfg.getCoresize();
        int b = paramCfg.getKeepAliveTime();
        int c = paramCfg.getMaxsize();
        System.out.println("Welcome to login! Tp = "+a +'/'+b +'/'+c +'/');
        return "login";
    }

    /**
     * 登录主页
     * @return
     */
    @RequestMapping(value="/index",method= RequestMethod.GET )
    public String index(){
        System.out.println("Welcome to index!");
        return "index";
    }

    /**
     * 页面跳转
     * @param html
     * @return
     */
    @RequestMapping(value="/{html}")
    public String htmlGet(@PathVariable String html){
        System.out.println("Welcome to "+html+" !");
        return html;
    }
}