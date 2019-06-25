package com.wangxinenpu.springbootdemo.service;

import com.wangxinenpu.springbootdemo.dataobject.SysUser;
import com.wangxinenpu.springbootdemo.dataobject.Test;
import org.springframework.stereotype.Service;

public interface SysUserService {

    Test getById(Integer id);

    SysUser findUser(SysUser sysUser);
}
