package org.scoula.travel.service;

import org.scoula.common.pagination.Page;
import org.scoula.common.pagination.PageRequest;
import org.scoula.travel.dto.TravelDTO;
import org.scoula.travel.dto.TravelImageDTO;

import java.util.List;

public interface TravelService {
    // image 정보가 빠져있음 (join 처리 X)
    Page<TravelDTO> getPage(PageRequest pageRequest);

    // image 정보가 포함되어 있음 (join 처리 O)
    List<TravelDTO> getList();

    TravelDTO get(Long no);

    TravelImageDTO getImage(Long no);
}
