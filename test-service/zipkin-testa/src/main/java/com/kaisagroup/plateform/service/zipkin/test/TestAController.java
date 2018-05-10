package com.kaisagroup.plateform.service.zipkin.test;

import com.kaisagroup.plateform.service.zipkin.test.client.ServiceBClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by jackssy on 2018/5/7.
 */
@RestController
public class TestAController {

    private static final Logger LOG = Logger.getLogger(TestAController.class.getName());

    @Value("${name:unknown}")
    private String name;



    @Autowired
    private ServiceBClient serviceBClient;

    @RequestMapping(value = "/hello",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String printServiceA() {
        return serviceBClient.printServiceB();
    }

}
