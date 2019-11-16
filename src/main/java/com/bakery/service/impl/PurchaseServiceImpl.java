package com.bakery.service.impl;

import com.bakery.common.Utils;
import com.bakery.dto.ResultDto;
import com.bakery.model.PacksEntity;
import com.bakery.model.ProductEntity;
import com.bakery.model.QProductEntity;
import com.bakery.repository.ProductRepository;
import com.bakery.service.PacksService;
import com.bakery.service.ProductService;
import com.bakery.service.PurchaseService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.StreamSupport;

import static com.bakery.common.MapperHelper.option;

/**
 * Created by behro on 07/11/2019.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    ProductService productService;
    @Autowired
    PacksService packsService;


    @Override
    public ResultDto calc(Integer count, Long productId) {
        ProductEntity productEntity = productService.findById(productId);

        // find Packs by product
        PacksEntity packsEntity = new PacksEntity();
        packsEntity.setProduct(productEntity);
        List<PacksEntity> packsEntities = Utils.toList(packsService.findAll(packsEntity));

        // calculate...
        int[] packCounts = packsEntities.stream().mapToInt(PacksEntity::getPackCount).toArray();
        Map<Integer, Integer> packs = Utils.withdrawAmount(packCounts, count);

        //prepare answer for custommer
        ResultDto resultDto = new ResultDto();
        List<BigDecimal> totlaAmount = new ArrayList<>();
        packs.forEach((key, value) -> {
            BigDecimal amount = packsEntities.stream().filter(f -> f.getPackCount().equals(key)).map(PacksEntity::getAmount).findFirst().orElse(BigDecimal.ZERO);
            totlaAmount.add(amount.multiply(new BigDecimal(value)));
            resultDto.getDetail().add(String.format("%s * %s => %s$", value, key, amount));
        });
        resultDto.setTotal(String.format("%s %s => %s$", count, productEntity.getCode(), totlaAmount.stream().reduce(BigDecimal::add).get()));

        return resultDto;
    }


}
