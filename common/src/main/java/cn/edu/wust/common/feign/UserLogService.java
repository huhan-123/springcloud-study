package cn.edu.wust.common.feign;

import cn.edu.wust.common.entity.UserLog;
import cn.edu.wust.common.feign.fallback.UserLogServiceFallbackImpl;
import cn.edu.wust.common.vo.Result;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: huhan
 * @Date: 2020/1/17 11:01
 * @Description
 * @Version 1.0
 */
@FeignClient(name = "log-service",fallback = UserLogServiceFallbackImpl.class)
@Component
public interface UserLogService {
    @PostMapping("/log/user_log")
    Result<Object> add(@RequestBody UserLog userLog);
}
