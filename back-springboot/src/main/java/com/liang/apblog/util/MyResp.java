package com.liang.apblog.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.cwen.util
 * @date 2021/6/7 20:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MyResp<T> {
    private int code;
    private boolean isSuccess;
    private String message;
    private T data;
}
