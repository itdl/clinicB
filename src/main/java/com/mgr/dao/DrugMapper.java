package com.mgr.dao;

import com.mgr.model.DrugMdl;

import java.util.List;
import java.util.Map;

/**
 * Created by BikeBoy on 2017/4/24.
 */
public interface DrugMapper {
    int addDrug(Map<String,Object> param);
    List<DrugMdl> selDrug(Map<String,Object> param);
}
