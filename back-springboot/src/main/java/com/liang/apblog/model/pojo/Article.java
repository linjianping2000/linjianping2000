package com.liang.apblog.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * MongoDB存放的文章内容
 *
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.model.pojo
 * @date 2021/11/2 10:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Article {
    /*id插入时不用设置，插入后自动生成*/
    private String id;

    private String content;

}
