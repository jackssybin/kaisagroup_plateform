package com.kaisagroup.plateform.service.user.client;

import com.kaisagroup.plateform.service.user.client.impl.ServiceMsgClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jackssy on 2018/5/10.
 */
@FeignClient(name = "msg-service", fallback = ServiceMsgClientFallback.class)
public interface ServiceMsgClient {

    @GetMapping(value = "/sendMsg")
    String sendMsg();
}
