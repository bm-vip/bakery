package com.bakery.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by behro on 07/11/2019.
 */
@Entity
@Table(name = "TBL_PRODUCT")
public class ProductEntity extends BaseEntity <Long>{

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="SEQ_PRODUCT",sequenceName="SEQ_PRODUCT",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT")
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_GROUP_ID", nullable = false)
    private ProductGroupEntity productGroup;

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
        return String.format("%s (%s)", title, code);
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ProductGroupEntity getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroupEntity productGroup) {
        this.productGroup = productGroup;
    }

}
