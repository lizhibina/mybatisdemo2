package com.rails.mybatisdemo.demo.config.error;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Name: BusinessWifiException.java Function: 业务异常处理类 * Modifications: * @author
 * lizhibin DateTime 2015-1-7 下午7:15:08
 *
 * @version 1.0 *
 */

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    List<ExceptionMessage> businessExceptionMessageList = null;

    public BusinessException(
            List<ExceptionMessage> businessExceptionMessageList) {
        this.businessExceptionMessageList = businessExceptionMessageList;
    }

    public BusinessException(String code, String message) {
        this.businessExceptionMessageList = new ArrayList<ExceptionMessage>();
        ExceptionMessage businessExceptionMessage = new ExceptionMessage(
                code, message);
        businessExceptionMessageList.add(businessExceptionMessage);
    }

    /**
     * 构造方法：code默认为空
     *
     * @param message
     */
    public BusinessException(String message) {
        this.businessExceptionMessageList = new ArrayList<ExceptionMessage>();
        ExceptionMessage businessExceptionMessage = new ExceptionMessage(
                "", message);
        businessExceptionMessageList.add(businessExceptionMessage);
    }

    public BusinessException(Throwable e) {
        super(e);
        this.businessExceptionMessageList = new ArrayList<ExceptionMessage>();
        ExceptionMessage businessExceptionMessage = new ExceptionMessage(
                "", e.getMessage());
        businessExceptionMessageList.add(businessExceptionMessage);
    }

    public BusinessException(ExceptionMessage exceptionMessage) {
        this.businessExceptionMessageList = new ArrayList<ExceptionMessage>();
        businessExceptionMessageList.add(exceptionMessage);
    }

    public BusinessException(Throwable e, String code) {
        super(e);
        this.businessExceptionMessageList = new ArrayList<ExceptionMessage>();
        ExceptionMessage businessExceptionMessage = new ExceptionMessage(
                code, e.getMessage());
        businessExceptionMessageList.add(businessExceptionMessage);
    }

    public List<ExceptionMessage> getBusinessExceptionMessageList() {
        return businessExceptionMessageList;
    }

    public ExceptionMessage getBusinessExceptionMessage() {
        if (businessExceptionMessageList != null
                && businessExceptionMessageList.size() > 0) {
            return businessExceptionMessageList.get(0);
        } else {
            return null;
        }
    }

}
