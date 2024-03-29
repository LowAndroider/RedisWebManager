package com.djh.module.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * redis连接信息
 * @author Djh
 */
@Data
public class RedisConnectionInfo {

    /** 类型 */
    private String type;

    /** 名称 */
    @NotNull
    @Size(min = 1)
    private String name;

    /** ip或域名 */
    @NotNull
    @Size(min = 1)
    private String host;

    /** 端口 */
    private int port;

    /** 密码 */
    private String auth;
}
