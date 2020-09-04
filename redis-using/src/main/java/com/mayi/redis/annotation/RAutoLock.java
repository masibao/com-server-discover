package com.mayi.redis.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 14:44 2020/6/5
 */
@Target({ElementType.METHOD})//该注解只能被用在方法上
@Retention(RetentionPolicy.RUNTIME) //在运行时期生效
@Documented
@Inherited
public @interface RAutoLock {


    /**
     * key
     * @return
     */
    String localKey();

    /**
     * 时间 默认5s
     * @return
     */
    long leaseTime() default 20*1000;

    /**
     * 时间单位默认秒
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

}
