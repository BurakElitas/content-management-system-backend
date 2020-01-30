package com.burak.cms.dto;

import com.burak.cms.entity.Category;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class LayoutDto implements Serializable {
    private Long id;
    private String name;
    private Category categoryDto;
    private List<RowDto> rowDto;

    public LayoutDto(){
        rowDto=new ArrayList<>();
    }
}
