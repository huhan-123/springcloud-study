package cn.edu.wust.common.aspect;

import cn.edu.wust.common.annotation.Loggable;
import cn.edu.wust.common.entity.UserLog;
import cn.edu.wust.common.feign.UserLogService;
import cn.edu.wust.common.util.IpUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: huhan
 * @Date: 2020/1/17 11:12
 * @Description
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class UserLogAspect {
    @Autowired
    private UserLogService userLogService;

    @Pointcut("@annotation(cn.edu.wust.common.annotation.Loggable)")
    public void UserLogPointCut() {
    }

    @Before("UserLogPointCut()")
    public void before(JoinPoint point) {
        HttpServletRequest request = getHttpservletRequest();
        request.setAttribute("requestTime",System.currentTimeMillis());
        request.setAttribute("id", UUID.randomUUID().toString().replace("-",""));
    }

    @After("UserLogPointCut()")
    public void after(JoinPoint point){
        Object[] args = point.getArgs();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        UserLog userLog = assembleData(args, method);
        userLogService.add(userLog);
    }

    private HttpServletRequest getHttpservletRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    private UserLog assembleData(Object[] args, Method method) {
        UserLog userLog = new UserLog();
        Loggable loggable = method.getAnnotation(Loggable.class);
        HttpServletRequest request = getHttpservletRequest();
        userLog.setId((String) request.getAttribute("id"));
        //TODO 根据具体的业务场景设置相应的userId
        userLog.setOpType(loggable.opType());
        userLog.setOpText(loggable.opText());
        userLog.setServerIp(IpUtils.getLocalIP());
        userLog.setClientIp(IpUtils.getIpAddr(request));
        userLog.setRequestUrl(request.getRequestURI());
        String requestParam = "";
        try {
            requestParam = JSON.toJSONString(args);
        } catch (Exception e) {
            log.error("parse requestParam to json string error, param array maybe contains HttpServletRequest or HttpServletResponse");
        }
        userLog.setRequestParam(requestParam);
        Object requestTimeObj = request.getAttribute("requestTime");
        long requestTime = requestTimeObj == null ? 0L : (long) requestTimeObj;
        long responseTime = System.currentTimeMillis();
        userLog.setRequestTime(requestTime);
        userLog.setResponseTime(responseTime);
        userLog.setTotalCostTime(responseTime-requestTime);
        userLog.setRequestMethod(request.getMethod());
        userLog.setMethod(method.getName());
        userLog.setCreateTime(new Date());
        return userLog;
    }

}
