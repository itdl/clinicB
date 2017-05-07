package com.mgr.serviceImpl;

import com.mgr.dao.StaffMapper;
import com.mgr.model.StaffMdl;
import com.mgr.service.StaffSrv;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by BikeBoy on 2017/5/4.
 */
@Service
public class StaffSrvImpl implements StaffSrv {
    @Resource
    private StaffMapper staffMapper;

    @Override
    public List<StaffMdl> selectList(Map<String,Object> param) {
        return staffMapper.selectList(param);
    }

    @Override
    public int updateStaff(StaffMdl staffMdl) {
        return staffMapper.updateStaff(staffMdl);
    }

    @Override
    public int insertStaff(StaffMdl staffMdl) {
        return staffMapper.insertStaff(staffMdl);
    }

    @Override
    public int delStaff(Map<String, Object> param) {
        return staffMapper.delStaff(param);
    }
}
