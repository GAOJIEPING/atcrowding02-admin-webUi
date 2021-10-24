package com.atguigu.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GaoUP
 * @Date 2021/10/13 7:55
 * @Version 1.0
 */
public class LoginFailedException extends RuntimeException{
    private static final long serialVersionUID = -1;
    public LoginFailedException() {
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    public LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
