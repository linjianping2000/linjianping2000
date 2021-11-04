package com.liang.apblog.dao;

import com.liang.apblog.model.pojo.BlogUser;
import com.liang.apblog.util.SnowflakeIdWorker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.dao
 * @date 2021/10/31 15:57
 */
@SpringBootTest
public class BlogUserDaoTest {
    @Autowired
    private BlogUserDao userDao;

    @Autowired
    @Qualifier("idWorker")
    private SnowflakeIdWorker idWorker;

    @Test
    public void insertTest() {
        BlogUser user = new BlogUser();
        user.setId(idWorker.nextId())
                .setEmail(new Random().toString() + "@a.com")
                .setPassword("123456");
        int insert = userDao.insert(user);
        assert insert == 1;
    }

    @Test
    public void selectByIdTest() {
        BlogUser user = userDao.selectById(754785976320L);
        System.out.println(user);

        System.out.println(userDao.selectById(null));
    }

    @Test
    public void selectByEmailTest() {
        BlogUser user = userDao.selectByEmail("hello@test.com");
        System.out.println(user);

        System.out.println(userDao.selectByEmail("123@com"));
    }

    @Test
    public void updatePasswordTest() {
        System.out.println(userDao.updatePassword("hello@test.com", "999999"));
        // System.out.println("-------------------------");
        // System.out.println(userDao.updatePassword("hello@test.com", "999999"));
    }

    @Test
    public void updateStatusTest() {
        System.out.println(userDao.updateStatus("hello@test.com", 1));
    }
}
