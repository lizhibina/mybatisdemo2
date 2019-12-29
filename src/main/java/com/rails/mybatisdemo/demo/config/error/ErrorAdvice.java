package com.rails.mybatisdemo.demo.config.error;

import com.rails.mybatisdemo.demo.utils.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResourceAccessException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 功能描述:全局异常处理
 *
 * @author: LiZhenfei
 * @date: 2018/7/27 14:43
 */
@ControllerAdvice
public class ErrorAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = HttpStatus.OK;
        ExceptionMessage exceptionMessage = null;
        String message = ex.getMessage();
        String code;
        if (ex instanceof BusinessException) {
            BusinessException b = (BusinessException) ex;
            exceptionMessage = b.getBusinessExceptionMessage();
            message = exceptionMessage.getMessage();
            code = exceptionMessage.getCode();
            status = HttpStatus.OK;
            logger.info("BussinessException: " + code + ":" + message);
            return new ResponseEntity(ResultData.deny(code, message), status);
        } else if (ex instanceof ResourceAccessException) {
            ResourceAccessException b = (ResourceAccessException) ex;
            message = "服务调用失败！";
            code = "-1";
            logger.error("ConnectException: " + b.getMessage());
            return new ResponseEntity(ResultData.error(code, message), status);
        } else if (ex instanceof SystemException) {
            SystemException b = (SystemException) ex;
            exceptionMessage = b.getSystemExceptionMessage();
            message = exceptionMessage.getMessage();
            code = exceptionMessage.getCode();
            logger.error("SystemException: " + message);
            return new ResponseEntity(ResultData.error(code, message), status);
        } else if (ex instanceof BindException) {
            message = "";
            BindException b = (BindException) ex;
            List<ObjectError> allErrors = b.getBindingResult().getAllErrors();
            message = allErrors.get(0).getDefaultMessage();
            logger.error("BindException: " + message);
            return new ResponseEntity(ResultData.error(message), HttpStatus.OK);
        } else {
            logger.error("Exception: " + message, ex);
            return new ResponseEntity(ResultData.error("系统异常！"), HttpStatus.OK);
        }
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }


}
