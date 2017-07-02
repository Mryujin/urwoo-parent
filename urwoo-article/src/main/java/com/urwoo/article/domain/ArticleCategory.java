package com.urwoo.article.domain;

import com.urwoo.article.domain.command.ArticleCategoryUpdatedCommand;
import com.urwoo.basic.base.BaseModel;
import com.urwoo.basic.constant.Status;
import lombok.Data;
import java.util.Objects;

@Data
public class ArticleCategory extends BaseModel{

    private String name;
    private Status status;

    public void update(ArticleCategoryUpdatedCommand updateCommand) {

        if (!Objects.equals(updateCommand.getNewArticleCategoryVO().getId(), this.id)){
            System.err.print("update not this articleCategory");
            return;
        }

        this.name = updateCommand.getNewArticleCategoryVO().getName();
        this.status = updateCommand.getNewArticleCategoryVO().getStatus();
        this.createDate = updateCommand.getNewArticleCategoryVO().getCreateDate();
        this.modifyDate = updateCommand.getNewArticleCategoryVO().getModifyDate();

        //this.es.updated(new UserUpdatedEvent(updateCommand.getNewUserDTO()));
    }
}
