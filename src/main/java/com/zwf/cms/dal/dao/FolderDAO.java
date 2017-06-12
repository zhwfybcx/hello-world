package com.zwf.cms.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zwf.cms.dal.dataobject.FolderDO;
import java.util.List;
import java.lang.Long;
import com.zwf.cms.dal.mapper.FolderDOMapper;

/**
* The Table FOLDER.
* FOLDER
*/
@Repository
public class FolderDAO{

    @Autowired
    private FolderDOMapper folderDOMapper;

    /**
     * desc:插入�?:FOLDER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO FOLDER( NAME ,PATH ,SORT ,ENAME ,LEVEL ,STATUS ,FATHER_ID ,CREATE_TIME ,UPDATE_TIME )VALUES( #{name,jdbcType=VARCHAR} , #{path,jdbcType=VARCHAR} , #{sort,jdbcType=BIGINT} , #{ename,jdbcType=VARCHAR} , #{level,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{fatherId,jdbcType=BIGINT} , now() , now() )
     * @param entity entity
     * @return Long
     */
    public Long insert(FolderDO entity){
        return folderDOMapper.insert(entity);
    }
    /**
     * desc:更新表?:FOLDER.<br/>
     * descSql =  UPDATE FOLDER SET NAME = #{name,jdbcType=VARCHAR} ,PATH = #{path,jdbcType=VARCHAR} ,ENAME = #{ename,jdbcType=VARCHAR} ,LEVEL = #{level,jdbcType=BIGINT} ,STATUS = #{status,jdbcType=VARCHAR} ,FATHER_ID = #{fatherId,jdbcType=BIGINT} ,UPDATE_TIME = now() WHERE FOLDER_ID = #{folderId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(FolderDO entity){
        return folderDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:FOLDER.<br/>
     * descSql =  DELETE FROM FOLDER WHERE FOLDER_ID = #{folderId,jdbcType=BIGINT}
     * @param folderId folderId
     * @return Long
     */
    public Long deleteByPrimary(Long folderId){
        return folderDOMapper.deleteByPrimary(folderId);
    }
    /**
     * desc:根据主键获取数据:FOLDER.<br/>
     * descSql =  SELECT * FROM FOLDER WHERE FOLDER_ID = #{folderId,jdbcType=BIGINT}
     * @param folderId folderId
     * @return FolderDO
     */
    public FolderDO getByPrimary(Long folderId){
        return folderDOMapper.getByPrimary(folderId);
    }
    /**
     * desc:根据英文名字: 获取数据:FOLDER.<br/>
     * descSql =  SELECT * FROM FOLDER WHERE ENAME = #{ename,jdbcType=VARCHAR}
     * @param ename ename
     * @return FolderDO
     */
    public FolderDO getByEname(String ename){
        return folderDOMapper.getByEname(ename);
    }
    /**
     * desc:根据id更新数据：path,level.<br/>
     * descSql =  UPDATE FOLDER SET PATH = #{path,jdbcType=VARCHAR} ,LEVEL = #{level,jdbcType=BIGINT} ,UPDATE_TIME = NOW() WHERE FOLDER_ID = #{folderId,jdbcType=BIGINT}
     * @param path path
     * @param level level
     * @param folderId folderId
     * @return Long
     */
    public Long updatePathLevel(String path,Long level,Long folderId){
        return folderDOMapper.updatePathLevel(path, level, folderId);
    }
    /**
     * desc:根据 id 更新数据:sort.<br/>
     * descSql =  UPDATE FOLDER SET SORT = #{sort,jdbcType=BIGINT} ,UPDATE_TIME = NOW() WHERE FOLDER_ID = #{folderId,jdbcType=BIGINT}
     * @param sort sort
     * @param folderId folderId
     * @return Long
     */
    public Long updateSort(Long sort,Long folderId){
        return folderDOMapper.updateSort(sort, folderId);
    }
    /**
     * desc:查找所有目录.<br/>
     * descSql =  SELECT * FROM FOLDER LIMIT 20000
     * @return List<FolderDO>
     */
    public List<FolderDO> getAllFolder(){
        return folderDOMapper.getAllFolder();
    }
    /**
     * desc:子目录的数量.<br/>
     * descSql =  SELECT count(1) FROM folder WHERE father_id = #{fatherId,jdbcType=BIGINT}
     * @param fatherId fatherId
     * @return Long
     */
    public Long getChildFolderNum(Long fatherId){
        return folderDOMapper.getChildFolderNum(fatherId);
    }
    /**
     * desc:查找子目录并进行分页.<br/>
     * descSql =  SELECT * FROM folder WHERE father_id = #{fatherId,jdbcType=BIGINT} ORDER BY sort LIMIT #{offset,jdbcType=TINYINT}, #{row,jdbcType=TINYINT};
     * @param offset offset
     * @param fatherId fatherId
     * @param row row
     * @return List<FolderDO>
     */
    public List<FolderDO> getChildFolderPages(Integer offset,Long fatherId,Integer row){
        return folderDOMapper.getChildFolderPages(offset, fatherId, row);
    }
    /**
     * desc:根据管理员查找所有目录.<br/>
     * descSql =  SELECT * FROM folder WHERE folder_id IN ( SELECT af.folder_id FROM admin_folder af WHERE af.admin_id = #{adminId,jdbcType=BIGINT} )
     * @param adminId adminId
     * @return List<FolderDO>
     */
    public List<FolderDO> getFolderAdminId(Long adminId){
        return folderDOMapper.getFolderAdminId(adminId);
    }
    /**
     * desc:根据管理员查找目录分页.<br/>
     * descSql =  SELECT * FROM folder WHERE folder_id IN ( SELECT af.folder_id FROM admin_folder af WHERE af.admin_id = #{adminId,jdbcType=BIGINT} ) LIMIT #{offset,jdbcType=TINYINT},#{row,jdbcType=TINYINT};
     * @param offset offset
     * @param adminId adminId
     * @param row row
     * @return List<FolderDO>
     */
    public List<FolderDO> getFolderPageByAdminId(Integer offset,Long adminId,Integer row){
        return folderDOMapper.getFolderPageByAdminId(offset, adminId, row);
    }
    /**
     * desc:根据管理员Id 获取没有管理权限的目录.<br/>
     * descSql =  SELECT * FROM folder WHERE folder_id NOT IN ( SELECT af.folder_id FROM admin_folder af WHERE af.admin_id = #{adminId,jdbcType=BIGINT} );
     * @param adminId adminId
     * @return List<FolderDO>
     */
    public List<FolderDO> getFolderByNoAdminId(Long adminId){
        return folderDOMapper.getFolderByNoAdminId(adminId);
    }
    /**
     * desc:根据管理员id获取管理的目录数量.<br/>
     * descSql =  SELECT count(1) FROM folder WHERE folder_id IN ( SELECT af.folder_id FROM admin_folder af WHERE af.admin_id = #{adminId,jdbcType=BIGINT} )
     * @param adminId adminId
     * @return Long
     */
    public Long getFolderCountbyAdminId(Long adminId){
        return folderDOMapper.getFolderCountbyAdminId(adminId);
    }
    /**
     * desc:根据父Id，状态获得 folder.<br/>
     * descSql =  SELECT * FROM folder WHERE father_id=#{fatherId,jdbcType=BIGINT} AND status=#{status,jdbcType=VARCHAR}
     * @param fatherId fatherId
     * @param status status
     * @return List<FolderDO>
     */
    public List<FolderDO> getFolderByFatherIdStatus(Long fatherId,String status){
        return folderDOMapper.getFolderByFatherIdStatus(fatherId, status);
    }
    /**
     * desc:根据父亲ID获取数据:father_id.<br/>
     * descSql =  SELECT * FROM FOLDER WHERE father_id = 0 AND status= 'display'
     * @return List<FolderDO>
     */
    public List<FolderDO> getByFatherId(){
        return folderDOMapper.getByFatherId();
    }
}
