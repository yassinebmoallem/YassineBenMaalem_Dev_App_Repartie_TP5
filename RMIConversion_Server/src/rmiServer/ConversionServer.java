package rmiServer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import rmiService.ConversionImpl;


public class ConversionServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("Serveur RMI démarré...");
            System.out.println("RMIRegistry activé sur le port 1099");

            ConversionImpl serviceConversion = new ConversionImpl();

            Naming.rebind("rmi://localhost/ServiceConversion", serviceConversion);
            System.out.println("Service 'ServiceConversion' publié avec succès.");
            System.out.println("Le serveur attend les requêtes des clients...");

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}