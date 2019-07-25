package org.sikora.tw2.flow;

import org.sikora.tw2.driver.CustomWebDriver;
import org.sikora.tw2.driver.selectors.CssUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventsFlow extends Flow implements Runnable {

    protected EventsFlow(CustomWebDriver driver) {
        super(driver);
    }

    private static final Logger LOG = LoggerFactory.getLogger(EventsFlow.class);

    @Override
    public void run() {
        LOG.info("Checking for events.");
        checkForEvents();
        try {
            int interval = 10000;
            LOG.info("Stopping thread for " + interval + " milliseconds.");
            Thread.sleep(interval);

            LOG.info("Resuming thread.");
        } catch (InterruptedException e) {
            LOG.error("Error while stopping thread.");
            e.printStackTrace();
        }
        run();
    }

    private void checkForEvents(){
        try {
            LOG.info("Checking for building upgrade ready to finish.");
            custom.getElement(CssUtils.FINISH_UPGRADE).click();
            LOG.info("Building upgrade finished.");
        } catch (Exception e) {
            LOG.info("No building upgrade ready to finish.");
        }
        BuilderFlow builderFlow = new BuilderFlow(custom);
        if (builderFlow.queueReady()) {
            builderFlow.run();
        } else {
            LOG.info("No free slots in building queue.");
        }
    }
}
