public class DeclaracaoSimplificada implements CalculoIRPF{

    private Contribuinte c;
    private double imposto;
    private double desconto;
    private double base;
    private double baseCalculo;

    public DeclaracaoSimplificada(Contribuinte c) {
        this.c = c;
    }

    @Override
    public void calcularImposto() {
        baseCalculo = c.getTotalRendimentos() - c.getContribuicaoPrevidenciaria();
        base = baseCalculo - (baseCalculo * 0.05);
        if(base <= 12000){
            imposto = 0;
        }else if(base >= 12000 && base <= 24000){
            imposto = (base - 12000) * 0.15;
        }else if(base >= 24000){
            imposto = (base - 24000) * 0.275 + 12000 * 0.15 ;
        }
    }

    @Override
    public void calcularDesconto() {
        desconto = 0;
    }

    public double getImposto() {
        return imposto;
    }

    public double getDesconto() {
        return desconto;
    }
}
