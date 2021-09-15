package br.com.letscode.java;

import java.util.Scanner;

public class TabuadaDificil {
    public static void main(String[] args){
        int Numero,Tabuada1, Tabuada2, Tabuada3, Tabuada4, Tabuada5, Tabuada6, Tabuada7, Tabuada8, Tabuada9,
                Tabuada10;

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número que deseja saber a tabuada: ");
        Numero = sc.nextInt();

        Tabuada1 = Numero;
        Tabuada2 = Numero * 2;
        Tabuada3 = Numero * 3;
        Tabuada4 = Numero * 4;
        Tabuada5 = Numero * 5;
        Tabuada6 = Numero * 6;
        Tabuada7 = Numero * 7;
        Tabuada8 = Numero * 8;
        Tabuada9 = Numero * 9;
        Tabuada10 = Numero* 10;
        System.out.printf("%d x 1 = %d%n", Numero, Tabuada1);
        System.out.printf("%d x 2 = %d%n", Numero, Tabuada2);
        System.out.printf("%d x 3 = %d%n", Numero, Tabuada3);
        System.out.printf("%d x 4 = %d%n", Numero, Tabuada4);
        System.out.printf("%d x 5 = %d%n", Numero, Tabuada5);
        System.out.printf("%d x 6 = %d%n", Numero, Tabuada6);
        System.out.printf("%d x 7 = %d%n", Numero, Tabuada7);
        System.out.printf("%d x 8 = %d%n", Numero, Tabuada8);
        System.out.printf("%d x 9 = %d%n", Numero, Tabuada9);
        System.out.printf("%d x 10 = %d%n", Numero, Tabuada10);



    }
}
