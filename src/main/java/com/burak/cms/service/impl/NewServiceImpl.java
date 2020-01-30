package com.burak.cms.service.impl;

import com.burak.cms.entity.Category;
import com.burak.cms.entity.Layout;
import com.burak.cms.entity.News;
import com.burak.cms.entity.User;
import com.burak.cms.repo.CategoryRepository;
import com.burak.cms.repo.LayoutRepository;
import com.burak.cms.repo.NewRepository;
import com.burak.cms.repo.UserRepository;
import com.burak.cms.service.NewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewServiceImpl implements NewService {
    private final NewRepository newRepository;
    private final LayoutRepository layoutRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public NewServiceImpl(NewRepository newRepository, LayoutRepository layoutRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.newRepository = newRepository;
        this.layoutRepository = layoutRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Boolean addNew(News news,Long layoutId,Long categoryId,Long userId) {
        Layout layout=layoutRepository.getOne(layoutId);
        Category category=categoryRepository.getOne(categoryId);
        User user=userRepository.getOne(userId);
        news.setCategory(category);
        news.setUser(user);
        news.setLayout(layout);
        newRepository.save(news);
        if(newRepository.existsById(news.getId()))
            return true;
        return false;
    }

    @Override
    public News getNew(Long id) {
        return newRepository.getOne(id);
    }

    @Override
    public List<News> getAllNews() {
        return newRepository.findAll();
    }

    @Override
    public List<News> getNewsByUserId(Long userId) {
        return newRepository.getAllByUserId(userId);
    }
}
