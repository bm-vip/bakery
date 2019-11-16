package com.bakery.service.impl;

import com.bakery.model.ProductEntity;
import com.bakery.model.QProductEntity;
import com.bakery.repository.ProductRepository;
import com.bakery.service.ProductService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.bakery.common.MapperHelper.option;

/**
 * Created by behro on 07/11/2019.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductEntity,Long> implements ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
        productRepository = repository;
    }

    @Override
    public Predicate queryBuilder(ProductEntity filter) {
        QProductEntity product = QProductEntity.productEntity;
        BooleanBuilder builder = new BooleanBuilder();

        option(() -> filter.getId()).ifPresent(id -> builder.and(product.id.eq(id)));
        option(() -> filter.getAmount()).ifPresent(amount -> builder.and(product.amount.eq(amount)));
        option(() -> filter.getProductGroup().getId()).ifPresent(parameterGroupId -> builder.and(product.productGroup.id.eq(parameterGroupId)));

        if (StringUtils.hasLength(filter.getCode()))
            builder.and(product.code.eq(filter.getCode()));
        if (StringUtils.hasLength(filter.getTitle()))
            builder.and(product.title.contains(filter.getTitle()));

        return builder;
    }

    @Override
    public ProductEntity findByCode(String code) {
        return productRepository.findByCode(code);
    }
}
