package com.bakery.service;

import com.bakery.dto.ResultDto;
import com.bakery.model.ProductEntity;

/**
 * Created by behro on 07/11/2019.
 */
public interface PurchaseService{
    public ResultDto calc(Integer count, Long productId);
}
