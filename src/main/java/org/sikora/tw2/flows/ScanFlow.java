package org.sikora.tw2.flows;

import org.sikora.tw2.actions.Actions;
import org.sikora.tw2.driver.CustomWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScanFlow {

    @Autowired
    private Actions actions;

    public void execute(CustomWebDriver driver){
        actions.goToVillage(driver);
    }
}
