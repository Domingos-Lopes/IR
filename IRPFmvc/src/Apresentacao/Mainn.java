package Apresentacao;

import Persistencia.CadastroDAOJavaDB;

public class Mainn {
    public static void main(String [] args) {
        Janelas.iniciarView();

        CadastroDAOJavaDB cDAO = Janelas.getcDAO();
        cDAO.createDB();


        //List<Contribuinte> lista = new ArrayList<Contribuinte>();
     // cDAO.getTodos();
     //   System.out.println(cDAO.getResultado().toString());
    }
}

