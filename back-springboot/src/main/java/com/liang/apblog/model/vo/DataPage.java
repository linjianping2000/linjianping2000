package com.liang.apblog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.model.vo
 * @date 2021/11/11 15:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DataPage<T> {
    // 共有几条记录
    private int total;
    // 当前第几页
    private int pageNo;
    // 一页多少条记录
    private int pageSize;

    private List<T> records;
}
