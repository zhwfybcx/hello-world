package com.zwf.cms.model;


import com.zwf.cms.dal.dataobject.HeadlineDO;
import com.zwf.cms.web.model.HeadlineVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * HeadlineDo转换
 * @author weifeng
 * @version $Id: HeadlineDoConvertor.java, v 0.1 2017年3月10日 下午3:21:04 dell Exp $
 */
public class HeadlineDoConvertor {
    /**
     * Vo转换为HeadlineDO
     * 
     * @return
     */
  public static HeadlineDO convertToDo(HeadlineVo headlineVo){
      if(headlineVo==null){
          return null;
      }
      HeadlineDO headlineDO=new HeadlineDO();
      BeanUtils.copyProperties(headlineVo,headlineDO,"createTime");
    return headlineDO;            
  }
  /**
   * HeadlineDO转换Vo
   * @return
   */
  public static HeadlineVo convert(HeadlineDO headlineDO){
      if(headlineDO==null){
          return null;
      }
      HeadlineVo headlineVo=new HeadlineVo();
      BeanUtils.copyProperties(headlineDO,headlineVo,"createTime");
      return headlineVo;
      
  }
  /**
   * list<HeadlineDO>转换List<Vo>
   * @return
   */
  public static List<HeadlineVo> convert(List<HeadlineDO> headlineDoList){
      if(headlineDoList==null || headlineDoList.size() < 1){
          return null;
      }
     List<HeadlineVo> headlineVoList=new ArrayList<>();
     for(HeadlineDO headlline:headlineDoList){
         if(headlline==null){
             continue;
         }
         headlineVoList.add(convert(headlline));
     }
      return headlineVoList;     
  }
  
} 
