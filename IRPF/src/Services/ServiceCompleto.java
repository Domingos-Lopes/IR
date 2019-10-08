package Services;

import Entities.ContribuinteCompleto;
import Interfaces.DeclaracaoCompleta;

public class ServiceCompleto implements DeclaracaoCompleta{
    private double imposto;
    private double desconto;
    private double base;
    private ContribuinteCompleto cp;

    public ServiceCompleto(ContribuinteCompleto cp) {
        this.cp = cp;
    }

    @Override
    public void desconto() {
        desconto = 0;
        if(cp.getIdade() < 65){
            if(cp.getNumeroDependentes() <=2){
                desconto = base * 0.02;
            }else if(cp.getNumeroDependentes() >= 3 && cp.getNumeroDependentes() <=5 ){
                desconto = base* 0.035;
            }else if(cp.getNumeroDependentes() > 5){
                desconto = base * 0.05;
            }
        }else {
            if(cp.getNumeroDependentes() <=2){
                desconto = base * 0.03;
            }else if(cp.getNumeroDependentes() >= 3 && cp.getNumeroDependentes() <=5 ){
                desconto = base* 0.045;
            }else if(cp.getNumeroDependentes() > 5){
                desconto = base * 0.06;
            }
        }
    }

    @Override
    public void imposto() {
        base = cp.getTotalRendimentos() - cp.getContribuicaoPrevidenciaria();
        base = base - desconto;
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
}
