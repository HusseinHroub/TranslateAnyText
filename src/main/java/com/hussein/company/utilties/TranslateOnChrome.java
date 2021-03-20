package com.hussein.company.utilties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class TranslateOnChrome {
    static {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\user\\IdeaProjects\\TranslateAnyText\\src\\main\\resources\\chromedriver.exe");
    }

    private final static WebDriver driver = new ChromeDriver();

    public static void translate(String string) {
        String url = String.format("https://translate.google.co.uk/?sl=en&tl=ar&text=%s&op=translate", string);
        driver.get(url);
    }
}
