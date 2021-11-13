package com.liang.apblog.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 文章实体类
 *
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.model.pojo
 * @date 2021/10/28 16:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BlogArticleRecord {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Integer isDeleted;

    private Long frUserId;
    private String articleTitle;
    private String articleSummary;
    private String frArticleId;
    private Integer commentCount;
    private Integer visitCount;
    private Long frCategoryId;
    private Integer likesCount;
    private Integer opposeCount;
    private Integer priority;
}
