package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.AdminDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于�?要对分页支持,请直接使用对应的DAO�?
 * The Table ADMIN.
 * ADMIN
 */
public interface AdminDOMapper{

    /**
     * desc:插入表:ADMIN.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO ADMIN( NAME ,ADMIN_ID ,PASSWORD ,CREATE_TIME ,UPDATE_TIME )VALUES( #{name,jdbcType=VARCHAR} , #{adminId,jdbcType=BIGINT} , #{password,jdbcType=VARCHAR} , now() , now() )
     * @param entity entity
     * @return Long
     */
    Long insert(AdminDO entity);
    /**
     * desc:更新表:ADMIN.<br/>
     * descSql =  UPDATE ADMIN SET NAME = #{name,jdbcType=VARCHAR} ,PASSWORD = #{password,jdbcType=VARCHAR} ,UPDATE_TIME = now() WHERE ADMIN_ID = #{adminId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(AdminDO entity);
    /**
     * desc:根据主键删除数据:ADMIN.<br/>
     * descSql =  DELETE FROM ADMIN WHERE ADMIN_ID = #{adminId,jdbcType=BIGINT}
     * @param adminId adminId
     * @return Long
     */
    Long deleteByPrimary(Long adminId);
    /**
     * desc:根据主键获取数据:ADMIN.<br/>
     * descSql =  SELECT * FROM ADMIN WHERE ADMIN_ID = #{adminId,jdbcType=BIGINT}
     * @param adminId adminId
     * @return AdminDO
     */
    AdminDO getByPrimary(Long adminId);
    /**
     * desc:根据姓名获取数据:ADMIN.<br/>
     * descSql =  SELECT * FROM ADMIN WHERE name = #{name,jdbcType=VARCHAR}
     * @param name name
     * @return AdminDO
     */
    AdminDO getByName(String name);
    /**
     * desc:获取部分数据:ADMIN.<br/>
     * descSql =  SELECT * FROM ADMIN limit #{offset,jdbcType=BIGINT},#{rows,jdbcType=BIGINT}
     * @param offset offset
     * @param rows rows
     * @return List<AdminDO>
     */
    List<AdminDO> getPartList(@Param("offset")Long offset,@Param("rows")Long rows);
    /**
     * desc:获取部分数据的数量:ADMIN.<br/>
     * descSql =  SELECT count(*) FROM ADMIN
     * @return int
     */
    int getAllListCount();
    /**
     * desc:获取全部数据的数量:ADMIN.<br/>
     * descSql =  SELECT * FROM ADMIN ORDER BY update_time
     * @return List<AdminDO>
     */
    List<AdminDO> getAllList();
}
