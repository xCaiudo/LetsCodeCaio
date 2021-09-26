package br.com.letscode.java;

import java.util.Arrays;
import java.util.Scanner;

public class Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrayListaConvidados = new String[5];
        String nomeLongo = "";

        for (int i = 0; i < arrayListaConvidados.length; i++) {
            System.out.println("Digite um nome: ");
            arrayListaConvidados[i] = sc.nextLine();
        }
        for (String nomeAtual : arrayListaConvidados) {
            if (nomeAtual.length() > nomeLongo.length()) {
                nomeLongo = nomeAtual;
            }
        }

        System.out.println("A lista de convidados é: " + Arrays.toString(arrayListaConvidados));
        System.out.println("O(s) convidado(s) com nome mais longo(s) é(são): " + nomeLongo);
    }
}
