package com.tj720.mip.framework.auth;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tj720.mip.utils.OrgUtil;

@Aspect
@Component
public class ControllerAopOperator {

	HttpServletRequest request = null;
	
	//声明AOP切入点，凡是使用了XXXOperateLog的方法均被拦截
    @Pointcut("@annotation(com.tj720.mip.framework.auth.ControllerAop)")
    public void log() {
//        System.out.println("我是一个切入点");
    }
    
    /**
     * 在所有标注@Log的地方切入
     * @param joinPoint
     */
    @Before("log()")
    public void beforeExec(JoinPoint joinPoint) {
        request=  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        ControllerAop annotation = method.getAnnotation(ControllerAop.class);
        Map<String, Integer> btnList = OrgUtil.getBtnList(annotation.url(), request);
        session.setAttribute("btn", btnList);
    }
    
}
