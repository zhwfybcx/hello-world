package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.AdminFolderDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于�?要对分页支持,请直接使用对应的DAO�?
 * The Table ADMIN_FOLDER.
 * ADMIN_FOLDER
 */
public interface AdminFolderDOMapper{

    /**
     * desc:插入�?:ADMIN_FOLDER.<br/>
     * descSql =  INSERT INTO ADMIN_FOLDER( ADMIN_ID ,FOLDER_ID ,CREATE_TIME )VALUES( #{adminId,jdbcType=BIGINT} , #{folderId,jdbcType=BIGINT} , now() )
     * @param entity entity
     * @return Long
     */
    Long insert(AdminFolderDO entity);
    /**
     * desc: 根据 管理员 id, 目录 id，获取 AdminFolder.<br/>
     * descSql =  SELECT * FROM ADMIN_FOLDER WHERE ADMIN_ID = #{adminId,jdbcType=BIGINT} AND FOLDER_ID=#{folderId,jdbcType=BIGINT}
     * @param adminId adminId
     * @param folderId folderId
     * @return List<AdminFolderDO>
     */
    List<AdminFolderDO> getByIds(@Param("adminId")Long adminId,@Param("folderId")Long folderId);
    /**
     * desc:根据管理员 id, 目录 id, 删除 AdminFolder.<br/>
     * descSql =  DELETE FROM admin_folder WHERE admin_id = #{adminId,jdbcType=BIGINT} AND folder_id = #{folderId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long delete(AdminFolderDO entity);
    /**
     * desc:根据管理员 id, 删除 AdminFolder.<br/>
     * descSql =  DELETE FROM admin_folder WHERE admin_id=#{adminId,jdbcType=BIGINT}
     * @param adminId adminId
     * @return Long
     */
    Long deleteByAdminId(Long adminId);
    /**
     * desc:根据文件 id, 删除 AdminFolder.<br/>
     * descSql =  DELETE FROM admin_folder WHERE folder_id=#{folderId,jdbcType=BIGINT}
     * @param folderId folderId
     * @return Long
     */
    Long deleteByFolderId(Long folderId);
}
