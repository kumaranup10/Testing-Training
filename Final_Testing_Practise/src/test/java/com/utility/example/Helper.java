package com.utility.example;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Helper {
    public static void captureScreenShot(WebDriver driver) {
        try {
            File directory = new File("./ScreenShots");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(directory,
                    getCurrentDateTime() + ".png");
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot Captured");
        } catch (IOException e) {
            System.out.println("Unable to capture Screenshot " + e.getMessage());
        }
    }
    public static String getCurrentDateTime() {
        SimpleDateFormat formatter =
                new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_SSS");
        Date date = new Date();
        return formatter.format(date);
    }
}