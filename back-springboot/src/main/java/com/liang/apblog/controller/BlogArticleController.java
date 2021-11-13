package com.liang.apblog.controller;

import com.liang.apblog.model.pojo.BlogArticleRecord;
import com.liang.apblog.model.vo.BlogArticleRecordVO;
import com.liang.apblog.model.vo.DataPage;
import com.liang.apblog.service.BlogArticleService;
import com.liang.apblog.util.MyResp;
import com.liang.apblog.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.apblog.controller
 * @date 2021/11/11 15:25
 */
@RestController
@RequestMapping("/blog")
public class BlogArticleController {
    @Autowired
    private BlogArticleService articleService;

    /**
     * @param userId
     * @param status
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/article")
    public MyResp listArticleByUserId(@RequestParam long userId,
                                      @RequestParam(required = false) Integer status,
                                      @RequestParam int pageNo,
                                      @RequestParam int pageSize) {
        if (pageNo <= 0 || pageSize <= 0) {
            return RespUtil.fail();
        }
        DataPage<BlogArticleRecordVO> page = articleService.listByUserId(userId, status, pageNo, pageSize);
        return RespUtil.success(page);
    }
}
