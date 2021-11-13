package com.liang.apblog.controller;

import com.liang.apblog.dao.BlogUserDao;
import com.liang.apblog.model.pojo.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.controller
 * @date 2021/10/28 10:53
 */
@RestController
public class TestController {
    @Autowired
    private BlogUserDao userDao;

    @GetMapping("/test")
    public BlogUser hello() {
        // BlogUser user = new BlogUser();
        // user.setId(11111L).setEmail("hello@test.com").setPassword("123456");
        // System.out.println(userDao.insert(user));
        return new BlogUser();
        // return "hello";
    }
}
