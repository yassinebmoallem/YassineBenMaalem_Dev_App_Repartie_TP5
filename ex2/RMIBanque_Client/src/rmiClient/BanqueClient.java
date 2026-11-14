package rmiClient;

import javax.naming.InitialContext;
import metier.Compte;
import rmiService.IBanque;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
            IBanque serviceBanque = (IBanque) ctx.lookup("ServiceBanque");

            System.out.println("Connexion au serveur reussie via JNDI !");

            Compte c1 = new Compte(101, 5000);
            Compte c2 = new Compte(102, 12000);

            System.out.println("--- Creation des comptes ---");
            System.out.println(serviceBanque.creerCompte(c1));
            System.out.println(serviceBanque.creerCompte(c2));
            System.out.println(serviceBanque.creerCompte(c1));

            System.out.println("\n--- Consultation des comptes ---");
            System.out.println(serviceBanque.getInfoCompte(101));
            System.out.println(serviceBanque.getInfoCompte(102));
            System.out.println(serviceBanque.getInfoCompte(999));

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}