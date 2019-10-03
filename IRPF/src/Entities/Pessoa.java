package Entities;

public class Pessoa {
    private String nome;
    private String cpf;
    private double totalRendimentos;
    private double contribuicaoPrevidenciaria;

    public Pessoa(String nome, String cpf, double totalRendimentos) {
        this.nome = nome;
        this.cpf = cpf;
        this.totalRendimentos = totalRendimentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getTotalRendimentos() {
        return totalRendimentos;
    }

    public void setTotalRendimentos(double totalRendimentos) {
        this.totalRendimentos = totalRendimentos;
    }

    public double getContribuicaoPrevidenciaria() {
        return contribuicaoPrevidenciaria;
    }

}
