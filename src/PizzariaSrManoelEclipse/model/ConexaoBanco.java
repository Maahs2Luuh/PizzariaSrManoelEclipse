package PizzariaSrManoelEclipse.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String URL = "jdbc:mysql://localhost:3306/PizzariaSrManoel";
    private static final String USER = "root"; // Altere para o seu usuário
    private static final String PASSWORD = "skyline_r34"; // Altere para sua senha

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
            throw new RuntimeException("Falha na conexão com o banco de dados", e);
        }
    }
}

