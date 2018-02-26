package com.feicui.com.util;

public final class CommonUtils {
 
    /**
     * 获取字符串中指定字符的的个数
     */
    public static int getCharacterCount(String str, int c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * 将Underlining命名法的变量名转换为Pascal命名法 MY_VARIABLE或my_variable
     * 转换为MyVariable
     * 
     * @param str 要转换的字符串
     * @return 转换后的字符串
     */
    public static String underliningToPascal(String str) {
        String[] strs = str.split("_"); // 用下划线分割字符串
        StringBuilder sb = new StringBuilder();
        for (String item : strs) {
            item = item.toLowerCase(); // 字符串全部转为小写
            item = item.replaceFirst(item.substring(0, 1), item.substring(0, 1)
                .toUpperCase());
            // 首字母转为大写
            sb.append(item);
        }
        return sb.toString();
    }

    
    /**
     * 获取资源路径
     */
    public static String getClassPath() {
        return CommonUtils.class.getClassLoader().getResource("").getPath();
    }
}
