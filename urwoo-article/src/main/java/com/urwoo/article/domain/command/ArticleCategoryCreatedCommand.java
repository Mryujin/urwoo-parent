package com.urwoo.article.domain.command;

import com.urwoo.article.domain.ArticleCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文章种类创建命令，文章创建命令由领域对象构成
 */
@Getter
@AllArgsConstructor
public class ArticleCategoryCreatedCommand {

    private final ArticleCategory articleCategoryVO;
}
