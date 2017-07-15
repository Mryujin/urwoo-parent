package com.urwoo.article.query;

import com.urwoo.article.domain.ArticleCategory;
import com.urwoo.article.query.param.ArticleCategoryQueryParam;
import com.urwoo.article.repository.ArticleCategoryRepository;
import com.urwoo.basic.tool.ObjectTools;
import com.urwoo.basic.tool.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章种类查询对象
 */
@Component
public class ArticleCategoryQuery {

    private Logger logger = LoggerFactory.getLogger(ArticleCategoryQuery.class);

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;

    public ArticleCategory get(Long id){

        logger.info("get() : id={}", id);
        return articleCategoryRepository.get(id);
    }

    public ArticleCategory get(String name){
        logger.info("get() : name={}", name);
        return articleCategoryRepository.get(name);
    }

    public List<ArticleCategory> list(ArticleCategoryQueryParam queryParam,
                                      Integer start, Integer limit) {

        logger.info("list() : queryParam={}", ObjectTools.toString(queryParam), start, limit);

        return articleCategoryRepository.list(transformMap(queryParam), start, limit);
    }

    private Map<String, Object> transformMap(ArticleCategoryQueryParam param){

        if (ObjectTools.isNull(param)){
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        if (StringTools.isNotNullAndEmpty(param.getName())) {
            map.put("name", param.getName());
        }
        if (ObjectTools.nonNull(param.getStatus())) {
            map.put("status", param.getStatus().code());
        }
        if (ObjectTools.nonNull(param.getEndTime())
                && ObjectTools.nonNull(param.getStartTime())){
            map.put("startTime", param.getStartTime());
            map.put("endTime", param.getEndTime());
        }
        return map;
    }
}