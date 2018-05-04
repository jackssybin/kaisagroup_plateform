package com.kaisagroup.plateform.service.config.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jackssy on 2018/4/28.
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${foot:test}") // git配置文件里的key
    String foot;

    @RequestMapping(value = "/hi")
    public String hi(){
        return foot;
    }
}
