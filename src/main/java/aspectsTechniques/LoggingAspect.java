package aspectsTechniques;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);  // Utilisez LoggerFactory.getLogger
    long t1,t2;
    @Pointcut("execution(* metier.MetierBanqueImpl.*(..))") // c'est dans les méthodes de la classe metier
    // que les codes advices vont etre gréffés (les méthodes qui vont etre executées
    //@Pointcut("call(* metier.*.*(..))") dans l'appel des méthodes de la classes metier(
    //ici dans la classe main application que les codes advices vont etre greffés
    public void pc1(){}

    @Before("pc1()")
    public void avant(JoinPoint joinPoint){
        t1=System.currentTimeMillis();
        logger.info("avant l'execution de la méthode " +joinPoint.getSignature());
    }


    @After("pc1()")
    public void apres(JoinPoint joinPoint){
        logger.info("apres l'execution de la méthode "+joinPoint.getSignature());
        t2=System.currentTimeMillis();
        logger.info("durée de l'execution de la méthode : " +(t2-t1));
    }
    /**
     * c'est pour ça qu'on dit que paradigme AOP sépare les codes techniques (ici logging)
     * des codes metiers , nous avons pas toucher le code source de l'application
     */


}
