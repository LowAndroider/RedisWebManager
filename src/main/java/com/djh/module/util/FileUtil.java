package com.djh.module.util;

import java.io.*;

/**
 * 用于文件的读写, 文本类
 * @author djh
 */
public class FileUtil {

    public static String read(File file) throws Exception {

        byte[] buffer = new byte[1024];
        StringBuffer result = new StringBuffer();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));

        int byteLength;
        if((byteLength = bufferedInputStream.read(buffer)) != -1) {
            result.append(new String(buffer, 0, byteLength));
        }

        return result.toString();
    }

    /**
     * 写入，会覆盖文件以前的内容
     * @param file 文件
     * @param content 内容
     */
    public static void write(File file, String content) throws IOException {
        new FileOutputStream(file).write(content.getBytes());
    }

    public static void append(File file, String content) throws Exception {
        String preContent = read(file);
        write(file, content + preContent);
    }
}
