package com.zwf.cms.dal.dao;

import com.zwf.cms.dal.dataobject.ArticleDO;
import com.zwf.cms.dal.mapper.ExtArticleDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 2017/3/5.
 */
@Repository
public class ExtArticleDAO {
    @Autowired
    private ExtArticleDOMapper extArticleDOMapper;

    /**
     * desc:获取分页数据的数量:ARTICLE.<br/>
     * @param offset offset
     * @param rows rows
     * @return List<ArticleDO>
     */
    public List<ArticleDO> queryParmArticleList(Long folderid, int offset, int rows){
        return extArticleDOMapper.queryParmArticleList(folderid,offset,rows);
    }

    /**
     * desc:根据目录 id 获取文章数量.<br/>
     * @return Long
     */
    public Long countParmArticleList(ArticleDO article){
        return extArticleDOMapper.countParmArticleList(article);
    }

    /**
     * 自定义方法
     * 查询目录集合文章
     * @param folderStr
     * @param offset
     * @param rows
     * @return
     */
    public List<ArticleDO> getArticleListByFolderIds(List<String> folderStr, int offset, int rows) {
        return extArticleDOMapper.getArticleListByFolderIds(folderStr,offset,rows);
    }

    /**
     * 统计目录下所有文章，递归查询
     */
    public long countArticleListByFolderIds(List<String> folderStr){
        return extArticleDOMapper.countArticleListByFolderIds(folderStr);
    }

}
