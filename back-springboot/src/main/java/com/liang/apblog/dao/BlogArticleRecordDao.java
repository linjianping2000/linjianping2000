package com.liang.apblog.dao;

import com.liang.apblog.model.pojo.BlogArticleRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.dao
 * @date 2021/10/28 16:46
 */
@Repository
public interface BlogArticleRecordDao {

    /**
     * 插入记录
     *
     * @param blogArticleRecord
     * @return
     */
    int insert(BlogArticleRecord blogArticleRecord);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    BlogArticleRecord selectById(Long id);

    /**
     * 根据外键，用户id查询
     *
     * @param userId 外键，用户id
     * @param status 状态位，如果为null则查询所有状态
     * @return
     */
    List<BlogArticleRecord> selectByUserId(Long userId, Integer status);

    /**
     * 根据外键，分类id查询
     *
     * @param categoryId 外键，分类id
     * @return
     */
    List<BlogArticleRecord> selectByCategoryId(Long categoryId);

    /**
     * 修改
     *
     * @param blogArticleRecord 可以修改
     *                          1. 状态位 isDeleted
     *                          2. 文章标题 articleTitle
     *                          3. 摘要 articleSummary
     *                          4. 分类 frCategoryId
     *                          5. 排序 priority
     * @return
     */
    int update(BlogArticleRecord blogArticleRecord);

    /**
     * 评论数加一
     *
     * @param id
     * @return
     */
    int addCommentCount(Long id);

    /**
     * 访问量加一
     *
     * @param id
     * @return
     */
    int addVisitCount(Long id);


}
