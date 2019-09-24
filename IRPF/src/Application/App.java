package Application;

import Entities.ContribuinteCompleto;
import Entities.Pessoa;
import Services.ServiceCompleto;
import Services.ServiceSimplificado;

public class App {
    public static void main (String[] args){

        //TEST Contribuinte Simplificado base inferior a 12000
        Pessoa p1 = new Pessoa("Carlos Ruan", "000001", 10000);
        ServiceSimplificado sc1 = new ServiceSimplificado(p1);
        sc1.imposto();
        System.out.println(sc1.getImposto());

        //TEST Contribuinte Simplificado base entre 12000 e 24000
        Pessoa p2 = new Pessoa("Michelly", "000004", 15000);
        ServiceSimplificado sc2 = new ServiceSimplificado(p2);
        sc2.imposto();
        System.out.println(sc2.getImposto());

        //TEST Contribuinte Simplificado base superior a 24000
        Pessoa p3 = new Pessoa("Julia", "000003", 32000);
        ServiceSimplificado sc3 = new ServiceSimplificado(p3);
        sc3.imposto();
        System.out.println(sc3.getImposto());




        //TEST Contribuinte Completo base inferior a 12000
        ContribuinteCompleto cp1 = new ContribuinteCompleto("Thaina", "000011", 22, 7000, 4);
        ServiceCompleto sc_cp1 = new ServiceCompleto(cp1);
        sc_cp1.desconto();
        sc_cp1.imposto();
        System.out.println(sc_cp1.getImposto());

        //TEST Contribuinte Completo entre 12000 e 24000
        ContribuinteCompleto cp2 = new ContribuinteCompleto("Marlon", "000012", 22, 13500, 4);
        ServiceCompleto sc_cp2 = new ServiceCompleto(cp2);
        sc_cp2.desconto();
        sc_cp2.imposto();
        System.out.println(sc_cp2.getImposto());

        //TEST Contribuinte Completo base superior a 24000
        ContribuinteCompleto cp3 = new ContribuinteCompleto("Domingos", "000013", 22, 40000, 4);
        ServiceCompleto sc_cp3 = new ServiceCompleto(cp3);
        sc_cp3.desconto();
        sc_cp3.imposto();
        System.out.println(sc_cp3.getImposto());

    }
}
