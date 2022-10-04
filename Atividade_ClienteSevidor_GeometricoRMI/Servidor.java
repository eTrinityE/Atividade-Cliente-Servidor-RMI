package Atividade_ClienteSevidor_GeometricoRMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements Calc {

    protected Servidor() throws RemoteException {
        super();
    }

    @Override
    public int getQuadrado(int ladoQuadrado) throws RemoteException {
        System.out.println("Calculando a area do quadrado de lado "+ ladoQuadrado);
        return ladoQuadrado*ladoQuadrado;
    }

    @Override
    public int getRetangulo(int lado1Retangulo, int lado2Retangulo) throws RemoteException {
        System.out.println("Calculado area do retagulo de lado "+ lado1Retangulo+" e "+lado2Retangulo);
        return lado1Retangulo*lado2Retangulo;
    }

    @Override
    public double getTriangulo(int lado1Triangulo, int lado2Triangulo, int lado3Triangulo) throws RemoteException {
        double p = (double) (lado1Triangulo+lado2Triangulo+lado3Triangulo)/2;
        return Math.pow(p*(p-lado1Triangulo)*(p-lado2Triangulo)*(p-lado3Triangulo), 0.5);
    }

    @Override
    public double getCirculo(double raio) throws RemoteException {
        System.out.println("Calculando a area do circulo de raio "+ raio);
        return Math.PI*(raio*raio);
    }

    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(3000);
            Servidor s = new Servidor();
            Naming.rebind("//localhost:3000/calc", s);
            System.out.println("Servidor pronto.");

        }catch (RemoteException re){
            System.out.println(re);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
