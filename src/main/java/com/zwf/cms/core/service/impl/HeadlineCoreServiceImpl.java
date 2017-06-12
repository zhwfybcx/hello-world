package com.zwf.cms.core.service.impl;

import com.zwf.cms.core.service.HeadlineCoreService;
import com.zwf.cms.dal.dao.HeadlineDAO;
import com.zwf.cms.dal.dataobject.HeadlineDO;
import com.zwf.cms.model.HeadlineDoConvertor;
import com.zwf.cms.web.model.HeadlineVo;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * 
 * 
 * @author weifeng
 * @version $Id: HeadlineCoreServiceImpl.java, v 0.1 2017年3月9日 下午12:57:15  Exp $
 */
@Service
public class HeadlineCoreServiceImpl implements HeadlineCoreService {
    @Autowired
    private HeadlineDAO headlineDao;

    /**
     * 根据主键获取相应信息
     * @param headlineid
     * @return
     */
    @Override
    public HeadlineVo getByPrimary(final Long headlineid) {
        HeadlineDO headlineDo=this.headlineDao.getByPrimary(headlineid);
        return HeadlineDoConvertor.convert(headlineDo);
    }

    /**
     * 获取分页相应信息
     * @param
     * @return
     */
    @Override
    public List<HeadlineVo> getHeadlineList(int offset, int rows) {
        return HeadlineDoConvertor.convert(headlineDao.getHeadlineList((long)offset, (long)rows));
    }

    /**
     * 获取信息总数
     */
    @Override
    public Long getByCount() {
        return headlineDao.getByCount();
    }

    /**
     * 获取所有的分页
     * @param pageNum
     */
    @Override
    public PageVo<HeadlineVo> getAllListPage(int pageNum) {
        PageVo<HeadlineVo> pageVo = new PageVo<HeadlineVo>(pageNum);
        pageVo.setRows(10);        
        List<HeadlineVo> list = this.getHeadlineList(pageVo.getOffset(), pageVo.getRows());
        pageVo.setList(list);
        pageVo.setCount(this.getByCount().intValue());
        return pageVo;
    }

    /**
    * 更新数据
    */
    @Override
    public void update(Long headlineid, String name,String picture, String url) {
        HeadlineDO headlineDO = new HeadlineDO();
        headlineDO.setHeadlineid(headlineid);
        headlineDO.setName(name);
        headlineDO.setPicture(picture);
        headlineDO.setUrl(url);
        headlineDO.setSort(0);
        headlineDao.update(headlineDO);
    }
    /**
     * 根据主键删除数据
     */
    @Override
    public Long deleteByPrimary(Long headlineid) {       
        return headlineDao.deleteByPrimary(headlineid);
    }
    /**
     * 插入数据
     * 
     * @return
     */
    @Override
    public void insert( String name, String picture, String url) {
        HeadlineDO headlineDO = new HeadlineDO();
        headlineDO.setName(name);
        headlineDO.setPicture(picture);
        headlineDO.setUrl(url);
        headlineDO.setSort(0);
        headlineDao.insert(headlineDO);
    }
     /**
      * 获取所有数据
      * @return
      */
    @Override
    public List<HeadlineVo> getHeadAllList() {
        return HeadlineDoConvertor.convert(headlineDao.getHeadAllList());
    }

    public HeadlineDAO getHeadlineDAO() {
        return headlineDao;
    }

    public void setHeadlineDAO(HeadlineDAO headlineDAO) {
        this.headlineDao = headlineDAO;
    }

   
}