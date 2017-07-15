package com.urwoo.article.domain.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文章种类创建命令
 */
@Getter
@AllArgsConstructor
public class ArticleCategoryDeletedCommand {

    private final Long articleCategoryId;
}
