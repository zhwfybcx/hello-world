package com.zwf.cms.core.service;

import com.zwf.cms.web.model.CmsCommentInfo;
import com.zwf.cms.web.model.PageVo;

import java.util.List;

/**
 * 评论
 * @author weifeng
 * @version $Id: HeadlineCoreService.java, v 0.1 2017年3月9日 下午1:09:22 dell Exp $
 */
public interface CmsCommentCoreService {

    // 根据文章id查询评论
    List<CmsCommentInfo> getByArticleId(long articleId);

    // 封装数据源
    PageVo<CmsCommentInfo> getByAllComments(int pageNum);

    // 添加评论
    long insert (CmsCommentInfo cmsCommentInfo);

    //  删除评论

    long delete (long commentId);

}
