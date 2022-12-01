package com.learning.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

import com.learning.vo.common.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2800218291449436457L;
	private String id;
	private Date createdOn;
	private Date modifiedOn;
	private String createdBy;
	private String modifiedBy;
	private boolean isActive;

}
