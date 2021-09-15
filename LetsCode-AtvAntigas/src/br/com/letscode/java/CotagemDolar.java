package br.com.letscode.java;

import java.util.Scanner;

public class CotagemDolar {
    public static void main(String[] args){

        double dolarHoje, valorReais, reaisParaDolar;

        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a cotação do dólar hoje?");
        dolarHoje = sc.nextDouble();
        System.out.println("Qual valor você deseja ver em dólar?");
        valorReais = sc.nextDouble();

        reaisParaDolar = valorReais / dolarHoje;

        System.out.printf("O Valor de R$%.2f reais equivale a US$%.2f dolares.",valorReais,reaisParaDolar);


    }
}
