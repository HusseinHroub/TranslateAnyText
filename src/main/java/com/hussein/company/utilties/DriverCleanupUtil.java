package com.hussein.company.utilties;

import java.io.IOException;

public class DriverCleanupUtil {
    public static void killRunningChromeDrivers() throws IOException {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } else {
            Runtime.getRuntime().exec("killall chromedriver");
        }
    }
}
