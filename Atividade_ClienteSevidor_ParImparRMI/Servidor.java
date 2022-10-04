package Atividade_ClienteSevidor_ParImparRMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements Calc {

    protected Servidor() throws RemoteException {
        super();
    }

    @Override
    public String ParOuImpar(int numero) throws RemoteException {
        if ((numero%2) == 0){
            return "Par";
        }else {
            return "Impar";
        }
    }

    @Override
    public String PrimoOuNao(int numero) throws RemoteException {
        int cont=0;
        for (int i = 1; i <= numero ; i++) {
            if(numero%i==0){
                cont++;
            }
        }

        if(cont==2){
            return "O número "+ numero+" é primo";
        } else{
            return "O numero "+ numero+" não é primo";
        }
    }

    @Override
    public String DivisivelPorNumero(int numero1, int numero2) throws RemoteException {
        if((numero1%numero2) == 0){
            return "O número é divisivel";
        }else{
            return "O número não é divisivel";
        }
    }

    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(3001);
            Servidor s = new Servidor();
            Naming.rebind("//localhost:3001/calc", s);
            System.out.println("Servidor pronto");

        }catch (RemoteException re){
            System.out.println(re);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
