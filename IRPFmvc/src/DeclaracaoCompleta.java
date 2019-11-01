public class DeclaracaoCompleta implements  CalculoIRPF {
    private Contribuinte c;
    private double imposto;
    private double desconto;
    private double base;
    private double baseCalculo;

    public DeclaracaoCompleta(Contribuinte c) {
        this.c = c;
    }

    @Override
    public void calcularImposto() {
        baseCalculo = c.getTotalRendimentos() - c.getContribuicaoPrevidenciaria();
        base = baseCalculo - desconto;
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
        baseCalculo = c.getTotalRendimentos() - c.getContribuicaoPrevidenciaria();
        if(c.getIdade() < 65){
            if(c.getNumeroDependentes() <= 2){
                desconto = baseCalculo * 0.02;
            }else if(c.getNumeroDependentes() >= 3 && c.getNumeroDependentes() <= 5 ){
                desconto = baseCalculo* 0.035;
            }else if(c.getNumeroDependentes() > 5){
                desconto = baseCalculo * 0.05;
            }
        }else {
            if(c.getNumeroDependentes() <= 2){
                desconto = baseCalculo * 0.03;
            }else if(c.getNumeroDependentes() >= 3 && c.getNumeroDependentes() <= 5 ){
                desconto = baseCalculo * 0.045;
            }else if(c.getNumeroDependentes() > 5){
                desconto = baseCalculo * 0.06;
            }
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
        return "Nome: " + c.getNome()+"\n" +
                "CPF: " + c.getCpf() + "\n" +
                "Idade: " + c.getIdade() +"\n" +
                "Total de Rendimentos: R$ " + c.getTotalRendimentos() + "\n" +
                "Contribuição Previdênciaria: R$ " + c.getContribuicaoPrevidenciaria() + "\n" +
                "Numero de Dependentes: R$ " + c.getNumeroDependentes() + "\n" +
                "Desconto: R$ " + desconto +"\n" +
                "Imposto à Pagar: R$ " + imposto +"\n";
    }
}
