package br.com.letscode.java;

public class Q08 {
    public static   void main(String[] args){

       String[] arrayNomes = {"João", "Mario", "Maria", "Jose", "Marcio"};
       double[] arrayPesos = {65.5,70,55.8,80.5,48.7}, arrayAltura= {1.65,1.70,1.55,1.75,1.60} ;
       double checaIMC;

       for (int i = 0;i<arrayAltura.length;i++){
           checaIMC = arrayPesos[i] / (arrayAltura[i]*arrayAltura[i]);
           if (checaIMC < 18.5 || checaIMC > 25 ){
               System.out.printf("%s não esta no peso ideal, pois possui o IMC de %.2f\n", arrayNomes[i],checaIMC);
           }
           else{
               System.out.printf("%s esta no peso ideal, pois possui o IMC de %.2f\n", arrayNomes[i],checaIMC);
           }
       }
    }
}
