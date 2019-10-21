package View;

import Model.Entities.ContribuinteCompleto;
import Model.Entities.Pessoa;
import Model.Util.Constantes;
import Controller.ServiceCompleto;
import Controller.ServiceSimplificado;

import javax.swing.*;

public class App {
    public static void main (String[] args){

        iniciarView();

    }

    public static void iniciarView(){
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

        String resultado = sc.toString();

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

        String resultado = ss.toString();

        JOptionPane.showMessageDialog( null , resultado , Constantes.TITLE_INFO_CONTRIBUINTE, JOptionPane.INFORMATION_MESSAGE);
    }
}