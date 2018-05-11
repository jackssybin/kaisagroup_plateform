package com.kaisagroup.plateform.service.user.client.impl;

import com.kaisagroup.plateform.service.user.client.ServiceMsgClient;
import org.springframework.stereotype.Component;

/**
 * Created by jackssy on 2018/5/10.
 */

//@Slf4j
@Component
public class ServiceMsgClientFallback implements ServiceMsgClient {

    @Override
    public String sendFeignMsg(String phone) {
//        log.info("异常发生，进入fallback方法"+msg);
        return "ServiceMsgClient FAILED! - FALLING BACK["+phone+"]";
    }
}
