package com.bakery.model;

import javax.persistence.*;

/**
 * Created by behro on 07/11/2019.
 */
@Entity
@Table(name = "TBL_PRODUCT_GROUP")
public class ProductGroupEntity extends BaseEntity<Integer> {

    @Id
    @SequenceGenerator(name="SEQ_PRODUCT_GROUP",sequenceName="SEQ_PRODUCT_GROUP",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT_GROUP")
    private Integer id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "TITLE", nullable = false)
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSelectTitle() {
        return title;
    }
}
