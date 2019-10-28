package com.djh.core.config;

import com.djh.core.common.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Djh
 */
@RestControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public R common(Exception e) {
        e.printStackTrace();
        return R.error(e.getMessage());
    }
}
