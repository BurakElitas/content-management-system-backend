package com.burak.cms.service;

import com.burak.cms.dto.LayoutDto;
import com.burak.cms.entity.Layout;

import java.util.List;

public interface LayoutService {
    List<Layout> getLayoutsByUserId(Long userId);
    Boolean addLayout(Layout layout,Long userId,Long categoryId);
    Layout getLayoutByLayoutId(Long id);
    LayoutDto getLayoutById(Long id);
    List<Layout> getLayoutsByCategoryId(Long categoryId);
}
