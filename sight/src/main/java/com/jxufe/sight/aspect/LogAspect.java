package com.jxufe.sight.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 切面=切点+增强。
 * 切点：定义需要增强的方法。
 * 增强：方位+增强逻辑。方位信息决定在方法调用前、后执行增强。
 */
@Aspect//使该类成为切面类
@Component//将切面类对象注册到IOC容器中
public class LogAspect {
    //具有默认值的实例变量
    private final Logger logger= LoggerFactory.getLogger(LogAspect.class);

    //定义切点
    @Pointcut("execution(* com.jxufe.sight.web..*.*(..))")
    public void log(){}


    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();
        String method=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        RequestLog requestLog=new RequestLog(url,ip,method,joinPoint.getArgs());
        logger.info("RequestLog-->{}",requestLog.toString());
    }
//    @AfterReturning(value = "log()",returning = "result")
//    public void doAfterReturning(Object result){
//        logger.info("Return result:{}",result);
//    }

    //成员内部类。该类对象只会在本类中使用。将日志信息封装起来。
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog() {
        }

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}

