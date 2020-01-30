package com.burak.cms.controller;

import com.burak.cms.dto.ColDto;
import com.burak.cms.entity.Col;
import com.burak.cms.service.ColService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("col")
@CrossOrigin
public class ColController {
    private final ColService colService;

    public ColController(ColService colService) {
        this.colService = colService;
    }

    @GetMapping(value = "/{rowId}")
    public ResponseEntity<List<ColDto>> getColsByRowId(@PathVariable("rowId") Long rowId){
        return ResponseEntity.ok(colService.getAllColByRowId(rowId));
    }

    @PostMapping(value = "/{rowId}")
    public ResponseEntity<ColDto> addCol(@PathVariable("rowId") Long rowId,@RequestBody Col col){
        return ResponseEntity.ok(colService.addCol(rowId,col));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteCol(@PathVariable("id") Long id){
        return ResponseEntity.ok(colService.deleteCol(id));
    }



}
