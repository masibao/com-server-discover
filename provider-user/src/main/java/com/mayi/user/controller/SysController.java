package com.mayi.user.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j
public class SysController {


    @GetMapping("/index")
    public String index(){

        return "success";

    }





}
