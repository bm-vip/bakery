package com.bakery.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductGroupEntity is a Querydsl query type for ProductGroupEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductGroupEntity extends EntityPathBase<ProductGroupEntity> {

    private static final long serialVersionUID = 1523947961L;

    public static final QProductGroupEntity productGroupEntity = new QProductGroupEntity("productGroupEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath code = createString("code");

    //inherited
    public final DateTimePath<java.util.Date> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath title = createString("title");

    public QProductGroupEntity(String variable) {
        super(ProductGroupEntity.class, forVariable(variable));
    }

    public QProductGroupEntity(Path<? extends ProductGroupEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductGroupEntity(PathMetadata metadata) {
        super(ProductGroupEntity.class, metadata);
    }

}

