package models;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n\n=== EXTRATO CONTA CORRENTE ===\n");
        super.imprimirExtrato();
    }
}
