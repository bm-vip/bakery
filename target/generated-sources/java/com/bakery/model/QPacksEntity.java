package com.bakery.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPacksEntity is a Querydsl query type for PacksEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPacksEntity extends EntityPathBase<PacksEntity> {

    private static final long serialVersionUID = 1894733271L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPacksEntity packsEntity = new QPacksEntity("packsEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.util.Date> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final NumberPath<Integer> packCount = createNumber("packCount", Integer.class);

    public final QProductEntity product;

    public QPacksEntity(String variable) {
        this(PacksEntity.class, forVariable(variable), INITS);
    }

    public QPacksEntity(Path<? extends PacksEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPacksEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPacksEntity(PathMetadata metadata, PathInits inits) {
        this(PacksEntity.class, metadata, inits);
    }

    public QPacksEntity(Class<? extends PacksEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProductEntity(forProperty("product"), inits.get("product")) : null;
    }

}

