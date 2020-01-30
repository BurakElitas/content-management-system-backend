package com.burak.cms.controller;

import com.burak.cms.dto.RowDto;
import com.burak.cms.entity.Row;
import com.burak.cms.service.RowService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("row")
@CrossOrigin
public class RowController {

    private final RowService rowService;

    public RowController(RowService rowService) {
        this.rowService = rowService;
    }


    @GetMapping(value = "/{layoutId}")
    public List<Row> getRowsByLayoutId(@PathVariable("layoutId") Long layoutId){
        return rowService.getRowsByLayoutId(layoutId);
    }

    @PostMapping(value ="/{layoutId}")
    public RowDto addRow(@PathVariable("layoutId")Long layoutId, @RequestBody Row row){
        return rowService.addRow(layoutId,row);
    }

    @DeleteMapping(value ="/{id}")
    public Boolean deleteRow(@PathVariable("id")Long id){
        return rowService.deleteRow(id);
    }
}
