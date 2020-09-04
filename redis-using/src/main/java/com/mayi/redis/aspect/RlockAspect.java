package com.mayi.redis.aspect;

import com.mayi.redis.annotation.RAutoLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 15:22 2020/6/5
 */
@Aspect
@Component
public class RlockAspect {


    @Autowired
    private RedissonClient redissonClient;

    @Pointcut("@annotation(com.mayi.redis.annotation.RAutoLock)")
    public void RlockAspect() {
    }

    @Around("RlockAspect()")
    public Object arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object object = null;
        RLock lock = null;


        try {
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            RAutoLock rlockInfo;
            rlockInfo = methodSignature.getMethod().getAnnotation(RAutoLock.class);
            lock = redissonClient.getLock(getLocalKey(proceedingJoinPoint, rlockInfo));

            if (lock != null) {
                System.out.println("-------尝试加锁");
//                lock.lock(rlockInfo.leaseTime(), rlockInfo.timeUnit());
                boolean getLock = lock.tryLock(10000, rlockInfo.leaseTime(), rlockInfo.timeUnit());
                System.out.println("-------加锁成功" + getLock);
                object = proceedingJoinPoint.proceed();
                System.out.println(object);
            }
        } finally {
            /*if (lock != null) {
                lock.unlock();
            }*/
        }
        return object;
    }

/*    public RLock getRlockInfo(ProceedLingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        return methodSignature.getMethod().getAnnotation(RLock.class);
    }*/

    /**
     * redis lock key 生成逻辑  这里只是简单生成，如需投入生产使用，可考虑复杂化
     *
     * @param proceedingJoinPoint
     * @return
     */
    public String getLocalKey(ProceedingJoinPoint proceedingJoinPoint, RAutoLock rlockInfo) {
        StringBuilder localKey = new StringBuilder("dis_lock_");
        /*final Object[] args = proceedingJoinPoint.getArgs();

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();*/
        localKey.append(rlockInfo.localKey());

        return localKey.toString();
    }
    
    @AfterReturning("RlockAspect()")
    public void afterReturning(){
        System.out.println("----afterReturning----");
    }

    @After(value = "RlockAspect()")
    public void after(){
        System.out.println("----after----");
    }

    @Before(value = "RlockAspect()")
    public void before(){

        System.out.println("----before----");
    }

    /**
     *
     * @Around("targetMyAspec()")
     *     public Object Interceptor(ProceedingJoinPoint pjp){
     *         Object result = null;
     *         Class<?> aClass = pjp.getTarget().getClass();//获得所在切点的该类的class对象，也就是UserController这个类的对象
     *         String name = pjp.getSignature().getName();//获取该切点所在方法的名称，也就是listUser
     *         try {
     *             Method method = aClass.getMethod(name);//通过反射获得该方法
     *             MyLog annotation = method.getAnnotation(MyLog.class);//获得该注解
     *             System.out.println(annotation.value());//获得自定义注解上面的值
     *         } catch (NoSuchMethodException e) {
     *             e.printStackTrace();
     *         }
     *         try {
     *             result =pjp.proceed();//执行该方法
     *         } catch (Throwable e) {
     *             e.printStackTrace();
     *         }
     *         return result;
     *     }
     *
     */

}
