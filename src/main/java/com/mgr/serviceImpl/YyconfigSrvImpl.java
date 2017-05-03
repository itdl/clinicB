package com.mgr.serviceImpl;

import com.mgr.dao.YyconfigMapper;
import com.mgr.model.YyconfigMdl;
import com.mgr.service.YyconfigSrv;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by BikeBoy on 2017/4/16.
 */
@Service
public class YyconfigSrvImpl implements YyconfigSrv {
    @Resource
    private YyconfigMapper yyconfigMapper;
    @Override
    public int insertDate(Map<String,Object> date) {
        return yyconfigMapper.insertDate(date);
    }

    @Override
    public List<YyconfigMdl> selCfgDate(Map<String, Object> date) {
        return yyconfigMapper.selCfgDate(date);
    }
}
