package org.sikora.tw2.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikora.tw2.driver.CustomWebDriver;
import org.sikora.tw2.driver.selectors.CssHeadquarters;
import org.sikora.tw2.driver.selectors.CssUtils;
import org.sikora.tw2.driver.selectors.CssVillage;
import org.sikora.tw2.utils.Buildings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BuilderFlow extends Flow implements Runnable {

    public BuilderFlow(CustomWebDriver driver) {
        super(driver);
    }

    private static final Logger LOG = LoggerFactory.getLogger(BuilderFlow.class);

    public void test() {
        upgradeBuilding(Buildings.CLAY_PIT);
    }

    public void test2() {
        System.out.println(queueReady());
    }

    @Override
    public void run() {

    }

    private void upgradeBuilding(Buildings building) {
        String selector = CssHeadquarters.UPGRADE.toString().replace("xxx", String.valueOf(building.index));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(selector)));
        driver.findElement(By.cssSelector(selector)).click();
    }

    public boolean queueReady() {
        List<WebElement> elements = custom.getElements(CssUtils.UPGRADE_SLOTS);
        for (int i=0; i<elements.size()-1;i++) {
            WebElement webElement = elements.get(i);
            String attribute = webElement.getAttribute("tooltip-content");
            if (attribute != null && attribute.equals("Otwórz okno Ratusza")){
                return true;
            }
        }
        return false;
    }

    private WebElement getFreeQueueElement(){
        List<WebElement> elements = custom.getElements(CssUtils.UPGRADE_SLOTS);
        for (int i=0; i<elements.size()-1;i++) {
            WebElement webElement = elements.get(i);
            String attribute = webElement.getAttribute("tooltip-content");
            if (attribute != null && attribute.equals("Otwórz okno Ratusza")){
                return webElement;
            }
        }
        return null;
    }
}
