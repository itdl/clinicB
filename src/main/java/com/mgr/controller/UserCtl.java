package com.mgr.controller;

import com.mgr.model.UserMdl;
import com.mgr.service.IUserSrv;
import com.mgr.util.DateUtil;
import com.mgr.util.GlobalVar;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员管理模块
 * @author mpc
 * @time 2017/4/30.
 */
@Service
@RequestMapping(value="/cmgr")
public class UserCtl {
    @Resource
    private IUserSrv userSrv;

    /**
     * 页面跳转
     * @param html
     * @return
     */
    @RequestMapping(value="/{html}")
    public String htmlGet(@PathVariable String html){
        return "cmgr/"+html;
    }

    /**
     * 管理员列表查询
     * @param model
     * @return
     */
    @RequestMapping(value="/admins",method=RequestMethod.GET)
    public ModelAndView adminList(ModelAndView model,HttpServletRequest req){
        model.setViewName("cmgr/admin-list");
        if(this.validAdmin(req)) {
            model.addObject("result", "F");
            model.addObject("msg", "无操作管理员权限!");
            return model;
        }
        List<UserMdl> admins = userSrv.selectList(new HashMap<String,Object>());
        if(admins.size()!=0){
            model.addObject("admins",admins);
            return model;
        }
        model.addObject("result","F");
        model.addObject("msg","不存在管理员记录请添加管理员");
        return model;
    }

    /**
     * 管理添加
     * @param model
     * @param req
     * @return
     */
    @RequestMapping(value="/admins/addsub",method = RequestMethod.POST)
    public ModelAndView mgrAdd(ModelAndView model, HttpServletRequest req){
        UserMdl user  = new UserMdl();
        model.setViewName("cmgr/admin-add");
        if(this.validAdmin(req)) {
            model.addObject("result", "F");
            model.addObject("msg", "无操作管理员权限!");
            return model;
        }
        if(req.getParameter("name") == null){
            model.addObject("result","F");
            model.addObject("msg","用户名不能为空!");
        }
        if(req.getParameter("pwd") == null){
            model.addObject("result","F");
            model.addObject("msg","用户密码不能为空!");
        }
        user.setUserName(req.getParameter("name"));
        user.setUserPwd(req.getParameter("pwd"));
        user.setUserRole(Integer.parseInt(req.getParameter("power")));
        user.setCreateDate(DateUtil.FormatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        try{
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("userName",user.getUserName());
            List<UserMdl> users = userSrv.selectList(param);
            if(users.size()>0){
                model.addObject("result","F");
                model.addObject("msg","用户已存在!");
                return model;
            }
            userSrv.insert(user);
            model.addObject("result","T");
            model.addObject("msg","管理员添加成功");
            model.setViewName("redirect:/cmgr/admins");
        }catch(Exception e){
            e.printStackTrace();
            model.addObject("result","F");
            model.addObject("msg","管理员添加失败，网络开小差了亲!");
        }
        return model;
    }

    /**
     * 管理员列表查询
     * @param model
     * @return
     */
    @RequestMapping(value="/admins/del",method=RequestMethod.POST)
    public ModelAndView delAdmin(ModelAndView model, HttpServletRequest req){
        if(this.validAdmin(req)) {
            model.addObject("result", "F");
            model.addObject("msg", "无操作管理员权限!");
            return model;
        }
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("userId", req.getParameter("id"));
        try{
            userSrv.delAdmin(param);
        }catch(Exception e){
            e.printStackTrace();
            model.addObject("result","F");
            model.addObject("msg","网络异常亲!");
            return model;
        }
        model.addObject("result","T");
        model.addObject("msg","管理员删除成功!");
        model.setViewName("redirect:/cmgr/admins");
        return model;
    }

    private boolean validAdmin(HttpServletRequest req){
        UserMdl user = (UserMdl)req.getSession().getAttribute(GlobalVar.UINFO);
        if(user.getUserRole() == -1)
            return false;
        return true;
    }
}
