package com.wwx.Login.service.impl;

import com.wwx.Login.mapper.LoginMapper;
import com.wwx.Login.model.Login;
import com.wwx.Login.model.LoginExample;
import com.wwx.Login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper mapper;
    @Override
    public long countByExample(LoginExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LoginExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String userId) {
        return mapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(Login record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Login record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Login> selectByExample(LoginExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Login selectByPrimaryKey(String userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByExampleSelective(Login record, LoginExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Login record, LoginExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Login record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Login record) {
        return mapper.updateByPrimaryKey(record);
    }
}
