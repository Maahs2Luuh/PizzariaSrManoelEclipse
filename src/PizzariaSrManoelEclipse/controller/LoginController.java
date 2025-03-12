package PizzariaSrManoelEclipse.controller;

import PizzariaSrManoelEclipse.model.ConexaoBanco;
import PizzariaSrManoelEclipse.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger; // Importe o Logger
import org.mindrot.jbcrypt.BCrypt;

public class LoginController {

    // Criando uma instância do Logger
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    public Usuario buscarUsuario(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        try (Connection conn = ConexaoBanco.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("senha");
                // Verifica se a senha fornecida corresponde à senha armazenada
                if (BCrypt.checkpw(password, hashedPassword)) {
                    // Retorna o usuário se a senha estiver correta
                    return new Usuario(
                            rs.getInt("id"),
                            rs.getString("username"),
                            hashedPassword,
                            rs.getString("email"),
                            rs.getTimestamp("data_criacao").toLocalDateTime()
                    );
                }
            }
        } catch (Exception e) {
            // Logando o erro
            LOGGER.severe("Erro ao buscar usuário: " + e.getMessage());
        }
        return null; // Retorna null se o usuário não for encontrado ou a senha não corresponder
    }
}
