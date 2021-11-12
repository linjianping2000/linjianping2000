package com.liang.apblog.dao;

import com.liang.apblog.model.pojo.Article;
import com.liang.apblog.model.pojo.BlogArticleRecord;
import com.liang.apblog.util.SnowflakeIdWorker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.dao
 * @date 2021/11/3 20:53
 */
@SpringBootTest
public class BlogArticleRecordDaoTest {
    @Autowired
    private BlogArticleRecordDao articleRecordDao;

    @Autowired
    @Qualifier("idWorker")
    private SnowflakeIdWorker idWorker;

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void insertTest() {
        Article article = new Article();
        article.setContent("快来捞我吧，别养鱼了");
        String articleId = articleDao.insert(article);

        BlogArticleRecord articleRecord = new BlogArticleRecord();
        articleRecord.setId(idWorker.nextId())
                .setArticleTitle("标题33")
                .setArticleSummary("摘要bbb")
                .setFrUserId(1L)
                .setFrArticleId(articleId)
                .setFrCategoryId(0L);
        System.out.println(articleRecordDao.insert(articleRecord));
    }

    @Test
    public void selectByIdTest() {
        System.out.println(articleRecordDao.selectById(1162686750523392L));
        System.out.println(articleRecordDao.selectById(1162686750523395L));
    }

    @Test
    public void selectByUserIdTest() {
        articleRecordDao.selectByUserId(1L, null, 0, 2).forEach(System.out::println);
    }

    @Test
    public void selectByCategoryIdTest() {
        articleRecordDao.selectByCategoryId(0L).forEach(System.out::println);
    }

    @Test
    public void updateTest() {
        BlogArticleRecord articleRecord = new BlogArticleRecord();
        articleRecord.setId(11L)
                .setIsDeleted(5)
                .setArticleTitle("abc标题xxx123")
                .setArticleSummary("abc摘要部分000");
        System.out.println(articleRecordDao.update(articleRecord));
    }

    @Test
    public void addCommentCountTest() {
        System.out.println(articleRecordDao.addCommentCount(11L));
    }

    @Test
    public void addVisitCountTest() {
        System.out.println(articleRecordDao.addVisitCount(11L));
    }
}
