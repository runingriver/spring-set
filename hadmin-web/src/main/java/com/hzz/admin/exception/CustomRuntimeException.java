package com.hzz.admin.exception;

/**
 * Created by zongzhehu on 16-12-12.
 */
public class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException() {
        super();
    }

    public CustomRuntimeException(Throwable cause) {
        super(cause);
    }

    public CustomRuntimeException(String message) {
        super(message);
    }

    public CustomRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    protected CustomRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
