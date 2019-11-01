package View;

import Controller.DeclaracaoCompleta;
import Controller.DeclaracaoSimplificada;
import DAO.CadastroDAO;
import DAO.CadastroDAOJavaDB;
import Model.Constantes;
import Model.Contribuinte;

import javax.swing.*;

public class Apresentacao {
   static boolean flag = false;
    static CadastroDAOJavaDB cDAO = new CadastroDAOJavaDB();

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
                flag = true;
            }
        }
    }

    public static void formularioCompleto(){
        Contribuinte c = new Contribuinte();

        String nome = JOptionPane.showInputDialog(Constantes.MESSAGE_NOME);
        int idade = Integer.parseInt(JOptionPane.showInputDialog(Constantes.MESSAGE_IDADE));
        String cpf = JOptionPane.showInputDialog(Constantes.MESSAGE_CPF);
        int nroDependentes = Integer.parseInt(JOptionPane.showInputDialog(Constantes.MESSAGE_NRO_DEPENDENTES));
        double totalRendimentos = Double.parseDouble(JOptionPane.showInputDialog(Constantes.MESSAGE_TOTAL_RENDIMENTOS));
        double contribuicaoPrevidenciaria = Double.parseDouble(JOptionPane.showInputDialog(Constantes.MESSAGE_CONTRIBUICAO_PREVIDENCIARIA));

        c.setNome(nome.toUpperCase());
        c.setIdade(idade);
        c.setCpf(cpf);
        c.setNumeroDependentes(nroDependentes);
        c.setTotalRendimentos(totalRendimentos);
        c.setContribuicaoPrevidenciaria(contribuicaoPrevidenciaria);

        DeclaracaoCompleta dc  = new DeclaracaoCompleta(c);

        dc.calcularDesconto();
        dc.calcularImposto();

        cDAO.salvarContribuinte(c, dc.getDesconto(), dc.getImposto());

       // String resultado = dc.toString();

        ///JOptionPane.showMessageDialog( null , resultado , Constantes.TITLE_INFO_CONTRIBUINTE, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void formularioSimplificado(){
        Contribuinte c = new Contribuinte();

        String nome = JOptionPane.showInputDialog(Constantes.MESSAGE_NOME);
        int idade = Integer.parseInt(JOptionPane.showInputDialog(Constantes.MESSAGE_IDADE));
        String cpf = JOptionPane.showInputDialog(Constantes.MESSAGE_CPF);
        double totalRendimentos = Double.parseDouble(JOptionPane.showInputDialog(Constantes.MESSAGE_TOTAL_RENDIMENTOS));
        double contribuicaoPrevidenciaria = Double.parseDouble(JOptionPane.showInputDialog(Constantes.MESSAGE_CONTRIBUICAO_PREVIDENCIARIA));

        c.setNome(nome.toUpperCase());
        c.setIdade(idade);
        c.setCpf(cpf);
        c.setTotalRendimentos(totalRendimentos);
        c.setContribuicaoPrevidenciaria(contribuicaoPrevidenciaria);

        DeclaracaoSimplificada ds = new DeclaracaoSimplificada(c);
        ds.calcularImposto();

        String resultado = ds.toString();

        JOptionPane.showMessageDialog( null , resultado , Constantes.TITLE_INFO_CONTRIBUINTE, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean isFlag() {
        return flag;
    }

    public static CadastroDAOJavaDB getcDAO() {
        return cDAO;
    }
}
