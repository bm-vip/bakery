package com.bakery.controller;

import com.bakery.model.ProductEntity;
import com.bakery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by behro on 07/11/2019.
 */
@Controller
@RequestMapping(value = "/products")
public class ProductController extends BaseController<ProductEntity,Long> {

    @Autowired
    public ProductController(ProductService service) {
        super(service,ProductEntity.class);
    }
}
