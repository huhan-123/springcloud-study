package cn.edu.wust.log.service.impl;

import cn.edu.wust.common.entity.UserLog;
import cn.edu.wust.log.mapper.UserLogMapper;
import cn.edu.wust.log.service.UserLogService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author: huhan
 * @Date: 2020/1/17 10:28
 * @Description
 * @Version 1.0
 */
@Service
@DS("master")
public class UserLogServiceImpl extends ServiceImpl<UserLogMapper,UserLog> implements UserLogService {
}