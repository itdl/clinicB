package com.mgr.controller;

import com.alibaba.dubbo.common.json.JSON;
import com.mgr.model.StaffMdl;
import com.mgr.service.StaffSrv;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            List<StaffMdl> staffs = staffSrv.selectList(null);
            if(staffs.size()==0){
                model.addObject("result","F");
                model.addObject("msg","您还没有员工哇亲!");
                return model;
            }
            model.addObject("staffs",staffs);
        }catch (Exception e){
            e.printStackTrace();
            model.addObject("result","F");
            model.addObject("msg","网络开小差了亲!");
        }
        model.setViewName("cmgr/staff-index");
        return model;
    }

    /**
     * 员工详情信息页
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value="/staff/details")
    public ModelAndView deatilStaff(HttpServletRequest req,ModelAndView model){
        List<StaffMdl> staffs= new ArrayList<StaffMdl>();
        if(req.getParameter("id") != null){
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id",req.getParameter("id"));
            try{
                staffs = staffSrv.selectList(param);
                if(staffs.size()==0){
                    model.addObject("result","F");
                    model.addObject("msg","亲没有查到员工信息哇!");
                }
            }catch (Exception e){
                e.printStackTrace();
                model.addObject("result","F");
                model.addObject("msg","网络开小差了亲!");
                model.setViewName("cmgr/staff-index");
                return model;
            }
        }
        model.addObject("staff",staffs.size()==0?new StaffMdl():staffs.get(0));
        model.setViewName("cmgr/staff-details");
        return model;
    }

    /**
     * 新增员工信息
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value="/staff/add",method = RequestMethod.POST)
    public ModelAndView addStaff(HttpServletRequest req,ModelAndView model){
        model.setViewName("cmgr/staff-details");
        model.addObject("staff",new StaffMdl());
        if(req.getParameter("name")==null || req.getParameter("name").trim().equals("")){
            model.addObject("result","F");
            model.addObject("msg","用户名不能为空");
            return model;
        }
        if(req.getParameter("phone")==null || req.getParameter("phone").trim().equals("")){
            model.addObject("result","F");
            model.addObject("msg","电话号不能为空");
            return model;
        }
        Map<String,String[]> param = req.getParameterMap();
        try{
            StaffMdl staff = new StaffMdl();
            staff.setAddress((!param.containsKey("address"))||req.getParameter("address").equals("")
                    ?"无":req.getParameter("address"));
            staff.setAge((!param.containsKey("age"))||param.get("age")[0].equals("")
                    ?0:Integer.parseInt(req.getParameter("age")));
            staff.setBirthday((!param.containsKey("birthday"))||req.getParameter("birthday").equals("")
                    ?null:req.getParameter("birthday"));
            staff.setCard(req.getParameter("card"));
            staff.setEdu((!param.containsKey("edu"))||req.getParameter("edu").equals("")
                    ?-1:Integer.parseInt(req.getParameter("edu")));
            staff.setIsjob((!param.containsKey("isjob"))||req.getParameter("isjob").equals("")
                    ?-1:Integer.parseInt(req.getParameter("isjob")));
            staff.setJob_date((!param.containsKey("job_date"))||req.getParameter("job_date").equals("")
                    ?null:req.getParameter("job_date"));
            staff.setName(req.getParameter("name"));
            staff.setOld_pro((!param.containsKey("old_pro"))||req.getParameter("old_pro").equals("")
                    ?"无":req.getParameter("old_pro"));
            staff.setPay((!param.containsKey("pay"))||req.getParameter("pay").equals("")
                    ?0:Double.parseDouble(req.getParameter("pay")));
            staff.setPhone((!param.containsKey("phone"))||req.getParameter("phone").equals("")
                    ?"无":req.getParameter("phone"));
            staff.setPro((!param.containsKey("pro"))||req.getParameter("pro").equals("")
                    ?"无":req.getParameter("pro"));
            staff.setSex((!param.containsKey("sex"))||req.getParameter("sex").equals("")
                    ?-1:Integer.parseInt(req.getParameter("sex")));
            staff.setUnjob_date((!param.containsKey("unjob_date"))||req.getParameter("unjob_date").equals("")
                    ?null:req.getParameter("unjob_date"));
            staff.setYear_work((!param.containsKey("year_work"))||req.getParameter("year_work").equals("")
                    ?0:Double.parseDouble(req.getParameter("year_work")));
            staffSrv.insertStaff(staff);
            model.addObject("msg","添加成功!");
            model.addObject("result","T");
        }catch(Exception e){
            e.printStackTrace();
            model.addObject("result","F");
            model.addObject("msg","网络开小差了亲!");
        }
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
        model.setViewName("cmgr/staff-details");
        model.addObject("staff",new StaffMdl());
        if(req.getParameter("name")==null || req.getParameter("name").trim().equals("")){
            model.addObject("result","F");
            model.addObject("msg","用户名不能为空");
            return model;
        }
        if(req.getParameter("phone")==null || req.getParameter("phone").trim().equals("")){
            model.addObject("result","F");
            model.addObject("msg","电话号不能为空");
            return model;
        }
        try{
            StaffMdl staff = new StaffMdl();
            staff.setId(Integer.parseInt(req.getParameter("id")));
            staff.setAddress(req.getParameter("address"));
            staff.setAge(Integer.parseInt(req.getParameter("age")));
            staff.setBirthday(req.getParameter("birthday"));
            staff.setCard(req.getParameter("card"));
            staff.setEdu(Integer.parseInt(req.getParameter("edu")));
            staff.setIsjob(Integer.parseInt(req.getParameter("isjob")));
            staff.setJob_date(req.getParameter("job_date"));
            staff.setName(req.getParameter("name"));
            staff.setOld_pro(req.getParameter("old_pro"));
            staff.setPay(Double.parseDouble(req.getParameter("pay")));
            staff.setPhone(req.getParameter("phone"));
            staff.setPro(req.getParameter("pro"));
            staff.setSex(Integer.parseInt(req.getParameter("sex")));
            staff.setUnjob_date(req.getParameter("unjob_date"));
            staff.setYear_work(Double.parseDouble(req.getParameter("year_work")));
            staffSrv.updateStaff(staff);
            model.addObject("msg","更新成功!");
            model.addObject("result","T");

        }catch(Exception e){
            e.printStackTrace();
            model.addObject("result","F");
            model.addObject("msg","网络开小差了亲!");
        }
        return model;
    }
    /**
     * 员工详情信息页
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value="/staff/del")
    public ModelAndView delStaff(HttpServletRequest req,ModelAndView model){
        model.setViewName("cmgr/staff-details");
        if(req.getParameter("id") != null){
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id",req.getParameter("id"));
            try{
                staffSrv.delStaff(param);
                model.addObject("result","T");
                model.addObject("msg","删除成功!");
                model.setViewName("redirect:/cmgr/staff");
                return model;
            }catch (Exception e){
                e.printStackTrace();
                model.addObject("result","F");
                model.addObject("msg","网络开小差了亲!");
                return model;
            }
        }
        model.addObject("result","F");
        model.addObject("msg","用户id不能为空!");
        return model;
    }
}
