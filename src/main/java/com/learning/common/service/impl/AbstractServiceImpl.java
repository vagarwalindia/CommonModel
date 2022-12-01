package com.learning.common.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.learning.common.entity.BaseEntity;
import com.learning.common.repository.CustomRepo;
import com.learning.common.service.GenericService;
import com.learning.common.spec.BaseSpec;
import com.learning.common.vo.BaseVO;
import com.learning.constant.MessageConstant;
import com.learning.vo.filter.BaseFilter;

public abstract class AbstractServiceImpl<V extends BaseVO, F extends BaseFilter, S extends BaseSpec, T extends BaseEntity, ID extends Serializable> implements GenericService<V, F, S, T, ID> {
	
	

	@Autowired
	private CustomRepo<T, ID> repo;

	@Override
	public V addUpdate(V vo) {
		this.validate(vo);
		T t = this.convertToEntity(vo);
		this.setAdditionalDataToEntity(t, vo);
		V v = this.convertToVO(repo.save(t));
		this.setAdditionalDataToVO(t, v);
		return v;		
	}

	abstract V convertToVO(T t);

	abstract T convertToEntity(V vo);

	@Override
	public Page<V> getList(Pageable page, F f) {
		if(checkIfFilterAndSortManually(page,f))
			page = PageRequest.of(0, Integer.MAX_VALUE);
		S s = this.filter();
		Page<T> tPage = repo.findAll(s.filter(f, page.getSort()), page);
		if(tPage!=null && tPage.hasContent())
			return this.getPageVO(tPage,f);
		else
			throw new RuntimeException(MessageConstant.PAGINATION_NO_RECORD_FOUND);
	}

	private Page<V> getPageVO(Page<T> tPage, F f) {
		 List<V> vList = tPage.get().map(t->this.convertToVO(t)).collect(Collectors.toList());
		return new PageImpl<>(vList, tPage.getPageable(), tPage.getTotalElements());
	}

	private boolean checkIfFilterAndSortManually(Pageable page, F f) {
		S s = this.filter();
		return s.sort(page.getSort())!=null || s.filter(f)!=null;
	}

	@Override
	public V get(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(V vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getTById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getTById(ID id, boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(ID id, boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public S filter() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T setAdditionalDataToEntity(T t, V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V setAdditionalDataToVO(T t, V v) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
