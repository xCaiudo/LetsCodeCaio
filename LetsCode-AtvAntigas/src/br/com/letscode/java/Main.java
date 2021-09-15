package br.com.letscode.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator.Calculadora calc = new Calculator.Calculadora();
        long numero1, numero2;
        short escolha = 8;

        Scanner input = new Scanner(System.in);
        System.out.println("Qual operação deseja realizar?");
        System.out.println("1 - Soma, 2 - Subtração, 3 - Divisão, 4 - Mutiplicação, 5 - Qual é par, 6 - Qual é o " +
                "maior, 0 - Desejo Sair.");
        System.out.println("Operação: ");

        escolha = input.nextShort();

        while(escolha == 0) {
            System.out.println("Até a proxima!");
            break;
        }


        while (escolha != 0 && escolha < 7) {
            Scanner input1 = new Scanner(System.in);

            System.out.println("Digite o primeiro número: ");
            numero1 = input1.nextInt();
            System.out.println("Digite o segundo número: ");
            numero2 = input1.nextInt();

            if (escolha == 1) {
                float operacao = calc.Soma(numero1, numero2);
                System.out.println(" resultado desta soma é: " + operacao);
                break;
            } else if (escolha == 2) {
                float operacao = calc.Subtracao(numero1, numero2);
                System.out.println(" resultado desta subtração é: " + operacao);
                break;
            } else if (escolha == 3) {
                float operacao = calc.Divisao(numero1, numero2);
                System.out.println(" resultado desta divisão é: " + operacao);
                break;
            } else if (escolha == 4) {
                float operacao = calc.Multiplicacao(numero1, numero2);
                System.out.println(" resultado desta multiplicação é: " + operacao);
                break;
            } else if (escolha == 5) {
                String operacao = calc.ChecagemDePar(numero1, numero2);
                System.out.println(operacao);
                break;
            } else if (escolha == 6) {
                String operacao = calc.QualOMaior(numero1, numero2);
                System.out.println(operacao);
                break;
            }
        }
    }
}



