package com.mgr.serviceImpl;

import com.mgr.dao.YyMapper;
import com.mgr.model.YyRegisterMdl;
import com.mgr.service.YySrv;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author mpc
 * @time 2017/4/22.
 */
@Service
public class YySrvImpl implements YySrv {
    @Resource
    private YyMapper yyMapper;

    public List<YyRegisterMdl> selTodayYyList(Map<String,Object> param) {
        return yyMapper.selTodayYyList(param);
    }
}
