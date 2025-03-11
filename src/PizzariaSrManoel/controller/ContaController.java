package PizzariaSrManoel.controller;

import PizzariaSrManoel.model.ConexaoBanco;
import PizzariaSrManoel.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger; // Importe o Logger
import org.mindrot.jbcrypt.BCrypt;

public class ContaController {

    // Criando uma instância do Logger
    private static final Logger LOGGER = Logger.getLogger(ContaController.class.getName());

    public boolean criarConta(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, senha, email, data_criacao) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Criptografa a senha antes de armazenar no banco
            String hashedPassword = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, hashedPassword);
            stmt.setString(3, usuario.getEmail());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(usuario.getDataCriacao()));

            // Executa a inserção no banco de dados
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            // Logando o erro
            LOGGER.severe("Erro ao criar conta: " + e.getMessage());
            return false;
        }
    }
}
