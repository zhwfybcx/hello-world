package com.zwf.cms.dal.dataobject;

import java.util.Date;

/**
 * The table USER
 */
public class UserDO{

    /**
     * email EMAIL.
     */
    private String email;
    /**
     * userid 用户ID.
     */
    private Long userid;
    /**
     * account 帐号类型：0 本站 1 师说 2 QQ 3 微博.
     */
    private Long account;
    /**
     * nickname 公共用户ID，只有是师说，QQ，微博等其它网站登录时才有。.
     */
    private String nickname;
    /**
     * password 用户名.
     */
    private String password;
    /**
     * createtime 创建时间.
     */
    private Date createtime;

    /**
     * Set email EMAIL.
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Get email EMAIL.
     *
     * @return the string
     */
    public String getEmail(){
        return email;
    }

    /**
     * Set userid 用户ID.
     */
    public void setUserid(Long userid){
        this.userid = userid;
    }

    /**
     * Get userid 用户ID.
     *
     * @return the string
     */
    public Long getUserid(){
        return userid;
    }

    /**
     * Set account 帐号类型：0 本站 1 师说 2 QQ 3 微博.
     */
    public void setAccount(Long account){
        this.account = account;
    }

    /**
     * Get account 帐号类型：0 本站 1 师说 2 QQ 3 微博.
     *
     * @return the string
     */
    public Long getAccount(){
        return account;
    }

    /**
     * Set nickname 公共用户ID，只有是师说，QQ，微博等其它网站登录时才有。.
     */
    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    /**
     * Get nickname 公共用户ID，只有是师说，QQ，微博等其它网站登录时才有。.
     *
     * @return the string
     */
    public String getNickname(){
        return nickname;
    }

    /**
     * Set password 用户名.
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Get password 用户名.
     *
     * @return the string
     */
    public String getPassword(){
        return password;
    }

    /**
     * Set createtime 创建时间.
     */
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    /**
     * Get createtime 创建时间.
     *
     * @return the string
     */
    public Date getCreatetime(){
        return createtime;
    }
}
