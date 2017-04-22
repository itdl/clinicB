package com.mgr.controller;

import com.mgr.model.YyRegisterMdl;
import com.mgr.service.YySrv;
import com.mgr.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 今日门诊模块
 * @author mpc
 * @time 2017/4/20.
 */
@Controller
@RequestMapping(value="/op")
public class OpCtl {
    @Resource
    private YySrv yySrv;

    /**
     * 获取今天的预约门诊
     * @param model
     * @return
     */
    @RequestMapping(value="/today",method = RequestMethod.GET)
    public ModelAndView goOp(ModelAndView model){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("rptFlg",0);
        param.put("registerDate", DateUtil.FormatDate(new Date(),"yyyy-MM-dd"));
        List<YyRegisterMdl> yys = yySrv.selTodayYyList(param);
        if(yys!=null){
            model.addObject("yys",yys);
        }else{
            model.addObject("msg","今天无患者预约信息");
        }
        model.setViewName("op/op-today");
        return model;
    }
}
