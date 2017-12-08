package com.ypvoid.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Yuanping on 2017/12/7.
 */
@ControllerAdvice
public class SpringMVCTestExceptionHandler {

    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex) {
        System.out.println("出异常了:" + ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        return mv;
    }
}
