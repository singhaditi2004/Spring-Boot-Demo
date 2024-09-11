package com.springboot.first.springboot_demo;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError() {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errorMessage", "Something went wrong. Please try again later.");
        return mav;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleException(Exception e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errorMessage", "An unexpected error occurred: " + e.getMessage());
        return mav;
    }
}
