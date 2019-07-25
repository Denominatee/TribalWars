package org.sikora.tw2.services.coord;

import org.sikora.tw2.entities.CoordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoordDao extends JpaRepository<CoordEntity, Long> {

    Optional<CoordEntity> findByXAndY(int x,int y);

}