package com.gly.log4j2.filters;

import com.alibaba.fastjson.JSON;
import com.gly.common.utils.RequestUtil;
import com.gly.common.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Order(0)
@WebFilter(urlPatterns = {"/*"})
public class MDCFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        try {
            MDC.put("traceId", UUIDUtil.createUUID());
            MDC.put("cfPath", request.getRequestURI());
            MDC.put("cfClientIp", RequestUtil.getIp(request));
            MDC.put("cfParams", JSON.toJSONString(request.getParameterMap()));
            MDC.put("cfHead", JSON.toJSONString(RequestUtil.allHead(request)));
            chain.doFilter(new ContentCachingRequestWrapper(request), response);
        } catch (Exception exception) {
            log.error("Web端traceId处理异常", exception);
        } finally {
            MDC.clear();
        }
    }

}
