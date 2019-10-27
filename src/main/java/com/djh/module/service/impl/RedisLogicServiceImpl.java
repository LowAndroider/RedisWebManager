package com.djh.module.service.impl;

import com.alibaba.fastjson.JSON;
import com.djh.module.dto.RedisLoginInfoDTO;
import com.djh.module.service.RedisLogicService;
import com.djh.module.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.util.Map;

/**
 *
 */
@Service("redisLogicService")
public class RedisLogicServiceImpl implements RedisLogicService {

    @Autowired
    private Map<String, Jedis> redisMap;

    @Autowired
    private File redisProperties;

    @Override
    public boolean loginRedis(RedisLoginInfoDTO loginInfo) throws Exception{
        Jedis jedis = new Jedis(loginInfo.host, loginInfo.port);
        jedis.auth(loginInfo.auth);
        String result = jedis.ping();
        if (!"PONG".equalsIgnoreCase(result)) {
            throw new Exception("连接失败，请检查连接信息后重试");
        }

        saveConnectionInfo(loginInfo, jedis);

        return true;
    }

    /**
     * 保存连接信息
     * @param loginInfo {@link RedisLoginInfoDTO}
     */
    private void saveConnectionInfo(RedisLoginInfoDTO loginInfo, Jedis jedis) throws Exception {
        // 理论上来说redisMap此时的数据跟文件内的数据是同步的
        redisMap.put(loginInfo.name + loginInfo.host, jedis);
        FileUtil.write(redisProperties, JSON.toJSONString(redisMap));
    }
}
