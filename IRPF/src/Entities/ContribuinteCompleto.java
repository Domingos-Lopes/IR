package Entities;

public class ContribuinteCompleto extends Pessoa {
    private int numeroDependentes;
    private int totalDeRendimentos;

    public ContribuinteCompleto (String nome, String cpf, String idade, int numeroDependentes) {
        super(nome, cpf, idade);
        this.numeroDependentes = numeroDependentes;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(int numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }
}
