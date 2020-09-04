package com.mayi.web.controller;

import com.mayi.web.annotation.UserPermisionAnno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 11:02 2020/8/8
 */
@RestController
@RequestMapping("/")
@Slf4j
public class UserManagerController {

    @GetMapping("user/list")
    @UserPermisionAnno(userId = "444",userName = "mayi",userAge = "28")
    public String acquireUserList(){
        log.info("喀什获取用户列表");
        return "success";
    }
}
