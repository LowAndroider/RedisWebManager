package com.djh.module.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.djh.module.util.FileUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataConfig {

    @Value("${redis-properties}")
    private String filePath;

    @Bean("redisMap")
    public Map<String, Jedis> redisMap(@Qualifier("redisProperties") File redisProperties) throws Exception {
        Map<String, Jedis> redisMap = new HashMap<>();
        String read = FileUtil.read(redisProperties);
        if (!StringUtils.isEmpty(read)) {
            redisMap = JSON.parseObject(read, new TypeReference<Map<String, Jedis>>() {
            });
        }

        return redisMap;
    }

    @Bean("redisProperties")
    public File redisProperties() throws Exception {
        File file = new File(filePath);

        File dir = file.getParentFile();
        if (!file.exists()) {
            if (dir.exists()) {
                if (!dir.mkdirs()) {
                    System.out.println("创建配置文件路径失败");
                }
            }

            if (!file.createNewFile()) {
                System.out.println("创建配置文件失败");
            }
        }

        return file;
    }
}
