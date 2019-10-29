package com.djh.module.service;

import com.djh.module.entity.dto.RedisConnectionInfo;

import java.util.Map;

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

    /**
     * 获取本地保存的redis连接信息
     * @return redis信息
     */
    Map<String, RedisConnectionInfo> redisConnList();
}
