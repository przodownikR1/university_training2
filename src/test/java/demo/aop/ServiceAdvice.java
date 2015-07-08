package demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAdvice {
    @Around("demo.aop.service.PointcutService.getMessageWithNoArgument()")
    public Object around(ProceedingJoinPoint joinPoint) {
        String retString = null;
        try {
            retString = (String) joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "advice_" + retString;
    }

    @Around("demo.aop.service.PointcutService.getMessageWithStringArgument()")
    public Object around2(ProceedingJoinPoint joinPoint) {
        String retString = null;
        try {

            retString = (String) joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "advice 1 _" + retString;
    }
}
