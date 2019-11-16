package com.bakery.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by behro on 07/11/2019.
 */
@Entity
@Table(name = "TBL_PACKS")
public class PacksEntity extends BaseEntity <Long>{

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="SEQ_PACKS",sequenceName="SEQ_PACKS",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PACKS")
    private Long id;

    @Column(name = "PACK_COUNT", nullable = false)
    private Integer packCount;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private ProductEntity product;

    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getSelectTitle() {
        return packCount.toString();
    }

    public Integer getPackCount() {
        return packCount;
    }

    public void setPackCount(Integer packCount) {
        this.packCount = packCount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
