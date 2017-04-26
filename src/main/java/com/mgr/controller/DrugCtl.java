package com.mgr.controller;

import com.mgr.dao.DrugMapper;
import com.mgr.model.DrugMdl;
import com.mgr.service.DrugSrv;
import com.mgr.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 药品管理控制层
 * @author mpc
 * @time 2017/03/12
 */
@Controller
@RequestMapping("/drug")
public class DrugCtl {
    @Resource
    private DrugSrv drugSrv;

    /**
     * 页面跳转
     * @param html
     * @return
     */
    @RequestMapping(value="/{html}")
    public String htmlGet(@PathVariable String html){
        return "drug/drug-"+html;
    }

    @RequestMapping(value = "/addDrug",method = RequestMethod.POST)
    public ModelAndView drugAdd(HttpServletRequest req, ModelAndView model){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("code",req.getParameter("code"));
        param.put("name",req.getParameter("name"));
        param.put("type",req.getParameter("type"));
        param.put("attention",req.getParameter("attention"));
        param.put("format",req.getParameter("format"));
        param.put("prd_date",req.getParameter("prd_date"));
        param.put("valid_date",req.getParameter("valid_date"));
        param.put("shape",req.getParameter("shape"));
        param.put("counts",req.getParameter("counts"));
        param.put("prd_phone",req.getParameter("prd_phone"));
        param.put("prd_firm",req.getParameter("prd_firm"));
        param.put("uses",req.getParameter("uses"));
        param.put("dosage",req.getParameter("dosage"));
        param.put("remark",req.getParameter("remark"));
        param.put("create_date", DateUtil.FormatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        param.put("update_date", DateUtil.FormatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        model.setViewName("drug/drug-add");
        try{
            drugSrv.addDrug(param);
            model.addObject("msg","添加成功");
            model.addObject("flag","T");
        }catch(Exception e){
            e.printStackTrace();
            model.addObject("msg","网络开小差了亲");
            model.addObject("flag","F");
        }
        return model;
    }

    @RequestMapping(value="/check",method=RequestMethod.GET)
    public ModelAndView drugCheck(ModelAndView model){
        Map<String,Object> param = new HashMap<String,Object>();
        try{
            List<DrugMdl> drugs = drugSrv.selDrug(new HashMap<String,Object>());
            model.addObject("drugs",drugs);
        }catch(Exception e){
            e.printStackTrace();
            model.addObject("msg","未添加药品信息!");
            model.addObject("flag","F");
        }
        model.setViewName("drug/drug-check");
        return model;
    }

    @RequestMapping(value="/details",method=RequestMethod.POST)
    public ModelAndView drugSearch(ModelAndView model,HttpServletRequest req){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("code",req.getParameter("code"));
        try{
            List<DrugMdl> drugs = drugSrv.selDrug(param);
            if(drugs.size()==0){
                model.setViewName("drug/drug-check");
                model.addObject("msg","未查到相关药品信息");
                model.addObject("flag","F");
                return model;
            }
            model.setViewName("drug/drug-details");
            model.addObject("drug",drugs.get(0));
        }catch(Exception e){
            e.printStackTrace();
            model.setViewName("drug/drug-check");
            model.addObject("msg","网络异常了亲~");
            model.addObject("flag","F");
        }
        return model;
    }
}
