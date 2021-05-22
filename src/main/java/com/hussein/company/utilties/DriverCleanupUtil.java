package com.hussein.company.utilties;

import java.io.IOException;

public class DriverCleanupUtil {
    public static void killRunningChromeDrivers() throws IOException {
        if (Common.IS_WINDOWS) {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } else {
            Runtime.getRuntime().exec("killall chromedriver_mac");
        }
    }
}
