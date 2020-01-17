package cn.edu.wust.common.feign.fallback;

import cn.edu.wust.common.entity.UserLog;
import cn.edu.wust.common.feign.UserLogService;
import cn.edu.wust.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: huhan
 * @Date: 2020/1/17 11:03
 * @Description
 * @Version 1.0
 */
@Service
@Slf4j
public class UserLogServiceFallbackImpl implements UserLogService {
    @Override
    public Result<Object> add(UserLog userLog) {
        log.error("服务：{}，调用方法：{}，方法：{}异常，参数：{}", "系统自动", "log-service", "/user_log", userLog.toString());
        return Result.error500("日志服务调用失败");
    }
}
