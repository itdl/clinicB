package com.mgr.dao;

import com.mgr.model.UserMdl;

import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserMdl record);

    int insertSelective(UserMdl record);

    UserMdl selByUnamePwd(Map<String,Object> param);

    int updateByPrimaryKeySelective(UserMdl record);

    int updateByPrimaryKey(UserMdl record);
}