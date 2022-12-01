package com.learning.common.service;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.learning.common.entity.BaseEntity;
import com.learning.common.spec.BaseSpec;
import com.learning.common.vo.BaseVO;
import com.learning.vo.filter.BaseFilter;

public interface GenericService <V extends BaseVO, F extends BaseFilter, S extends BaseSpec, T extends BaseEntity, ID extends Serializable>{
	
	V addUpdate(V vo);
	Page<V> getList(Pageable page, F f);
	V get(ID id);
	void validate(V vo);
	T getTById(ID id);
	T getTById(ID id, boolean isActive);
	V get(ID id, boolean isActive);
	boolean delete(ID id);
	S filter();
	T setAdditionalDataToEntity(T t, V v);
	V setAdditionalDataToVO(T t, V v);

}
