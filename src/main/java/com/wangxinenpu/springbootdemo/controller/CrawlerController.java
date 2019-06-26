package com.wangxinenpu.springbootdemo.controller;

import com.wangxinenpu.springbootdemo.dao.mapper.InstitutionMapper;
import com.wangxinenpu.springbootdemo.dataobject.Institution;
import com.wangxinenpu.springbootdemo.util.CrawlerUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "crawler")
@Slf4j
public class CrawlerController {

    private static String  url="http://www.5cm.cn/bank/zhejiang/{index}/";

    @Autowired
    InstitutionMapper institutionMapper;

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("test")
    public String hello(){
        RestTemplate restTemplate=new RestTemplate();
        for (Integer i=1;i<=182;i++){
            String tempUrl=url.replace("{index}",i.toString());
            String totalReturnStr=restTemplate.getForObject(tempUrl,String.class);
            Elements tableString= CrawlerUtil.getTableString(totalReturnStr);
            List<Institution> institutions=CrawlerUtil.getInsStringList(tableString);
            institutionMapper.insertList(institutions);
        }
        return "hello Spring";
    }

}
