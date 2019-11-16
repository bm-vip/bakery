package com.bakery.service;

import com.bakery.model.ProductEntity;

/**
 * Created by behro on 07/11/2019.
 */
public interface ProductService extends BaseService<ProductEntity,Long>{
    public ProductEntity findByCode(String code);
}
