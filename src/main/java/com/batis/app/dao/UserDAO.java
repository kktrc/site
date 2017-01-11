package com.batis.app.dao;

import com.batis.app.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by moslpc on 2017/1/11.
 */
@Service
public interface UserDAO {

    void save(User user);
}
