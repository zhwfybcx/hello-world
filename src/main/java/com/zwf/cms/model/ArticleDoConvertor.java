/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.model;

import com.zwf.cms.dal.dataobject.ArticleDO;
import com.zwf.cms.web.model.ArticleInfo;
import com.zwf.cms.web.model.ArticleVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;



/**
 * @author weifeng
 * @version $Id: ArticleVoConvertor.java, v 0.1 2017年03月17日 上午9:57  Exp $
 */
public class ArticleDoConvertor {
	
	/**
	 * articleDO ->ArticleInfo
	 * @param articleDO
	 * @return
	 */
    public static ArticleInfo convertToInfo(ArticleDO articleDO) {
        if(articleDO == null){
            return null;
        }

        ArticleInfo articleInfo = new ArticleInfo();
        BeanUtils.copyProperties(articleDO,articleInfo,"createTime","updateTime");
        articleInfo.setCreatetime(articleDO.getCreatetime());
        articleInfo.setUpdatetime(articleDO.getUpdatetime());
        return articleInfo;
    }

    /**
     * ArticleInfo->ArticleDO
     * @return
     */
    public static ArticleDO convertToDo(ArticleInfo articleInfo) {
        if(articleInfo == null){
            return null;
        }
        ArticleDO articleDO = new ArticleDO();
        BeanUtils.copyProperties(articleInfo,articleDO,"createTime","updateTime");
        articleDO.setCreatetime(articleInfo.getCreatetime());
        articleDO.setUpdatetime(articleInfo.getUpdatetime());
        return articleDO;
    }
    
    /**
     * ArticleInfo->ArticleVo
     * @return
     */
    public static ArticleVo convertToVo(ArticleInfo articleInfo) {
        if(articleInfo == null){
            return null;
        }
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(articleInfo,articleVo,"createTime","updateTime");
        //articleVo.setCreatetime(articleInfo.getCreatetime());
        //articleVo.setUpdatetime(articleInfo.getUpdatetime());
        return articleVo;
    }

    public static List<ArticleInfo> convertList(List<ArticleDO> articleDOList) {
        List<ArticleInfo> articleVoList = new ArrayList<>();
        if (articleDOList != null && articleDOList.size() > 0) {
            for (int i = 0; i < articleDOList.size(); i++) {
                ArticleInfo articleVo = convertToInfo(articleDOList.get(i));
                articleVoList.add(articleVo);
            }
        }
        return articleVoList;
    }
    
    public static List<ArticleVo> convertToVoList(List<ArticleInfo> list) {
        List<ArticleVo> articleVoList = new ArrayList<ArticleVo>();
        if (list != null && list.size() > 0) {
            for (ArticleInfo articleInfo : list) {
            	ArticleVo articleVo = convertToVo(articleInfo);
                articleVoList.add(articleVo);
			}
        }
        return articleVoList;
    }
}
