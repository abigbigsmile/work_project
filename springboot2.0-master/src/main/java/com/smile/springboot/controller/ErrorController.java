package com.smile.springboot.controller;

import com.smile.springboot.exception.JdbcException;
import com.smile.springboot.exception.NotLoginException;
import com.smile.springboot.exception.NullOrEmptyException;
import com.smile.springboot.model.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


//设置全局捕获异常
@Controller
@ControllerAdvice(basePackages = {"com.smile.springboot.controller"})//一般异常都层层往外抛，在controller层接收
public class ErrorController {

//    @Autowired
//    private ErrorMessage errorMessage;

    //返回json格式的错误提示
    @ExceptionHandler(NullOrEmptyException.class)
    @ResponseBody
    public ErrorMessage nullOrEmptyExceptionHandler(HttpServletRequest request, NullOrEmptyException ex){
        return handleException(ex.getCODE(),ex.getMessage(), request.getRequestURL().toString());
    }

    @ExceptionHandler(NotLoginException.class)
    @ResponseBody
    public ErrorMessage notLoginExceptionHandler(HttpServletRequest request, NotLoginException ex){
        return handleException(ex.getCODE(),ex.getMessage(), request.getRequestURL().toString());
    }

    @ExceptionHandler(JdbcException.class)
    @ResponseBody
    public ErrorMessage jdbcException(HttpServletRequest request, JdbcException ex){
        return handleException(ex.getCODE(),ex.getMessage(), request.getRequestURL().toString());
    }

    //系统默认的异常处理
    @ExceptionHandler(Exception.class)
    public ModelAndView dafaultExceptionHandler(HttpServletRequest request, Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errCode",100);
        modelAndView.addObject("errMsg"," 系统错误");
        modelAndView.addObject("url", request.getRequestURL().toString());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    public ErrorMessage handleException(Integer code, String msg, String url){
        return new ErrorMessage(code, msg, url);
    }

}
