package com.mgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 药品管理控制层
 * @author mpc
 * @time 2017/03/12
 */
@Controller
@RequestMapping("/drug")
public class DrugCtl {
    /**
     * 页面跳转
     * @param html
     * @return
     */
    @RequestMapping(value="/{html}")
    public String htmlGet(@PathVariable String html){
        return "drug/drug-"+html;
    }
}
