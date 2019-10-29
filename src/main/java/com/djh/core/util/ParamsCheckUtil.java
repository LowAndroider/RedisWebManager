package com.djh.core.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 参数校验工具
 * @author Djh
 */
public class ParamsCheckUtil {

    /**
     * 获取校验结果
     * @param bindingResult bindingResult
     * @return 校验结果
     */
    public static String getErrorMsg(BindingResult bindingResult) {
        StringBuilder errorData = new StringBuilder();

        if (bindingResult.hasErrors()) {
            for (FieldError fieldError: bindingResult.getFieldErrors()) {
                errorData.append(fieldError.getDefaultMessage()).append(";");
            }
        }

        return errorData.toString();
    }
}
