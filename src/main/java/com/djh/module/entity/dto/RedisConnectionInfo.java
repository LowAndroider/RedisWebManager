package com.djh.module.entity.dto;

import lombok.Data;

/**
 * redis连接信息
 * @author Djh
 */

public class RedisConnectionInfo {

    /** 类型 */
    public String type;

    /** 名称 */
    public String name;

    /** ip或域名 */
    public String host;

    /** 端口 */
    public int port;

    /** 密码 */
    public String auth;
}
