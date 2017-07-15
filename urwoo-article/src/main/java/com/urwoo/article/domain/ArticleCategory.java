package com.urwoo.article.domain;

import com.google.common.eventbus.EventBus;
import com.urwoo.article.domain.command.ArticleCategoryCreatedCommand;
import com.urwoo.article.domain.command.ArticleCategoryDeletedCommand;
import com.urwoo.article.domain.command.ArticleCategoryUpdatedCommand;
import com.urwoo.article.domain.event.ArticleCategoryCreatedEvent;
import com.urwoo.article.domain.event.ArticleCategoryDeletedEvent;
import com.urwoo.article.domain.event.ArticleCategoryUpdatedEvent;
import com.urwoo.basic.base.BaseModel;
import com.urwoo.basic.tool.ObjectTools;
import lombok.*;

import java.util.Set;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCategory extends BaseModel{

    private String name;
    private Long sort;
    private Set<Article> articles;

    public EventBus eventBus;

    public ArticleCategory(EventBus eventBus){
        this.eventBus = eventBus;
    }

    public void save(ArticleCategoryCreatedCommand createdCommand){
        this.name = createdCommand.getArticleCategoryVO().getName();
        this.status = createdCommand.getArticleCategoryVO().getStatus();
        this.sort = createdCommand.getArticleCategoryVO().getSort();

        this.eventBus.post(new ArticleCategoryCreatedEvent(
                createdCommand.getArticleCategoryVO()));
    }

    public void update(ArticleCategoryUpdatedCommand updateCommand) {

        if (!ObjectTools.equals(updateCommand.getNewArticleCategoryVO().getId(), this.id)){
            return;
        }

        this.name = updateCommand.getNewArticleCategoryVO().getName();
        this.status = updateCommand.getNewArticleCategoryVO().getStatus();
        this.sort = updateCommand.getNewArticleCategoryVO().getSort();

        this.eventBus.post(new ArticleCategoryUpdatedEvent(
                updateCommand.getNewArticleCategoryVO()));
    }

    public void delete(ArticleCategoryDeletedCommand deletedCommand){
        this.id = deletedCommand.getArticleCategoryId();
        this.eventBus.post(new ArticleCategoryDeletedEvent(
                deletedCommand.getArticleCategoryId()));
    }
}
