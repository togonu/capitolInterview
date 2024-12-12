package com.capitol.interview.infrastructure.adapter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitol.interview.infrastructure.adapter.entity.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
	List<PriceEntity> findAllByProductId(Long productId);
}
