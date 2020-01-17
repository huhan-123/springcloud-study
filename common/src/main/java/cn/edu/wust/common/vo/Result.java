package cn.edu.wust.common.vo;

import cn.edu.wust.common.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;

    private String message;

    private T data;

    public static Result<Object> error500(){
        Result<Object> result = new Result<>();
        result.setCode(ResponseCode.INTERNAL_SERVER_ERROR.getCode());
        result.setMessage(ResponseCode.INTERNAL_SERVER_ERROR.getMessage());
        return result;
    }

    public static Result<Object> error500(String message){
        Result<Object> result = new Result<>();
        result.setCode(ResponseCode.INTERNAL_SERVER_ERROR.getCode());
        result.setMessage(message);
        return result;
    }

    public static Result<Object> error404(){
        Result<Object> result = new Result<>();
        result.setCode(ResponseCode.RESOURCE_NOT_FOUND.getCode());
        result.setMessage(ResponseCode.RESOURCE_NOT_FOUND.getMessage());
        return result;
    }

    public static Result<Object> error404(String message){
        Result<Object> result = new Result<>();
        result.setCode(ResponseCode.RESOURCE_NOT_FOUND.getCode());
        result.setMessage(message);
        return result;
    }

    public static Result<Object> error400(){
        Result<Object> result = new Result<>();
        result.setCode(ResponseCode.BAD_REQUEST.getCode());
        result.setMessage(ResponseCode.BAD_REQUEST.getMessage());
        return result;
    }

    public static Result<Object> error400(String message){
        Result<Object> result = new Result<>();
        result.setCode(ResponseCode.BAD_REQUEST.getCode());
        result.setMessage(message);
        return result;
    }

    public void success(String message){
        this.code=ResponseCode.SUCCESS.getCode();
        this.message=message;
    }

    public static Result<Object> ok(){
        Result<Object> result = new Result<>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(ResponseCode.SUCCESS.getMessage());
        return result;
    }

    public static Result<Object> ok(String message){
        Result<Object> result = new Result<>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(message);
        return result;
    }

    public static Result<Object> ok(Object data){
        Result<Object> result = new Result<>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(ResponseCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static Result<Object> ok(String message,Object data){
        Result<Object> result = new Result<>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
