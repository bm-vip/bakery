package com.bakery.service.impl;

import com.bakery.model.PacksEntity;
import com.bakery.model.QPacksEntity;
import com.bakery.repository.PacksRepository;
import com.bakery.service.PacksService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.bakery.common.MapperHelper.option;

/**
 * Created by behro on 07/11/2019.
 */
@Service
public class PacksServiceImpl extends BaseServiceImpl<PacksEntity, Long> implements PacksService {

    private PacksRepository packsRepository;

    @Autowired
    public PacksServiceImpl(PacksRepository repository) {
        super(repository);
        packsRepository = repository;
    }


    @Override
    public Predicate queryBuilder(PacksEntity filter) {
        QPacksEntity packs = QPacksEntity.packsEntity;
        BooleanBuilder builder = new BooleanBuilder();

        option(() -> filter.getId()).ifPresent(id -> builder.and(packs.id.eq(id)));
        option(() -> filter.getPackCount()).ifPresent(packCount -> builder.and(packs.packCount.eq(packCount)));
        option(() -> filter.getAmount()).ifPresent(amount -> builder.and(packs.amount.eq(amount)));
        option(() -> filter.getProduct().getId()).ifPresent(productId -> builder.and(packs.product.id.eq(productId)));
        return builder;
    }
}
