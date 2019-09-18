package com.mayi.comservereureka;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 19:47 2019/9/18
 */
@Configuration
public class UploadSizeLimit {



    /**
     * 文件上传配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("100MB"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("1024MB");
        return factory.createMultipartConfig();
    }


}
