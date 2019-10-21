package Utilidades;

import Entities.Pessoa;
import Interfaces.DeclaracaoSimplificada;

public class ServiceSimplificado implements DeclaracaoSimplificada {
    private Pessoa pessoa;
    private double imposto;
    private double baseCalculo;
    private double base;

    public ServiceSimplificado(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public void imposto() {
        baseCalculo = pessoa.getTotalRendimentos() - pessoa.getContribuicaoPrevidenciaria();
        base = baseCalculo - (baseCalculo * 0.05);
        if(base <= 12000){
            imposto = 0;
        }else if(base >= 12000 && base <= 24000){
            imposto = (base - 12000) * 0.15;
        }else if(base >= 24000){
            imposto = (base - 24000) * 0.275 ;
        }
    }

    public double getImposto() {
        return imposto;
    }

    @Override
    public String toString() {
        return "Imposto à pagar: R$ " + imposto + "\n";
    }
}
