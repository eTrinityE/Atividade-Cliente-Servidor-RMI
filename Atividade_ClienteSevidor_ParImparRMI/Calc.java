package Atividade_ClienteSevidor_ParImparRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote {
    public String ParOuImpar (int numero) throws RemoteException;
    public String PrimoOuNao (int numero) throws RemoteException;
    public String DivisivelPorNumero (int numero1, int numero2) throws RemoteException;
}
