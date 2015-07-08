package demo.aop.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutService {
    @Pointcut("execution(String getMessage())")
    public void getMessageWithNoArgument() {
    }

    @Pointcut("execution(String pl.java.borowiec..Service+.getMessage(String))")
    public void getMessageWithStringArgument() {
    }
}
