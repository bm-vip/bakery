package com.bakery.service.impl;

import com.bakery.model.ProductGroupEntity;
import com.bakery.model.QProductGroupEntity;
import com.bakery.repository.ProductGroupRepository;
import com.bakery.service.ProductGroupService;
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
public class ProductGroupServiceImpl extends BaseServiceImpl<ProductGroupEntity,Integer> implements ProductGroupService {

    private ProductGroupRepository productGroupRepository;
    @Autowired
    public ProductGroupServiceImpl(ProductGroupRepository repository) {
        super(repository);
        productGroupRepository = repository;
    }

    @Override
    public Predicate queryBuilder(ProductGroupEntity filter) {
        QProductGroupEntity productGroup = QProductGroupEntity.productGroupEntity;
        BooleanBuilder builder = new BooleanBuilder();

        option(() -> filter.getId()).ifPresent(id -> builder.and(productGroup.id.eq(id)));
        if (StringUtils.hasLength(filter.getCode()))
            builder.and(productGroup.code.eq(filter.getCode()));
        if (StringUtils.hasLength(filter.getTitle()))
            builder.and(productGroup.title.contains(filter.getTitle()));
        return builder;
    }

    @Override
    public ProductGroupEntity findByCode(String code) {
        return productGroupRepository.findByCode(code);
    }
}
