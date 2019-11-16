package com.bakery.controller;

import com.bakery.model.ProductGroupEntity;
import com.bakery.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by behro on 07/11/2019.
 */
@Controller
@RequestMapping(value = "/productGroup")
public class ProductGroupController extends BaseController<ProductGroupEntity,Integer> {

    @Autowired
    public ProductGroupController(ProductGroupService service) {
        super(service,ProductGroupEntity.class);
    }
}
