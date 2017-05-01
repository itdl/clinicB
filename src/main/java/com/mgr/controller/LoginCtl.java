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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
     * 登录页面
     * @return
     */
    @RequestMapping(value="/index",method= RequestMethod.GET )
    public String index(){
        return "index";
    }

    /**
     * 登录跳转到主页
     * @param req
     * @return
     */
    @RequestMapping(value="/main",method= RequestMethod.POST )
    public String index(HttpServletRequest req, RedirectAttributes attr){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("userName",req.getParameter("uName"));
        param.put("userPwd",req.getParameter("uPwd"));
        UserMdl user = userSrv.selByUnamePwd(param);
        if( user==null ){
            attr.addFlashAttribute("msg","用户名和密码错误,请重新输入!");
            attr.addFlashAttribute("fg","error");
            return "redirect:/";
        }
        req.getSession().setAttribute(GlobalVar.UINFO,user);
        req.getSession().setAttribute("isAdm",user.getUserId()==1?true:false);
        return "index";
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