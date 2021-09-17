package br.com.letscode.java;

import java.util.Locale;
import java.util.Scanner;

public class Q06 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma palavra ");
        String palavra = sc.next();
        var arrayPalavra = palavra.split("");
        String palavraRetorno = "";

        for (int i = 0; i< arrayPalavra.length;i++){
            if (i % 2 == 0){
                palavraRetorno += arrayPalavra[i].toUpperCase();
            }
            else{
                palavraRetorno += arrayPalavra[i];
            }
        }
        System.out.println("A formatação da palavra ficou assim: ");
        System.out.println(palavraRetorno);


    }
}
