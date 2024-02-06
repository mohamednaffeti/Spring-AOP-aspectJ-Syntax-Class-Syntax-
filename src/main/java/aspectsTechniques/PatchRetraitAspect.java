package aspectsTechniques;

import metier.Compte;
import metier.MetierBanqueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchRetraitAspect {

    @Pointcut("execution(* metier.MetierBanqueImpl.retirer(..))")
    public void pc1(){}


    /**
     * pour utiliser ce code advice il faut avoir le code et le montant pour vérifier
     * si on peut retirer de l'argent ou non ( solde suffisant ou pas)
     * @param code
     * @param montant
     * @param proceedingJoinPoint
     * @param joinPoint
     */
    @Around("pc1() && args(code,montant)")
    public Object autourRetirer(Long code , double montant,ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
        // target l'objet sur lequel on va faire le test
        MetierBanqueImpl metierBanque = (MetierBanqueImpl) joinPoint.getTarget();
        Compte compte = metierBanque.consulter(code);
        if(compte.getSolde()<montant) throw new RuntimeException("Solde insuffisant");
        return proceedingJoinPoint.proceed();
    }

}
