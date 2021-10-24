package com.atguigu.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GaoUP
 * @Date 2021/10/14 19:16
 * @Version 1.0
 */
public class AccessForbidden extends RuntimeException{
    static final long serialVersionUID = 1L;

    public AccessForbidden() {
    }

    public AccessForbidden(String message) {
        super(message);
    }

    public AccessForbidden(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbidden(Throwable cause) {
        super(cause);
    }

    public AccessForbidden(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
