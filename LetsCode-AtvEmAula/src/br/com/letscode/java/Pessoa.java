package br.com.letscode.java;

public class Pessoa {
    private String nome;
    private int idade;
    private int alturaCentimetros;
    private double pesoQuilogramas;
    private SexoEnum sexo;

    public Pessoa(String nome, int idade, int alturaCentimetros, double pesoQuilogramas, SexoEnum sexo) {
        this.nome = nome;
        this.idade = idade;
        this.alturaCentimetros = alturaCentimetros;
        this.pesoQuilogramas = pesoQuilogramas;
        this.sexo = sexo;
    }

    public void falar() {
        System.out.println(this.nome + " está falando...");
    }
    public void comer() {
        System.out.println(this.nome + " está comendo...");
    }
    public void dormir() {
        System.out.println(this.nome + " está dormindo...");
    }

    public static void quemSou() {
        System.out.println("Eu sou uma Pessoa");
    }

    public String toString() {
        return "Pessoa{" +
                "nome='" + this.nome + '\'' +
                ", idade=" + this.idade +
                ", alturaCentimetros=" + this.alturaCentimetros +
                ", pesoQuilogramas=" + this.pesoQuilogramas +
                ", sexo=" + this.sexo +
                '}';
    }

    public enum SexoEnum{
        Masculino,
        Feminino;
    }
}
