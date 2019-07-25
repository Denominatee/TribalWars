package org.sikora.tw2.driver.selectors;

public enum CssLogin implements Css {

    LOGIN {
        @Override
        public String toString() {
            return "div.input.user>input";
        }
    },
    PASSWORD {
        @Override
        public String toString() {
            return "div.input.pw>input";
        }
    },
    SUBMIT {
        @Override
        public String toString() {
            return "button.button-login";
        }
    },
    WORLD {
        @Override
        public String toString() {
            return "span.text.world.ng-binding";
        }
    },
    WORLD_LIST {
        @Override
        public String toString() {
            return "div.scroll-wrap";
        }
    },
    CLICK_LAYER{
        @Override
        public String toString() {
            return "#click-layer";
        }
    }
}
