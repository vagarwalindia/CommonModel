package com.learning.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7763777187793808428L;
	private String id;
	private List<String> ids;
	private String createdOn;
	private String modifiedOn;
	private String createdBy;
	private String modifiedBy;
	private String createdName;
	private String modifiedName;
	private boolean isActive;

}
