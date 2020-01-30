package com.burak.cms.controller;

import com.burak.cms.dto.LayoutDto;
import com.burak.cms.entity.Layout;
import com.burak.cms.service.LayoutService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("layout")
@CrossOrigin
public class LayoutController {

    private final LayoutService layoutService;

    public LayoutController(LayoutService layoutService) {
        this.layoutService = layoutService;
    }


    @GetMapping(value = "/user/{userId}")
    public List<Layout> getLayoutsByUserId(@PathVariable("userId") Long userId){
        List<Layout> layouts=layoutService.getLayoutsByUserId(userId);
        return layouts;
    }

    @PostMapping(value ="add/user/{userId}/category/{categoryId}")
    public Boolean addLayout(@RequestBody Layout layout, @PathVariable("userId") Long userId,@PathVariable("categoryId") Long categoryId){
        return layoutService.addLayout(layout,userId,categoryId);
    }

    @GetMapping(value = "/{layoutId}")
    public LayoutDto getLayoutById(@PathVariable("layoutId") Long layoutId){
        return layoutService.getLayoutById(layoutId);
    }

    @GetMapping(value = "/category/{categoryId}")
    public ResponseEntity<List<Layout>> getLayoutByCategoryId(@PathVariable("categoryId") Long categoryId){
        return ResponseEntity.ok(layoutService.getLayoutsByCategoryId(categoryId));
    }

}
