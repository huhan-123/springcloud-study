package cn.edu.wust.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: huhan
 * @Date: 2020/1/17 9:52
 * @Description
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLog {
    private String id;

    //用户id
    private String userId;

    //操作类型
    private String opType;

    //操作描述
    private String opText;

    //服务器ip
    private String serverIp;

    //客户端ip
    private String clientIp;

    //请求url
    private String requestUrl;

    //请求参数
    private String requestParam;

    //请求时间
    private long requestTime;

    //响应时间
    private long responseTime;

    //请求花费时间
    private long totalCostTime;

    //请求方法
    private String requestMethod;

    //访问具体方法
    private String method;

    //创建时间
    private Date createTime;
}
