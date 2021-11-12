package com.liang.apblog.service;

import com.liang.apblog.model.vo.BlogArticleRecordVO;
import com.liang.apblog.model.vo.DataPage;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.service
 * @date 2021/11/11 15:34
 */
public interface BlogArticleService {
    DataPage<BlogArticleRecordVO> listByUserId(long userId, Integer status, int pageNo, int pageSize);
}
