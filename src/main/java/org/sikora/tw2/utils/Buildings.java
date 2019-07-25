package org.sikora.tw2.utils;

public enum Buildings {

    HEADQUARTERS(0),
    TIMBAR_CAMP(1),
    CLAY_PIT(2),
    IRON_MINE(3),
    FARM(4),
    WAREHOUSE(5),
    CHURCH(6),
    RALLY_POINT(7),
    BARRACKS(8),
    STATUE(9),
    HOSPITAL(10),
    WALL(11),
    MARKET(12),
    TAWERN(13),
    ACADEMY(14),
    HALL_OF_ORDERS(15);

    public int index;

    private Buildings(int index) {
        this.index = index;
    }
}
