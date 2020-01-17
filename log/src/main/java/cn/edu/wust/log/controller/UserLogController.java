package cn.edu.wust.log.controller;

import cn.edu.wust.common.entity.UserLog;
import cn.edu.wust.common.vo.Result;
import cn.edu.wust.log.service.UserLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huhan
 * @Date: 2020/1/17 10:29
 * @Description
 * @Version 1.0
 */
@RestController
@Api(tags = "用户日志")
@Slf4j
public class UserLogController {
    @Autowired
    private UserLogService userLogService;

    @ApiOperation("新增用户日志")
    @PostMapping("/user_log")
    public Result<Object> add(@RequestBody UserLog userlog){
        try {
            userLogService.save(userlog);
            return Result.ok("操作成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return Result.error500("操作失败");
        }
    }
}
