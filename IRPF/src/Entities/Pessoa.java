package Entities;

public class Pessoa {
    private String nome;
    private String cpf;
    private double totalRendimentos;
    private double contribuicaoPrevidenciaria;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, double totalRendimentos, double contribuicaoPrevidenciaria) {
        this.nome = nome;
        this.cpf = cpf;
        this.totalRendimentos = totalRendimentos;
        this.contribuicaoPrevidenciaria = contribuicaoPrevidenciaria;
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

    public void setContribuicaoPrevidenciaria(double contribuicaoPrevidenciaria) {
        this.contribuicaoPrevidenciaria = contribuicaoPrevidenciaria;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Total de Rendimentos: R$ " + totalRendimentos + "\n" +
                "Contribuição Previdênciaria: R$ " + contribuicaoPrevidenciaria + "\n";
    }
}
