package com.urwoo.article.domain.event;

import com.urwoo.article.domain.ArticleCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文章种类更新事件
 */
@Getter
@AllArgsConstructor
public class ArticleCategoryUpdatedEvent {

    private final ArticleCategory articleCategoryDTO;
}
