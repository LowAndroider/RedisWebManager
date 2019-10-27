package com.djh.module.service;

import com.djh.module.dto.RedisLoginInfoDTO;

public interface RedisLogicService {

    /**
     * 连接redis
     * @param loginInfo {@link RedisLoginInfoDTO}
     * @return 是否连接成功
     * @throws Exception 连接redis相关报错信息
     */
    boolean loginRedis(RedisLoginInfoDTO loginInfo) throws Exception;
}
