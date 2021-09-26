package br.com.letscode.java;

import java.util.Scanner;

public class Q02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual palavra deseja ver ao contrario? ");
        String palavra = sc.next();
        var arrayArvalap = palavra.split("");

        for (int i= arrayArvalap.length-1; i>= 0; i--){
            if (i == 0) {
                System.out.println(arrayArvalap[i] + " ]");
            }
            else if (i == arrayArvalap.length-1){
                System.out.print("[ " + arrayArvalap[i]);
            }
            else {
                System.out.print(arrayArvalap[i]);
            }
        }
    }
}
