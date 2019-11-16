package com.bakery.controller;

import com.bakery.dto.ResponseDto;
import com.bakery.model.ProductEntity;
import com.bakery.service.ProductService;
import com.bakery.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by behro on 07/11/2019.
 */
@Controller
@RequestMapping(value = "/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @GetMapping(value = {"/calc"})
    public ResponseEntity getTopInfoWarning(@RequestParam Integer count, @RequestParam Long productId) {
        try {
            return new ResponseDto(purchaseService.calc(count, productId)).send();
        } catch (Exception e) {
            return new ResponseDto().send(e.toString());
        }
    }
}
