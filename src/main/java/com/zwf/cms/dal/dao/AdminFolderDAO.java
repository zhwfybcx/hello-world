package com.zwf.cms.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zwf.cms.dal.dataobject.AdminFolderDO;
import java.util.List;
import com.zwf.cms.dal.mapper.AdminFolderDOMapper;

/**
* The Table ADMIN_FOLDER.
* ADMIN_FOLDER
*/
@Repository
public class AdminFolderDAO{

    @Autowired
    private AdminFolderDOMapper adminFolderDOMapper;

    /**
     * desc:插入�?:ADMIN_FOLDER.<br/>
     * descSql =  INSERT INTO ADMIN_FOLDER( ADMIN_ID ,FOLDER_ID ,CREATE_TIME )VALUES( #{adminId,jdbcType=BIGINT} , #{folderId,jdbcType=BIGINT} , now() )
     * @param entity entity
     * @return Long
     */
    public Long insert(AdminFolderDO entity){
        return adminFolderDOMapper.insert(entity);
    }
    /**
     * desc: 根据 管理员 id, 目录 id，获取 AdminFolder.<br/>
     * descSql =  SELECT * FROM ADMIN_FOLDER WHERE ADMIN_ID = #{adminId,jdbcType=BIGINT} AND FOLDER_ID=#{folderId,jdbcType=BIGINT}
     * @param adminId adminId
     * @param folderId folderId
     * @return List<AdminFolderDO>
     */
    public List<AdminFolderDO> getByIds(Long adminId,Long folderId){
        return adminFolderDOMapper.getByIds(adminId, folderId);
    }
    /**
     * desc:根据管理员 id, 目录 id, 删除 AdminFolder.<br/>
     * descSql =  DELETE FROM admin_folder WHERE admin_id = #{adminId,jdbcType=BIGINT} AND folder_id = #{folderId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long delete(AdminFolderDO entity){
        return adminFolderDOMapper.delete(entity);
    }
    /**
     * desc:根据管理员 id, 删除 AdminFolder.<br/>
     * descSql =  DELETE FROM admin_folder WHERE admin_id=#{adminId,jdbcType=BIGINT}
     * @param adminId adminId
     * @return Long
     */
    public Long deleteByAdminId(Long adminId){
        return adminFolderDOMapper.deleteByAdminId(adminId);
    }
    /**
     * desc:根据文件 id, 删除 AdminFolder.<br/>
     * descSql =  DELETE FROM admin_folder WHERE folder_id=#{folderId,jdbcType=BIGINT}
     * @param folderId folderId
     * @return Long
     */
    public Long deleteByFolderId(Long folderId){
        return adminFolderDOMapper.deleteByFolderId(folderId);
    }
}
