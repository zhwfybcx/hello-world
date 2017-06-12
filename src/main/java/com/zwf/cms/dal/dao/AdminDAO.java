package com.zwf.cms.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zwf.cms.dal.dataobject.AdminDO;
import java.util.List;
import com.zwf.cms.dal.mapper.AdminDOMapper;

/**
* The Table ADMIN.
* ADMIN
*/
@Repository
public class AdminDAO{

    @Autowired
    private AdminDOMapper adminDOMapper;

    /**
     * desc:插入表:ADMIN.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO ADMIN( NAME ,ADMIN_ID ,PASSWORD ,CREATE_TIME ,UPDATE_TIME )VALUES( #{name,jdbcType=VARCHAR} , #{adminId,jdbcType=BIGINT} , #{password,jdbcType=VARCHAR} , now() , now() )
     * @param entity entity
     * @return Long
     */
    public Long insert(AdminDO entity){
        return adminDOMapper.insert(entity);
    }
    /**
     * desc:更新表:ADMIN.<br/>
     * descSql =  UPDATE ADMIN SET NAME = #{name,jdbcType=VARCHAR} ,PASSWORD = #{password,jdbcType=VARCHAR} ,UPDATE_TIME = now() WHERE ADMIN_ID = #{adminId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(AdminDO entity){
        return adminDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:ADMIN.<br/>
     * descSql =  DELETE FROM ADMIN WHERE ADMIN_ID = #{adminId,jdbcType=BIGINT}
     * @param adminId adminId
     * @return Long
     */
    public Long deleteByPrimary(Long adminId){
        return adminDOMapper.deleteByPrimary(adminId);
    }
    /**
     * desc:根据主键获取数据:ADMIN.<br/>
     * descSql =  SELECT * FROM ADMIN WHERE ADMIN_ID = #{adminId,jdbcType=BIGINT}
     * @param adminId adminId
     * @return AdminDO
     */
    public AdminDO getByPrimary(Long adminId){
        return adminDOMapper.getByPrimary(adminId);
    }
    /**
     * desc:根据姓名获取数据:ADMIN.<br/>
     * descSql =  SELECT * FROM ADMIN WHERE name = #{name,jdbcType=VARCHAR}
     * @param name name
     * @return AdminDO
     */
    public AdminDO getByName(String name){
        return adminDOMapper.getByName(name);
    }
    /**
     * desc:获取部分数据:ADMIN.<br/>
     * descSql =  SELECT * FROM ADMIN limit #{offset,jdbcType=BIGINT},#{rows,jdbcType=BIGINT}
     * @param offset offset
     * @param rows rows
     * @return List<AdminDO>
     */
    public List<AdminDO> getPartList(Long offset,Long rows){
        return adminDOMapper.getPartList(offset, rows);
    }
    /**
     * desc:获取部分数据的数量:ADMIN.<br/>
     * descSql =  SELECT count(*) FROM ADMIN
     * @return int
     */
    public int getAllListCount(){
        return adminDOMapper.getAllListCount();
    }
    /**
     * desc:获取全部数据的数量:ADMIN.<br/>
     * descSql =  SELECT * FROM ADMIN ORDER BY update_time
     * @return List<AdminDO>
     */
    public List<AdminDO> getAllList(){
        return adminDOMapper.getAllList();
    }
}
