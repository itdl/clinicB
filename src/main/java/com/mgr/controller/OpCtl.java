package com.mgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 今日门诊模块
 * @author mpc
 * @time 2017/4/20.
 */
@Controller
@RequestMapping(value="/op")
public class OpCtl {
    @RequestMapping(value="/{html}",method = RequestMethod.GET)
    public String goOp(@PathVariable String html){
        return "op/op-"+html;
    }
}
