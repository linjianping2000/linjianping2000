package com.liang.apblog;

import com.liang.apblog.model.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootTest
class ApBlogApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        // Query query = new Query(Criteria.where("id").is("11"));
        // Article one = mongoTemplate.findOne(query, Article.class);
        // System.out.println(one);

        Article article = new Article();
        article.setId("1")
                .setContent("hello world</br>");
        Article save = mongoTemplate.save(article);
        System.out.println(save);
    }

}
