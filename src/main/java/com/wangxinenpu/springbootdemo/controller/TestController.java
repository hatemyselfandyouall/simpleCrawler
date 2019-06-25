package com.wangxinenpu.springbootdemo.controller;

import com.wangxinenpu.springbootdemo.dataobject.SysUser;
import com.wangxinenpu.springbootdemo.dataobject.Test;
import com.wangxinenpu.springbootdemo.service.SysUserService;
import com.wangxinenpu.springbootdemo.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "test")
@Slf4j
public class TestController {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("hello")
    public String hello(){
        log.info("hello log");
        return "hello Spring";
    }

    @RequestMapping(value = "mybtaisTest",method = RequestMethod.GET)
    public ResultVo<Test> mybtaisTest(@RequestParam(value = "id")Integer id){
        ResultVo<Test> resultVo=new ResultVo<>();
        try {
            Test sysUser=sysUserService.getById(id);
            resultVo.setSuccess(true);
            resultVo.setResult(sysUser);
        }catch (Exception e){
            log.error("获取测试库数据异常",e);
            resultVo.setResultDes("获取测试库数据异常");
            resultVo.setCode("500");
        }
        return resultVo;
    }

    @RequestMapping(value = "redisTest",method = RequestMethod.GET)
    public SysUser redisTest(){
//        for (int i=0;i<10;i++) {
//            redisTemplate.opsForValue().set(i+"","缓存测试"+i);
//        }
        for (int i=0;i<10;i++){
            log.info(redisTemplate.opsForValue().get(i+"")+"");
        }
        return null;
    }
}
