package com.liang.apblog.dao;

import com.liang.apblog.model.pojo.BlogUser;
import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Repository;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.dao
 * @date 2021/10/28 15:33
 */
@Repository
public interface BlogUserDao {

    /**
     * 插入一条用户记录
     *
     * @param user 用户实体类，其中id,email,password不能为空
     * @return 插入条数，一般为1
     */
    int insert(BlogUser user);

    /**
     * 根据id查看
     *
     * @param id 不能为空
     * @return
     */
    BlogUser selectById(@NotNull Long id);

    /**
     * 根据email查看
     *
     * @param email 不能为空
     * @return
     */
    BlogUser selectByEmail(@NotNull String email);

    /**
     * 根据email修改密码
     *
     * @param email    不为空，且存在对应记录
     * @param password
     * @return
     */
    int updatePassword(@NotNull String email, @NotNull String password);

    /**
     * 修改记录状态
     *
     * @param email     不为空，且存在对应记录
     * @param isDeleted 0：存在
     *                  -1：用户已删除
     * @return
     */
    int updateStatus(@NotNull String email, @NotNull Integer isDeleted);

    /**
     * 根据email修改昵称
     *
     * @param email    不为空，且存在对应记录
     * @param nickName
     * @return
     */
    int updateNickName(@NotNull String email, @NotNull String nickName);

    /**
     * 根据email修改头像
     *
     * @param email        不为空，且存在对应记录
     * @param avatarImgUrl
     * @return
     */
    int updateAvatar(@NotNull String email, @NotNull String avatarImgUrl);


}
