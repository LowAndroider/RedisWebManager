package com.djh.core.config;

import com.djh.core.common.R;
import com.djh.core.util.ParamsCheckUtil;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /**
     * 参数校验错误异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R errorParams(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        e.printStackTrace();
        return R.error(422, ParamsCheckUtil.getErrorMsg(bindingResult));
    }

    /**
     * 参数校验错误异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R errorParams2(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        e.printStackTrace();
        return R .error(422, ParamsCheckUtil.getErrorMsg(bindingResult));
    }
}
