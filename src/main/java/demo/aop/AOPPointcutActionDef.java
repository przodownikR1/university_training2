package demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPPointcutActionDef {

    @Pointcut("@annotation(demo.annotation.CatchException) || within(@org.springframework.stereotype.Service *) ")
    public void serviceExLog() {
        // empty
    }

}