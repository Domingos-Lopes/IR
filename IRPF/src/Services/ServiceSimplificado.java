package Services;

import Entities.Pessoa;
import Interfaces.DeclaracaoSimplificada;

public class ServiceSimplificado implements DeclaracaoSimplificada {
    private Pessoa pessoa;
    private double imposto;

    public ServiceSimplificado(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public void imposto() {
        double base = pessoa.getTotalRendimentos() * 0.95;
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
