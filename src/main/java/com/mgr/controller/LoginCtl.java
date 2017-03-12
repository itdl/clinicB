package com.mgr.controller;

import com.mgr.config.ParamCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 首页与登录
 * @author
 * @time 2017/3/2
 */
@Controller
public class LoginCtl {

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value="/",method= RequestMethod.GET )
    public String login(){
        return "login";
    }

    /**
     * 登录跳转到主页
     * @param req
     * @param mv
     * @return
     */
    @RequestMapping(value="/login",method= RequestMethod.POST )
    public ModelAndView index(HttpServletRequest req, ModelAndView mv){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("userName",req.getParameter("userName"));
        param.put("userPwd",req.getParameter("userPwd"));

        mv.setViewName("/index");
        return mv;
    }
}