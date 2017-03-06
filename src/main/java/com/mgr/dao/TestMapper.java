package com.mgr.dao;

import com.mgr.model.Test;

public interface TestMapper {
    int insert(Test record);

    int insertSelective(Test record);
}