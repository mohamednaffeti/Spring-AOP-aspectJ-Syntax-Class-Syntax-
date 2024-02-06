package aspectsTechniques;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {

    @Pointcut("execution(* test.application.*(..))")
    public void startApplicationPointCut(){}

    @Around("startApplicationPointCut()")
    public void autourStart(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.println("username ?");
        String username = scanner.nextLine();
        System.out.println("password ?");
        String password = scanner.nextLine();
        if (username.equals("mohamed") && password.equals("12345678"))
            {proceedingJoinPoint.proceed();}
        else {
            System.out.println("vous n'avez pas acces");
        }
    }
}
