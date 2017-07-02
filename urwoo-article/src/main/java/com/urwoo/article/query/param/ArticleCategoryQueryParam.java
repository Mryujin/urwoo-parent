package com.urwoo.article.query.param;

import com.urwoo.basic.constant.Status;
import com.urwoo.basic.base.BaseQueryParam;
import lombok.Data;

/**
 * 段子种类查询对象
 */
@Data
public class ArticleCategoryQueryParam extends BaseQueryParam{

    private String name;
    private Status status;
}
