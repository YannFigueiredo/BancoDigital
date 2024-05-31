package models;

import models.exceptions.ContaInexistenteException;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static int ID = 1;
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.contas = new ArrayList<>();
        this.nome = nome;
        ID = ID++;
    }

    public void salvarConta(Conta conta) {
        this.contas.add(conta);
        System.out.println("Conta salva com sucesso!");
    }

    public void removerConta(int numero) {
        if(this.contas.stream().noneMatch(c -> c.getNumero() == numero))
            throw new ContaInexistenteException("Esse número de conta é inexistente!");

        this.contas.removeIf(c -> c.getNumero() == numero);
        System.out.println("Conta removida com sucesso!");
    }

    public void listarContas() {
        if(!this.contas.isEmpty()) {
            System.out.println("\n\n=== CONTAS CADASTRADAS ===");
            this.contas.forEach(c -> {
                System.out.printf("\nCliente: %s %s", c.getCliente().getNome(), c.getCliente().getSobrenome());
                System.out.printf("\nCPF: %s", c.getCliente().getCpf());
                System.out.printf("\nNúmero: %d\n======", c.getNumero());
            });
        } else {
            System.out.println("Não existe nenhuma conta cadastrada!");
        }
    }

    public void listarClientes() {
        if(!this.contas.isEmpty()) {
            List<Cliente> clientes = new ArrayList<>();

            this.contas.forEach(c -> {
                clientes.add(c.getCliente());
            });

            System.out.println("\n\n=== CLIENTES CADASTRADOS ===");
            clientes.stream().distinct().forEach(c -> {
                System.out.printf("\nCliente: %s %s", c.getNome(), c.getSobrenome());
                System.out.printf("\nCPF: %s\n======", c.getCpf());
            });
        } else {
            System.out.println("Não existe nenhum cliente cadastrado!");
        }
    }

    public static int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }
}
