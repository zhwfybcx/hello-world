package com.zwf.cms.biz.process;

import com.zwf.cms.web.model.CmsCommentInfo;
import com.zwf.cms.web.model.PageVo;

import java.util.List;
import java.util.Map;

/**
 * @author weifeng
 * @version $Id: CmsCommentBizProcess.java, v 0.1 2017年03月19日 13:38 Exp $
 */
public interface CmsCommentBizProcess {

    /**
     * 查询所有评论
     * @param articleId
     * @return
     */
    List<CmsCommentInfo> queryByArticle(long articleId);

    Map<String,Object> queryList(long articleId);

    /**
     * 包装分页数据源
     * @param pageNum
     * @return
     */
    PageVo<CmsCommentInfo> getByAllComments(int pageNum);

    /**
     * 添加数据
     * @param cmsCommentInfo
     * @return
     */
    long addComment(CmsCommentInfo cmsCommentInfo);

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    void deleteComment(long commentId);
}
