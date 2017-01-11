package com.batis.app;

import com.batis.app.dao.UserDAO;
import com.batis.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by mosl on 2017/1/8.
 */
@Controller
public class AppController {

  @Autowired
  private UserDAO userDAO;

  @RequestMapping("/")
  public String getIndex() {
    return "index";
  }

  @RequestMapping("/json")
  @ResponseBody
  public Map<String,Object> getJson() {
    return new HashMap<String,Object>();
  }

  @RequestMapping("/sleep")
  @ResponseBody
  public Map<String,Object> sleep() {
    try {
      TimeUnit.SECONDS.sleep(10);
//      Thread.sleep(20 * );
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Map<String,Object> result = new HashMap<>();
    result.put("ok","good");
    return result;
  }

  @RequestMapping("/saveUser")
  @ResponseBody
  public Map<String,Object> saveUser() {
    User user = new User();
    user.setId(100);
    user.setUserName("mosl");
    user.setPassword("123456");
    userDAO.save(user);
    return new HashMap<>();
  }
}
