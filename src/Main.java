import models.*;

public class Main {
    public static void main(String[] args) {
        //Criando o banco
        Banco banco = new Banco("Banco Fake");

        //Criando clientes
        Cliente cliente1 = new Cliente("Yann", "Figueiredo", "12345678925");
        Cliente cliente2 = new Cliente("Max", "Cambota", "12345678923");
        Cliente cliente3 = new Cliente("Fernando", "Portugal", "12345678921");

        //Criando contas
        Conta conta1 = new ContaCorrente(cliente1);
        Conta conta2 = new ContaPoupanca(cliente1);
        Conta conta3 = new ContaCorrente(cliente2);
        Conta conta4 = new ContaPoupanca(cliente3);

        //Registrando as contas no banco criado
        banco.salvarConta(conta1);
        banco.salvarConta(conta2);
        banco.salvarConta(conta3);
        banco.salvarConta(conta4);

        //Depositando nas contas
        conta1.depositar(325);
        conta2.depositar(457);
        conta3.depositar(1520);
        conta4.depositar(3600);

        //Extratos após depósito
        System.out.println("\n\n=== EXTRATO APÓS DEPÓSITO ===");
        conta1.imprimirExtrato();
        conta2.imprimirExtrato();
        conta3.imprimirExtrato();
        conta4.imprimirExtrato();

        //Sacando das contas
        conta1.sacar(30);
        conta2.sacar(150);
        conta3.sacar(500);
        conta4.sacar(1820);

        //Extratos após saque
        System.out.println("\n\n=== EXTRATO APÓS SAQUE ===");
        conta1.imprimirExtrato();
        conta2.imprimirExtrato();
        conta3.imprimirExtrato();
        conta4.imprimirExtrato();

        //Transferindo valores
        conta1.transferir(conta2, 100);
        conta2.transferir(conta3, 125);
        conta3.transferir(conta4, 600);

        //Extratos após transferência
        System.out.println("\n\n=== EXTRATO APÓS TRANSFERÊNCIA ===");
        conta1.imprimirExtrato();
        conta2.imprimirExtrato();
        conta3.imprimirExtrato();
        conta4.imprimirExtrato();

        //Listando contas
        banco.listarContas();

        //Listando clientes
        banco.listarClientes();
    }
}