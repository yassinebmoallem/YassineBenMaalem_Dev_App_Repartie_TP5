package rmiClient;

import java.rmi.Naming;
import rmiService.IConversion;


public class ConversionClient {

    public static void main(String[] args) {
        try {
            IConversion serviceConversion = (IConversion) Naming.lookup("rmi://localhost/ServiceConversion");
            System.out.println("Connexion au serveur réussie !");

            double montantEnEuros = 500;
            double montantEnDinars = serviceConversion.convertirMontant(montantEnEuros);

            System.out.println("Montant en Euros : " + montantEnEuros + " €");
            System.out.println("Montant converti en Dinars : " + montantEnDinars + " DT");

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}