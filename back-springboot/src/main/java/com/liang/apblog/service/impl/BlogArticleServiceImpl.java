package com.liang.apblog.service.impl;

import com.liang.apblog.dao.BlogArticleRecordDao;
import com.liang.apblog.dao.BlogCategoryDao;
import com.liang.apblog.dao.BlogUserDao;
import com.liang.apblog.dao.DictValueDao;
import com.liang.apblog.model.pojo.BlogArticleRecord;
import com.liang.apblog.model.pojo.BlogUser;
import com.liang.apblog.model.vo.BlogArticleRecordVO;
import com.liang.apblog.model.vo.DataPage;
import com.liang.apblog.service.BlogArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.service.impl
 * @date 2021/11/11 15:50
 */
@Service
public class BlogArticleServiceImpl implements BlogArticleService {
    @Autowired
    private BlogArticleRecordDao articleRecordDao;
    @Autowired
    private BlogUserDao userDao;
    @Autowired
    private DictValueDao dictValueDao;
    @Autowired
    private BlogCategoryDao categoryDao;

    @Override
    public DataPage<BlogArticleRecordVO> listByUserId(long userId, Integer status,
                                                      int pageNo, int pageSize) {
        BlogUser blogUser = userDao.selectById(userId);
        DataPage<BlogArticleRecordVO> page = new DataPage<>();
        if (blogUser != null) {
            int st = (pageNo - 1) * pageSize;
            List<BlogArticleRecord> records = articleRecordDao.selectByUserId(userId, status, st, pageSize);
            List<BlogArticleRecordVO> voList = new ArrayList<>(records.size());
            BlogArticleRecordVO vo;
            for (BlogArticleRecord record : records) {
                vo = new BlogArticleRecordVO();
                BeanUtils.copyProperties(record, vo);
                vo.setStatusText(dictValueDao.selectById(vo.getIsDeleted()).getValueName());
                vo.setCategoryText(categoryDao.selectById(vo.getFrCategoryId()).getCategoryName());
                voList.add(vo);
            }

            page.setRecords(voList)
                    .setPageNo(pageNo)
                    .setPageSize(pageSize);
        }
        return page;
    }
}
