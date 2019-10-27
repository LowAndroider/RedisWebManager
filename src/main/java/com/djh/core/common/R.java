package com.djh.core.common;

import lombok.Data;

@Data
public class R<T> {

    private int code;

    private String msg;

    private T data;


    public static <T> R success(String msg, T data) {
        R r = new R();
        r.code = 200;
        r.msg = msg;
        r.data = data;

        return r;
    }

    public static <T> R success(T obj) {
        return success("请求成功", obj);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.code = code;
        r.msg = msg;
        return r;
    }

    public static R error(String msg) {
        return error(500, msg);
    }
}
