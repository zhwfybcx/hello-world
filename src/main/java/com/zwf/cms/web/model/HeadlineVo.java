package com.zwf.cms.web.model;

import com.zwf.cms.dal.dataobject.HeadlineDO;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;


public class HeadlineVo extends HeadlineDO implements Serializable {
	/**  */
	private static final long serialVersionUID = 8060627079774853013L;

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
