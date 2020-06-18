package com.gly.common.utils;

import org.slf4j.MDC;

public class TraceIdUtil {

    /**
     * traceId
     */
    public static final String TRACE_ID = "traceId";

    public static void createTraceId() {
        MDC.put(TRACE_ID, UUIDUtil.createUUID());
    }
    
    public static void setTraceId(String traceId) {
        MDC.put(TRACE_ID, traceId);
    }
    
    public static String get() {

        return MDC.get(TRACE_ID);
    }

    public static void clearTraceId() {
        MDC.clear();
    }

}
