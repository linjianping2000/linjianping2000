package com.liang.apblog.model.vo;

import com.liang.apblog.model.pojo.BlogArticleRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.model.vo
 * @date 2021/11/12 20:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BlogArticleRecordVO extends BlogArticleRecord {
    private String categoryText;
    private String statusText;
}
