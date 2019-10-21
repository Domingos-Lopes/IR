package Controller;

import Model.Entities.ContribuinteCompleto;
import Model.Interfaces.DeclaracaoCompleta;

public class ServiceCompleto implements DeclaracaoCompleta{
    private double imposto;
    private double desconto;
    private double base;
    private double baseCalculo;
    private ContribuinteCompleto cc;

    public ServiceCompleto(ContribuinteCompleto cc) {
        this.cc = cc;
    }

    @Override
    public void desconto() {
        baseCalculo = cc.getTotalRendimentos() - cc.getContribuicaoPrevidenciaria();
        if(cc.getIdade() < 65){
            if(cc.getNumeroDependentes() <= 2){
                desconto = baseCalculo * 0.02;
            }else if(cc.getNumeroDependentes() >= 3 && cc.getNumeroDependentes() <= 5 ){
                desconto = baseCalculo* 0.035;
            }else if(cc.getNumeroDependentes() > 5){
                desconto = baseCalculo * 0.05;
            }
        }else {
            if(cc.getNumeroDependentes() <= 2){
                desconto = baseCalculo * 0.03;
            }else if(cc.getNumeroDependentes() >= 3 && cc.getNumeroDependentes() <= 5 ){
                desconto = baseCalculo * 0.045;
            }else if(cc.getNumeroDependentes() > 5){
                desconto = baseCalculo * 0.06;
            }
        }
    }

    @Override
    public void imposto() {
        baseCalculo = cc.getTotalRendimentos() - cc.getContribuicaoPrevidenciaria();
        base = baseCalculo - desconto;
        if(base <= 12000){
            imposto = 0;
        }else if(base >= 12000 && base <= 24000){
            imposto = (base - 12000) * 0.15;
        }else if(base >= 24000){
            imposto = (base - 24000) * 0.275 + 12000 * 0.15 ;
        }
    }

    public double getImposto() {
        return imposto;
    }
    
    public double getDesconto() {
    	return desconto;
    }

    @Override
    public String toString() {
        return "Nome: " + cc.getNome()+"\n" +
                "CPF: " + cc.getCpf() + "\n" +
                "Idade: " + cc.getIdade() +"\n" +
                "Total de Rendimentos: R$ " + cc.getTotalRendimentos() + "\n" +
                "Contribuição Previdênciaria: R$ " + cc.getContribuicaoPrevidenciaria() + "\n" +
                "Desconto: R$ " + desconto +"\n" +
                "Imposto à Pagar: R$ " + imposto +"\n";
    }
}
