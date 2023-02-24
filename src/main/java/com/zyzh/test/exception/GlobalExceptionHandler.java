package com.zyzh.test.exception;

import com.zyzh.test.controller.TestController;
import com.zyzh.test.result.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: GlobalExceptionHandler
 * @Description:
 * @author: Leo wey
 * @date: 2023/2/22 17:52
 * @Version: 1.0
 */
@ResponseBody
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 捕获参数异常信息
     * @param ex 异常信息
     * @return R
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public R<String> illegalArgumentException(IllegalArgumentException ex){
        logger.info(ex.getMessage());
        return R.fail(ex.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public R<String> nullPointerException(NullPointerException ex){
        logger.info(ex.getMessage());
        return R.fail(ex.getMessage());
    }
}