package com.liang.apblog.util;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.util
 * @date 2021/11/11 9:46
 */
public class ValidateUtil {
    // private static final String pattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    private static final Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");

    public static boolean isEmail(String s) {
        if (StringUtils.hasText(s)) {
            return pattern.matcher(s).matches();
        }
        return false;
    }
}
