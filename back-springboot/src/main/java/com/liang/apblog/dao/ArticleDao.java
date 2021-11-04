package com.liang.apblog.dao;

import com.liang.apblog.model.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * 文章内容dao(mongodb)
 *
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.dao
 * @date 2021/11/2 15:54
 */
@Repository
public class ArticleDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 插入文章内容
     *
     * @param article 文章内容实体对象
     * @return 插入后的id
     * @throws IllegalArgumentException 文章内容不能为空
     */
    public String insert(Article article) {
        if (!StringUtils.hasText(article.getContent())) {
            throw new IllegalArgumentException("文章内容不能为空");
        }
        return mongoTemplate.save(article).getId();
    }


    /**
     * 根据id查
     *
     * @param id
     * @return 文章内容对象
     */
    public Article find(String id) {
        if (!StringUtils.hasText(id)) {
            throw new IllegalArgumentException("id不能为空");
        }
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Article.class);
    }

    /**
     * 修改已有记录
     *
     * @param article id必须已经存在相应记录
     * @return 修改成功与否
     */
    public boolean update(Article article) {
        if (find(article.getId()) == null) {
            return false;
        }
        return insert(article) != null;
    }
}
