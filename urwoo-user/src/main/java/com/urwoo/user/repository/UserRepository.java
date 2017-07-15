package com.urwoo.user.repository;

import com.urwoo.basic.core.jdbc.core.EntityCreator;
import com.urwoo.basic.core.jdbc.core.SpringJdbcDao;
import com.urwoo.basic.tool.ObjectTools;
import com.urwoo.user.domain.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("userRepository")
public class UserRepository extends SpringJdbcDao{

    private Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long save(UserModel user){

        logger.info("save() : user={}" , ObjectTools.toString(user));

        final String sql = "insert into w_user(username,nickname,phone,email,status,login_type,avatar,gender,meta,level,md5,create_date,modify_date) value(?,?,?,?,?,?,?,?,?,?,?,now(),now())";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new EntityCreator(sql, new Object[]{
                user.getUsername(), user.getNickname(), user.getPhone(),
                user.getEmail(), user.getStatus().code(), user.getLoginType(), user.getAvatar(),
                user.getGender().code(), user.getMeta(), user.getLevel().code(), user.getMd5()
        }), keyHolder);

        logger.info("sql : insert into w_user(username,nickname,phone,email,status,login_type,avatar,gender,meta,level,md5,create_date,modify_date) value({},{},{},{},{},{},{},{},{},{},{},now(),now())" ,
                user.getUsername(), user.getNickname(), user.getPhone(),
                user.getEmail(), user.getStatus().code(), user.getLoginType(), user.getAvatar(),
                user.getGender().code(), user.getMeta(), user.getLevel().code(), user.getMd5());

        return keyHolder.getKey().longValue();
    }

    /**
     username,nickname,phone,email,status,login_type,avatar,gender,meta,level,md5,create_date,modify_date
     */
    public void update(UserModel user){
        logger.info("save() : user={}" , ObjectTools.toString(user));
        final String sql = "update w_user set nickname=?,phone=?,email=?,status=?,avatar=?,meta=?,level=? where id=?";

        jdbcTemplate.update(sql, new Object[]{user.getNickname(), user.getPhone(), user.getEmail(),
                user.getStatus().code(), user.getAvatar(), user.getMeta(), user.getId()});

        logger.info("sql :update w_user set nickname={},phone={},email={},status={},avatar={},meta={},level={} where id={}" ,
                user.getNickname(), user.getPhone(), user.getEmail(),
                user.getStatus().code(), user.getAvatar(), user.getMeta());
    }

    public void delete(Long ...ids){
        logger.info("delete() : ids={}" , ids);
        final String sql ="delete from w_user where id in (?)";
        logger.info("sql: delete from w_user where id in ({})", ids);
        jdbcTemplate.update(sql, ids);
    }

    public UserModel get(Long id) {
        logger.info("get() : id={}" , id);

        final String sql = "select u.id,u.username,u.nickname,u.phone,u.email,u.status,u.login_type,u.avatar,u.gender,u.meta,u.level,u.md5,u.create_date,u.modify_date from w_user u where u.id=:id";

        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        logger.info("select u.id,u.username,u.nickname,u.phone,u.email,u.status,u.login_type,u.avatar,u.gender,u.meta,u.level,u.md5,u.create_date,u.modify_date from w_user u where u.id={}", id);
        return get(sql, UserModel.class, param);
    }

    public UserModel get(String username) {
        logger.info("get() : username={}" , username);

        final String sql = "select u.id,u.username,u.nickname,u.phone,u.email,u.status,u.login_type,u.avatar,u.gender,u.meta,u.level,u.md5,u.create_date,u.modify_date from w_user u where u.username=:username";

        Map<String, Object> param = new HashMap<>();
        param.put("name", username);
        logger.info("select u.id,u.username,u.nickname,u.phone,u.email,u.status,u.login_type,u.avatar,u.gender,u.meta,u.level,u.md5,u.create_date,u.modify_date from w_user u where u.username={}", username);
        return get(sql, UserModel.class, param);
    }
}
