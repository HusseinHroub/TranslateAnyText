package com.hussein.company.utilties;

import java.io.IOException;

public class DriverCleanupUtil {
    public static void killRunningChromeDrivers() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
}
