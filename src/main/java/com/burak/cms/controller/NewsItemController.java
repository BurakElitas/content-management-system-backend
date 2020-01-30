package com.burak.cms.controller;

import com.burak.cms.entity.NewItem;
import com.burak.cms.service.NewsItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "newsItem")
@CrossOrigin
public class NewsItemController {
    private final NewsItemService newsItemService;

    public NewsItemController(NewsItemService newsItemService) {
        this.newsItemService = newsItemService;
    }

    @PostMapping(value ="/news/{newsId}/col/{colId}")
    public Boolean addNewsItem(@RequestBody NewItem newItem, @PathVariable("newsId") Long newsId,@PathVariable("colId")Long colId){
        return  newsItemService.addNewsItem(newItem,newsId,colId);
    }
}
