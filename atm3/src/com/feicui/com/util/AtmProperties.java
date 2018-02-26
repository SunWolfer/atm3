package com.feicui.com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.feicui.com.exception.AtmException;

// 从指定的文件中读取属性
@SuppressWarnings("serial")
public class AtmProperties extends Properties {

    public AtmProperties(String fileName) throws IOException {
        load(new FileInputStream(fileName));
    }
    
    /**
     * 从Properties中获取正则表达式
     * 
     * @param key
     * @return
     * @throws IOException 
     */
    public static String getRegex(String key) {
        if (key == null) {
            return key;
        }
        String path = CommonUtils.getClassPath() + "regex.properties";
        String str = null;
        try {
            str = new AtmProperties(path).getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str == null ? key : str; // 没找到, 返回原文本
    }

    /**
     * 从Properties中获取界面消息
     * 
     * @param key
     * @return
     */
    public static String getMessage(String key){
        if (key == null) {
            return key;
        }
        String path = CommonUtils.getClassPath() + "message.properties";
        String str = null;
        try {
            str = new AtmProperties(path).getProperty(key);
        } catch (IOException e) {
            throw new AtmException(e);
        }
        return str == null ? key : str; // 没找到, 返回原文本
    }
}
