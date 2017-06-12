package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.UserDO;
import java.lang.Long;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于�?要对分页支持,请直接使用对应的DAO�?
 * The Table USER.
 * USER
 */
public interface UserDOMapper{

    /**
     * desc:插入�?:USER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO USER( EMAIL ,USERID ,ACCOUNT ,NICKNAME ,PASSWORD ,CREATETIME )VALUES( #{email,jdbcType=VARCHAR} , #{userid,jdbcType=BIGINT} , #{account,jdbcType=BIGINT} , #{nickname,jdbcType=VARCHAR} , #{password,jdbcType=VARCHAR} , #{createtime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(UserDO entity);
    /**
     * desc:更新�?:USER.<br/>
     * descSql =  UPDATE USER SET EMAIL = #{email,jdbcType=VARCHAR} ,ACCOUNT = #{account,jdbcType=BIGINT} ,NICKNAME = #{nickname,jdbcType=VARCHAR} ,PASSWORD = #{password,jdbcType=VARCHAR} ,CREATETIME = #{createtime,jdbcType=TIMESTAMP} WHERE USERID = #{userid,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(UserDO entity);
    /**
     * desc:根据主键删除数据:USER.<br/>
     * descSql =  DELETE FROM USER WHERE USERID = #{userid,jdbcType=BIGINT}
     * @param userid userid
     * @return Long
     */
    Long deleteByPrimary(Long userid);
    /**
     * desc:根据主键获取数据:USER.<br/>
     * descSql =  SELECT * FROM USER WHERE USERID = #{userid,jdbcType=BIGINT}
     * @param userid userid
     * @return UserDO
     */
    UserDO getByPrimary(Long userid);
    /**
     * desc:根据主键获取数据:USER.<br/>
     * descSql =  SELECT COUNT(*) FROM USER WHERE DATE_FORMAT(createTime,'%Y-%m-%d') = #{timeDesc,jdbcType=VARCHAR}
     * @param timeDesc timeDesc
     * @return Long
     */
    Long getByDateCount(String timeDesc);
    /**
     * desc:根据主键获取数据:USER.<br/>
     * descSql =  SELECT * FROM USER
     * @return List<UserDO>
     */
    List<UserDO> getAllUser();
    /**
     * desc:根据主键获取数据:USER.<br/>
     * descSql =  SELECT Count(*) FROM USER
     * @return Long
     */
    Long getAllUserCount();
    /**
     * desc:根据主键获取数据:USER.<br/>
     * descSql =  SELECT * FROM USER WHERE ACCOUNT = #{account,jdbcType=BIGINT}
     * @param account account
     * @return UserDO
     */
    UserDO getByAccount(Long account);
    /**
     * desc:更新�?:USER.<br/>
     * descSql =  SELECT * FROM USER WHERE EMAIL = #{email,jdbcType=VARCHAR}
     * @param email email
     * @return UserDO
     */
    UserDO getByEmail(String email);
}
