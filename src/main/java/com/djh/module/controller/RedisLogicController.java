package com.djh.module.controller;

import com.djh.core.common.R;
import com.djh.module.entity.dto.RedisConnectionInfo;
import com.djh.module.service.RedisLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * @author Djh
 */
@RestController
public class RedisLogicController {

    private RedisLogicService redisLogicService;

    @Autowired
    public RedisLogicController(RedisLogicService redisLogicService) {
        this.redisLogicService = redisLogicService;
    }

    @GetMapping("/redisLogin")
    public R redisLogin(RedisConnectionInfo redisLoginInfoDTO) throws Exception {
        redisLogicService.loginRedis(redisLoginInfoDTO);

        return R.success("连接成功", null);
    }

    @GetMapping("/redisConnList")
    public R redisInfo() {
        List<Map<String, Object>> resultList = redisLogicService.getRedisInfoList();
        return R.success(resultList);
    }
}
