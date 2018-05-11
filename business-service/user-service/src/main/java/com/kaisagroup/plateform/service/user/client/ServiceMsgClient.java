package com.kaisagroup.plateform.service.user.client;

import com.kaisagroup.plateform.service.user.client.impl.ServiceMsgClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jackssy on 2018/5/10.
 */
@FeignClient(name = "msg-service", fallback = ServiceMsgClientFallback.class)
public interface ServiceMsgClient {

    @RequestMapping(method = RequestMethod.GET, value = "/msg/sendFeignMsg")
    String sendFeignMsg(@RequestParam("phone") String phone);
}
