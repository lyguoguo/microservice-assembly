//package com.gly.test.filter;
//
//import com.alibaba.fastjson.JSON;
//import com.gly.test.utils.RequestUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
//import org.apache.skywalking.apm.toolkit.trace.Trace;
//import org.apache.skywalking.apm.toolkit.trace.TraceContext;
//import org.slf4j.MDC;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.UUID;
//
//@Slf4j
//@WebFilter(filterName = "requestWrapperFilter", urlPatterns = "/*")
//public class RequestFilter implements Filter {
//
//    public static final String TRACE_ID = "trace";
//    public static final String SPAN_ID = "span";
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    /**
//     * 初始化请求链路信息：唯一key，日志初始化，body包装防止获取日志打印时后续不能继续使用
//     */
//    @Override
//    @Trace(operationName = "requestWrapperFilter")
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//        throws IOException, ServletException {
////        String contextString = ((HttpServletRequest) request).getHeader(ProjectContext.CONTEXT_KEY);
////        if (Objects.nonNull(contextString)) {
////            ProjectContext.fromString(contextString);
////        } else {
////            // 无内容时，也自动初始化
////            ProjectContext.initContext();
////        }
//        initLog();
//
////
////        CustomHttpServletRequestWrapper requestWrapper = new CustomHttpServletRequestWrapper(
////            (HttpServletRequest) request);
////        String uri = requestWrapper.getRequestURI();
////        String remoteAddr = requestWrapper.getRemoteAddr();
////        String method = requestWrapper.getMethod();
////
////        String requestStr;
//
//
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//
////        MDC.put("cfPath", ((HttpServletRequest) request).getRequestURI());
////        MDC.put("cfClientIp", RequestUtil.getIp(request));
////        MDC.put("cfParams", JSON.toJSONString(request.getParameterMap()));
////        MDC.put("cfHead", JSON.toJSONString(RequestUtil.allHead(request)));
////
////        if (method.equals(RequestMethod.GET.name())) {
////            requestStr = GsonUtil.toJson(requestWrapper.getParameterMap());
////        } else {
////            requestStr = requestWrapper.getBody();
////        }
//        ActiveSpan.tag("request", JSON.toJSONString(request.getParameterMap()));
//        log.info("请求参数：{}",JSON.toJSONString(request.getParameterMap()));
////        log.info(
////            "url:{} , method:{}, clientIp:{}, params:{}", uri, method, remoteAddr, requestStr);
//        log.info("TID：{}", TraceContext.traceId());
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//    public static void initLog() {
////        MDC.put(TRACE_ID, ProjectContext.getContext().getTraceId());
////        MDC.put(SPAN_ID, ProjectContext.getContext().getSpanId());
//        MDC.put("traceId", UUID.randomUUID().toString().replace("-", ""));
//
//    }
//}
