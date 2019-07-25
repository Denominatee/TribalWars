package org.sikora.tw2.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikora.tw2.driver.selectors.Css;
import org.sikora.tw2.utils.PropertiesKeys;
import org.sikora.tw2.utils.PropertiesUtils;

import java.util.List;

public class CustomWebDriver {

    private WebDriver driver;
    private WebDriverWait wait;

    public CustomWebDriver(WebDriver driver) {
        this.driver = driver;
        String property = PropertiesUtils.getInstance().getProperty("driver.configuration.wait.interval");
        this.wait = new WebDriverWait(driver, Integer.valueOf(property));
    }

    public WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getDriverWait() { return wait; }

    public WebElement getElementW8(Css cssSelector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector.toString())));
        return driver.findElement(By.cssSelector(cssSelector.toString()));
    }

    public WebElement getElement(Css cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector.toString()));
    }

    public List<WebElement> getElements(Css cssSelector) {
        return driver.findElements(By.cssSelector(cssSelector.toString()));
    }


    public List<WebElement> getElementsW8(Css cssSelector) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(cssSelector.toString())));
        return driver.findElements(By.cssSelector(cssSelector.toString()));
    }

    public List<WebElement> getElementsVisible(Css cssSelector) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelector.toString())));
        return driver.findElements(By.cssSelector(cssSelector.toString()));
    }

    public WebElement getElementW8(Css cssSelector, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector.toString())));
        return driver.findElement(By.cssSelector(cssSelector.toString()));
    }

    public void waitUntilVisible(Css cssSelector, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector.toString())));
    }
}