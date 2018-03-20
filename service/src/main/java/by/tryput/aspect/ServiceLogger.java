package by.tryput.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

import static org.apache.log4j.Level.ERROR;


@Aspect
public class ServiceLogger {

    private static final Logger LOG = Logger.getLogger(ServiceLogger.class);

    @Pointcut("execution(* by.tryput.services.*.*(..))")
    public void serviceMethod() {
    }

    @Around("serviceMethod()")
    public Object logServiceCall(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        Object result = null;

        LOG.info("Call method " + methodName + " with args " + Arrays.toString(methodArgs));
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        LOG.info("Method " + methodName + " return result " + result);
        return result;
    }
}
