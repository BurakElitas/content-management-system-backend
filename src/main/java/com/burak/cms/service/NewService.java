package com.burak.cms.service;

import com.burak.cms.entity.News;

import java.util.List;

public interface NewService {

    Boolean addNew(News news,Long layoutId,Long categoryId,Long userId);
    News getNew(Long id);
    List<News> getAllNews();

    List<News> getNewsByUserId(Long userId);

}
