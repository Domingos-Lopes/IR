package Persistencia;

import Negocio.ConnectionDB;
import Negocio.Contribuinte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroDAOJavaDB implements CadastroDAO {
    private ResultSet resultado;
    private Connection connection;
    String sql = "";
    String sql2 = "";

    public void createDB() {
        try {
            connection = ConnectionDB.getConnection();
            Statement sta = connection.createStatement();
            String sql = "CREATE TABLE CONTRIBUINTE ("
                    + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "NOME VARCHAR(100) NOT NULL,"
                    + "CPF VARCHAR(50) NOT NULL,"
                    + "IDADE INTEGER NOT NULL,"
                    + "TOTAL_RENDIMENTOS DECIMAL(10) NOT NULL,"
                    + "CONTRIBUICAO_PREVIDENCIARIA DECIMAL(5) NOT NULL,"
                    + "NUMERO_DEPENDENTES INTEGER NOT NULL"
                    + ")";

            String sql2 = "CREATE TABLE DECLARACAO_CONTRIBUINTE ("
                    + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "IMPOSTO DECIMAL(8) NOT NULL,"
                    + "DESCONTO DECIMAL(8) NOT NULL,"
                    + "FOREIGN KEY (ID) REFERENCES CONTRIBUINTE(ID)"
                    + ")";


            sta.executeUpdate(sql);
            sta.executeUpdate(sql2);
            sta.close();
            connection.close();
        } catch (Exception ex) {
            System.out.println("Falhou criacao do db" + ex.getMessage());
        }
    }

    @Override
    public void salvarContribuinte(Contribuinte c) {
        try {
            connection = ConnectionDB.getConnection();

                sql = "INSERT INTO CONTRIBUINTES (NOME, CPF, IDADE, TOTAL_RENDIMENTOS, CONTRIBUICAO_PREVIDENCIARIA, NUMERO_DEPENDENTES) VALUES (?,?,?,?,?,?)";

                PreparedStatement insert = connection.prepareStatement(sql);
                insert.setString(1, c.getNome());
                insert.setString(2, c.getCpf());
                insert.setInt(3, c.getIdade());
                insert.setDouble(4, c.getTotalRendimentos());
                insert.setDouble(5, c.getContribuicaoPrevidenciaria());
                insert.setInt(6, c.getNumeroDependentes());


                insert.execute();

            sql2 = "INSERT INTO DECLARACAO_CONTRIBUINTES (NOME, CPF, IDADE, TOTAL_RENDIMENTOS, CONTRIBUICAO_PREVIDENCIARIA, NUMERO_DEPENDENTES, IMPOSTO, DESCONTO) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement insert2 = connection.prepareStatement(sql);
            insert.setDouble(7, );
            insert.setDouble(8, );

            connection.commit();

        } catch (Exception e) {
            System.out.println("Falha ao salvar contribuinte" + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Contribuinte> getTodos() {
        List<Contribuinte> lista = new ArrayList<Contribuinte>();
        try {
            connection = ConnectionDB.getConnection();
            Statement stmt = connection.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM CONTRIBUINTES");

            while (resultado.next()) {
                String nome = resultado.getString("NOME");
                String cpf = resultado.getString("CPF");
                int idade = resultado.getInt("IDADE");
                double totalRendimentos = resultado.getDouble("TOTAL_RENDIMENTOS");
                double contribuicaoPrev = resultado.getDouble("CONTRIBUICAO_PREVIDENCIARIA");
                int nroDependentes = resultado.getInt("NUMERO_DEPENDENTES");
                double imposto = resultado.getDouble("IMPOSTO");
                double desconto = resultado.getDouble("DESCONTO");

               // System.out.println(resultado.toString());

                Contribuinte c = new Contribuinte();
                c.setNome(nome);
                c.setCpf(cpf);
                c.setIdade(idade);
                c.setTotalRendimentos(totalRendimentos);
                c.setContribuicaoPrevidenciaria(contribuicaoPrev);
                c.setNumeroDependentes(nroDependentes);
                lista.add(c);
            }

        } catch (Exception e) {
            System.out.println("Falha ao buscar todos contribuintes" + e.getMessage());
        }

        return lista;
    }

    public ResultSet getResultado() {
        return resultado;
    }
}
