package com.liang.apblog.service;

import com.liang.apblog.model.pojo.BlogUser;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.service
 * @date 2021/11/4 10:44
 */
public interface BlogUserService {
    BlogUser register(String email, String password);
}
