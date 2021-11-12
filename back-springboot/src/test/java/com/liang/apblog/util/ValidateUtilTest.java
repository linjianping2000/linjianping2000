package com.liang.apblog.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.util
 * @date 2021/11/11 10:07
 */
@SpringBootTest
public class ValidateUtilTest {
    @Test
    public void isEmailTest() {
        System.out.println(ValidateUtil.isEmail("1234asf_1fa@qq.abc.com"));
        System.out.println(ValidateUtil.isEmail("1234asf_1fa@qq"));
        System.out.println(ValidateUtil.isEmail("1234asf_1fa"));
    }
}
