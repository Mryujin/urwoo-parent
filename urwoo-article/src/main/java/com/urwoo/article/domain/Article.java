package com.urwoo.article.domain;

import com.urwoo.basic.base.BaseModel;
import com.urwoo.basic.constant.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Article extends BaseModel {

    private String title;
    private Status status;
    private String content;

    private ArticleCategory articleCategoryDTO;
}
