package cn.edu.wust.common.exception;

/**
 * @Author: huhan
 * @Date: 2020/1/15 20:45
 * @Description
 * @Version 1.0
 */
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String message){
        super(message);
    }

    public InvalidParameterException(Throwable exception){
        super(exception);
    }

    public InvalidParameterException(String message,Throwable exception){
        super(message,exception);
    }
}
