package com.learning.common.spec;

import java.util.Comparator;
import java.util.function.Predicate;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.learning.common.entity.BaseEntity;
import com.learning.common.vo.BaseVO;
import com.learning.vo.filter.BaseFilter;

public abstract class BaseSpec <T extends BaseEntity,F extends BaseFilter, V extends BaseVO>{
	
	public abstract Specification<T> filter(F f, Sort sort);

	public Predicate<V> filter(F f) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<V> sort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

}
