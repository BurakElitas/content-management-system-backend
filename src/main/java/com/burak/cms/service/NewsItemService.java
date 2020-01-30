package com.burak.cms.service;


import com.burak.cms.entity.NewItem;

public interface NewsItemService {
    Boolean addNewsItem(NewItem newItem,Long newsId,Long colId);
}
