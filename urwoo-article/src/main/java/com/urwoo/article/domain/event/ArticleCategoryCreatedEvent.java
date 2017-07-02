package com.urwoo.article.domain.event;

import com.urwoo.article.domain.ArticleCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 段子种类创建事件
 */
@Getter
@AllArgsConstructor
public class ArticleCategoryCreatedEvent {

    private final ArticleCategory articleCategoryDTO;
}
