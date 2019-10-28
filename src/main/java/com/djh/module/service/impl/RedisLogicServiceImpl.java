package com.djh.module.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.djh.module.entity.dto.RedisConnectionInfo;
import com.djh.module.service.RedisLogicService;
import com.djh.module.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.util.Map;

/**
 * @author Djh
 */
@Service("redisLogicService")
public class RedisLogicServiceImpl implements RedisLogicService {

    @Autowired
    private Map<String, Jedis> redisMap;

    @Autowired
    private Map<String, RedisConnectionInfo> redisInfoMap;

    @Autowired
    private File redisProperties;

    @Override
    public void loginRedis(RedisConnectionInfo loginInfo) throws Exception{

        // 判断有没有重复name的连接
        if (redisInfoMap.get(loginInfo.getName()) != null) {
            throw new Exception("重复的连接名称！");
        }

        Jedis jedis = new Jedis(loginInfo.getHost(), loginInfo.getPort());
        if (!StringUtils.isEmpty(loginInfo.getAuth())) {
            jedis.auth(loginInfo.getAuth());
        }

        String result = jedis.ping();
        if (!"PONG".equalsIgnoreCase(result)) {
            throw new Exception("连接失败，请检查连接信息后重试");
        }

        saveConnectionInfo(loginInfo, jedis);

    }

    /**
     * 保存连接信息
     * @param loginInfo {@link RedisConnectionInfo}
     */
    private void saveConnectionInfo(RedisConnectionInfo loginInfo, Jedis jedis) throws Exception {
        // 理论上来说redisMap此时的数据跟文件内的数据是同步的
        redisMap.put(loginInfo.getName(), jedis);
        redisInfoMap.put(loginInfo.getName(), loginInfo);
        // 格式化输出
        FileUtil.write(redisProperties, JSON.toJSONString(redisInfoMap, SerializerFeature.PrettyFormat));
    }
}
