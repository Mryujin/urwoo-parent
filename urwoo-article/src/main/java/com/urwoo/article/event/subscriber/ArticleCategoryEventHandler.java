package com.urwoo.article.event.subscriber;

import com.urwoo.article.domain.event.ArticleCategoryUpdatedEvent;
import com.urwoo.article.query.ArticleCategoryQuery;
import com.urwoo.article.repository.ArticleCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 段子种类的事件处理
 */
@Component
public class ArticleCategoryEventHandler {

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;
    @Autowired
    private ArticleCategoryQuery articleCategoryQuery;

    public void updated(ArticleCategoryUpdatedEvent event) {
        try {
            articleCategoryRepository.update(event.getArticleCategoryDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
