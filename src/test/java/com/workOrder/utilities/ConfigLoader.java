package com.workOrder.utilities;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigLoader {
    public static Config config = ConfigFactory.load("env");
    public static String environment = System.getProperty("env") == null ? "test" : System.getProperty("env");
    private static final Logger log = LoggerFactory.getLogger(ConfigLoader.class);

    public static Config load() {
//        environment = System.getProperty("env") == null ? "test" : System.getProperty("env");
        if (config.hasPath(environment)) {
            log.info("Running the tests against:" + environment);
            return config.getConfig(environment).withFallback(config);
        }
        return config;
    }
}
