package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.FolderDO;
import java.util.List;
import java.lang.Long;
import org.apache.ibatis.annotations.Param;

/**
 * 由于�?要对分页支持,请直接使用对应的DAO�?
 * The Table FOLDER.
 * FOLDER
 */
public interface FolderDOMapper{

    /**
     * desc:插入�?:FOLDER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO FOLDER( NAME ,PATH ,SORT ,ENAME ,LEVEL ,STATUS ,FATHER_ID ,CREATE_TIME ,UPDATE_TIME )VALUES( #{name,jdbcType=VARCHAR} , #{path,jdbcType=VARCHAR} , #{sort,jdbcType=BIGINT} , #{ename,jdbcType=VARCHAR} , #{level,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{fatherId,jdbcType=BIGINT} , now() , now() )
     * @param entity entity
     * @return Long
     */
    Long insert(FolderDO entity);
    /**
     * desc:更新表?:FOLDER.<br/>
     * descSql =  UPDATE FOLDER SET NAME = #{name,jdbcType=VARCHAR} ,PATH = #{path,jdbcType=VARCHAR} ,ENAME = #{ename,jdbcType=VARCHAR} ,LEVEL = #{level,jdbcType=BIGINT} ,STATUS = #{status,jdbcType=VARCHAR} ,FATHER_ID = #{fatherId,jdbcType=BIGINT} ,UPDATE_TIME = now() WHERE FOLDER_ID = #{folderId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(FolderDO entity);
    /**
     * desc:根据主键删除数据:FOLDER.<br/>
     * descSql =  DELETE FROM FOLDER WHERE FOLDER_ID = #{folderId,jdbcType=BIGINT}
     * @param folderId folderId
     * @return Long
     */
    Long deleteByPrimary(Long folderId);
    /**
     * desc:根据主键获取数据:FOLDER.<br/>
     * descSql =  SELECT * FROM FOLDER WHERE FOLDER_ID = #{folderId,jdbcType=BIGINT}
     * @param folderId folderId
     * @return FolderDO
     */
    FolderDO getByPrimary(Long folderId);
    /**
     * desc:根据英文名字: 获取数据:FOLDER.<br/>
     * descSql =  SELECT * FROM FOLDER WHERE ENAME = #{ename,jdbcType=VARCHAR}
     * @param ename ename
     * @return FolderDO
     */
    FolderDO getByEname(String ename);
    /**
     * desc:根据id更新数据：path,level.<br/>
     * descSql =  UPDATE FOLDER SET PATH = #{path,jdbcType=VARCHAR} ,LEVEL = #{level,jdbcType=BIGINT} ,UPDATE_TIME = NOW() WHERE FOLDER_ID = #{folderId,jdbcType=BIGINT}
     * @param path path
     * @param level level
     * @param folderId folderId
     * @return Long
     */
    Long updatePathLevel(@Param("path")String path,@Param("level")Long level,@Param("folderId")Long folderId);
    /**
     * desc:根据 id 更新数据:sort.<br/>
     * descSql =  UPDATE FOLDER SET SORT = #{sort,jdbcType=BIGINT} ,UPDATE_TIME = NOW() WHERE FOLDER_ID = #{folderId,jdbcType=BIGINT}
     * @param sort sort
     * @param folderId folderId
     * @return Long
     */
    Long updateSort(@Param("sort")Long sort,@Param("folderId")Long folderId);
    /**
     * desc:查找所有目录.<br/>
     * descSql =  SELECT * FROM FOLDER LIMIT 20000
     * @return List<FolderDO>
     */
    List<FolderDO> getAllFolder();
    /**
     * desc:子目录的数量.<br/>
     * descSql =  SELECT count(1) FROM folder WHERE father_id = #{fatherId,jdbcType=BIGINT}
     * @param fatherId fatherId
     * @return Long
     */
    Long getChildFolderNum(Long fatherId);
    /**
     * desc:查找子目录并进行分页.<br/>
     * descSql =  SELECT * FROM folder WHERE father_id = #{fatherId,jdbcType=BIGINT} ORDER BY sort LIMIT #{offset,jdbcType=TINYINT}, #{row,jdbcType=TINYINT};
     * @param offset offset
     * @param fatherId fatherId
     * @param row row
     * @return List<FolderDO>
     */
    List<FolderDO> getChildFolderPages(@Param("offset")Integer offset,@Param("fatherId")Long fatherId,@Param("row")Integer row);
    /**
     * desc:根据管理员查找所有目录.<br/>
     * descSql =  SELECT * FROM folder WHERE folder_id IN ( SELECT af.folder_id FROM admin_folder af WHERE af.admin_id = #{adminId,jdbcType=BIGINT} )
     * @param adminId adminId
     * @return List<FolderDO>
     */
    List<FolderDO> getFolderAdminId(Long adminId);
    /**
     * desc:根据管理员查找目录分页.<br/>
     * descSql =  SELECT * FROM folder WHERE folder_id IN ( SELECT af.folder_id FROM admin_folder af WHERE af.admin_id = #{adminId,jdbcType=BIGINT} ) LIMIT #{offset,jdbcType=TINYINT},#{row,jdbcType=TINYINT};
     * @param offset offset
     * @param adminId adminId
     * @param row row
     * @return List<FolderDO>
     */
    List<FolderDO> getFolderPageByAdminId(@Param("offset")Integer offset,@Param("adminId")Long adminId,@Param("row")Integer row);
    /**
     * desc:根据管理员Id 获取没有管理权限的目录.<br/>
     * descSql =  SELECT * FROM folder WHERE folder_id NOT IN ( SELECT af.folder_id FROM admin_folder af WHERE af.admin_id = #{adminId,jdbcType=BIGINT} );
     * @param adminId adminId
     * @return List<FolderDO>
     */
    List<FolderDO> getFolderByNoAdminId(Long adminId);
    /**
     * desc:根据管理员id获取管理的目录数量.<br/>
     * descSql =  SELECT count(1) FROM folder WHERE folder_id IN ( SELECT af.folder_id FROM admin_folder af WHERE af.admin_id = #{adminId,jdbcType=BIGINT} )
     * @param adminId adminId
     * @return Long
     */
    Long getFolderCountbyAdminId(Long adminId);
    /**
     * desc:根据父Id，状态获得 folder.<br/>
     * descSql =  SELECT * FROM folder WHERE father_id=#{fatherId,jdbcType=BIGINT} AND status=#{status,jdbcType=VARCHAR}
     * @param fatherId fatherId
     * @param status status
     * @return List<FolderDO>
     */
    List<FolderDO> getFolderByFatherIdStatus(@Param("fatherId")Long fatherId,@Param("status")String status);
    /**
     * desc:根据父亲ID获取数据:father_id.<br/>
     * descSql =  SELECT * FROM FOLDER WHERE father_id = 0 AND status= 'display'
     * @return List<FolderDO>
     */
    List<FolderDO> getByFatherId();
}
