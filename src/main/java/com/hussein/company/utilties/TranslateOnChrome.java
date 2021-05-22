package com.hussein.company.utilties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TranslateOnChrome {
    
    static {
        if (Common.IS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", Common.getFullFilePathFromResources("chromedriver.exe"));
        } else {
            System.setProperty("webdriver.chrome.driver", Common.getFullFilePathFromResources("chromedriver_mac"));
        }
        
    }
    
    private final static WebDriver driver = new ChromeDriver();
    
    public static void translate(String string) {
        String url = String.format("https://translate.google.co.uk/?sl=en&tl=ar&text=%s&op=translate", string);
        driver.get(url);
    }
}
