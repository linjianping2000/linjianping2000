package com.liang.apblog.controller;

import com.liang.apblog.model.pojo.BlogUser;
import com.liang.apblog.service.BlogUserService;
import com.liang.apblog.util.MyResp;
import com.liang.apblog.util.RespUtil;
import com.liang.apblog.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.controller
 * @date 2021/11/10 16:28
 */
@RestController
@RequestMapping("/user")
public class BlogUserController {
    @Autowired
    private BlogUserService userService;

    /**
     * 登录接口
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public MyResp login(@RequestBody BlogUser user) {
        if (ValidateUtil.isEmail(user.getEmail()) && user.getPassword() != null) {
            BlogUser login = userService.login(user.getEmail(), user.getPassword());
            if (login != null) {
                return RespUtil.success(login);
            }
        }
        return RespUtil.fail("登录失败");
    }
}
