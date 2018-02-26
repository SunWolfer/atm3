package com.feicui.com.exception;

@SuppressWarnings("serial")
public class AtmException extends RuntimeException {
    public AtmException() {
        super("", null);
    }
    
    public AtmException(String message) {
        super(message);
    }
    
    public AtmException(Exception e) {
        super("", e);
    }
    
    public AtmException(String message, Exception e) {
        super(message, e);
    }

    /**
     * 注释掉此方法可显示异常栈信息
     */
   /* @Override
    public void printStackTrace() {    
        System.err.println("系统错误!");
    }*/
}
