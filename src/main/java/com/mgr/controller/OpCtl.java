package com.mgr.controller;

import com.mgr.model.YyRegisterMdl;
import com.mgr.service.YySrv;
import com.mgr.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView goOpToday(ModelAndView model){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("rptFlg",0);
        param.put("registerDate", DateUtil.FormatDate(new Date(),"yyyy-MM-dd"));
        List<YyRegisterMdl> yys = yySrv.selTodayYyList(param);
        if(yys.size()!=0){
            model.addObject("yys",yys);
        }else{
            model.addObject("msg","今天无患者预约信息");
        }
        model.setViewName("op/op-today");
        return model;
    }

    /**
     * 获取患者病历列表
     * @param model
     * @return
     */
    @RequestMapping(value="/resume",method = RequestMethod.GET)
    public ModelAndView goOpResume(ModelAndView model){
        try{
            List<YyRegisterMdl> resumes = yySrv.selResumeList(new HashMap<String,Object>());
            model.addObject("patients",resumes);
            if(resumes.size()==0){
                model.addObject("flag","F");
                model.addObject("msg","亲您暂无患者病历信息！");
            }
        }catch(Exception e){
            model.addObject("flag","F");
            model.addObject("msg","亲网络异常啦！");
        }
        model.setViewName("op/op-resume");
        return model;
    }

    /**
     * 获取患者病历列表
     * @param model
     * @return
     */
    @RequestMapping(value="/resume/detail",method = RequestMethod.POST)
    public ModelAndView goResumeDetl(ModelAndView model, HttpServletRequest req,RedirectAttributes attr){
        model.setViewName("redirect:/op/resume");
        try{
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("userId",req.getParameter("userId"));
            List<YyRegisterMdl> resumes = yySrv.selResumeList(param);
            if(resumes.size()==0){
                attr.addFlashAttribute("msg","亲未查询到患者病历信息！");
                attr.addFlashAttribute("flag","F");
                return model;
            }
            resumes.get(0).setRegisterTime(String.valueOf(yySrv.selStoods(param)));
            param.put("rptFlg",3);
            resumes.get(0).setStoodAcount(yySrv.selStoods(param));
            model.addObject("patient",resumes.get(0));
            model.setViewName("op/op-resdetl");
        }catch(Exception e){
            e.printStackTrace();
            attr.addFlashAttribute("msg","亲网络异常啦！");
            attr.addFlashAttribute("flag","F");
        }
        return model;
    }
}
