package com.jzfq.seata.student.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;

/**
 * @Author: jianmin.li
 * @Description: 日志打印工具类
 * @Date: 2021/3/21 21:30
 * @Version: 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogUtils {
    /**
     * Log a message at the TRACE level according to the specified format and arguments.
     *
     * @param log       The org.slf4j.Logger
     * @param format    the format string
     * @param arguments arguments
     * @author jianmin.li
     * @date 2021/3/21 21:32
     */
    public static void trace(Logger log,String format,Object... arguments) {
        if (log.isTraceEnabled()) {
            log.trace(format,arguments);
        }
    }

    /**
     * Log a message at the DEBUG level according to the specified format and arguments.
     *
     * @param log       The org.slf4j.Logger
     * @param format    the format string
     * @param arguments arguments
     * @author jianmin.li
     * @date 2021/3/21 21:32
     */
    public static void debug(Logger log,String format,Object... arguments) {
        if (log.isDebugEnabled()) {
            log.debug(format,arguments);
        }
    }

    /**
     * Log a message at the INFO level according to the specified format and arguments.
     *
     * @param log       The org.slf4j.Logger
     * @param format    the format string
     * @param arguments arguments
     * @author jianmin.li
     * @date 2021/3/21 21:32
     */
    public static void info(Logger log,String format,Object... arguments) {
        if (log.isInfoEnabled()) {
            log.info(format,arguments);
        }
    }

    /**
     * Log a message at the WARN level according to the specified format and arguments.
     *
     * @param log       The org.slf4j.Logger
     * @param format    the format string
     * @param arguments arguments
     * @author jianmin.li
     * @date 2021/3/21 21:32
     */
    public static void warn(Logger log,String format,Object... arguments) {
        if (log.isWarnEnabled()) {
            log.warn(format,arguments);
        }
    }

    /**
     * Log a message at the ERROR level according to the specified format and arguments.
     *
     * @param log       The org.slf4j.Logger
     * @param format    the format string
     * @param arguments arguments
     * @author jianmin.li
     * @date 2021/3/21 21:32
     */
    public static void error(Logger log,String format,Object... arguments) {
        if (log.isErrorEnabled()) {
            log.error(format,arguments);
        }
    }
}
