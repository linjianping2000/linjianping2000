package com.liang.apblog.dao;

import com.liang.apblog.model.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.dao
 * @date 2021/11/2 16:41
 */
@SpringBootTest
public class ArticleDaoTest {
    @Autowired
    private ArticleDao articleDao;

    @Test
    public void insertTest() {
        Article article = new Article();
        article.setContent("是一首简单的");
        System.out.println("插入成功: " + articleDao.insert(article));

        // articleDao.insert(new Article());
    }

    @Test
    public void findTest() {
        // System.out.println(articleDao.find("1"));
        //
        // System.out.println(articleDao.find("2"));
        //
        // System.out.println(articleDao.find(""));
        System.out.println(articleDao.find(null));
        // System.out.println(articleDao.find("6183c36cd9f0aa5be2ac7080"));
    }

    @Test
    public void updateTest() {
        Article article = new Article();
        // article.setId("1").setContent("爱让每个人都有机会");
        // System.out.println(articleDao.update(article));

        article.setId("2");
        System.out.println(articleDao.update(article));
    }

}
