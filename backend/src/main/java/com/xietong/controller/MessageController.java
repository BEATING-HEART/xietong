package com.xietong.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sunforge
 * @Date 2021-06-10 10:40
 */
@Api("消息操作")
@RestController
@RequestMapping("/api/message")
public class MessageController {
    // 消息操作只有get和list
    // list  联表查询，
    // get
}
