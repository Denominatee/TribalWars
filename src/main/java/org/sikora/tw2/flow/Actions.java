package org.sikora.tw2.flow;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikora.tw2.driver.CustomWebDriver;
import org.sikora.tw2.driver.selectors.CssHeadquarters;
import org.sikora.tw2.driver.selectors.CssVillage;
import org.sikora.tw2.entities.dto.CoordDto;
import org.sikora.tw2.utils.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Actions {

    private final CustomWebDriver custom;
    private final WebDriver driver;

    @Autowired
    private PropertiesUtils propertiesUtils;

    public Actions(CustomWebDriver driver) {
        this.custom = driver;
        this.driver = driver.getDriver();
        //this.propertiesUtils = PropertiesUtils.getInstance();
    }
    public void goToVillage() {
        custom.getElement(CssVillage.TO_VILLAGE).click();
    }

    public boolean isInVillage() {
        try {
            custom.getElementW8(CssVillage.TO_VILLAGE);
            return false;
        } catch (Exception e) {
            e.getMessage();
            return true;
        }
    }


    public void openHeadquaters() {
        custom.getElementW8(CssVillage.HEADQUARTER).click();
        WebElement element = custom.getElementW8(CssVillage.CITY_HALL_OPEN);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    public int[] getBuildingsLevel() {
        List<WebElement> elements = custom.getElements(CssHeadquarters.BUILDING_LEVELS);
        int levels[] = new int[elements.size()];
        for (int i=0; i<elements.size(); i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = elements.get(i);
            js.executeScript("arguments[0].scrollIntoView();", element);
            String level = element.getText();
            if (level.equals("")) {
                levels[i] = -1;
                continue;
            }
            levels[i] = Integer.valueOf(level);
        }
        return levels;
    }
    public CoordDto getCoords(){
        String coords = custom.getElement(CssHeadquarters.COORDS).getText();
        String x = coords.substring(1, 4);
        String y = coords.substring(5, 8);
        CoordDto coord = new CoordDto(Integer.valueOf(x),Integer.valueOf(y));
        return coord;
    }

    public String getVillageName(){
        String vilallageName = custom.getElement(CssVillage.VILLAGE_NAME).getText();
        return vilallageName;
    }
}
