package com.bakery.service.impl;

import com.bakery.dto.PageDto;
import com.bakery.dto.Select2Dto;
import com.bakery.model.BaseEntity;
import com.bakery.repository.BaseRepository;
import com.bakery.service.BaseService;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseService<T, ID> {

    public BaseRepository<T, ID> repository;

    public BaseServiceImpl(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    public abstract Predicate queryBuilder(T filter);

    /**
     * @param filter
     * @param pageable
     * @return This is make result of data in a Pageable object that way use for grid/datatable
     */
    @Override
    @Transactional(readOnly = true)
    public PageDto findAllTable(T filter, Pageable pageable) {
        Predicate predicate = queryBuilder(filter);
        Page<T> page = repository.findAll(predicate, pageable);
        return new PageDto(page.getTotalElements(), repository.count(predicate), page.getContent());
    }

    /**
     * @param filter
     * @param pageable
     * @return This is make result of Select2Dto in a Pageable object that way use for dropDown
     */
    @Override
    @Transactional(readOnly = true)
    public PageDto findAllSelect(T filter, Pageable pageable) {
        Predicate predicate = queryBuilder(filter);
        Page<T> page = repository.findAll(predicate, pageable);
        return new PageDto(page.getTotalElements(), repository.count(predicate), page.getContent().stream().
                map(m -> new Select2Dto(m.getId().toString(), m.getSelectTitle())));
    }

    /**
     * @param filter
     * @return return all data
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<T> findAll(T filter) {
        return repository.findAll(queryBuilder(filter));
    }

    /**
     * @param filter
     * @return count all data
     */
    @Override
    @Transactional(readOnly = true)
    public Long countAll(T filter) {
        return repository.count(queryBuilder(filter));
    }

    /**
     * @param id
     * @return find one record by id
     */
    @Override
    public T findById(ID id) {
        return repository.findById(id).get();
    }

    /**
     * @param entity
     * @return after save or update return that record
     */
    @Override
    public T save(T entity) {
        if (entity.getId() == null) {
            entity.setCreatedBy("ADMIN");
            entity.setCreated(new Date());
        } else {
            entity.setModifiedBy("ADMIN");
            entity.setModified(new Date());
        }
        return repository.save(entity);
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
