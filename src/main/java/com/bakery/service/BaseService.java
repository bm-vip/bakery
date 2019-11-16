package com.bakery.service;

import com.bakery.dto.PageDto;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * Created by behro on 07/11/2019.
 */
public interface BaseService<T, ID extends Serializable> {
    PageDto findAllTable(T filter, Pageable pageable);
    PageDto findAllSelect(T filter, Pageable pageable);
    Iterable<T> findAll(T filter);
    Long countAll(T filter);
    T findById(ID id);
    T save(T entity);
    void deleteById(ID id);
}
