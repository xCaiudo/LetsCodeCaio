package br.com.letscode.java;

//
//Enunciado
//        Crie uma aplicação que simule uma app bancária. Os clientes podem ser pessoa física ou jurídica, sendo que para
//        PJ existe a cobrança de uma taxa de 0.5% para cada saque ou transferência. Além do produto conta-corrente, os
//        clientes PF podem abrir uma conta-poupança e conta-investimento. Clientes PJ não abrem poupança, mas seus
//        rendimentos em conta-investimento rendem 2% a mais.
//
//        Crie as funcionalidades: abrir conta, sacar, depositar, transferência, investir, consultar saldo.
//
//        Use a classe "Aplicacao" para criar seu método "main" e demonstrar o fucionamento do seu código.
//
//        O projeto pode ser entregue via arquivo zip para o e-mail do professor ou via link de repositório Github.

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Cliente fisica = new ClientePessoaFisica("Caio", 5594954, "rua seila", "55555", "55454");
        Cliente fisicaDois = new ClientePessoaFisica("CaioDois", 5594954, "rua seila", "55555", "55454");
        Cliente juridica = new ClientePessoaJuridica("CaioTres", 5594954, "rua seila", "554355", "55454");
        ContaBancaria teste = new ContaBancaria(fisica, "itau", 5542, 10000.00);
        ContaBancaria testeDois = new ContaBancaria(juridica, "itau", 5542, 8000.00);


        ContaBancaria contaFisica = new ContaBancaria();
        contaFisica= criarContaCorrente(fisicaDois);

        System.out.println(contaFisica.ColsultarSaldo() + " saldo da conta de " + contaFisica.getTitular().getNome());
        System.out.print(" Tipo de cliente -> ");
        System.out.println(teste.getTitular().getTipo());
        System.out.println(teste.ColsultarSaldo());
        System.out.println(testeDois.getTitular().getTipo());
        System.out.println(testeDois.getTitular().getEndereco());
        System.out.println(testeDois.getTitular().getTelefone());


        testeDois.Transferencia(teste,2000);

        System.out.println(testeDois.ColsultarSaldo()+ " novo saldo apos a transferencia do titular " + testeDois.getTitular().getNome());

        System.out.println(teste.ColsultarSaldo()+ " novo saldo apos receber a transferencia, titular " + teste.getTitular().getNome());


        testeDois.Render();
        teste.Render();
        contaFisica.Render();

        System.out.println(testeDois.ColsultarSaldo()+ " novo saldo apos render do titular " + testeDois.getTitular().getNome());
        System.out.println(teste.ColsultarSaldo()+ " novo saldo apos render do titular " + teste.getTitular().getNome());
        System.out.println(contaFisica.ColsultarSaldo()+ " novo saldo apos render do titular " + contaFisica.getTitular().getNome());

    }



    public static ContaBancaria criarContaCorrente(Cliente cliente){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da agencia: ");
        String agencia = sc.nextLine();
        System.out.println("Digite o numero da conta: ");
        int conta = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o Saldo inicial: ");
        double saldo = Double.parseDouble(sc.nextLine());
        ContaBancaria novaConta = new ContaBancaria(cliente,agencia,conta,saldo);
        return novaConta;
    }

    public static ContaBancaria criarContaPoupanca(Cliente cliente){
        if (cliente.getTipo() != "Juridico"){
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o nome da agencia: ");
            String agencia = sc.nextLine();
            System.out.println("Digite o numero da conta: ");
            int conta = Integer.parseInt(sc.nextLine());
            System.out.println("Digite o Saldo inicial: ");
            double saldo = Double.parseDouble(sc.nextLine());
            ContaBancaria novaConta = new ContaPoupanca (cliente,agencia,conta,saldo);
            return novaConta;
        }
        else{
            System.out.println("Apenas pessoas Fisicas podem criar uma conta poupanca!");
        }

        return null;
    }

    public static ContaBancaria criarContaInvestimento(Cliente cliente){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da agencia: ");
        String agencia = sc.nextLine();
        System.out.println("Digite o numero da conta: ");
        int conta = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o Saldo inicial: ");
        double saldo = Double.parseDouble(sc.nextLine());
        ContaBancaria novaConta = new ContaInvestimento (cliente,agencia,conta,saldo);
        return novaConta;

    }

}


