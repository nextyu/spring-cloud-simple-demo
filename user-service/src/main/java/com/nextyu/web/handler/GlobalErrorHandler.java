package com.nextyu.web.handler;

import com.nextyu.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created on 2017-05-31 17:25
 *
 * @author nextyu
 */
@RestControllerAdvice
public class GlobalErrorHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalErrorHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Object errorHandlerOverJson(HttpServletRequest request, HttpServletResponse response,
                                       Exception e) {
        logger.error(request.getRequestURL().toString(), e);
        return new User(3L, "haha");
    }
}
