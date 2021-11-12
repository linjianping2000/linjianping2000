package com.liang.apblog.service;

import com.liang.apblog.model.pojo.BlogUser;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.service
 * @date 2021/11/4 10:44
 */
public interface BlogUserService {
    @Deprecated
    BlogUser register(String email, String password);

    /**
     * 登录
     *
     * @param email
     * @param password
     * @return 登录成功返回用户信息，失败返回null
     */
    BlogUser login(String email, String password);
}
