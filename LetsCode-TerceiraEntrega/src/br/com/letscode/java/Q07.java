package br.com.letscode.java;

import java.util.Scanner;

public class Q07 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] arrayNomes = new String[5];
        int[] arrayIdades = new int[5];
        int somaIdades = 0, indiceMaior = 0, indiceMenor = 0;

        for (int i =0; i<arrayNomes.length; i++){
            System.out.println("Digite um nome: ");
            arrayNomes[i] = sc.nextLine();
            System.out.println("Digite a idade da pessoa: ");
            arrayIdades[i] = Integer.parseInt(sc.nextLine());
            somaIdades += arrayIdades[i];
        }
        int maior = arrayIdades[0], menor = arrayIdades[0];
        for (int i =0; i<arrayIdades.length; i++){
            if (maior < arrayIdades[i]){
                maior = arrayIdades[i];
                indiceMaior = i;
            }

            if (menor > arrayIdades[i]){
                menor = arrayIdades[i];
                indiceMenor = i;
            }
        }
        double media =(double) somaIdades / arrayIdades.length;
        System.out.printf("A maior idade é %s e a pessoa se chama %s.\n",maior,arrayNomes[indiceMaior]);
        System.out.printf("A menor idade é %s e a pessoa se chama %s.\n",menor,arrayNomes[indiceMenor]);
        System.out.printf("A média das idades de todas pessoas na lista é %.2f!",media);

    }

}
