package br.com.letscode.java;

import java.util.Scanner;

public class PolegadaParaCentimetro {
    public static void  main(String[] args){

        double valorPolegada, polegadaParaCM;
        System.out.println("Qual valor de polegadas deseja converter? ");
        Scanner sc = new Scanner(System.in);
        valorPolegada = sc.nextDouble();
        polegadaParaCM = valorPolegada * 2.54;

        System.out.printf("O valor de %.2f polegadas é %.2f centímetros.", valorPolegada, polegadaParaCM);


    }
}
