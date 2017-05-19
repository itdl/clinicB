package com.mgr.controller;

import com.mgr.dao.DrugMapper;
import com.mgr.model.DrugMdl;
import com.mgr.service.DrugSrv;
import com.mgr.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /**
     * 药品添加
     * @param req
     * @param model
     * @return
     */
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
        param.put("price", DateUtil.FormatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
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

    /**
     * 药品盘点信息
     * @param model
     * @return
     */
    @RequestMapping(value="/check",method=RequestMethod.GET)
    public ModelAndView drugCheck(ModelAndView model){
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

    /**
     * 药品详情信息查询
     * @param model
     * @param req
     * @return
     */
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

    /**
     * 药品列表
     * @param model
     * @return
     */
    @RequestMapping(value="/stocks",method=RequestMethod.GET)
    public ModelAndView outStockList(ModelAndView model){
        model.setViewName("drug/drug-outstock");
        try{
            List<DrugMdl> drugList = drugSrv.selDrug(new HashMap<String,Object>());
            if(drugList.size()==0){
                model.addObject("flag","F");
                model.addObject("msg","亲您库里暂时还没有药品库存呀");
                return model;
            }
            model.addObject("drugs",drugList);
        }catch(Exception e){
            e.printStackTrace();
            model.addObject("msg","亲网络异常啦!");
            model.addObject("flag","F");
        }
        return model;
    }

    /**
     * 药品出库
     * @param req
     * @return
     */
    @RequestMapping(value="/outstock",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> drugOutStock(HttpServletRequest req){
        Map<String,Object> param = new HashMap<String,Object>();
        if(req.getParameter("stockAct")==null||
                req.getParameter("code")==null){
            param.put("flag","F");
            param.put("msg","出库数量或者药品编号不能为空！");
            return param;
        }
        param.put("code",req.getParameter("code"));
        try{
            List<DrugMdl> drugs = drugSrv.selDrug(param);
            if(drugs.size()==0){
                param.clear();
                param.put("flag","F");
                param.put("msg","药品编号不存在");
                return param;
            }

            int stockAct = Integer.parseInt(req.getParameter("stockAct"));
            int counts = Integer.parseInt(drugs.get(0).getCounts());
            if(counts < stockAct){
                param.clear();
                param.put("flag","F");
                param.put("msg","药品数量出库数量超过库存了亲，请重新刷新页面");
                return param;
            }else{
                param.put("counts",counts-stockAct);
            }

            try{
                drugSrv.updateDrugAct(param);
                param.clear();
                param.put("flag","T");
                param.put("msg","药品出库成功!");
            }catch(Exception e){
                e.printStackTrace();
                param.clear();
                param.put("flag","F");
                param.put("msg","网络异常了亲!");
            }
        }catch(Exception e){
            e.printStackTrace();
            param.clear();
            param.put("flag","F");
            param.put("msg","网络异常了亲!");
        }
        return param;
    }
}
