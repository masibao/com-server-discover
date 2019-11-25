package com.mayi.user.controller;

import com.mayi.user.entity.UserAddress;
import com.mayi.user.entity.UserDo;
import com.mayi.user.entity.UserDto;
import com.mayi.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description: 用户管理控制器
 * @Date: Create in 17:55 2019/9/29
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto){

        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(userDto,userDo);
        int res = userMapper.selectCount();
        int rows = -1;
        try {
            for (int i = 0; i < 30; i++) {
                userMapper.insert(userDo);
            }

        }catch (Exception ex){
            log.error("插入用户信息异常!:{}",ex.getMessage());
        }
        return "success" + rows;

    }


    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/saveData")
    public String saveData(){
        log.info("<<<<<<<<<<<开始加入数据<<<<<<<<<<<");
        List<UserAddress> userAddresses = new ArrayList<>();
        UserAddress userDo = new UserAddress();
        try {
            for (int i = 0; i < 10; i++) {
                userDo.setName("小码 "+ i);
                userDo.setAge(i);
                userDo.setAddress("湖南省平江县第" + i+"号");
                userAddresses.add(userDo);
            }
            userMapper.insertUserAddress(userAddresses);

        }catch (Exception ex){
            log.error("插入用户信息异常!:{}",ex.getMessage());
            throw new RuntimeException("查询数据库异常!");
        }
        return "success";

    }
}
