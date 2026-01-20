package com.checkpoint.swaggerdemo.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LoglevelUtil {
    private static Logger LOG = LoggerFactory.getLogger(LoglevelUtil.class);
    private static final String app_logger = "com.checkpoint.swaggerdemo";

    public static boolean switchLog(String logLevel) {
        Level level = getLogLevel(logLevel);

        if (null != level) {
            Configurator.setRootLevel(level);
            switchLog(app_logger, level);
            return true;
        } else {
            LOG.error("logLevel parameter {} not recognized", logLevel);
            return false;
        }

    }

    public static String getCurrentLogLevel(Logger logger){
		return ((LoggerContext) LogManager.getContext(false)).getConfiguration().getLoggerConfig(app_logger).getLevel().name();
	}


    private static void switchLog(String logName, Level Level) {
        Map<String, org.apache.logging.log4j.Level> map = new HashMap<String, org.apache.logging.log4j.Level>();
        map.put(logName, Level);
        Configurator.setLevel(map);
        LOG.trace("Log level is successfully changed to {}", Level.name());
    }

    private static Level getLogLevel(String logLevel) {
        Level level = null;
        if ("DEBUG".equalsIgnoreCase(logLevel)) {
            level = Level.DEBUG;
        } else if ("INFO".equalsIgnoreCase(logLevel)) {
            level = Level.INFO;
        } else if ("WARN".equalsIgnoreCase(logLevel)) {
            level = Level.WARN;
        } else if ("ERROR".equalsIgnoreCase(logLevel)) {
            level = Level.ERROR;
        } else if ("FATAL".equalsIgnoreCase(logLevel)) {
            level = Level.FATAL;
        }
        return level;
    }
}
