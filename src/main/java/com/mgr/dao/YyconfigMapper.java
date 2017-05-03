package com.mgr.dao;

import com.mgr.model.YyconfigMdl;

import java.util.List;
import java.util.Map;

/**
 * 客户端-注册-配置
 * @author mpc
 * @time 2017/4/16.
 */
public interface YyconfigMapper {
    int insertDate(Map<String,Object> date);
    List<YyconfigMdl> selCfgDate(Map<String,Object> date);
    int chgConfig(Map<String,Object> param);
}
