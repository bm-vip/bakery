package com.bakery.repository;

import com.bakery.model.ProductGroupEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGroupRepository extends BaseRepository<ProductGroupEntity, Integer> {
	ProductGroupEntity findByCode(String code);
}
