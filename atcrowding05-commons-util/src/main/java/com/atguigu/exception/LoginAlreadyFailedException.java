package com.atguigu.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GaoUP
 * @Date 2021/10/23 18:12
 * @Version 1.0
 */
public class LoginAlreadyFailedException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public LoginAlreadyFailedException() {
    }

    public LoginAlreadyFailedException(String message) {
        super(message);
    }

    public LoginAlreadyFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAlreadyFailedException(Throwable cause) {
        super(cause);
    }

    public LoginAlreadyFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
