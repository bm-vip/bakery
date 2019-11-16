package com.bakery.controller;

import com.bakery.common.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Behrooz Mohamadi
 * @email behroooz.mohamadi@gmail.com
 * @date 3/27/2018 11:42 AM
 */
@Controller
public class LoginController {

    @Autowired
    Messages messages;


    @RequestMapping(value = {"/{name}"}, method = RequestMethod.GET)
    public ModelAndView loadPage(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageTitle", messages.get(name));
        modelAndView.addObject("errorMsg", null);
        modelAndView.setViewName(name);
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String resourceNotFound() {
        return "notfound";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String errorMsg = request.getParameter("errorMsg");
        if (errorMsg != null)
            modelAndView.addObject("errorMsg", messages.get(errorMsg));
        modelAndView.setViewName("purchase");
        return modelAndView;
    }

}
