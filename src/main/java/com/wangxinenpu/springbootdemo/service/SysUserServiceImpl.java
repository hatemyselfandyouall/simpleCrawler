package com.wangxinenpu.springbootdemo.service;

import com.wangxinenpu.springbootdemo.dao.mapper.SysUserMapper;
import com.wangxinenpu.springbootdemo.dao.mapper.TestMapper;
import com.wangxinenpu.springbootdemo.dataobject.SysUser;
import com.wangxinenpu.springbootdemo.dataobject.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    TestMapper testMapper;
    @Override
    public Test getById(Integer id) {
        return testMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysUser findUser(SysUser sysUser) {
        return sysUserMapper.selectOne(sysUser);
    }
}
