package Atividade_ClienteSevidor_GeometricoRMI;

import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Calc calculador;
        try{
            calculador = (Calc) Naming.lookup("rmi://localhost:3000/calc");
            System.out.println("Selecione o numero correspondente a figura geometrica");
            System.out.println("1 - Quadrado");
            System.out.println("2 - Retangulo");
            System.out.println("3 - Triangulo");
            System.out.println("4 - Circulo");
            System.out.println("5 - Sair do Menu");
            int numero, ladoQuadrado, lado1Retangulo, lado2Retangulo, lado1Triangulo, lado2Triangulo, lado3Triangulo;
            double raio;
            Scanner sc = new Scanner(System.in);
            numero = sc.nextInt();
            switch (numero){
                case 1:
                    System.out.println("Insira o lado do quadrado: ");
                    ladoQuadrado = sc.nextInt();
                    int result = calculador.getQuadrado(ladoQuadrado);
                    System.out.println("Resultado: "+result);
                    break;
                case 2:
                    System.out.println("Insira o primeiro lado do retangulo: ");
                    lado1Retangulo = sc.nextInt();
                    System.out.println("Insira o segundo lado do retangulo: ");
                    lado2Retangulo = sc.nextInt();
                    int result2 = calculador.getRetangulo(lado1Retangulo, lado2Retangulo);
                    System.out.println("Resultado: "+ result2);
                    break;
                case 3:
                    System.out.println("Insira o primeiro lado do triangulo: ");
                    lado1Triangulo = sc.nextInt();
                    System.out.println("Insira o segundo lado do triangulo: ");
                    lado2Triangulo = sc.nextInt();
                    System.out.println("Insira o terceiro lado do triangulo: ");
                    lado3Triangulo = sc.nextInt();
                    double result3 = calculador.getTriangulo(lado1Triangulo, lado2Triangulo, lado3Triangulo);
                    System.out.println("Resultado: "+ result3);
                    break;
                case 4:
                    System.out.println("Insira o tamanho do raio: ");
                    raio = sc.nextDouble();
                    double result4 = calculador.getCirculo(raio);
                    System.out.println("Resultado: "+ result4);
                    break;
                case 5:
                    break;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
