package com.zwf.cms.biz.process.impl;

import com.zwf.cms.biz.process.HeadlineBizProcess;
import com.zwf.cms.core.service.HeadlineCoreService;
import com.zwf.cms.web.model.HeadlineVo;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * 轮播列表
 * @author weifeng
 * @version $Id: HeadlineBizProcessImpl.java, v 0.1 2017年3月10日 上午9:07:10  Exp $
 */
@Component
public class HeadlineBizProcessImpl implements HeadlineBizProcess {
    @Autowired
    private HeadlineCoreService headlineCoreService;

    /**
    * 根据主键获取相应信息
    */
    @Override
    public HeadlineVo queryByPrimary(final Long headlineid) {
        return this.headlineCoreService.getByPrimary(headlineid);
    }

    /**
     * 获取所有的分页
     */

    @Override
    public PageVo<HeadlineVo> getAllListPage(int pageNum) {
        return headlineCoreService.getAllListPage(pageNum);
    }

    /**
     * 更新数据
     * @return
     */
    @Override
    public void update(Long headlineid, String name, String picture, String url) {
        headlineCoreService.update(headlineid, name, picture, url);
    }

    /**
     * 删除数据
     * @return
     */
    @Override
    public Long deleteByPrimary(Long headlineid) {
        return headlineCoreService.deleteByPrimary(headlineid);
    }

    /**
     * 插入数据
     * 
     * @return
     */
    @Override
    public void addHeadline(String name, String picture, String url) {
        headlineCoreService.insert( name, picture, url);
    }
     /**
      * 查询所有数据
      */
    @Override
    public List<HeadlineVo> getHeadAllList() {
        return headlineCoreService.getHeadAllList();
    }

    public HeadlineCoreService getHeadlineCoreService() {
        return headlineCoreService;
    }

    public void setHeadlineCoreService(HeadlineCoreService headlineCoreService) {
        this.headlineCoreService = headlineCoreService;
    }

   
}
