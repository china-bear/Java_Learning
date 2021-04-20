package log_test;

import org.slf4j.LoggerFactory;

public class Log4JLevelsTest {

    public static void main(String[] args) {

        //  once the logger is created the log level can't be changed. If you need to dynamically change the logging level you might want to use log4j with SLF4J
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");

        final org.slf4j.Logger log = LoggerFactory.getLogger(Log4JLevelsTest.class);

        // ERROR > WARN > INFO > DEBUG > TRACE
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warning");
        log.error("error");
    }
}
