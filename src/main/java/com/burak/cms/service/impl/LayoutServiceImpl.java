package com.burak.cms.service.impl;

import com.burak.cms.dto.ColDto;
import com.burak.cms.dto.LayoutDto;
import com.burak.cms.dto.RowDto;
import com.burak.cms.entity.Category;
import com.burak.cms.entity.Layout;
import com.burak.cms.entity.User;
import com.burak.cms.repo.CategoryRepository;
import com.burak.cms.repo.LayoutRepository;
import com.burak.cms.repo.UserRepository;
import com.burak.cms.service.ColService;
import com.burak.cms.service.LayoutService;
import com.burak.cms.service.RowService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LayoutServiceImpl implements LayoutService {

    private final LayoutRepository layoutRepository;
    private final ColService colService;
    private final RowService rowService;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public LayoutServiceImpl(LayoutRepository layoutRepository, ColService colService, RowService rowService, ModelMapper modelMapper, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.layoutRepository = layoutRepository;
        this.colService = colService;
        this.rowService = rowService;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Layout> getLayoutsByUserId(Long userId) {
        return layoutRepository.findAllByUserId(userId);
    }

    @Override
    public Boolean addLayout(Layout layout,Long userId,Long categoryId) {
        User user=userRepository.getOne(userId);
        layout.setUser(user);
        Category category=categoryRepository.getOne(categoryId);
        layout.setCategory(category);
        layoutRepository.save(layout);
        if(layoutRepository.getOne(layout.getId())!=null){
            return true;
        }
        return false;
    }

    @Override
    public Layout getLayoutByLayoutId(Long id) {
        return layoutRepository.getOne(id);
    }


    @Override
    public LayoutDto getLayoutById(Long id) {
        Layout layout=layoutRepository.getOne(id);

        LayoutDto layoutDto=new LayoutDto();
        List<RowDto> rowDtos=rowService.getAllByLayoutId(id);
        for (RowDto rowDto:rowDtos) {
            List<ColDto> colDtos=colService.getAllColByRowId(rowDto.getId());
            rowDto.setColDtos(colDtos);
        }
        layoutDto=modelMapper.map(layoutRepository.getOne(id),LayoutDto.class);
        layoutDto.setRowDto(rowDtos);
        layoutDto.setCategoryDto(layout.getCategory());
        return layoutDto;
    }

    @Override
    public List<Layout> getLayoutsByCategoryId(Long categoryId) {
        return layoutRepository.getAllByCategoryId(categoryId);
    }
}
