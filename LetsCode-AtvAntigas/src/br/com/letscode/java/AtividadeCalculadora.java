package br.com.letscode.java;

import java.util.Scanner;

public class AtividadeCalculadora {
    public static void main(String[] args){

        int Numero1, Numero2;
        int Soma, Subtracao, Multiplicacao;
        double Divisao;

        Scanner input1 = new Scanner(System.in);
        System.out.println("Digite o primeiro número: ");
        Numero1 = input1.nextInt();
        System.out.println("Digite o segundo número: ");
        Numero2 = input1.nextInt();

        Soma = Numero1 + Numero2;
        Subtracao = Numero1 - Numero2;
        Divisao = (double) Numero1 / Numero2;
        Multiplicacao = Numero1 * Numero2;

        System.out.printf("A Soma dos números é %d, a Subtração é %d, a Divisão é %.2f e a Multiplicação é %d.",
                Soma,
                Subtracao, Divisao, Multiplicacao);


    }

}
