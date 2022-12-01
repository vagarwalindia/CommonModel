package com.learning.common.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomRepo<T,ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
	Optional<T> findByIdAndIsActive(ID id, Boolean isActive);
}
