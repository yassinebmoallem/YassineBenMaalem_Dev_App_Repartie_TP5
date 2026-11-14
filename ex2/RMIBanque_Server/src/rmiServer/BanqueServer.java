package rmiServer;

import java.rmi.registry.LocateRegistry;
import javax.naming.InitialContext;
import rmiService.BanqueImpl;

public class BanqueServer {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "localhost");
            LocateRegistry.createRegistry(1099);

            BanqueImpl serviceBanque = new BanqueImpl();

            InitialContext ctx = new InitialContext();
            ctx.bind("ServiceBanque", serviceBanque);

            System.out.println("Serveur RMI demarre avec JNDI.");
            System.out.println("Service 'ServiceBanque' enregistre avec succes.");
            System.out.println("En attente des requetes clients...");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}