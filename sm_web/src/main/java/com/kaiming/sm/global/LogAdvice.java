package com.kaiming.sm.global;


import com.kaiming.sm.entity.Log;
import com.kaiming.sm.entity.Staff;
import com.kaiming.sm.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LogAdvice {

    @Autowired
    private LogService logService;

    @After(value = "execution(* com.kaiming.sm.controller.*.*(..))&& !execution(* com.kaiming.sm.controller.SelfController.*(..)) && !execution(* com.kaiming.sm.controller.*.to*(..))")
    public void operationLog(JoinPoint joinPoint) {
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("USER");
        log.setOperator(staff.getAccount());
        log.setResult("success");

        logService.addOperationLog(log);

    }


    @AfterThrowing(value = "execution(* com.kaiming.sm.controller.*.*(..))&& !execution(* com.kaiming.sm.controller.SelfController.*(..))", throwing = "e")
    public void systemLog(JoinPoint joinPoint, Throwable e) {
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("USER");
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());

        logService.addSystemLog(log);

    }

    @After(value = "execution(* com.kaiming.sm.controller.SelfController.login(..))")
    public void loginLog(JoinPoint joinPoint) {
        log(joinPoint);
    }

    @Before(value = "execution(* com.kaiming.sm.controller.SelfController.logout(..))")
    public void logoutLog(JoinPoint joinPoint) {
        log(joinPoint);
    }

    private void log(JoinPoint joinPoint) {
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];

        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");

        if (obj == null) {
            log.setOperator((String) request.getAttribute("account"));
            log.setResult("failed");
        } else {
            Staff staff = (Staff) obj;
            log.setOperator(staff.getAccount());
            log.setResult("success");
        }


        logService.addLoginLog(log);
    }

}
