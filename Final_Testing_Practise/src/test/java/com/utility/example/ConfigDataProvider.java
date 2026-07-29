package com.utility.example;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigDataProvider {
    Properties pro;
    public ConfigDataProvider() {
        try {
            File src = new File("./Configuration/config.properties");
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Unable to load Config File " + e.getMessage());
        }
    }
    public String getBrowser() {
        return pro.getProperty("Browser");
    }
    public String getApplicationUrl() {
        return pro.getProperty("AppUrl");
    }
}