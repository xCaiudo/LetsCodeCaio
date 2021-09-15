package br.com.letscode.java;

import java.util.Scanner;

public class ConverteTemperatura{
    public static void  main(String[] args){
        double temperaturaCelsius, converteFahrenheit;


        System.out.println("Digite a temperatura que deseja converter: ");
        Scanner sc = new Scanner(System.in);
        temperaturaCelsius = sc.nextDouble();

        converteFahrenheit = 1.8*temperaturaCelsius+32;

        System.out.printf("O resultado da conversão de %.1fC para Fahrenheit é %.2fF.", temperaturaCelsius,
                converteFahrenheit);
    }
}








