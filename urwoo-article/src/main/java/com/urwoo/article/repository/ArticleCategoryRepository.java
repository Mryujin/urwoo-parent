package com.urwoo.article.repository;

import com.urwoo.article.domain.ArticleCategory;
import com.urwoo.basic.core.jdbc.core.EntityCreator;
import com.urwoo.basic.core.jdbc.core.SpringJdbcDao;
import com.urwoo.basic.tool.MapTools;
import com.urwoo.basic.tool.ObjectTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("articleCategoryRepository")
public class ArticleCategoryRepository extends SpringJdbcDao{

    private Logger logger = LoggerFactory.getLogger(ArticleCategoryRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long save(ArticleCategory articleCategory){
        logger.info("save() : articleCategory={}" , ObjectTools.toString(articleCategory));

        final String sql = "insert into w_article_category(name, sort, status, create_time, modify_time) value(?,?,?,now(),now())";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new EntityCreator(sql, new Object[]{
                articleCategory.getName(), articleCategory.getSort(), articleCategory.getStatus().code(),
        }), keyHolder);

        logger.info("sql : insert into w_article_category(name, sort, status, create_time, modify_time) value({},{},{},now(),now())" ,
                articleCategory.getName(), articleCategory.getSort(), articleCategory.getStatus().code());

        return keyHolder.getKey().longValue();
    }

    public void update(ArticleCategory articleCategory){
        logger.info("save() : articleCategory={}" , ObjectTools.toString(articleCategory));
        final String sql = "update w_article_category set name=?, sort=?, status=? where id=?";

        jdbcTemplate.update(sql, new Object[]{articleCategory.getName(), articleCategory.getSort(),
                articleCategory.getStatus().code(), articleCategory.getId()});

        logger.info("sql : update w_article_category SET name={}, sort={}, status={} WHERE id={}" ,
                articleCategory.getName(), articleCategory.getSort(), articleCategory.getStatus().code(), articleCategory.getId());
    }

    public void delete(Long ...ids){
        logger.info("delete() : ids={}" , ids);
        final String sql ="delete from w_article_category where id in (?)";
        logger.info("sql: delete from w_article_category where id in ({})", ids);
        jdbcTemplate.update(sql, ids);
    }

    public ArticleCategory get(Long id) {
        logger.info("get() : id={}" , id);
        final String sql = "select ac.id, ac.name, ac.sort, ac.status, ac.create_time, ac.modify_time from w_article_category ac where ac.id=:id";
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        logger.info("sql：select ac.id, ad.name, ac.sort, ac.status, ac.create_time, ac.modify_time from w_article_category ac  where ac.id={}", id);
        return get(sql, ArticleCategory.class, param);
    }

    public ArticleCategory get(String name) {
        logger.info("get() : name={}" , name);
        final String sql = "select ac.id, ac.name, ac.sort, ac.status, ac.create_time, ac.modify_time from w_article_category ac where ac.name=:name";
        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        logger.info("sql：select ac.id, ad.name, ac.sort, ac.status, ac.create_time, ac.modify_time from w_article_category ac  where ac.name={}", name);
        return get(sql, ArticleCategory.class, param);
    }

    public List<ArticleCategory> list(Map<String,Object> queryParam, int start, int limit) {
        logger.info("list() : queryParam={}, start={}, limit={}" , queryParam, start, limit);
        String sql = "select ac.id, ad.name, ac.sort, ac.status, ac.create_time, ac.modify_time from w_article_category ac";
        StringBuilder strBuilder = new StringBuilder(sql);
        genConditionSql(queryParam, strBuilder);
        logger.info("sql={}, query={}", strBuilder.toString(), queryParam);
        return list(strBuilder.toString(), ArticleCategory.class, start, limit, queryParam);
    }

    public Long count(Map<String,Object> queryParam) {
        logger.info("count() : queryParam={}" , queryParam);
        String SQL = "select count(1) from w_article_category ac";
        StringBuilder strBuilder = new StringBuilder(SQL);
        genConditionSql(queryParam, strBuilder);
        logger.info("sql={}", strBuilder.toString());
        return count(strBuilder.toString(),queryParam);
    }

    private void genConditionSql(Map<String,Object> queryParam, StringBuilder SQL){
        SQL.append(" WHERE 1=1");
        if (MapTools.isNotNullAndEmpty(queryParam)) {
            if (queryParam.containsKey("startTime") && queryParam.containsKey("endTime")) {
                SQL.append(" AND ac.create_time BETWEEN :startDate AND :endDate");
                queryParam.put("startTime", queryParam.get("startTime"));
                queryParam.put("endTime", queryParam.get("endTime"));
            }

            if (queryParam.containsKey("name")) {
                SQL.append(" AND ac.name LIKE CONCAT('%',CONCAT(:name,'%'))");
                queryParam.put("name", queryParam.get("name"));
            }

            if (queryParam.containsKey("status")){
                SQL.append(" AND ac.status=:status");
                queryParam.put("status", queryParam.get("status"));
            }
        }
    }
}
