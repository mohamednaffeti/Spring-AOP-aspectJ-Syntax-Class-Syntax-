package aspectsTechniques;

import org.aspectj.lang.annotation.*;

@Aspect
public class withClassSyntax {
    /*@Pointcut("execution(* test.*.main(..))")
    public void pc1(){

    }
    @Before("pc1()")
    public void beforeMain(){
        System.out.println("****************************************");
        System.out.println("Before main from Aspect with class syntax");
        System.out.println("****************************************");
    }
    @After("pc1()")
    public void afterMain(){
        System.out.println("****************************************");
        System.out.println("Before main from Aspect with class syntax");
        System.out.println("****************************************");
    }
    @Around("pc1()")
    public void arroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("****************************************");
        System.out.println("Before main from Aspect with class syntax");
        System.out.println("****************************************");
        //execution de la méthode
        proceedingJoinPoint.proceed();
        System.out.println("****************************************");
        System.out.println("Before main from Aspect with class syntax");
        System.out.println("****************************************");
    }*/
}
