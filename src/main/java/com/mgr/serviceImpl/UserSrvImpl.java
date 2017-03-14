package com.mgr.serviceImpl;

import com.mgr.dao.UserMapper;
import com.mgr.model.UserMdl;
import com.mgr.service.IUserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @author
 * @time 2017/3/2.
 */
@Service
public class UserSrvImpl implements IUserSrv {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(Map<String, Object> param) {
        return 0;
    }

    @Override
    public UserMdl selByUnamePwd(Map<String, Object> param) {
        return userMapper.selByUnamePwd(param);
    }
}
