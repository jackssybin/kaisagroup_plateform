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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jackssy on 2018/5/10.
 */
@RestController
@RequestMapping("/userMsg")
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
    @RequestMapping(value = "sentRibbonMsg", method = RequestMethod.GET)
    public BaseResp sentRibbonMsg(@RequestParam("phone") String phone, @RequestParam("password") String password  ) {

        ServiceInstance serviceInstance = this.loadBalancerClient.choose(msgRibbonService);
        log.info("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());// 打印当前调用服务的信息
        String restUrl="http://"+msgRibbonService+"/msg/pingUserPwd/121212121/aaaa";
        BaseResp resp = this.restTemplate.getForObject(restUrl , BaseResp.class);
        return resp;
    }

    @RequestMapping(value = "sendFeignMsg", method = RequestMethod.GET)
    public BaseResp sendFeignMsg(@RequestParam("phone") String phone) {
        BaseResp resp = new BaseResp();
        resp.setErrorMessage(serviceMsgClient.sendFeignMsg(phone));

        return resp;
    }
}
