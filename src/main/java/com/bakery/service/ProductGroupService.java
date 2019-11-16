package com.bakery.service;

import com.bakery.model.ProductGroupEntity;

/**
 * Created by behro on 07/11/2019.
 */
public interface ProductGroupService extends BaseService<ProductGroupEntity,Integer> {
    public ProductGroupEntity findByCode(String code);
}
