package br.com.letscode.java;
import java.util.Arrays;
import java.util.Scanner;

public class Q01 {
    public static void main(String[] args){
        String[] listaFrutas;
        listaFrutas =  new String[5];

        Scanner sc = new Scanner(System.in);

        for (int i=0; i<5; i++){
            System.out.println("Digite o nome da fruta: ");
            listaFrutas[i] = sc.next();

        }

        System.out.println(Arrays.toString(listaFrutas));

    }
}
