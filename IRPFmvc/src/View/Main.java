package View;

import DAO.CadastroDAOJavaDB;
import Model.Contribuinte;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        Apresentacao.iniciarView();

        CadastroDAOJavaDB cDAO = Apresentacao.getcDAO();
        cDAO.createDB();
        List<Contribuinte> lista = new ArrayList<Contribuinte>();
      cDAO.getTodos();
        System.out.println(cDAO.getResultado().toString());
    }
}

