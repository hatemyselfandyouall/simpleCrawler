package com.wangxinenpu.springbootdemo.dataobject;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Institution {

    String bankCode;

    String name;

    String phone;

    String mailCode;

    String adredd;

    @Column(name = "SWIFT")
    String SWIFT;
}
