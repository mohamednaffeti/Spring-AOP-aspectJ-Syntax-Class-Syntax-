package test;

import metier.Compte;
import metier.IMetierBanque;
import metier.MetierBanqueImpl;

import java.util.Scanner;

public class application {
    public static void main(String[] args) {
       new application().start();
    }

    private void start() {
        System.out.println("Démarrage de l'application");
        Scanner scanner = new Scanner(System.in);
        System.out.println("donner le code du compte");
        long code = scanner.nextLong();
        System.out.println("donner le solde initial du compte");
        double solde = scanner.nextDouble();
        IMetierBanque metierBanque = new MetierBanqueImpl();
        // si call on va inserer le bytecode des codes advices ici pour before
        metierBanque.addCompte(new Compte(code,solde));
        // si call on va inserer le bytecode des codes advices ici pour after
        while (true) {
            try {
                System.out.println("type d'opération ?");
                String typeOperation = scanner.nextLine();  // Utilisez nextLine ici
                if (typeOperation.equals("quitter"))
                    break;

                switch (typeOperation) {
                    case "v":
                        System.out.println("donner le montant de l'opération à verser");
                        double montant = scanner.nextDouble();
                        scanner.nextLine();  // Consommez le retour à la ligne
                        metierBanque.verser(code, montant);
                        break;
                    case "r":
                        System.out.println("donner le montant de l'opération à retirer");
                        double montant1 = scanner.nextDouble();

                        metierBanque.retirer(code, montant1);
                        break;

                }

                System.out.println(metierBanque.consulter(code));
            } catch (RuntimeException e) {
                System.out.println("Erreur : " + e.getMessage());
                // Ajoutez cette ligne pour consommer le retour chariot après l'erreur
                scanner.nextLine();
            }
        }
    }
}
