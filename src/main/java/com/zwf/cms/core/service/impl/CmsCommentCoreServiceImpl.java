package com.zwf.cms.core.service.impl;

import com.zwf.cms.core.service.CmsCommentCoreService;
import com.zwf.cms.dal.dao.CmsCommentDAO;
import com.zwf.cms.dal.dao.UserDAO;
import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.model.CommentConvertor;
import com.zwf.cms.web.model.CmsCommentInfo;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/3/12.
 */
@Service
public class CmsCommentCoreServiceImpl implements CmsCommentCoreService{

    @Autowired
    private CmsCommentDAO cmsCommentDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<CmsCommentInfo> getByArticleId(long articleId) {

        List<CmsCommentInfo> list = CommentConvertor.convertList(cmsCommentDAO.getByArticleId(articleId));
        if(list !=null && list.size()>0){
            for (CmsCommentInfo comment:list) {
                UserDO userDO = userDAO.getByPrimary(comment.getUserid());
                comment.setUserName(userDO.getNickname());
            }

        }
        return list;
    }

    @Override
    public PageVo<CmsCommentInfo> getByAllComments(int pageNum) {
        PageVo<CmsCommentInfo> pageVo = new PageVo<CmsCommentInfo>(pageNum);
        pageVo.setRows(10);
        List<CmsCommentInfo> list = CommentConvertor.convertList(cmsCommentDAO.getByAllComment((long)pageVo.getOffset(),(long)pageVo.getRows()));
        pageVo.setList(list);
        pageVo.setCount(cmsCommentDAO.getAllCommentCount());
        return pageVo;
    }

    @Override
    public long insert(CmsCommentInfo cmsCommentInfo) {
        return cmsCommentDAO.insert(cmsCommentInfo);
    }

    @Override
    public long delete(long commentId) {
        return cmsCommentDAO.deleteByPrimary(commentId);
    }
}
