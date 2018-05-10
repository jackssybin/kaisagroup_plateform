package com.kaisagroup.plateform.service.user.client.impl;

import com.kaisagroup.plateform.service.user.client.ServiceMsgClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by jackssy on 2018/5/10.
 */
@Component
@Slf4j
public class ServiceMsgClientFallback implements ServiceMsgClient {

    @Override
    public String sendMsg() {
        log.info("异常发生，进入fallback方法");
        return "ServiceMsgClient FAILED! - FALLING BACK";
    }
}
