package cn.edu.wust.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(200,"请求成功"),
    BAD_REQUEST(400,"参数不合法"),
    RESOURCE_NOT_FOUND(404,"资源未找到"),
    INTERNAL_SERVER_ERROR(500,"服务端错误");
    private Integer code;

    private String message;
}
