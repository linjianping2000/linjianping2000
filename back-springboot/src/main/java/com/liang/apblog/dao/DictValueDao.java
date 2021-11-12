package com.liang.apblog.dao;

import com.liang.apblog.model.pojo.DictValue;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.dao
 * @date 2021/11/12 15:12
 */
@Repository
public interface DictValueDao {
    List<DictValue> selectByKeyId(Integer keyId);

    DictValue selectById(Integer id);
}
