package org.sikora.tw2.rest;

import org.openqa.grid.common.exception.CapabilityNotPresentOnTheGridException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikora.tw2.driver.CustomWebDriver;
import org.sikora.tw2.driver.RestorableWebDriver;
import org.sikora.tw2.flow.Actions;
import org.sikora.tw2.flows.ScanFlow;
import org.sikora.tw2.flows.StartFlow;
import org.sikora.tw2.rest.dto.SessionForm;
import org.sikora.tw2.services.coord.CoordService;
import org.sikora.tw2.services.village.VillageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class ControllerRest {

    private CustomWebDriver driver;
    private static final Logger LOG = LoggerFactory.getLogger(ControllerRest.class);
    @Autowired
    VillageService villageService;
    @Autowired
    CoordService coordService;
    @Autowired
    StartFlow startFlow;
    @Autowired
    ScanFlow scanFlow;



    @PostMapping("/connect")
    public void connect(SessionForm form) {
        String id = form.getId();
        URL url = null;
        try {
            url = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        RemoteWebDriver driverFromSession = RestorableWebDriver.createDriverFromSession(id, url);
        driver = new CustomWebDriver(driverFromSession);
    }

    @PostMapping("/create")
    public void start() {
        LOG.info("Creating web driver session.");
        driver = new CustomWebDriver(RestorableWebDriver.createDriver());
    }


    @PostMapping("/login")
    public void remote() {
        startFlow.execute(driver);
        scanFlow.execute(driver);
    }

    @PostMapping("/build")
    public void build() {
    }

    @PostMapping("/scan")
    public void scan() {
    }

    @PostMapping("/events")
    public void events() {
    }

    @PostMapping("/test1")
    public void test1() {
        Actions actions = new Actions(driver);
        actions.goToVillage();
        actions.openHeadquaters();
        actions.getBuildingsLevel();
    }

    @PostMapping("/test2")
    public void test2() {
        scanFlow.execute(driver);
    }
}
