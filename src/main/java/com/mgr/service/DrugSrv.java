package com.mgr.service;

import com.mgr.model.DrugMdl;

import java.util.List;
import java.util.Map;

/**
 * Created by BikeBoy on 2017/4/24.
 */
public interface DrugSrv {
    int addDrug(Map<String,Object> param);
    List<DrugMdl> selDrug(Map<String,Object> param);
}

