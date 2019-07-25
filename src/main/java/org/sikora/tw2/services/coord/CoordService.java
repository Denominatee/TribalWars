package org.sikora.tw2.services.coord;

import org.sikora.tw2.entities.CoordEntity;
import org.sikora.tw2.entities.dto.CoordDto;

public interface CoordService {

    void save(CoordEntity coord);
    CoordEntity findCoord(CoordDto dto);
}
