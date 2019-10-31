package com.djh.module.service;

import com.djh.module.entity.dto.RedisConnectionInfo;

import java.util.List;
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
     * 获取连接信息
     * @return 连接信息
     */
    List<RedisConnectionInfo> getRedisInfoList();
}
