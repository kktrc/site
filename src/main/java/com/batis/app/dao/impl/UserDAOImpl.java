package com.batis.app.dao.impl;

import com.batis.app.dao.UserDAO;
import com.batis.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

/**
 * Created by moslpc on 2017/1/11.
 */
@Service
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public void save(User user) {
        String sql = "insert into user values(?,?,?)";
        jdbcOperations.update(sql, user.getId(), user.getUserName(),
               user.getPassword());
    }
}
