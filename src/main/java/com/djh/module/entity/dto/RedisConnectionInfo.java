package com.djh.module.entity.dto;

import lombok.Data;

/**
 * redis连接信息
 * @author Djh
 */
@Data
public class RedisConnectionInfo {

    /** 类型 */
    private String type;

    /** 名称 */
    private String name;

    /** ip或域名 */
    private String host;

    /** 端口 */
    private int port;

    /** 密码 */
    private String auth;
}
