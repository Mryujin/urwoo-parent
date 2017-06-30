package com.urwoo.article.domain;

import com.urwoo.basic.constant.Status;
import lombok.Data;

@Data
public class TextArticle {

    private Integer id;
    private String title;
    private Status status;
    private String content;

    private ArticleCategory articleCategory;
}
