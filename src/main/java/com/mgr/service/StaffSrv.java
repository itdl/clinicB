package com.mgr.service;

import com.mgr.model.StaffMdl;

import java.util.List;
import java.util.Map;

/**
 * 员工操作
 *
 * @author mpc
 * @time 2017/5/4.
 */
public interface StaffSrv {

    List<StaffMdl> selectList();

    int updateStaff(Map<String, Object> param);

    int insertStaff(StaffMdl staffMdl);
}
