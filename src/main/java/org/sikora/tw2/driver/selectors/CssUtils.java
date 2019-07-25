package org.sikora.tw2.driver.selectors;

public enum CssUtils implements  Css{

    DAILY_REWARD_SUBMIT {
        @Override
        public String toString() {
            return ".btn-premium";
        }
    },
    FINISH_UPGRADE {
        @Override
        public String toString() {
            return ".finish-visible > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)";
        }
    },
    UPGRADE_SLOTS {
        @Override
        public String toString() {
            return ".interface-building-queue > div:nth-child(2) > ul:nth-child(1) > li > div";
        }
    },
    UPGRADE_SLOTS2 {
        @Override
        public String toString() {
            return "div.slot-icon.slot-icon__no-margin.size-48x48.btn-orange.icon-26x26-plus";
        }
    }
}
