package com.zwf.cms.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zwf.cms.dal.dataobject.UserDO;
import java.lang.Long;
import java.util.List;
import com.zwf.cms.dal.mapper.UserDOMapper;

/**
* The Table USER.
* USER
*/
@Repository
public class UserDAO{

    @Autowired
    private UserDOMapper userDOMapper;

    /**
     * desc:插入�?:USER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO USER( EMAIL ,USERID ,ACCOUNT ,NICKNAME ,PASSWORD ,CREATETIME )VALUES( #{email,jdbcType=VARCHAR} , #{userid,jdbcType=BIGINT} , #{account,jdbcType=BIGINT} , #{nickname,jdbcType=VARCHAR} , #{password,jdbcType=VARCHAR} , #{createtime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    public Long insert(UserDO entity){
        return userDOMapper.insert(entity);
    }
    /**
     * desc:更新�?:USER.<br/>
     * descSql =  UPDATE USER SET EMAIL = #{email,jdbcType=VARCHAR} ,ACCOUNT = #{account,jdbcType=BIGINT} ,NICKNAME = #{nickname,jdbcType=VARCHAR} ,PASSWORD = #{password,jdbcType=VARCHAR} ,CREATETIME = #{createtime,jdbcType=TIMESTAMP} WHERE USERID = #{userid,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(UserDO entity){
        return userDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:USER.<br/>
     * descSql =  DELETE FROM USER WHERE USERID = #{userid,jdbcType=BIGINT}
     * @param userid userid
     * @return Long
     */
    public Long deleteByPrimary(Long userid){
        return userDOMapper.deleteByPrimary(userid);
    }
    /**
     * desc:根据主键获取数据:USER.<br/>
     * descSql =  SELECT * FROM USER WHERE USERID = #{userid,jdbcType=BIGINT}
     * @param userid userid
     * @return UserDO
     */
    public UserDO getByPrimary(Long userid){
        return userDOMapper.getByPrimary(userid);
    }
    /**
     * desc:根据主键获取数据:USER.<br/>
     * descSql =  SELECT COUNT(*) FROM USER WHERE DATE_FORMAT(createTime,'%Y-%m-%d') = #{timeDesc,jdbcType=VARCHAR}
     * @param timeDesc timeDesc
     * @return Long
     */
    public Long getByDateCount(String timeDesc){
        return userDOMapper.getByDateCount(timeDesc);
    }
    /**
     * desc:根据主键获取数据:USER.<br/>
     * descSql =  SELECT * FROM USER
     * @return List<UserDO>
     */
    public List<UserDO> getAllUser(){
        return userDOMapper.getAllUser();
    }
    /**
     * desc:根据主键获取数据:USER.<br/>
     * descSql =  SELECT Count(*) FROM USER
     * @return Long
     */
    public Long getAllUserCount(){
        return userDOMapper.getAllUserCount();
    }
    /**
     * desc:根据主键获取数据:USER.<br/>
     * descSql =  SELECT * FROM USER WHERE ACCOUNT = #{account,jdbcType=BIGINT}
     * @param account account
     * @return UserDO
     */
    public UserDO getByAccount(Long account){
        return userDOMapper.getByAccount(account);
    }
    /**
     * desc:更新�?:USER.<br/>
     * descSql =  SELECT * FROM USER WHERE EMAIL = #{email,jdbcType=VARCHAR}
     * @param email email
     * @return UserDO
     */
    public UserDO getByEmail(String email){
        return userDOMapper.getByEmail(email);
    }
}
