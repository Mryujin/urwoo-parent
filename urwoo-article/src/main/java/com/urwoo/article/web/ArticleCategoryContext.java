package com.urwoo.article.web;

import com.google.common.eventbus.EventBus;
import com.urwoo.article.config.message.Message;
import com.urwoo.article.domain.ArticleCategory;
import com.urwoo.article.domain.command.ArticleCategoryCreatedCommand;
import com.urwoo.article.domain.command.ArticleCategoryUpdatedCommand;
import com.urwoo.article.query.ArticleCategoryQuery;
import com.urwoo.basic.constant.CommonConst;
import com.urwoo.basic.constant.Status;
import com.urwoo.basic.tool.ObjectTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleCategoryContext implements CommonConst {

    @Autowired
    private ArticleCategoryQuery articleCategoryQuery;
    @Autowired
    private EventBus eventBus;
    @Autowired
    private Message message;

    @PutMapping(path = "/article_cate/update")
    public ResponseEntity update(@RequestParam(name = "cateId") Long cateId,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "sort") Long sort) {

        ArticleCategory articleCategoryDTO = new ArticleCategory(eventBus);
        articleCategoryDTO.setId(cateId);
        articleCategoryDTO.setName(name);
        articleCategoryDTO.setSort(sort);

        //发起更新文章种类命令
        articleCategoryDTO.update(new ArticleCategoryUpdatedCommand(articleCategoryDTO));

        return null;
    }

    @PostMapping(path = "/article_cate/save")
    public ResponseEntity<String> save(@RequestParam(name = "name") String name,
                                       @RequestParam(name = "sort") Long sort) throws Exception {

        if (checkNameIsExist(name)) {
            throw new Exception(message.getArticleCateNameExist());
        }
        ArticleCategory articleCategoryDTO = new ArticleCategory(eventBus);
        articleCategoryDTO.setName(name);
        articleCategoryDTO.setSort(sort);
        articleCategoryDTO.setStatus(Status.ON);

        //发起更新文章种类命令
        articleCategoryDTO.save(new ArticleCategoryCreatedCommand(articleCategoryDTO));
        //Optional.ofNullable(accountService.getUserAccount()).map(account -> new ResponseEntity<>(account, HttpStatus.OK)).orElseThrow(() -> new Exception("用户账户不存在"));
        return new ResponseEntity("保存段子种类成功！", HttpStatus.OK);
    }


    public ResponseEntity query() {
        return null;
    }

    private boolean checkNameIsExist(String name) {
        return ObjectTools.nonNull(articleCategoryQuery.get(name));
    }
}
