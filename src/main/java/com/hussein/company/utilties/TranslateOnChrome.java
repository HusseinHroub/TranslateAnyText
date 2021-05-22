package com.hussein.company.utilties;

import com.hussein.company.MainRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class TranslateOnChrome {

    static {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver", getFullFilePathFromResources("chromedriver.exe"));
        } else {
            getFullFilePathFromResources("chromedriver_mac");
        }

    }

    private static String getFullFilePathFromResources(String fileRelativePath) {
        URL res = MainRunner.class.getClassLoader().getResource(fileRelativePath);
        try {
            File file = Paths.get(res.toURI()).toFile();
            return file.getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Couldn't find chrome driver path for this fileRelative: " + fileRelativePath);
    }

    private final static WebDriver driver = new ChromeDriver();

    public static void translate(String string) {
        String url = String.format("https://translate.google.co.uk/?sl=en&tl=ar&text=%s&op=translate", string);
        driver.get(url);
    }
}
