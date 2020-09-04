package com.mayi.web.aspect;

import com.mayi.web.annotation.UserPermisionAnno;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 11:09 2020/8/8
 */
@Component
@Aspect
@Slf4j
public class UserPermisionAspect {

    @Pointcut("@annotation(com.mayi.web.annotation.UserPermisionAnno)")
    public void pointCut(){
        log.info("point");
    }

    @Before("pointCut()")
    public void before(JoinPoint point){

        Object[] args = point.getArgs();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            stringBuffer.append(args[i].toString());
        }
        log.info("args:{}",stringBuffer.toString());
        log.info("before 在 controller 前面");
    }

    @After("pointCut()")
    public void after(JoinPoint point){

        log.info("after 在 controller 后面");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        log.info("-----around 在 ....");
        Object[] args1 = point.getArgs();
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        UserPermisionAnno annotation = method.getAnnotation(UserPermisionAnno.class);
        String age = annotation.userAge();
        String name = annotation.userName();
        String id = annotation.userId();

        Object[] args = point.getArgs();


        log.info("around 在 ....");
        return point.proceed(args1);
    }

}
