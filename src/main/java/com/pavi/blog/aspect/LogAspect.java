package com.pavi.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/5 10:24
 */
@Aspect
@Component
public class LogAspect {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.pavi.blog.web.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("-------before--------");
        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringType()+joinPoint.getSignature().getName();
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        Object[] args = joinPoint.getArgs();
        ReqeustLog reqeustLog = new ReqeustLog(url,ip,classMethod,args);
        logger.info("Request: {}",reqeustLog);



    }

    @After("log()")
    public void doAfter(){
        logger.info("-------doAfter--------");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturning(JoinPoint joinPoint,Object result){
        logger.info("Result: {}",result);
    }


    private class ReqeustLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
        public ReqeustLog(String url, String ip, String classMethod, Object[]
                args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }
        @Override
        public String toString() {
            return "ReqeustLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
