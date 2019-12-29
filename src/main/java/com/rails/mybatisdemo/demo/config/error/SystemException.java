package com.rails.mybatisdemo.demo.config.error;

import java.util.ArrayList;
import java.util.List;

public class SystemException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    List<ExceptionMessage> exceptionMessageList = null;

    public SystemException(
            List<ExceptionMessage> businessExceptionMessageList) {
        this.exceptionMessageList = businessExceptionMessageList;
    }

    public SystemException(String code, String message) {
        this.exceptionMessageList = new ArrayList<ExceptionMessage>();
        ExceptionMessage businessExceptionMessage = new ExceptionMessage(
                code, message);
        exceptionMessageList.add(businessExceptionMessage);
    }

    /**
     * 构造方法：code默认为空
     *
     * @param message
     */
    public SystemException(String message) {
        this.exceptionMessageList = new ArrayList<ExceptionMessage>();
        ExceptionMessage businessExceptionMessage = new ExceptionMessage(
                "", message);
        exceptionMessageList.add(businessExceptionMessage);
    }

    public SystemException(Throwable e) {
        super(e);
        this.exceptionMessageList = new ArrayList<ExceptionMessage>();
        ExceptionMessage businessExceptionMessage = new ExceptionMessage(
                "", e.getMessage());
        exceptionMessageList.add(businessExceptionMessage);
    }

    public SystemException(Throwable e, String code) {
        super(e);
        this.exceptionMessageList = new ArrayList<ExceptionMessage>();
        ExceptionMessage businessExceptionMessage = new ExceptionMessage(
                code, e.getMessage());
        exceptionMessageList.add(businessExceptionMessage);
    }

    public List<ExceptionMessage> getBusinessExceptionMessageList() {
        return exceptionMessageList;
    }

    public ExceptionMessage getSystemExceptionMessage() {
        if (exceptionMessageList != null
                && exceptionMessageList.size() > 0) {
            return exceptionMessageList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return this.getSystemExceptionMessage().toString();
    }
}


