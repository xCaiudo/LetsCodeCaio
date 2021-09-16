package br.com.letscode.java;

import java.util.Scanner;

public class Q03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arrayNumeros = new int[5];
        StringBuilder par= new StringBuilder();
        StringBuilder impar = new StringBuilder();

        for (int i=0; i < arrayNumeros.length; i++ ){
            System.out.println("Digite um número: ");
            arrayNumeros[i] = sc.nextInt();
        }

        for (int arrayNumero : arrayNumeros) {
            if (arrayNumero % 2 == 0) {
                par.append(arrayNumero).append(" ");
            } else {
                impar.append(arrayNumero).append(" ");
            }
        }

        System.out.printf("Números Pares = %s, Números Impares = %s", par, impar);
    }
}
