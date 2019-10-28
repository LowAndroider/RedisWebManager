package com.djh.module.service;

import com.djh.module.entity.dto.RedisConnectionInfo;

/**
 * @author Djh
 */
public interface RedisLogicService {

    /**
     * 连接redis
     * @param loginInfo {@link RedisConnectionInfo}
     * @throws Exception 连接redis相关报错信息
     */
    void loginRedis(RedisConnectionInfo loginInfo) throws Exception;
}
