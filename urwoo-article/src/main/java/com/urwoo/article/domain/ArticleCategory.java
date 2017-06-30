package com.urwoo.article.domain;

import com.urwoo.basic.constant.Status;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleCategory {

    private Integer id;
    private String name;
    private Status status;
    private Date createDate;
    private Date modifyDate;
}
