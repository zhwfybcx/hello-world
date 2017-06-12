package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.ArticleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by user on 2017/3/5.
 */
public interface ExtArticleDOMapper {
    /**
     * desc:获取分页数据的数量:ARTICLE.<br/>
     * @param offset offset
     * @param rows rows
     * @return List<ArticleDO>
     */
    List<ArticleDO> queryParmArticleList(@Param("folderid")Long folderid, @Param("offset")int offset, @Param("rows")int rows);

    /**
     * desc:根据目录 id 获取文章数量.<br/>
     * @return Long
     */
    Long countParmArticleList(ArticleDO article);

    /**
     * 查询目录下所有文章，递归查询
     */
    List<ArticleDO> getArticleListByFolderIds(@Param("folderStr") List<String> folders, @Param("offset") int offset,
                                              @Param("rows") int rows);
    /**
     * 统计目录下所有文章，递归查询
     */
    long countArticleListByFolderIds(@Param("folderStr") List<String> folders);
}
