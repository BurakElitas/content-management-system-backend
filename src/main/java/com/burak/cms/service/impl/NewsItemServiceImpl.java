package com.burak.cms.service.impl;

import com.burak.cms.entity.Col;
import com.burak.cms.entity.NewItem;
import com.burak.cms.entity.News;
import com.burak.cms.repo.ColRepository;
import com.burak.cms.repo.NewRepository;
import com.burak.cms.repo.NewsItemRepository;
import com.burak.cms.service.NewsItemService;
import org.springframework.stereotype.Service;

@Service
public class NewsItemServiceImpl implements NewsItemService {
    private final NewsItemRepository newsItemRepository;
    private final NewRepository newRepository;
    private final ColRepository colRepository;

    public NewsItemServiceImpl(NewsItemRepository newsItemRepository, NewRepository newRepository, ColRepository colRepository) {
        this.newsItemRepository = newsItemRepository;
        this.newRepository = newRepository;
        this.colRepository = colRepository;
    }


    @Override
    public Boolean addNewsItem(NewItem newItem, Long newsId, Long colId) {
        News news=newRepository.getOne(newsId);
        Col col=colRepository.getOne(colId);
        newItem.setCol(col);
        newItem.setNews(news);
        newsItemRepository.save(newItem);

        if(newsItemRepository.existsById(newItem.getId()))
            return true;
        return false;
    }
}
