package com.mgr.service;

import com.mgr.model.YyRegisterMdl;

import java.util.List;
import java.util.Map;

/**
 * Created by BikeBoy on 2017/4/22.
 */
public interface YySrv {
    List<YyRegisterMdl> selTodayYyList(Map<String,Object> param);
    List<YyRegisterMdl> selResumeList(Map<String,Object> param);
    int selStoods(Map<String,Object> param);
}
