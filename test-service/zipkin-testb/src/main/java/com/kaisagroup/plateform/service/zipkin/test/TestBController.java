package com.kaisagroup.plateform.service.zipkin.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jackssy on 2018/5/7.
 */
@RestController
public class TestBController {

    private static final Logger LOG = Logger.getLogger(TestBController.class.getName());



    @Value("${msg:unknown}")
    private String msg;

    @RequestMapping(value = "/hello",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String printServiceB() {
        return  "===>Say " + msg;
    }

}
