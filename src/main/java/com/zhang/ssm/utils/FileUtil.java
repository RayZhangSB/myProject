package com.zhang.ssm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName FileUtil
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/31 9:05
 * @Version 1.0
 **/
public final class FileUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    private static String environment_img_dir = File.separator + "WEB-INF" + File.separator + "images";

    public static String HEAD_SAVE_DIR = environment_img_dir + File.separator + "profile_pictures" + File.separator;

    public static String AB_IMG_DIR = environment_img_dir + File.separator + "ab_images" + File.separator;

    public static String getFileSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."), fileName.length());
    }

    public static boolean uploadImageFromLocal(String src, String dest) {
        boolean res = true;
        FileInputStream in = null;
        FileChannel inC = null, outC = null;
        RandomAccessFile out = null;
        try {
            in = new FileInputStream(new File(src));
            long size = in.available();
            out = new RandomAccessFile(new File(dest), "rw");
            inC = in.getChannel();
            MappedByteBuffer in_bf = inC.map(FileChannel.MapMode.READ_ONLY, 0, size);
            outC = out.getChannel();
            MappedByteBuffer out_bf = outC.map(FileChannel.MapMode.READ_WRITE, 0, size);
            out_bf.put(in_bf);
        } catch (IOException e) {
            LOGGER.error("upload img failed" + e.getMessage());
            res = false;
        } finally {
            try {
                inC.close();
                outC.close();
                in.close();
                out.close();
            } catch (IOException e) {
                LOGGER.error("close file stream pointer failed" + e.getMessage());
                res = false;
            }
        }
        return res;
    }


    public static boolean uploadFileFromLocal(String src, String dest) {
        InputStream in = null;
        OutputStream out = null;
        boolean res = true;
        try {
            in = new BufferedInputStream(new FileInputStream(new File(src)));
            out = new BufferedOutputStream(new FileOutputStream(new File(dest)));
            byte[] b = new byte[4096];
            while (in.read(b) > 0) {
                out.write(b);
            }
            out.flush();
        } catch (IOException e) {
            LOGGER.error("upload file failed" + e.getMessage());
            res = false;
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                LOGGER.error("close file pointer failed" + e.getMessage());
                res = false;
            }
        }
        return res;
    }


}
