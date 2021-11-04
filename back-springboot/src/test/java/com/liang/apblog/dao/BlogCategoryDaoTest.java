package com.liang.apblog.dao;

import com.liang.apblog.model.pojo.BlogCategory;
import com.liang.apblog.util.SnowflakeIdWorker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.dao
 * @date 2021/11/4 10:18
 */
@SpringBootTest
public class BlogCategoryDaoTest {
    @Autowired
    private BlogCategoryDao categoryDao;

    @Autowired
    @Qualifier("idWorker")
    private SnowflakeIdWorker idWorker;

    @Test
    public void insertTest() {
        BlogCategory category = new BlogCategory();
        category.setId(idWorker.nextId())
                .setFrUserId(1L)
                .setCategoryName("spring")
                .setCategoryDesc("一起学");
        System.out.println(categoryDao.insert(category));
    }

    @Test
    public void updateTest() {
        BlogCategory category = new BlogCategory();
        category.setId(1363162368573440L)
                .setCategoryName("java12")
                .setCategoryDesc("快来学习吧12");
        System.out.println(categoryDao.update(category));
    }

    @Test
    public void selectByIdTest() {
        System.out.println(categoryDao.selectById(1363162368573440L));
    }

    @Test
    public void selectByUserIdTest() {
        categoryDao.selectByUserId(1L, 1).forEach(System.out::println);
    }
}
