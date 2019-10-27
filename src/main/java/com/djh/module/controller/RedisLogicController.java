package com.djh.module.controller;

import com.djh.core.common.R;
import com.djh.module.dto.RedisLoginInfoDTO;
import com.djh.module.service.RedisLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedisLogicController {

    @Autowired
    private RedisLogicService redisLogicService;

    @GetMapping("/redisLogin")
    public R redisLogin(RedisLoginInfoDTO redisLoginInfoDTO) throws Exception {
        redisLogicService.loginRedis(redisLoginInfoDTO);

        return R.success("连接成功", null);
    }
}
