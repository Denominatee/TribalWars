package org.sikora.tw2.services.village;

import java.util.Optional;

import org.sikora.tw2.entities.CoordEntity;
import org.sikora.tw2.entities.VillageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VillageServiceImpl implements VillageService {
	
	@Autowired
	VillageDao dao;

	@Override
	public Optional<VillageEntity> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Optional<VillageEntity> findByCoords(CoordEntity entity) {
		return dao.findByCoord(entity);
	}

	@Override
	public void save(VillageEntity village) {
		dao.save(village);
	}
}
