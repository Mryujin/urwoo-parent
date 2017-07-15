package com.urwoo.article.event.subscriber;

import com.google.common.eventbus.Subscribe;
import com.urwoo.article.domain.event.ArticleCategoryCreatedEvent;
import com.urwoo.article.domain.event.ArticleCategoryDeletedEvent;
import com.urwoo.article.domain.event.ArticleCategoryUpdatedEvent;
import com.urwoo.article.repository.ArticleCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 段子种类的事件处理
 */
@Component
public class ArticleCategoryEventHandler {

    private Logger logger = LoggerFactory.getLogger(ArticleCategoryEventHandler.class);

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;

    @Subscribe
    public void created(ArticleCategoryCreatedEvent event) {
        logger.info("created() : event={}", event.getArticleCategoryDTO().toString());
        try {
            articleCategoryRepository.save(event.getArticleCategoryDTO());
        } catch (Exception e) {
            logger.error("段子种类数据从数据库失败保存失败", e);
            e.printStackTrace();
        }
    }

    @Subscribe
    public void updated(ArticleCategoryUpdatedEvent event) {
        logger.info("updated() : event={}", event.getArticleCategoryDTO().toString());
        try {
            articleCategoryRepository.update(event.getArticleCategoryDTO());
        } catch (Exception e) {
            logger.error("段子种类数据从数据库更新失败", e);
            e.printStackTrace();
        }
    }

    @Subscribe
    public void deleted(ArticleCategoryDeletedEvent event) {
        logger.info("deleted() : event={}", event.getArticleCategoryId());
        try {
            articleCategoryRepository.delete(event.getArticleCategoryId());
        } catch (Exception e) {
            logger.error("段子种类数据从数据库删除失败", e);
            e.printStackTrace();
        }
    }
}
