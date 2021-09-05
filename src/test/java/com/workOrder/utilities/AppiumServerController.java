package com.workOrder.utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import java.io.File;
import java.io.FileNotFoundException;
import static com.workOrder.utilities.Property.*;
import static io.appium.java_client.service.local.AppiumDriverLocalService.buildService;

public class AppiumServerController {
    private final static AppiumDriverLocalService service;

    static {
        System.out.println("Print Default Data");
        System.out.println(APPIUM_HOST + "    " + APPIUM_PORT + "     " + APPIUM_LOG_LEVEL + "     " + GeneralServerFlag.LOG_LEVEL + "   " + IMPLICIT_WAIT_TIME);

        service = buildService(new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(Integer.parseInt("4723"))
                .withAppiumJS(new File(
                        System.getProperty("os.name").contains("Mac OS")
                                ? "/usr/local/lib/node_modules/appium/build/lib/main.js"
                                : "/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info"));
    }

    public AppiumServerController() throws FileNotFoundException {
    }

    public static void startAppiumServer() {
        try { service.start(); } catch (Exception e) { e.printStackTrace(); }
    }

    public static void stopAppiumServer() {
        try {
            if (service.isRunning()) { service.stop(); }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
