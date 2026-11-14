package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ConversionImpl extends UnicastRemoteObject implements IConversion {

    private static final double TAUX_CHANGE = 3.37;


    public ConversionImpl() throws RemoteException {
        super();
    }


    @Override
    public double convertirMontant(double mt) throws RemoteException {
        System.out.println("Demande de conversion reçue : " + mt + " Euros");
        return mt * TAUX_CHANGE;
    }
}