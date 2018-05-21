package com.kaisagroup.plateform.service.user.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jackssy on 2018/5/10.
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    @LoadBalanced //负载全靠他了
    public RestTemplate restTemplate(){return new RestTemplate();};

/*    @Autowired
    private SpringClientFactory springClientFactory;*/

    /**
     * RandomRule 随机策略
     * RoundRobinRule 轮询策咯
     * BestAvailableRule 最少并发数策略
     * @return
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }*/
}
