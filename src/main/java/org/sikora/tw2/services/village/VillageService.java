package org.sikora.tw2.services.village;

import java.util.Optional;

import org.sikora.tw2.entities.CoordEntity;
import org.sikora.tw2.entities.VillageEntity;

public interface VillageService {
	
	Optional<VillageEntity> findByName(String name);
	Optional<VillageEntity> findByCoords(CoordEntity entity);
	void save(VillageEntity village);
}
