package com.burak.cms.service;

import com.burak.cms.dto.ColDto;
import com.burak.cms.entity.Col;

import java.util.List;

public interface ColService {
    List<ColDto> getAllColByRowId(Long rowId);
    ColDto addCol(Long rowId, Col col);
    Boolean deleteCol(Long id);
}
