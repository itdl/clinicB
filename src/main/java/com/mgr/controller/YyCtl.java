package com.mgr.controller;

import com.mgr.model.YyconfigMdl;
import com.mgr.service.YySrv;
import com.mgr.service.YyconfigSrv;
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
 * 预约配置控制层
 * @author mpc
 * @time 2017/03/12
 */
@Controller
@RequestMapping(value="/yy")
public class YyCtl {
    @Resource
    private YyconfigSrv yyconfigSrv;

    /**
     * 预约列表主页
     * @param model
     * @return
     */
    @RequestMapping(value="",method=RequestMethod.GET)
    public ModelAndView goYyMgr(ModelAndView model){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("registerDate",DateUtil.FormatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        try{
            List<YyconfigMdl> cfgs = yyconfigSrv.selCfgDate(param);
            model.addObject("yyCfgs",cfgs);
        }catch(Exception e){
            e.printStackTrace();
            model.addObject("result","F");
            model.addObject("msg","网络开小差了亲!");
        }
        model.setViewName("yy/yy-index");
        return model;
    }

    /**
     * 停诊信息配置
     * @param req
     * @return
     */
    @RequestMapping(value="/chg",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> cfgChg(HttpServletRequest req){
        Map<String,Object> param = new HashMap<String,Object>();
        if(req.getParameter("date")==null){
            param.put("result","T");
            param.put("msg","预约配置更新成功!");
            return param;
        }
        param.put("date",req.getParameter("date"));
        param.put("time",req.getParameter("time"));
        param.put("used",req.getParameter("used"));
        try{
            yyconfigSrv.chgConfig(param);
            param.clear();
            param.put("result","T");
            param.put("msg","预约配置更新成功!");
        }catch(Exception e){
            e.printStackTrace();
            param.clear();
            param.put("result","F");
            param.put("msg","网络开小差了亲!");
        }
        return param;
    }
}
