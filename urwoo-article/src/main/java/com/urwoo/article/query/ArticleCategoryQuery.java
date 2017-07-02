package com.urwoo.article.query;

import com.urwoo.article.domain.ArticleCategory;
import com.urwoo.article.query.param.ArticleCategoryQueryParam;
import com.urwoo.article.repository.ArticleCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文章种类查询对象
 */
@Component
public class ArticleCategoryQuery {

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;

    public ArticleCategory get(Integer id){
        return null;
    }

    public ArticleCategory get(String name){
        return null;
    }

    public List<ArticleCategory> list(ArticleCategoryQueryParam queryParam,
                                      Integer start, Integer limit){
        return null;
    }
}