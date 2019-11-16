package com.bakery.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.bakery.dto.PageDto;
import com.bakery.dto.ResponseDto;
import com.bakery.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

import static java.lang.String.format;

/**
 * @author Behrooz Mohamadi
 * @email behroooz.mohamadi@gmail.com
 * @date 3/27/2018 11:42 AM
 */

public abstract class BaseController<T, ID extends Serializable> {
    protected Logger logger = LoggerFactory.getLogger(BaseController.class);
    protected BaseService<T, ID> service;
    protected Class<T> clazz;

    public BaseController(BaseService<T, ID> service, Class<T> clazz) {
        this.clazz = clazz;
        this.service = service;
    }

    /**
     * expose findById service on http
     * @param id
     * @return return one record by id
     */
    @RequestMapping(value = {"/findById"}, method = RequestMethod.GET)
    public ResponseEntity findById(@RequestParam ID id) {
        try {
            return new ResponseDto(service.findById(id)).send();
        } catch (Exception e) {
            logger.error(format("find {0} by id {1} throw exception",clazz.getName(),id), e);
            return new ResponseDto().send(e.toString());
        }
    }

    /**
     * expose findAllTable service on http
     * @param json
     * @param start
     * @param length
     * @param dir
     * @param col
     * @param request
     * @return This is make result of data in a Pageable object that way use for grid/datatable
     * @throws IOException
     */
    @RequestMapping(value = {"/findAllTable"}, method = RequestMethod.GET)
    public @ResponseBody
    PageDto findAllTable(@RequestParam("entity") String json,
                         @RequestParam int start,
                         @RequestParam int length,
                         @RequestParam("order[0][dir]") String dir,
                         @RequestParam("order[0][column]") int col,
                         HttpServletRequest request) throws IOException {
        T entity = new ObjectMapper().readValue(json, clazz);
        String propertyName = request.getParameter("columns[" + col + "][data]");
        Sort.Direction direction = dir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = new PageRequest(start / length, length, new Sort(direction, propertyName));
        return service.findAllTable(entity, pageable);
    }

    /**
     * expose findAllSelect service on http
     * @param json
     * @param page
     * @return This is make result of Select2Dto in a Pageable object that way use for dropDown
     * @throws IOException
     */
    @RequestMapping(value = {"/findAllSelect"}, method = RequestMethod.GET)
    public @ResponseBody
    PageDto findAllSelect(@RequestParam("entity") String json,
                          @RequestParam int page) throws IOException {
        T entity = new ObjectMapper().readValue(json, clazz);
        Pageable pageable = new PageRequest(page - 1, 10);
        return service.findAllSelect(entity, pageable);
    }

    /**
     * expose findAll service on http
     * @param json
     * @return return all data
     */
    @RequestMapping(value = {"/findAll"}, method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam("entity") String json) {
        try {
            T entity = new ObjectMapper().readValue(json, clazz);
            return new ResponseDto(service.findAll(entity)).send();
        } catch (Exception e) {
            logger.error(format("find all {0} throw exception",clazz.getName()), e);
            return new ResponseDto().send(e.toString());
        }
    }

    /**
     * expose count service on http
     * @param json
     * @return count all data
     */
    @RequestMapping(value = {"/countAll"}, method = RequestMethod.GET)
    public ResponseEntity countAll(@RequestParam("entity") String json) {
        try {
            T entity = new ObjectMapper().readValue(json, clazz);
            return new ResponseDto(service.countAll(entity)).send();
        } catch (Exception e) {
            logger.error(format("count All {0} throw exception",clazz.getName()), e);
            return new ResponseDto().send(e.toString());
        }
    }

    /**
     * expose delete service on http
     * @param id
     * @return
     */
    @RequestMapping(value = {"/deleteById"}, method = RequestMethod.POST)
    public ResponseEntity deleteById(@RequestParam("id") ID id) {
        try {
            service.deleteById(id);
            return new ResponseDto().send();
        } catch (Exception e) {
            logger.error(format("delete {0} by id {1} throw exception",clazz.getName(),id), e);
            return new ResponseDto().send(e.toString());
        }
    }

    /**
     * expose save service on http
     * @param json
     * @return after save or update return that record from database
     */
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public ResponseEntity save(@RequestParam("entity") String json) {
        try {
            T entity = new ObjectMapper().readValue(json, clazz);
            return new ResponseDto(service.save(entity)).send();
        } catch (Exception e) {
            logger.error(format("save {0} throw Exception",clazz.getName()), e);
            return new ResponseDto().send(e.toString());
        }
    }

}
