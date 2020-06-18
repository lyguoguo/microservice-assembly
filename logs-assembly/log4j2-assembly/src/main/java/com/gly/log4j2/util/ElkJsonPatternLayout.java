package com.gly.log4j2.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gly.common.utils.DateUtil;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.*;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.layout.PatternSelector;
import org.apache.logging.log4j.core.pattern.RegexReplacement;
import org.slf4j.MDC;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * ELK日志格式
 *
 * @Author lnk
 * @Date 2018/3/13
 */
@Plugin(name = "ElkJsonPatternLayout", category = Node.CATEGORY, elementType = Layout.ELEMENT_TYPE, printObject = true)
public class ElkJsonPatternLayout extends AbstractStringLayout {

    private PatternLayout patternLayout;
    private String serviceName;

    private ElkJsonPatternLayout(Configuration config, RegexReplacement replace, String eventPattern,
                                 PatternSelector patternSelector, Charset charset, boolean alwaysWriteExceptions,
                                 boolean noConsoleNoAnsi, String headerPattern, String footerPattern, String serviceName) {
        super(config, charset,
                PatternLayout.newSerializerBuilder().build(),
                PatternLayout.newSerializerBuilder().build());
        this.serviceName = serviceName;
        this.patternLayout = PatternLayout.newBuilder()
                .withPattern(eventPattern)
                .withPatternSelector(patternSelector)
                .withConfiguration(config)
                .withRegexReplacement(replace)
                .withCharset(charset)
                .withAlwaysWriteExceptions(alwaysWriteExceptions)
                .withNoConsoleNoAnsi(noConsoleNoAnsi)
                .withHeader(headerPattern)
                .withFooter(footerPattern)
                .build();
    }

    @PluginFactory
    public static ElkJsonPatternLayout createLayout(
            @PluginAttribute(value = "pattern", defaultString = PatternLayout.DEFAULT_CONVERSION_PATTERN) final String pattern,
            @PluginElement("PatternSelector") final PatternSelector patternSelector,
            @PluginConfiguration final Configuration config,
            @PluginElement("Replace") final RegexReplacement replace,
            // LOG4J2-783 use platform default by default, so do not specify defaultString for charset
            @PluginAttribute(value = "charset") final Charset charset,
            @PluginAttribute(value = "alwaysWriteExceptions", defaultBoolean = true) final boolean alwaysWriteExceptions,
            @PluginAttribute(value = "noConsoleNoAnsi", defaultBoolean = false) final boolean noConsoleNoAnsi,
            @PluginAttribute("header") final String headerPattern,
            @PluginAttribute("footer") final String footerPattern,
            @PluginAttribute("serviceName") final String serviceName) {
        return new ElkJsonPatternLayout(config, replace, pattern, patternSelector, charset,
                alwaysWriteExceptions, noConsoleNoAnsi, headerPattern, footerPattern, serviceName);
    }

    @Override
    public String toSerializable(LogEvent event) {
        String jsonStr = new JsonLoggerInfo(
                event.getThreadName(), event.getLevel().name(), event.getLoggerName(),
                patternLayout.toSerializable(event), null == event.getThrown() ? "" : event.getThrown().toString(),
                event.getThreadId(), event.getThreadPriority(),
                null == event.getSource() ? "" : event.getSource().toString(),
                DateUtil.formateDate(new Date(event.getTimeMillis())),
                MDC.get("traceId"), MDC.get("cfClientIp"), MDC.get("cfHead"), MDC.get("cfPath"), MDC.get("cfParams"),
                serviceName).toString();
        return jsonStr + "\n";
    }


    /**
     * 输出的日志内容
     */
    public static class JsonLoggerInfo {
        private String thread;
        private String level;
        private String loggerName;
        private String message;
        private String thrown;
        private Long threadId;
        private Integer threadPriority;
        private String source;
        private String timestamp;
        private String traceId;
        private String cfClientIp;
        private String cfHead;
        private String cfPath;
        private String cfParams;
        private String serviceName;

        public JsonLoggerInfo(String thread, String level, String loggerName, String message, String thrown, Long threadId,
                              Integer threadPriority, String source, String timestamp, String traceId, String cfClientIp, String cfHead,
                              String cfPath, String cfParams, String serviceName) {
            this.thread = thread;
            this.level = level;
            this.loggerName = loggerName;
            this.message = message;
            this.thrown = thrown;
            this.threadId = threadId;
            this.threadPriority = threadPriority;
            this.source = source;
            this.timestamp = timestamp;
            this.traceId = traceId;
            this.cfClientIp = cfClientIp;
            this.cfHead = cfHead;
            this.cfPath = cfPath;
            this.cfParams = cfParams;
            this.serviceName = serviceName;
        }

        public String getThread() {
            return thread;
        }

        public String getLevel() {
            return level;
        }

        public String getLoggerName() {
            return loggerName;
        }

        public String getMessage() {
            return message;
        }

        public String getThrown() {
            return thrown;
        }

        public Long getThreadId() {
            return threadId;
        }

        public Integer getThreadPriority() {
            return threadPriority;
        }

        public String getSource() {
            return source;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public String getTraceId() {
            return traceId;
        }

        public String getCfClientIp() {
            return cfClientIp;
        }

        public String getCfHead() {
            return cfHead;
        }

        public String getCfPath() {
            return cfPath;
        }

        public String getCfParams() {
            return cfParams;
        }

        public String getServiceName() {
            return serviceName;
        }

        @Override
        public String toString() {
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
                        .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
                return mapper.writeValueAsString(this);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}