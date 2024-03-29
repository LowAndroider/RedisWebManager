package com.djh.module.controller;

import com.djh.core.common.R;
import com.djh.module.entity.dto.RedisConnectionInfo;
import com.djh.module.service.RedisLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;
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
    public R redisLogin(@Valid RedisConnectionInfo redisLoginInfoDTO) throws Exception {
        redisLogicService.loginRedis(redisLoginInfoDTO);
        return R.success("连接成功", null);
    }

    @GetMapping("/redisConnList")
    public R redisInfo() {
        List<RedisConnectionInfo> resultList = redisLogicService.getRedisInfoList();
        return R.success(resultList);
    }
}
