package com.hussein.company.utilties;

import com.hussein.company.MainRunner;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Common {
    
    public static boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().contains("windows");
    
    public static String getFullFilePathFromResources(String fileRelativePath) {
        URL res = MainRunner.class.getClassLoader().getResource(fileRelativePath);
        try {
            File file = Paths.get(res.toURI()).toFile();
            return file.getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Couldn't find chrome driver path for this fileRelative: " + fileRelativePath);
    }
}
