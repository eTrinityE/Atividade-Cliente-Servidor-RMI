package Atividade_ClienteSevidor_GeometricoRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote {
    public int getQuadrado (int ladoQuadrado) throws RemoteException;
    public int getRetangulo (int lado1Retangulo, int lado2Retangulo) throws RemoteException;
    public double getTriangulo (int lado1Triangulo, int lado2Triangulo, int lado3Triangulo) throws RemoteException;
    public double getCirculo (double raio) throws RemoteException;
}
