package com.batis.app.dao.impl;

import com.batis.app.dao.UserDAO;
import com.batis.app.model.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by moslpc on 2017/1/11.
 */
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

    @Override
    public void save(User user) {
        String sql = "insert into user values(?,?,?)";
        this.getJdbcTemplate().update(sql, user.getId(), user.getUserName(),
               user.getPassword());
    }
}
