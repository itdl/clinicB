package com.mgr.controller;

import com.mgr.config.ParamCfg;
import com.mgr.model.UserMdl;
import com.mgr.service.IUserSrv;
import com.mgr.util.GlobalVar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 首页与登录
 * @author
 * @time 2017/3/2
 */
@Controller
public class LoginCtl {
    @Autowired
    private IUserSrv userSrv;

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
    @RequestMapping(value="/index",method= RequestMethod.POST )
    public ModelAndView index(HttpServletRequest req, HttpServletResponse res, ModelAndView mv){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("userName",req.getParameter("uName"));
        param.put("userPwd",req.getParameter("uPwd"));
        UserMdl user = userSrv.selByUnamePwd(param);
        if( user==null ){
            mv.addObject("msg","用户名和密码错误,请重新输入!");
            mv.addObject("fg","error");
            mv.setViewName("/");
            return mv;
        }
        req.getSession().setAttribute(GlobalVar.UINFO,user);
        mv.setViewName("index");
        return mv;
    }

    /**
     * 退出登录
     * @param req
     * @param mv
     * @return
     */
    @RequestMapping(value="/quit",method= RequestMethod.GET )
    public ModelAndView loginOut(HttpServletRequest req, ModelAndView mv){
        req.getSession().removeAttribute(GlobalVar.UINFO);
        req.getSession().invalidate();
        mv.setViewName("/");
        return mv;
    }
}