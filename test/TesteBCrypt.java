
import org.mindrot.jbcrypt.BCrypt;

public class TesteBCrypt {

    public static void main(String[] args) {
        String senha = "minhaSenha123";
        String senhaHash = BCrypt.hashpw(senha, BCrypt.gensalt());

        System.out.println("Senha original: " + senha);
        System.out.println("Senha criptografada: " + senhaHash);

        boolean valida = BCrypt.checkpw(senha, senhaHash);
        System.out.println("Senha válida? " + valida);
    }
}
