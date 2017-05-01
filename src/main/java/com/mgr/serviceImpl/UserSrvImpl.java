package com.mgr.serviceImpl;

import com.mgr.dao.UserMapper;
import com.mgr.model.UserMdl;
import com.mgr.service.IUserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
    public int insert(UserMdl user) {
        return userMapper.insert(user);
    }

    @Override
    public UserMdl selByUnamePwd(Map<String, Object> param) {
        return userMapper.selByUnamePwd(param);
    }

    @Override
    public List<UserMdl> selectList() {
        return userMapper.selectList();
    }

    @Override
    public int delAdmin(Map<String, Object> param) {
        return userMapper.delAdmin(param);
    }
}
