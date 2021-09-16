package br.com.letscode.java;

import java.util.Scanner;

public class Q04 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[] arrayNumeros = new int[5];
        int soma = 0;


        for (int i = 0; i <arrayNumeros.length;i++){
            System.out.println("Digite um número: ");
            arrayNumeros[i] = sc.nextInt();
            soma += arrayNumeros[i];
        }
        int maior = arrayNumeros[0],menor = arrayNumeros[0];
        double media= (double) soma/ arrayNumeros.length;

        for (int num : arrayNumeros){
            if (maior < num){
                maior = num;
            }
            if(menor > num){
                menor = num;
            }
        }

        System.out.printf("O maior número é %s, o menor número é %s e a média deles é %.2f",maior,menor,media);

    }
}
