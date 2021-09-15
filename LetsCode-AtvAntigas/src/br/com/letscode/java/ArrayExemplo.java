package br.com.letscode.java;

import java.util.Scanner;

public class ArrayExemplo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] numeros = new int[n];

    }
}

//class ArrayCopyOfDemo {
//    public static void main(String[] args) {
//        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
//                'i', 'n', 'a', 't', 'e', 'd'};
//        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);
//        System.out.println(new String(copyTo)); <--- O copyOfRange pega do indice 2 até o ultimo -1 (ou seja o 8),
//        retornando caffein.
//    }
//}