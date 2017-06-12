package com.zwf.cms.core.service;

import com.zwf.cms.web.model.HeadlineVo;
import com.zwf.cms.web.model.PageVo;

import java.util.List;


/**
 * 轮播管理
 * @author weifeng
 * @version $Id: HeadlineCoreService.java, v 0.1 2017年3月9日 下午1:09:22  Exp $
 */
public interface HeadlineCoreService {
    /**
     * 根据主键获取相应信息
     * @param headlineid
     * @return
     */
    HeadlineVo getByPrimary(final Long headlineid);

    /**
     * 获取分页相应数据
     * @param offset
     * @param rows
     * @return
     */
    List<HeadlineVo> getHeadlineList( int offset, int rows);

    /**
     * 根据数据包装成所有分页数据源
     * @param pageNum
     * @return
     */
    PageVo<HeadlineVo> getAllListPage(int pageNum);

    /**
     * 根据获取信息数量
     * @return
     */
    Long getByCount();

    /**
     * 更新数据
     * @param headlineid
     * @param name
     * @param picture
     * @param url
     */
    void update(Long headlineid,String name,String picture,String url);
    /**
     * 删除数据
     */
    Long deleteByPrimary(Long headlineid);
    /**
     * 增加数据
     */
    void insert(String name,String picture,String url);

    /**
     * 获取所有数据
     * @return
     */
    List<HeadlineVo> getHeadAllList();
}
