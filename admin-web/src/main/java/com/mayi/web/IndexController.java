package com.mayi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 21:22 2020/8/7
 */
@Controller
public class IndexController {

    @GetMapping("/freemarkerIndex")
    public String index(Map<String, Object> result) {
        result.put("nickname", "tEngSHe789");
        result.put("old", "18");
        result.put("my Blog", "HTTPS://blog.tengshe789.tech/");
        List<String> listResult = new ArrayList<String>();
        listResult.add("guanyu");
        listResult.add("zhugeliang");
        result.put("listResult", listResult);
        return "index";
    }

}
