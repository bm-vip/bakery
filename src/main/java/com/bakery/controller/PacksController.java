package com.bakery.controller;

import com.bakery.model.PacksEntity;
import com.bakery.model.ProductEntity;
import com.bakery.service.PacksService;
import com.bakery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by behro on 07/11/2019.
 */
@Controller
@RequestMapping(value = "/packs")
public class PacksController extends BaseController<PacksEntity,Long> {

    @Autowired
    public PacksController(PacksService service) {
        super(service,PacksEntity.class);
    }
}
