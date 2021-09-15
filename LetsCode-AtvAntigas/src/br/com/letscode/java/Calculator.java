package br.com.letscode.java;

public class Calculator {
    public static class Calculadora {

        public float Soma(float numero1, float numero2) {
            return numero1 + numero2;
        }

        public float Subtracao(float numero1, float numero2) {
            return numero1 - numero2;
        }

        public float Divisao(float numero1, float numero2) {
            return numero1 / numero2;
        }

        public float Multiplicacao(float numero1, float numero2) {
            return numero1 * numero2;
        }

        public String ChecagemDePar(float numero1, float numero2) {
            if (numero1 % 2 == 0 && numero2 % 2 == 0) {
                return "Ambos são pares";
            } else if (numero1 % 2 == 0 && !(numero2 % 2 == 0)) {
                return "Apenas o primeiro número é par";

            } else if (!(numero1 % 2 == 0) && numero2 % 2 == 0) {
                return "Apenas o Segundo número é par";

            } else {
                return "Nenhum dos números são Pares";

            }
        }

        public String QualOMaior(float numero1, float numero2) {
            if (numero1 > numero2) {
                return "O primeiro número é o maior!";
            } else if (numero1 == numero2) {
                return "Ambos os números são iguais";
            }else {
                return "O segundo número é o maior";
            }

        }
    }
}

