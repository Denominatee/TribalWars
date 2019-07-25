package org.sikora.tw2.flow;

import org.openqa.selenium.WebDriver;
import org.sikora.tw2.driver.CustomWebDriver;
import org.sikora.tw2.utils.PropertiesUtils;

public abstract class Flow {

    protected final CustomWebDriver custom;
    protected final WebDriver driver;
    protected final PropertiesUtils propertiesUtils;

    public Flow(CustomWebDriver driver) {
        this.custom = driver;
        this.driver = driver.getDriver();
        this.propertiesUtils = PropertiesUtils.getInstance();
    }
}
