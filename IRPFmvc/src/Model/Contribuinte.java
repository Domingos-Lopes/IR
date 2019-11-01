package Model;

public class Contribuinte {
    private String nome;
    private String cpf;
    private int idade;
    private double totalRendimentos;
    private double contribuicaoPrevidenciaria;
    private int numeroDependentes;

    public Contribuinte(){

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(int numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }
}

