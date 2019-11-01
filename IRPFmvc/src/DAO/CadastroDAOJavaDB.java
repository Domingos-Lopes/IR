package DAO;

import Controller.ConnectionDB;
import Controller.DeclaracaoCompleta;
import Controller.DeclaracaoSimplificada;
import Model.Contribuinte;
import View.Apresentacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroDAOJavaDB implements CadastroDAO {
    private ResultSet resultado;
    private Connection connection;
    String sql = "";

    public void createDB() {
        try {
            connection = ConnectionDB.getConnection();
            Statement sta = connection.createStatement();
            String sql = "CREATE TABLE CONTRIBUINTES ("
                    + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "NOME VARCHAR(100) NOT NULL,"
                    + "CPF VARCHAR(50) NOT NULL,"
                    + "IDADE NUMBER(50) NOT NULL,"
                    + "TOTAL_RENDIMENTOS NUMBER(50) NOT NULL,"
                    + "CONTRIBUICAO_PREVIDENCIARIA NUMBER(50) NOT NULL,"
                    + "NUMERO_DEPENDENTES NUMBER(50) NOT NULL,"
                    + "IMPOSTO NUMBER(50) NOT NULL,"
                    + "DESCONTO NUMBER(50) NOT NULL"
                    + ")";



            sta.executeUpdate(sql);
            sta.close();
            connection.close();
        } catch (Exception ex) {
            System.out.println("FalhouUU" + ex.getMessage());
        }
    }

    @Override
    public void salvarContribuinte(Contribuinte c, double desconto, double imposto) {
        try {
            connection = ConnectionDB.getConnection();

                sql = "INSERT INTO CONTRIBUINTES (NOME, CPF, IDADE, TOTAL_RENDIMENTOS, CONTRIBUICAO_PREVIDENCIARIA, NUMERO_DEPENDENTES, IMPOSTO, DESCONTO) VALUES (?,?,?,?,?,?,?,?)";

                PreparedStatement insert = connection.prepareStatement(sql);
                insert.setString(1, c.getNome());
                insert.setString(2, c.getCpf());
                insert.setInt(3, c.getIdade());
                insert.setDouble(4, c.getTotalRendimentos());
                insert.setDouble(5, c.getContribuicaoPrevidenciaria());
                insert.setInt(6, c.getNumeroDependentes());
                insert.setDouble(7, desconto);
                insert.setDouble(8, imposto);

                insert.execute();


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

                System.out.println(resultado.toString());

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
