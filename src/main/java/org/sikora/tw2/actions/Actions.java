package org.sikora.tw2.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikora.tw2.driver.CustomWebDriver;
import org.sikora.tw2.driver.selectors.CssLogin;
import org.sikora.tw2.driver.selectors.CssUtils;
import org.sikora.tw2.driver.selectors.CssVillage;
import org.sikora.tw2.utils.PropertiesKeys;
import org.sikora.tw2.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class Actions {

    protected final PropertiesUtils propertiesUtils = PropertiesUtils.getInstance();
    private static final Logger LOG = LoggerFactory.getLogger(Actions.class);

    public void login(CustomWebDriver custom){
        LOG.info("Logging in - Start.");
        WebDriver driver = custom.getDriver();
        String address = propertiesUtils.getProperty(PropertiesKeys.BOT_ADRESS);
        String login = propertiesUtils.getProperty(PropertiesKeys.BOT_LOGIN);
        String password = propertiesUtils.getProperty(PropertiesKeys.BOT_PASSWORD);
        driver.get(address);
        custom.getElementW8(CssLogin.LOGIN).sendKeys(login);
        custom.getElementW8(CssLogin.PASSWORD).sendKeys(password);
        custom.getElementW8(CssLogin.SUBMIT).click();
        custom.getElementW8(CssLogin.WORLD_LIST);
        LOG.info("Logging in - End.");
    }

    public void selectWorld(CustomWebDriver custom) {
        LOG.info("Selecting world - Start.");
        List<WebElement> elements = custom.getElementsW8(CssLogin.WORLD);
        String world = propertiesUtils.getProperty(PropertiesKeys.BOT_WORLD);
        for (WebElement element : elements) {
            if (element.getText().equals(world)) {
                element.findElement(By.xpath("../..")).click();
                LOG.info("Selecting world - world selected: " + world);
                break;
            }
        }
        custom.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CssLogin.CLICK_LAYER.toString())));
        custom.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector(CssLogin.CLICK_LAYER.toString())));
        LOG.info("Selecting world - End.");
    }

    public void skipTutorial(CustomWebDriver custom) {
        LOG.info("Skipping tutorial - Start.");
        try {
            custom.getElement(CssVillage.SKIP_TUTORIAL).click();
            WebDriverWait wait = new WebDriverWait(custom.getDriver(), 30);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div/div/footer/ul/li[2]/a")));
            custom.getDriver().findElement((By.xpath("/html/body/div[6]/div/div/div/div/footer/ul/li[2]/a"))).click();
        } catch (Exception e) {
            LOG.info("Skipping tutorial - already skipped.");
            return;
        }
        LOG.info("Skipping tutorial - End.");
    }

    public void claimReward(CustomWebDriver custom) {
        LOG.info("Claiming daily reward - Start.");
        try {
            custom.getElement(CssUtils.DAILY_REWARD_SUBMIT).click();
        } catch (Exception e) {
            LOG.info("Claiming daily reward - Already claimed.");
            return;
        }
        LOG.info("Claiming daily reward - End.");
    }

    public void goToVillage(CustomWebDriver custom) {
        LOG.info("Going to village - Start.");
        try {
            custom.getElement(CssVillage.TO_VILLAGE);
        } catch (Exception e) {
            LOG.info("Going to village - Already in the village.");
            return;
        }
        custom.getElement(CssVillage.TO_VILLAGE).click();
        custom.getElementW8(CssVillage.HEADQUARTER);
        LOG.info("Going to village - End.");
    }

}
