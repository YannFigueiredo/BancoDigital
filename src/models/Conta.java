package models;

import models.exceptions.SaldoInsuficienteException;
import models.exceptions.TransferenciaParaContaRemetenteException;

public class Conta {
    private static int SEQUENCIAL = 1;
    protected static final String AGENCIA_PADRAO = "1";
    protected int numero;
    protected double saldo;
    protected String agencia;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.agencia = Conta.AGENCIA_PADRAO;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            System.out.printf("\nSacado com sucesso a quantia de R$ %.2f.", valor);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.printf("\nDepositado com sucesso a quantia de R$ %.2f.", valor);
    }

    public void transferir(Conta contaDestino, double valor) {
        if(contaDestino.getNumero() == this.numero)
            throw new TransferenciaParaContaRemetenteException("Não é possível transferir para a conta remetente!");

        if(this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.printf(
                "\nTransferido com sucesso a quantia de R$ %.2f para %s %s.",
                valor,
                contaDestino.getCliente().getNome(),
                contaDestino.getCliente().getSobrenome()
            );
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }
    }

    public void imprimirExtrato() {
        System.out.printf("Cliente: %s %s", this.cliente.getNome(), this.cliente.getSobrenome());
        System.out.printf("\nAgência: %s", this.agencia);
        System.out.printf("\nNúmero: %d", this.numero);
        System.out.printf("\nSaldo: R$ %.2f", this.saldo);
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
