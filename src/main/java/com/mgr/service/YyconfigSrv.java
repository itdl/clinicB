package com.mgr.service;

import com.mgr.model.YyconfigMdl;

import java.util.List;
import java.util.Map;

/**
 * Created by BikeBoy on 2017/4/16.
 */
public interface YyconfigSrv {
    int insertDate(Map<String,Object> date);
    List<YyconfigMdl> selCfgDate(Map<String,Object> date);
}
