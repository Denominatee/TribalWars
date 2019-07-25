package org.sikora.tw2.services.coord;

import org.sikora.tw2.entities.CoordEntity;
import org.sikora.tw2.entities.dto.CoordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CoordServiceImpl implements CoordService {

    @Autowired
    CoordDao dao;

    @Override
    public void save(CoordEntity coord) {
        dao.save(coord);
    }

    @Override
    public CoordEntity findCoord(CoordDto dto) {
        Optional<CoordEntity> optionalCoord = dao.findByXAndY(dto.getX(), dto.getY());
        if (optionalCoord.isPresent()) {
            return optionalCoord.get();
        } else {
            CoordEntity newCoord = new CoordEntity();
            newCoord.setX(dto.getX());
            newCoord.setY(dto.getY());
            dao.save(newCoord);
            return newCoord;
        }
    }
}
