package com.burak.cms.service.impl;

import com.burak.cms.dto.ColDto;
import com.burak.cms.entity.Col;
import com.burak.cms.entity.Row;
import com.burak.cms.repo.ColRepository;
import com.burak.cms.repo.RowRepository;
import com.burak.cms.service.ColService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColServiceImpl implements ColService {

    private final ColRepository colRepository;
    private final ModelMapper modelMapper;
    private final RowRepository rowRepository;

    public ColServiceImpl(ColRepository colRepository, ModelMapper modelMapper, RowRepository rowRepository) {
        this.colRepository = colRepository;
        this.modelMapper = modelMapper;
        this.rowRepository = rowRepository;
    }

    @Override
    public List<ColDto> getAllColByRowId(Long rowId) {
       return colRepository.findAllByRow_IdOrderByDisplayNumberAsc(rowId).stream().map(entity->
            modelMapper.map(entity,ColDto.class)).collect(Collectors.toList());

    }

    @Override
    public ColDto addCol(Long rowId, Col col) {
        Row row=rowRepository.getOne(rowId);
        col.setRow(row);
        return modelMapper.map(colRepository.save(col),ColDto.class);
    }

    @Override
    public Boolean deleteCol(Long id) {
        Col col=colRepository.getOne(id);
        if(col==null)
            return false;
        colRepository.delete(col);
        if(colRepository.existsById(id)==false)
            return true;
        return  false;

    }
}
