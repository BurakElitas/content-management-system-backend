package com.burak.cms.controller;

import com.burak.cms.entity.News;
import com.burak.cms.service.NewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "news")
@CrossOrigin
public class NewController {

    private final NewService newsService;

    public NewController(NewService newService) {
        this.newsService = newService;
    }

    @GetMapping(value ="/")
    private List<News> getAll(){
        return newsService.getAllNews();
    }
    @GetMapping(value ="/user/{userId}")
    private List<News> getAllByUser(@PathVariable("userId")Long userId){
        return newsService.getNewsByUserId(userId);
    }

    @PostMapping(value = "/user/{userId}/category/{catId}/layout/{layoutId}")
    public Boolean addNews(@RequestBody News news,@PathVariable("userId") Long userId,@PathVariable("catId") Long catId,@PathVariable("layoutId") Long layoutId){
        return newsService.addNew(news,layoutId,catId,userId);
    }
}
