package com.kaisagroup.plateform.service.user.controller;

import com.kaisagroup.plateform.common.web.BaseResp;
import com.kaisagroup.plateform.service.user.client.ServiceMsgClient;
import com.kaisagroup.plateform.service.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jackssy on 2018/5/10.
 */
@RestController
@RequestMapping("/user/msg")
@Slf4j
public class UserMessageController {

    @Autowired
    IUserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${ribbon.service.msg.name:msg-service}")
    private String msgRibbonService;

    @Autowired
    private ServiceMsgClient serviceMsgClient;

    /**
     * 注册
     *
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "sentRibbon", method = RequestMethod.GET)
    public BaseResp sentRibbon(String phone, String password) {

        ServiceInstance serviceInstance = this.loadBalancerClient.choose(msgRibbonService);
        log.info("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());// 打印当前调用服务的信息
        BaseResp resp = this.restTemplate.getForObject("http://"+msgRibbonService+"/msg/ping" , BaseResp.class);
        return resp;
    }

    @RequestMapping(value = "sentFeign", method = RequestMethod.GET)
    public BaseResp sentFeign(String phone) {
        BaseResp resp = new BaseResp();
        resp.setErrorMessage(serviceMsgClient.sendMsg());

        return resp;
    }
}
