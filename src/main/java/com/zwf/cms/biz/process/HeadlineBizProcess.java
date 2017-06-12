package com.zwf.cms.biz.process;

import com.zwf.cms.web.model.HeadlineVo;
import com.zwf.cms.web.model.PageVo;

import java.util.List;



/**
 * @author weifeng
 * @version $Id: HeadlineBizProcess.java, v 0.1 2017年3月9日 下午1:20:31  Exp $
 */
public interface HeadlineBizProcess {
   /**  
    * 根据主键获取相应信息
    * @param headlineid
    * @return
    */
    HeadlineVo queryByPrimary(final Long headlineid);
   /**
    * 获取分页信息
    */
    PageVo<HeadlineVo> getAllListPage(int pageNum);
   /**
    * 更新数据
    */
    void update(Long headlineid,String name,String picture, String url);
    /**
     * 根据主键删除数据
     */
    Long deleteByPrimary(Long headlineid);
    /**
     * 插入数据
     */
    void addHeadline(String name,String picture, String url);
    /**
     * 查询所有数据
     */
    List<HeadlineVo> getHeadAllList();
}
