package com.mgr.service;

import com.mgr.model.UserMdl;

import java.util.List;
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
    int insert(UserMdl user);
    UserMdl selByUnamePwd(Map<String,Object> param);
    List<UserMdl> selectList(Map<String,Object> param);
    int delAdmin(Map<String,Object> param);
}
