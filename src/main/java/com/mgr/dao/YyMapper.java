package com.mgr.dao;

import com.mgr.model.YyRegisterMdl;

import java.util.List;
import java.util.Map;

/**
 * 预约查询
 * @author mpc
 * @time 2017/4/16.
 */
public interface YyMapper {
    List<YyRegisterMdl> selTodayYyList(Map<String,Object> param);
    List<YyRegisterMdl> selResumeList(Map<String,Object> param);
    int selStoods(Map<String,Object> param);
}
