package com.Framework.Example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import com.utility.example.BrowserFactory;
import com.utility.example.ConfigDataProvider;
import com.utility.example.ExcelDataProvider;
import com.utility.example.Helper;
public class BaseClass {
    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;
    @BeforeSuite
    public void setupSuite() {
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();
    }
    @BeforeClass
    public void setupBrowser() {
        driver = BrowserFactory.startBrowser(
                config.getBrowser(),
                config.getApplicationUrl());
    }
    @AfterMethod
    public void captureFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Helper.captureScreenShot(driver);
        }
    }
	@AfterMethod
	@AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }
}