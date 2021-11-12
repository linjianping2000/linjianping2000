package com.liang.apblog.service.impl;

import com.liang.apblog.dao.BlogUserDao;
import com.liang.apblog.model.pojo.BlogUser;
import com.liang.apblog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.service.impl
 * @date 2021/11/10 16:23
 */
@Service
public class BlogUserServiceImpl implements BlogUserService {
    @Autowired
    private BlogUserDao userDao;

    @Override
    public BlogUser register(String email, String password) {
        return null;
    }

    @Override
    public BlogUser login(String email, String password) {
        BlogUser blogUser = userDao.selectByEmail(email);
        if (blogUser != null && password.equals(blogUser.getPassword())) {
            blogUser.setPassword(null);
            return blogUser;
        }
        return null;
    }
}
