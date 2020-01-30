package com.burak.cms.service.impl;

import com.burak.cms.dto.RowDto;
import com.burak.cms.entity.Col;
import com.burak.cms.entity.Layout;
import com.burak.cms.entity.Row;
import com.burak.cms.repo.ColRepository;
import com.burak.cms.repo.LayoutRepository;
import com.burak.cms.repo.RowRepository;
import com.burak.cms.service.RowService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RowServiceImpl implements RowService {

    private final RowRepository rowRepository;
    private final ModelMapper modelMapper;
    private final LayoutRepository layoutRepository;
    private final ColRepository colRepository;

    public RowServiceImpl(RowRepository rowRepository, ModelMapper modelMapper, LayoutRepository layoutRepository, ColRepository colRepository) {
        this.rowRepository = rowRepository;
        this.modelMapper = modelMapper;
        this.layoutRepository = layoutRepository;
        this.colRepository = colRepository;
    }

    @Override
    public List<Row> getRowsByLayoutId(Long layoutId) {
        return rowRepository.findRowsByLayout_IdOrderByDisplayNumberAsc(layoutId);
    }

    @Override
    public List<RowDto> getAllByLayoutId(Long layoutId) {
         return rowRepository.findRowsByLayout_IdOrderByDisplayNumberAsc(layoutId).stream().map(entity->
                 modelMapper.map(entity,RowDto.class)).collect(Collectors.toList());
    }

    @Override
    public RowDto addRow(Long layoutId, Row row) {
        Layout layout=layoutRepository.getOne(layoutId);
        row.setLayout(layout);
        return modelMapper.map(rowRepository.save(row),RowDto.class);
    }

    @Override
    public Boolean deleteRow(Long id) {
       List<Col> cols=colRepository.findAllByRow_IdOrderByDisplayNumberAsc(id);
        for (Col col:cols) {
            colRepository.delete(col);
        }
        Row row=rowRepository.getOne(id);
        if(row==null)
            return false;
        rowRepository.delete(row);
        if(rowRepository.existsById(id)==false)
            return true;
        return false;

    }
}
