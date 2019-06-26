package com.wangxinenpu.springbootdemo.dao.mapper;



import com.wangxinenpu.springbootdemo.dataobject.Institution;
import com.wangxinenpu.springbootdemo.dataobject.Test;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface InstitutionMapper extends Mapper<Institution>,InsertListMapper<Institution> {

}