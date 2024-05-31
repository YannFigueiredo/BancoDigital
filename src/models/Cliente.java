package models;

import models.exceptions.CpfInvalidException;

public class Cliente {
    private static int ID = 0;
    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;

    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.id = ID++;
    }

    public String formatarCpf(String cpf) {
        String cpfFormatado;

        if(cpf.length() != 11)
            throw new CpfInvalidException("CPF inválido!");

        cpfFormatado = String.format(
            "%s.%s.%s-%s",
            cpf.substring(0, 3),
            cpf.substring(3, 6),
            cpf.substring(6, 9),
            cpf.substring(9, 11)
        );

        return cpfFormatado.length() == 14 ? cpfFormatado : cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return formatarCpf(cpf);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }
}
