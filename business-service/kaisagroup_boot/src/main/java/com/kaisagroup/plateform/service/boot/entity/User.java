package com.kaisagroup.plateform.service.boot.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


@Data
@Slf4j
public class User {

    private int uid;
    private String uname;
    private Date birth;
}
