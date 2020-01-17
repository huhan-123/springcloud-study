package cn.edu.wust.log.mapper;

import cn.edu.wust.common.entity.UserLog;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: huhan
 * @Date: 2020/1/17 10:11
 * @Description
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserLogMapperTest extends TestCase {

    @Autowired
    private UserLogMapper userLogMapper;

    @Test
    public void add(){
        UserLog userLog = new UserLog();
        userLog.setId("32432");
        userLog.setCreateTime(new Date());
        userLog.setMethod("add");
        userLog.setRequestMethod("GET");
        userLog.setRequestUrl("localhost");
        userLog.setClientIp("127.0.0.1");
        userLog.setServerIp("127.0.0.1");
        userLogMapper.insert(userLog);
    }
}