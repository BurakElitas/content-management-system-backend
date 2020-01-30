package com.burak.cms.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class RowDto implements Serializable {
    private Long id;
    private int displayNumber;
    private List<ColDto> colDtos;

    public RowDto(){
        colDtos=new ArrayList<>();
    }
}
