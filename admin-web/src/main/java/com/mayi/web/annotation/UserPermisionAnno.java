package com.mayi.web.annotation;

import java.lang.annotation.*;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 11:06 2020/8/8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface UserPermisionAnno {

    String userId() default "123";
    String userName() default "xh";
    String userAge() default "15";
}
