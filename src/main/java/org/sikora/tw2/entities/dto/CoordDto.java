package org.sikora.tw2.entities.dto;

public class CoordDto {

    private int x;
    private int y;
    private Long villageId;

    public CoordDto(int x, int y) {
        this.x = x;
        this.y = y;
        this.villageId = null;
    }

    public CoordDto(int x, int y, Long villageId) {
        this.x = x;
        this.y = y;
        this.villageId = villageId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }
}


