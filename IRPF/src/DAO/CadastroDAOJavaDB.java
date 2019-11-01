package DAO;

import Model.Entities.ContribuinteCompleto;
import Model.Entities.Pessoa;
import Model.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastroDAOJavaDB implements CadastroDAO{

    private Connection connection;
    String sql = "";

    public void createDB() {
        try {
            connection = DBConnection.getConnection();
            Statement sta = connection.createStatement();
            String sql = "CREATE TABLE PESSOAS ("
                    + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "NOME VARCHAR(100) NOT NULL,"
                    + "CPF VARCHAR(50) NOT NULL,"
                    + "IDADE NUMBER(50) NOT NULL,"
                    + "TOTAL_RENDIMENOS NUMBER(50) NOT NULL,"
                    + "CONTRIBUICAO_PREVIDENCIARIA NUMBER(50),"
                    + "NUMERO_DEPENDENTES NUMBER(50)"
                    + ")";
            sta.executeUpdate(sql);
            sta.close();
            connection.close();
        } catch (Exception ex) {
            System.out.println("Falhou" + ex.getMessage());

        }
    }
    @Override
    public void addPessoa(Object pessoa) {
        try {
            connection = DBConnection.getConnection();
            if(pessoa instanceof Pessoa){
                sql = "INSERT INTO PESSOAS (NOME, CPF, TOTAL_RENDIMENTOS, CONTRIBUICAO_PREVIDENCIARIA) VALUES (?,?,?,?)";
                Pessoa cs = (Pessoa) pessoa;
                PreparedStatement insert = connection.prepareStatement(sql);
                insert.setString(1, cs.getNome());
                insert.setString(2, cs.getCpf());
                insert.setDouble(3, cs.getTotalRendimentos());
                insert.setDouble(4, cs.getContribuicaoPrevidenciaria());
                insert.execute();

            } else if(pessoa instanceof ContribuinteCompleto) {
                sql = "INSERT INTO PESSOAS (NOME, CPF, IDADE, TOTAL_RENDIMENTOS, CONTRIBUICAO_PREVIDENCIARIA, NUMERO_DEPENDENTES) VALUES (?,?,?,?,?,?)";
                ContribuinteCompleto cc = (ContribuinteCompleto) pessoa;
                PreparedStatement insert = connection.prepareStatement(sql);
                insert.setString(1, cc.getNome());
                insert.setString(2, cc.getCpf());
                insert.setInt(3, cc.getIdade());
                insert.setDouble(4, cc.getTotalRendimentos());
                insert.setDouble(5, cc.getContribuicaoPrevidenciaria());
                insert.setInt(6, cc.getNumeroDependentes());
                insert.execute();

            }

            connection.commit();


        } catch (Exception e){
            System.out.println("Falha ao adicionar o contato! insere pessoa");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
