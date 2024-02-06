public aspect FirstAspect {
    // la syntaxe aspectJ l'ancienne
    /**
     * un point cut s'appelle pc1 qui va etre invoqué au moment de
     * l'execution pour n'importe quel type de retour pour la méthode
     * main qui se trouve dans la classe application dans le package test
     */
    pointcut pc1() : execution(* test.*.main(..));
    /**
     * on declare les codes advices
     * before : avant l'execution de la méthode declaré dans le point cut
     */
    before(): pc1(){
        System.out.println("-------------------------------------------");
        System.out.println("Before main from Aspect with AspectJ syntax");
        System.out.println("-------------------------------------------");
        /**
         * mecanisme d'introduction des codes advices
         * au moment de génération du bytecode on va trouver ces codes advices
         * sans changer le code source de la méthode
         */
    }
    /**
     * après l'execution de la méthode déclaré dans le point cut
     */
    after() : pc1(){
        System.out.println("-------------------------------------------");
        System.out.println("After main from Aspect with AspectJ syntax");
        System.out.println("-------------------------------------------");
    }
  /*  void around() : pc1(){
        System.out.println("-------------------------------------------");
        System.out.println("Before main from Aspect with AspectJ syntax");
        System.out.println("-------------------------------------------");
        proceed();
        System.out.println("-------------------------------------------");
        System.out.println("After main from Aspect with AspectJ syntax");
        System.out.println("-------------------------------------------");
    }*/

}
