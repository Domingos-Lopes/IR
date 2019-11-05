package Negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

        private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        private static final String JDBC_URL = "jdbc:derby:derbyDB;create=true";

        private static Connection connection = null;

        static {
            conectar();
        }

        private static void conectar(){
            try {
                if (connection == null) {
                    Class.forName(DRIVER);
                    connection = DriverManager.getConnection(JDBC_URL);
                    System.out.println("Conexão efetuada com sucesso!");
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Falha na conexão!" + e.getMessage());
            }
        }

        public static Connection getConnection(){
            return connection;
        }
}
