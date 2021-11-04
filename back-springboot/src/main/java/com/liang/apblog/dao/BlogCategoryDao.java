package com.liang.apblog.dao;

import com.liang.apblog.model.pojo.BlogCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.dao
 * @date 2021/10/28 15:33
 */
@Repository
public interface BlogCategoryDao {
    int insert(BlogCategory category);
    int update(BlogCategory category);
    BlogCategory selectById(Long id);
    List<BlogCategory> selectByUserId(Long userId, Integer isDeleted);

}
