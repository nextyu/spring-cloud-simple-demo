package com.nextyu.web.handler;

import com.nextyu.domain.User;
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
    @ExceptionHandler(value = Exception.class)
    public Object errorHandlerOverJson(HttpServletRequest request, HttpServletResponse response,
                                       Exception e) {
        return new User(3L,"haha");
    }
}
