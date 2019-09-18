package com.mayi.comservereureka;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * 文件保存在本地
 *
 * @author 吴晓林
 * @date 2018-03-17
 * @time 下午1:39:44
 */
@Slf4j
public class FileUtil {
    /**
     * Description:  保存文件
     *  * @Param path
     * @Param file
     * @Param fileName
     * @return void
     * @author xf
     * @date 2019/8/22 2:56 PM
     */
    public void saveFile(String path, File file, String fileName) {
        // 输出的文件流保存到本地文件
        File tempFile = new File(path);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
        try  (OutputStream os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
              FileInputStream fi = new FileInputStream(file);){
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 开始读取
            while ((len = fi.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            log.info("Finally.");
        }
    }

    /**
     * 根据文件,判断文件的大小
     * @param file
     * @return 文件的size,默认单位为
     */
    public Double checkFileSize(File file) {
        long len = file.length();
        double fileSize = 0;
        fileSize = (double) len / 1048576;
        return fileSize;
    }
}