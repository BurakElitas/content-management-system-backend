package com.burak.cms.service;

import com.burak.cms.dto.RowDto;
import com.burak.cms.entity.Row;

import java.util.List;

public interface RowService {
    List<Row> getRowsByLayoutId(Long layoutId);
    List<RowDto> getAllByLayoutId(Long layoutId);
    RowDto addRow(Long layoutId,Row row);
    Boolean deleteRow(Long id);
}
