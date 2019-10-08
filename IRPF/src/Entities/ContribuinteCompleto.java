package Entities;

import Interfaces.DeclaracaoCompleta;

public class ContribuinteCompleto extends Pessoa{
    private int numeroDependentes;
    private int idade;

   public ContribuinteCompleto (String nome, String cpf, int idade, double totalRendimentos, double contribuicaoPrevidenciaria, int numeroDependentes) {
        super(nome, cpf, totalRendimentos, contribuicaoPrevidenciaria);
        this.numeroDependentes = numeroDependentes;
        this.idade = idade;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(int numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
