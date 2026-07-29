package com.Framework.Example;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ConcreteVolumePage {
    WebDriver driver;
    WebDriverWait wait;
    public ConcreteVolumePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void enterDiameter(String diameter) {
        WebElement txt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("diam")));
        txt.sendKeys(diameter);
    }
    public void enterDepth(String depth) {
        WebElement txt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("dept")));
        txt.sendKeys(depth);
    }
    public void enterQuantity(String quantity) {
        WebElement txt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("quant")));
        txt.sendKeys(quantity);
    }
    public void clickResult() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("Result")));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", btn);
        try {
            btn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
    }
    public String getResult() {
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("r1")));
        return result.getAttribute("value");
    }
    public void calculateConcreteVolume(String diameter,String depth,String quantity) {
        enterDiameter(diameter);
        enterDepth(depth);
        enterQuantity(quantity);
        clickResult();
    }
}