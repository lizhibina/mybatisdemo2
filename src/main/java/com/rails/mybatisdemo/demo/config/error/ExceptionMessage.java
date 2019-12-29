package com.rails.mybatisdemo.demo.config.error;

import java.io.Serializable;

/**
 * Class Name: BusinessExceptionMessage.java Function: * Modifications: * @author
 * * lizhibin DateTime 2015-1-7 下午7:14:14
 *
 * @version 1.0 *
 */
public class ExceptionMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String message;

    public ExceptionMessage(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "code:" + code + " message:" + message;
    }

}
