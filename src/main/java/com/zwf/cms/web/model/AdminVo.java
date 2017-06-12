package com.zwf.cms.web.model;


import com.zwf.cms.dal.dataobject.AdminDO;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class AdminVo extends AdminDO implements Serializable{
	private static final long serialVersionUID=-3259511143470614605L;

	private boolean isAdmin;

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**start**/
	public void setIsAdmin(boolean isAdmin){
		this.isAdmin=isAdmin;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	/**end**/
}
