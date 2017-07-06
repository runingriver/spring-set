package com.hzz.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常拦截和处理,自动匹配不同类型的异常!
 * 异常匹配规则是,根据异常继承关系选择向上选择最近的异常匹配.
 *  eg: NPE异常首先寻找有没有NPE对应的,没有则向上找,所以会匹配RuntimeException,而不会匹配Exception!
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //定义返回显示页面的异常
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mv = new ModelAndView();
        logger.info("url:{} error.exception:{}", req.getRequestURL(), e);
        mv.setViewName("error");
        return mv;
    }

    //定义返回jason格式的异常
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, RuntimeException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(0);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }


    public static class ErrorInfo<T> {
        private Integer code;
        private String message;
        private String url;
        private T data;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ErrorInfo{" +
                    "code=" + code +
                    ", message='" + message + '\'' +
                    ", url='" + url + '\'' +
                    ", data=" + data +
                    '}';
        }
    }

}
