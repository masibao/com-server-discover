package com.mayi.comservereureka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 16:15 2019/9/10
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "Success";
    }
}
