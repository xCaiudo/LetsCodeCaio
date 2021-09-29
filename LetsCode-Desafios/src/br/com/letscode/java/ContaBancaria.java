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



import java.math.BigDecimal;


public class ContaBancaria {


    private Cliente titular;
    private String agencia;
    private int conta;
    protected BigDecimal saldo;
    private String tipoPessoa;

    public ContaBancaria(){

    }

    public ContaBancaria(Cliente titular, String agencia, int conta, double saldo) {
        this.titular = titular;
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = BigDecimal.valueOf(saldo);
        this.tipoPessoa = titular.getTipo();

    }

    public BigDecimal ColsultarSaldo(){
        return this.saldo;
    }

    public void Depositar(double valor){
        this.saldo = BigDecimal.valueOf(saldo.doubleValue() + valor);
    }

    public void Sacar(double valor){
        if (tipoPessoa == "Juridica"){
            this.saldo = BigDecimal.valueOf(saldo.doubleValue() - (valor*1.005));
        }
        else {
            this.saldo = BigDecimal.valueOf(saldo.doubleValue() - valor);
        }
    }

    public void Transferencia(ContaBancaria conta, double valor){
       ContaBancaria contaTemp = conta;
        if (tipoPessoa == "Jurídica"){
            this.saldo = BigDecimal.valueOf(saldo.doubleValue() - (valor*1.005));
        }
        else {
            this.saldo = BigDecimal.valueOf(saldo.doubleValue() - valor);
        }
        contaTemp.Depositar(valor);

    }

    public void Render(){
        if (this.getTitular().getTipo() != "Jurídica"){
            this.saldo = BigDecimal.valueOf(saldo.doubleValue()*1.02);
        }
        else{
            this.saldo = BigDecimal.valueOf(saldo.doubleValue()*1.04);
        }
    }

    public String getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public Cliente getTitular() {
        return titular;
    }
}

class ContaPoupanca extends ContaBancaria{
    public ContaPoupanca(Cliente titular, String agencia, int conta, double saldo) {
        super(titular, agencia, conta, saldo);
    }
    @Override
    public void Render(){
        this.saldo = BigDecimal.valueOf(saldo.doubleValue()*1.05);
    }
}

class ContaInvestimento extends ContaBancaria{
    public ContaInvestimento(Cliente titular, String agencia, int conta, double saldo) {
        super(titular, agencia, conta, saldo);
    }
    @Override
    public void Render(){
        if (this.getTitular().getTipo() != "Jurídica"){
            this.saldo = BigDecimal.valueOf(saldo.doubleValue()*1.05);
        }
        else{
            this.saldo = BigDecimal.valueOf(saldo.doubleValue()*1.07);
        }

    }


}

abstract class Cliente{
    private String nome;
    private String telefone;
    private String endereco;
    private String tipo = null;

    Cliente(String nome, int telefone, String endereco){
        this.nome = nome;
        this.telefone= String.valueOf(telefone);
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;}

}

class ClientePessoaJuridica extends Cliente {
    private String tipo = "Jurídica";
    private String cnpj;
    private String ie;

    ClientePessoaJuridica(String nome, int telefone, String endereco, String cnpj, String ie) {
        super(nome, telefone, endereco);
        this.cnpj=cnpj;
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getIe() {
        return ie;
    }

    public String getTipo() {
        return tipo;
    }
}

class ClientePessoaFisica extends Cliente {
    private String cpf;
    private String rg;
    private String tipo = "Fisica";

    ClientePessoaFisica(String nome, int telefone, String endereco, String cpf, String rg) {
        super(nome, telefone, endereco);
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }


    public String getTipo() {
        return tipo;
    }



}










