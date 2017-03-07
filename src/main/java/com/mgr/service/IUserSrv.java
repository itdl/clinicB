package com.mgr.service;

import java.util.Map;

/**
 * mybatis mapper interface
 * @author
 * @time 2017/3/2.
 */
public interface IUserSrv {
    /**
     * 用户数据注册
     * @param param
     * @return
     */
    int insert(Map<String, Object> param);
}
