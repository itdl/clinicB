package com.mgr.dao;

import com.mgr.model.UserMdl;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int delAdmin(Map<String,Object> param);

    int insert(UserMdl record);

    int insertSelective(UserMdl record);

    UserMdl selByUnamePwd(Map<String,Object> param);

    int updateByPrimaryKey(UserMdl record);

    List<UserMdl> selectList();
}