package cn.edu.wust.common.exception;

import cn.edu.wust.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidParameterException.class)
    public Result<Object> invalidParameterExceptionHandler(InvalidParameterException e) {
        log.error(e.getMessage(), e);
        return Result.error500(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<Object> defaultExceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error500(e.getMessage());
    }
}
