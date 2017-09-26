package com.mgr.serviceImpl;

import com.mgr.dao.DrugMapper;
import com.mgr.model.DrugMdl;
import com.mgr.service.DrugSrv;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by BikeBoy on 2017/4/24.
 */
@Service
public class DrugSrvImpl implements DrugSrv {

    @Resource
    private DrugMapper drugMapper;

    @Override
    public int addDrug(Map<String, Object> param) {
        return drugMapper.addDrug(param);
    }

    @Override
    public List<DrugMdl> selDrug(Map<String, Object> param) {
        return drugMapper.selDrug(param);
    }

    @Override
    public int updateDrugAct(Map<String, Object> param) {
        return drugMapper.updateDrugAct(param);
    }

    @Override
    public List<DrugMdl> search(Map<String, Object> param) {
        return drugMapper.search(param);
    }
}
