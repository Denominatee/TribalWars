package org.sikora.tw2.services.village;

import java.util.Optional;

import org.sikora.tw2.entities.CoordEntity;
import org.sikora.tw2.entities.VillageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageDao extends JpaRepository<VillageEntity, Long>{
	Optional<VillageEntity> findByName(String name);
	Optional<VillageEntity> findByCoord(CoordEntity coord);
}
