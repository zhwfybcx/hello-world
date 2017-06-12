package com.zwf.cms.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 * Created by user on 2017/3/21.
 */
public class LoggerUtil {

    /** 日志编号修饰符 */
    private static final String LOG_TOKEN_MARKER = "[{0}]";

    /** 线程编号修饰符 */
    private static final String THREAD_MARKER    = "[{0}]";

    /**
     * 禁用构造函数
     */
    private LoggerUtil() {
        // 禁用构造函数
    }

    /**
     * 生成<font color="blue">调试</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void debug(Logger logger, Object... obj) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogString(obj));
        }
    }

    /**
     * 生成<font color="blue">通知</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void info(Logger logger, Object... obj) {
        if (logger.isInfoEnabled()) {
            logger.info(getLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">警告</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void warn(Logger logger, Object... obj) {
        if (logger.isEnabledFor(Level.WARN)) {
            logger.warn(getLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">警告</font>级别日志<br>
     * <li>可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * <li>支持异常
     * @param logger
     * @param throwable
     * @param obj
     */
    public static void warn(Logger logger, Throwable throwable, Object... obj) {
        if (logger.isEnabledFor(Level.WARN)) {
            logger.warn(getLogString(obj), throwable);
        }
    }

    /**
     * 生成<font color="brown">错误</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void error(Logger logger, Object... obj) {
        if (logger.isEnabledFor(Level.ERROR)) {
            logger.error(getLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">错误</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * @param logger
     * @param throwable
     * @param obj
     */
    public static void error(Logger logger, Throwable throwable, Object... obj) {
        if (logger.isEnabledFor(Level.ERROR)) {
            logger.error(getLogString(obj), throwable);
        }
    }

    /**
     * 生成输出到日志的字符串
     *
     * @param obj 任意个要输出到日志的参数
     * @return
     */
    public static String getLogString(Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(",");
        log.append(MessageFormat.format(THREAD_MARKER, Thread.currentThread().getId()));
        log.append(" ");
        for (Object o : obj) {
            log.append(o);
        }
        return log.toString();
    }
}
