package com.mayi.comservereureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname shangchuan
 * @Author: Tony
 * @Description:
 * @Date:
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${file.storage.path}")
    private String storagePath;

    @PostMapping(value = "/upload", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public String batchUpload(HttpServletRequest request) {
        log.info("上传path:{}",storagePath);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files");

        for (int i = 0; i < files.size(); i++) {
            //生成文件id

            MultipartFile file = files.get(i);
            FileOperateUtils.upload(file,storagePath);
        }
        return "upload success";
    }
}
