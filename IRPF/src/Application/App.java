package Application;

import Entities.ContribuinteCompleto;
import Entities.Pessoa;
import Utilidades.Constantes;
import Utilidades.ServiceCompleto;
import Utilidades.ServiceSimplificado;

import javax.swing.*;

public class App {
    public static void main (String[] args){

        Object[] categoria= {Constantes.CONTRIBUINTE_SIMPLIFICADO, Constantes.CONTRIBUINTE_COMPLETO};
        String selecionado = (String) JOptionPane.showInputDialog( null , null, Constantes.CATEGORIA,
        JOptionPane.QUESTION_MESSAGE , null , categoria, Constantes.CONTRIBUINTE_SIMPLIFICADO );

        switch (selecionado){
            case Constantes.CONTRIBUINTE_SIMPLIFICADO:{
                formularioSimplificado();
                break;
            }
            case Constantes.CONTRIBUINTE_COMPLETO:{
                formularioCompleto();
            }
        }

    }

    public static void formularioCompleto(){
        ContribuinteCompleto cc = new ContribuinteCompleto();

        String nome = JOptionPane.showInputDialog(Constantes.MESSAGE_NOME);
        int idade = Integer.parseInt(JOptionPane.showInputDialog(Constantes.MESSAGE_IDADE));
        String cpf = JOptionPane.showInputDialog(Constantes.MESSAGE_CPF);
        int nroDependentes = Integer.parseInt(JOptionPane.showInputDialog(Constantes.MESSAGE_NRO_DEPENDENTES));
        double totalRendimentos = Double.parseDouble(JOptionPane.showInputDialog(Constantes.MESSAGE_TOTAL_RENDIMENTOS));
        double contribuicaoPrevidenciaria = Double.parseDouble(JOptionPane.showInputDialog(Constantes.MESSAGE_CONTRIBUICAO_PREVIDENCIARIA));

        cc.setNome(nome.toUpperCase());
        cc.setIdade(idade);
        cc.setCpf(cpf);
        cc.setNumeroDependentes(nroDependentes);
        cc.setTotalRendimentos(totalRendimentos);
        cc.setContribuicaoPrevidenciaria(contribuicaoPrevidenciaria);

        ServiceCompleto sc = new ServiceCompleto(cc);
        sc.desconto();
        sc.imposto();

        String resultado = cc.toString() + sc.toString();

        JOptionPane.showMessageDialog( null , resultado , Constantes.TITLE_INFO_CONTRIBUINTE, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void formularioSimplificado(){
        Pessoa p = new Pessoa();

        String nome = JOptionPane.showInputDialog(Constantes.MESSAGE_NOME);
        String cpf = JOptionPane.showInputDialog(Constantes.MESSAGE_CPF);
        double totalRendimentos = Double.parseDouble(JOptionPane.showInputDialog(Constantes.MESSAGE_TOTAL_RENDIMENTOS));
        double contribuicaoPrevidenciaria = Double.parseDouble(JOptionPane.showInputDialog(Constantes.MESSAGE_CONTRIBUICAO_PREVIDENCIARIA));

        p.setNome(nome.toUpperCase());
        p.setCpf(cpf);
        p.setTotalRendimentos(totalRendimentos);
        p.setContribuicaoPrevidenciaria(contribuicaoPrevidenciaria);

        ServiceSimplificado ss = new ServiceSimplificado(p);
        ss.imposto();

        String resultado = p.toString() + ss.toString();

        JOptionPane.showMessageDialog( null , resultado , Constantes.TITLE_INFO_CONTRIBUINTE, JOptionPane.INFORMATION_MESSAGE);
    }
}









     /*
        //TEST Contribuinte Simplificado base inferior a 12000
        Pessoa p1 = new Pessoa("Carlos Ruan", "000001", 10000, 74);
        ServiceSimplificado sc1 = new ServiceSimplificado(p1);
        sc1.imposto();
        System.out.println(sc1.getImposto());

        //TEST Contribuinte Simplificado base entre 12000 e 24000
        Pessoa p2 = new Pessoa("Michelly", "000004", 15000, 99);
        ServiceSimplificado sc2 = new ServiceSimplificado(p2);
        sc2.imposto();
        System.out.println(sc2.getImposto());

        //TEST Contribuinte Simplificado base superior a 24000
        Pessoa p3 = new Pessoa("Julia", "000003", 32000, 128);
        ServiceSimplificado sc3 = new ServiceSimplificado(p3);
        sc3.imposto();
        System.out.println(sc3.getImposto());


        //TEST Contribuinte Completo base inferior a 12000
        ContribuinteCompleto cp1 = new ContribuinteCompleto("Thaina", "000011", 20, 13000, 52, 5);
        ServiceCompleto sc_cp1 = new ServiceCompleto(cp1);
        sc_cp1.desconto();
        sc_cp1.imposto();
        System.out.println(sc_cp1.getImposto());

        //TEST Contribuinte Completo entre 12000 e 24000
        ContribuinteCompleto cp2 = new ContribuinteCompleto("Marlon", "000012", 22, 13500, 102, 2);
        ServiceCompleto sc_cp2 = new ServiceCompleto(cp2);
        sc_cp2.desconto();
        sc_cp2.imposto();
        System.out.println(sc_cp2.getImposto());

        //TEST Contribuinte Completo base superior a 24000
        ContribuinteCompleto cp3 = new ContribuinteCompleto("Domingos", "000013", 22, 40000, 48, 4);
        ServiceCompleto sc_cp3 = new ServiceCompleto(cp3);
        sc_cp3.desconto();
        sc_cp3.imposto();]
        System.out.println(sc_cp3.getImposto());
*/
