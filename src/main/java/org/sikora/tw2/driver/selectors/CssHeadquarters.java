package org.sikora.tw2.driver.selectors;

public enum CssHeadquarters implements Css {

    UPGRADE {
        @Override
        public String toString() {
            return "div.building-container:nth-child(xxx)> div:nth-child(1) >" +
                    " div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) >" +
                    " tr:nth-child(4) > td:nth-child(1) > span:nth-child(1)";
        }
    },
    BUILDING_LEVEL {
        @Override
        public String toString() {
            return " div.building-container:nth-child(xxx) > div:nth-child(1) > div:nth-child(1) >" +
                    " table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > th:nth-child(2) > " +
                    "span:nth-child(1) > span:nth-child(1)";
        }
    },
    BUILDING_LEVELS {
        @Override
        public String toString() {
            return "th.building-level-bg";
        }
    },
    COORDS {
        @Override
        public String toString() {
            return "#info-town > h4:nth-child(1) > span:nth-child(3)";
        }
    }
}

