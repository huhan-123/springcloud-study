package cn.edu.wust.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: huhan
 * @Date: 2020/1/17 11:14
 * @Description
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Loggable {
    String opType() default "查询";

    String opText() default "";
}
