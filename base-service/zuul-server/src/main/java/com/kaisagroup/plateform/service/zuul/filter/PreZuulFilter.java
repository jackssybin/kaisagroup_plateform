package com.kaisagroup.plateform.service.zuul.filter;

/**
 * Created by jackssy on 2018/5/11.
 */
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PreZuulFilter extends ZuulFilter{
    private final static Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;//数字越大越靠后
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest servletRequest = RequestContext.getCurrentContext().getRequest();
        String host = servletRequest.getRemoteHost();
        PreZuulFilter.LOGGER.info("request host : " + host);
        return null;
    }
}