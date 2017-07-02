package com.urwoo.article.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 段子种类删除事件
 */
@Getter
@AllArgsConstructor
public class ArticleCategoryDeletedEvent {

    private final Integer articleCategoryId;
}
