package com.pavi.blog.handler;

import com.pavi.blog.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/5 9:37
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e){



        logger.error("Request URL:{},exception:{}",request.getRequestURL(),e);

        //try {
        //    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)
        //            != null) {
        //        throw e;
        //    }
        //} catch (Exception ex) {
        //    ex.printStackTrace();
        //}
        ModelAndView modelAndView = new ModelAndView("error/error");
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.addObject("exception",e);


        return modelAndView;
    }
}
