package com.bakery.repository;

import com.bakery.model.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<ProductEntity, Long> {
	ProductEntity findByCode(String role);
}
