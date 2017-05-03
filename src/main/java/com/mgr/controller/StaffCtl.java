package com.mgr.controller;

import com.mgr.model.StaffMdl;
import com.mgr.service.StaffSrv;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author mpc
 * @time 2017/5/4.
 */
@Controller
@RequestMapping(value="/cmgr")
public class StaffCtl {
    @Resource
    private StaffSrv staffSrv;

    /**
     * 员工列表
     * @param model
     * @return
     */
    @RequestMapping(value="/staff",method= RequestMethod.GET)
    public ModelAndView staffList(ModelAndView model){
        try{
            List<StaffMdl> staffs = staffSrv.selectList();
            if(staffs.size()==0){
                model.addObject("result","F");
                model.addObject("msg","您还没有员工哇亲!");
            }
        }catch (Exception e){
            e.printStackTrace();
            model.addObject("result","F");
            model.addObject("msg","网络开小差了亲!");
        }
        model.setViewName("cmgr/staff-index");
        return model;
    }

    /**
     * 新增员工
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value="/staff/add",method = RequestMethod.POST)
    public ModelAndView addStaff(HttpServletRequest req,ModelAndView model){

        return model;
    }

    /**
     * 更新员工信息
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value="/staff/update",method = RequestMethod.POST)
    public ModelAndView updateStaff(HttpServletRequest req,ModelAndView model){

        return model;
    }
}
