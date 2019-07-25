package org.sikora.tw2.driver.selectors;

public enum CssVillage implements Css {

    SKIP_TUTORIAL {
        @Override
        public String toString() {
            return "a.skip-tutorial.btn-orange.btn-border";
        }
    },
    WORLD_MAP {
        @Override
        public String toString() {
            return "#world-map";
        }
    },
    TO_MAP {
        @Override
        public String toString() {
            return "a.btn-orange:nth-child(6)";
        }
    },
    TO_VILLAGE {
        @Override
        public String toString() {
            return "a.btn-orange:nth-child(5)";
        }
    },
    REPORT {
        @Override
        public String toString() {
            return "#report-button";
        }
    },
    MESSAGE {
        @Override
        public String toString() {
            return "#message-button";
        }
    },
    TRIBE {
        @Override
        public String toString() {
            return "#tribe-button";
        }
    },
    FORUM {
        @Override
        public String toString() {
            return "#forum-button";
        }
    },
    UNITS {
        @Override
        public String toString() {
            return ".icon-60x60-units";
        }
    },
    OVERVIEV {
        @Override
        public String toString() {
            return ".icon-60x60-overview";
        }
    },
    SHOP {
        @Override
        public String toString() {
            return ".icon-60x60-shop";
        }
    },
    INVENTORY {
        @Override
        public String toString() {
            return "#inventory-button";
        }
    },
    ACHIEVEMENTS {
        @Override
        public String toString() {
            return ".icon-60x60-achievements";
        }
    },
    SETTINGS {
        @Override
        public String toString() {
            return ".icon-60x60-settings";
        }
    },
    HEADQUARTER {
        @Override
        public String toString() {
            return "#label-headquarter > a:nth-child(1) > span:nth-child(1)";
        }
    },
    CITY_HALL_OPEN{
        @Override
        public String toString() {
            return "li.context-menu-item:nth-child(1) > div:nth-child(1) > div:nth-child(1)";
        }
    },
    VILLAGE_NAME{
        @Override
        public String toString() {
            return "#village-name";
        }
    }

}
