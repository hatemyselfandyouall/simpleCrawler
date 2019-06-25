package com.wangxinenpu.springbootdemo.dataobject;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Test {
    @Id
    private Long id;

    private String name;
}
