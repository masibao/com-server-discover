package com.mayi.comservereureka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Classname fsc
 * @Author: Tony
 * @Description:
 * @Date: Create in 18:11 2019/8/1
 */
@Slf4j
public class FileOperateUtils {
    private FileOperateUtils(){}
    /**
     * Description: 文件上传
     *  * @Param documentId
     * @Param file
     * @Param storagePath
     * @return java.lang.String
     * @author xf
     * @date 2019/8/22 2:54 PM
     */
    public static String upload( MultipartFile file, String storagePath) {
        log.info("当前线程NAME:{},ID:{}",Thread.currentThread().getName(),Thread.currentThread().getId());
        // 格式转换
        String filename = file.getOriginalFilename();
        long startTime = System.currentTimeMillis();
        String ext = filename.substring(filename.lastIndexOf('.'));
        log.info("[上传文件扩展名]{}",ext);
        String filePath = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator");
        log.info("[文件路径]是:{}",filePath);
        File newFile = new File(filePath + filename);
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            log.error("文件复制异常{}",e.getMessage());
        }
        // 上传文件服务器
        FileUtil fu = new FileUtil();
        fu.saveFile(storagePath, newFile, filename);
        log.info("文件上传至文件服务器！documentId={}",filename);
        Double fileSize = fu.checkFileSize(newFile);
        log.info("[uploadFile上传文件的大小为]:{},{}",fileSize,"M");
        long endTime = System.currentTimeMillis();
        log.info("文件:{},开始时间:{},结束时间:{},共耗时:{} 秒",filename,startTime,endTime,endTime - startTime);
        return filename;
    }
}
