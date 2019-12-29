/*
 * Copyright 2017 中铁程科技有限责任公司
 * All Right Reserved
 * Author：zhan
 * Create Date：Apr 1, 2017
 */
package com.rails.mybatisdemo.demo.utils;

import java.io.Serializable;

/**
 * 功能描述: 统一对外封装的对象. data为返回对象,如果非分页数据,直接返回对象类型的数据,
 * 如果为分页数据,则返回Page类,并在Page中的data设置为分页信息pageable查询出结果,total设置条件查询的总条数
 *
 * @auther:
 * @date: 2018/7/27 14:48
 */
public class ResultData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String SUCCESS = "1";

    private static final String BSI_FAIL = "0";

    private static final String SYS_FAIL = "-1";
    /**
     * 描述:状态(1:成功;0:业务异常;-1:系统异常)
     */
    private String returnState;
    /**
     * 描述:业务错误码 (returnState为0表示具体业务异常)
     */
    private String errorCode;
    /**
     * 描述:提示信息(失败原因描述,若成功则值为"success")
     */
    private String returnMessage;
    /**
     * 描述:返回实体类
     */
    private T data;

    public ResultData() {
        super();
    }

    /**
     * @param data
     * @return ResultData
     * @Title: success
     * @Description: 返回调用成功数据
     */
    @SuppressWarnings("unchecked")
    public static <T> ResultData<T> success(T data) {
        return new ResultData(SUCCESS, null, "success", data);
    }

    /**
     * @return ResultData
     * @Title: success
     * @Description: 调用异常, 如连接超时, 数据库异常等非业务异常
     */
    @SuppressWarnings("unchecked")
    public static <T> ResultData<T> error(String errorCode, String errorMessage) {
        return new ResultData(SYS_FAIL, errorCode, errorMessage, null);
    }

    /**
     * @return ResultData
     * @Title: success
     * @Description: 调用异常, 如连接超时, 数据库异常等非业务异常
     */
    @SuppressWarnings("unchecked")
    public static <T> ResultData<T> error(String errorMessage) {
        return new ResultData(SYS_FAIL, "", errorMessage, null);
    }

    /**
     * @param errorCode
     * @param errorMessage
     * @return ResultData
     * @Title: deny
     * @Description: 调用正常, 但是业务异常
     */
    @SuppressWarnings("unchecked")
    public static <T> ResultData<T> deny(String errorCode, String errorMessage) {
        return new ResultData(BSI_FAIL, errorCode, errorMessage, null);
    }

    /**
     * @param errorMessage
     * @return ResultData
     * @Title: deny
     * @Description: 调用正常, 但是业务异常
     */
    @SuppressWarnings("unchecked")
    public static <T> ResultData<T> deny(String errorMessage) {
        return new ResultData(BSI_FAIL, "", errorMessage, null);
    }

    public ResultData(String returnState, String errorCode, String returnMessage) {
        super();
        this.returnState = returnState;
        this.errorCode = errorCode;
        this.returnMessage = returnMessage;
    }

    public ResultData(String returnState, String errorCode, String returnMessage, T data) {
        this.returnState = returnState;
        this.errorCode = errorCode;
        this.returnMessage = returnMessage;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultData [returnState=" + returnState + ", errorCode=" + errorCode + ", returnMessage=" + returnMessage
                + ", data=" + data + "]";
    }

    public String getReturnState() {
        return returnState;
    }

    public void setReturnState(String returnState) {
        this.returnState = returnState;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toResult() {
        return "[returnState=" + returnState + ", errorCode=" + errorCode + ", returnMessage=" + returnMessage
                + "]";
    }
}
