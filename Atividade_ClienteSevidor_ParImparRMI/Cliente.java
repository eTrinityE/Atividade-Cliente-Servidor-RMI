package Atividade_ClienteSevidor_ParImparRMI;

import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Calc calculador;
        try{
            calculador = (Calc) Naming.lookup("rmi://localhost:3001/calc");
            System.out.println("Selecione o numero correspondente a finalidade");
            System.out.println("1 - Descobrir se o número é par ou impar");
            System.out.println("2 - Descobrir se o número é ou não é primo");
            System.out.println("3 - Descobrir se um número é divisivel por outro determinado número");
            System.out.println("4 - Sair do menu");
            int numero, parimpar, primo, divi1, divi2;
            Scanner sc = new Scanner(System.in);
            numero = sc.nextInt();
            switch (numero){
                case 1:
                    System.out.println("Insira o número para descobrir se ele é par ou impar: ");
                    parimpar = sc.nextInt();
                    String result = calculador.ParOuImpar(parimpar);
                    System.out.println("O número informado é "+result);
                    break;
                case 2:
                    System.out.println("Insira o número para descobrir se ele é primo: ");
                    primo = sc.nextInt();
                    String result2 = calculador.PrimoOuNao(primo);
                    System.out.println("Resultado: "+ result2);
                    break;
                case 3:
                    System.out.println("Insira o primeiro número: ");
                    divi1 = sc.nextInt();
                    System.out.println("Insira o segundo numero para ver se é divisivel pelo primeiro: ");
                    divi2 = sc.nextInt();
                    String result3 = calculador.DivisivelPorNumero(divi1, divi2);
                    System.out.println("Resultado: "+ result3);
                    break;
                case 4:
                    break;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
