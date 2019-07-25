package org.sikora.tw2.flow;

import org.sikora.tw2.driver.CustomWebDriver;
import org.sikora.tw2.entities.CoordEntity;
import org.sikora.tw2.entities.VillageEntity;
import org.sikora.tw2.entities.dto.CoordDto;
import org.sikora.tw2.services.coord.CoordService;
import org.sikora.tw2.services.village.VillageService;
import org.sikora.tw2.utils.Buildings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ScanFlow extends Flow {

    @Autowired
    VillageService villageService;
    @Autowired
    CoordService coordService;

    public ScanFlow(CustomWebDriver driver) {
        super(driver);
    }

    public void run() {
        Actions actions = new Actions(custom);
        if (!actions.isInVillage()) {
            actions.goToVillage();
        }
        CoordDto coordDto = actions.getCoords();
        CoordEntity coordEntity = coordService.findCoord(coordDto);
        Optional<VillageEntity> byCoords = villageService.findByCoords(coordEntity);
        String villageName = actions.getVillageName();
        VillageEntity villageEntity;
        if(byCoords.isPresent()) {
            villageEntity = byCoords.get();
            villageEntity.setName(villageName);
        } else {
            villageEntity = new VillageEntity();
            villageEntity.setName(villageName);
            villageEntity.setCoord(coordEntity);
        }
        int[] buildingsLevel = actions.getBuildingsLevel();
        setBuildingLevels(buildingsLevel,villageEntity);
        villageService.save(villageEntity);
    }

    private void setBuildingLevels(int[] buildingsLevel, VillageEntity villageEntity) {
        villageEntity.setHeadquarters(buildingsLevel[Buildings.HEADQUARTERS.index]);
        villageEntity.setTimber(buildingsLevel[Buildings.TIMBAR_CAMP.index]);
        villageEntity.setClay(buildingsLevel[Buildings.CLAY_PIT.index]);
        villageEntity.setIron(buildingsLevel[Buildings.IRON_MINE.index]);
        villageEntity.setFarm(buildingsLevel[Buildings.FARM.index]);
        villageEntity.setWarehouse(buildingsLevel[Buildings.WAREHOUSE.index]);
        villageEntity.setChurch(buildingsLevel[Buildings.CHURCH.index]);
        villageEntity.setRallypoint(buildingsLevel[Buildings.RALLY_POINT.index]);
        villageEntity.setBarracks(buildingsLevel[Buildings.BARRACKS.index]);
        villageEntity.setStatue(buildingsLevel[Buildings.STATUE.index]);
        villageEntity.setWall(buildingsLevel[Buildings.WALL.index]);
        villageEntity.setHospital(buildingsLevel[Buildings.HOSPITAL.index]);
        villageEntity.setMarket(buildingsLevel[Buildings.MARKET.index]);
        villageEntity.setTavern(buildingsLevel[Buildings.TAWERN.index]);
        villageEntity.setAcademy(buildingsLevel[Buildings.ACADEMY.index]);
        villageEntity.setHalloforders(buildingsLevel[Buildings.HALL_OF_ORDERS.index]);
    }
}
