package PizzariaSrManoelEclipse.view;

import javax.swing.*;

public class TestePizzaria {
    public static void main(String[] args) {
        try {
            // Garante que a UI siga o estilo do sistema operacional
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Exibe a TelaCadastro
            TelaCadastro telaCadastro = new TelaCadastro();
            telaCadastro.setVisible(true);

            // Exibe a TelaControleCaixa
            TelaControleCaixa telaControleCaixa = new TelaControleCaixa();
            telaControleCaixa.setVisible(true);

            // Exibe a TelaRecuperacaoSenha
            TelaRecuperacaoSenha telaRecuperacaoSenha = new TelaRecuperacaoSenha();
            telaRecuperacaoSenha.setVisible(true);

            System.out.println("✅ Todas as telas foram abertas corretamente.");

        } catch (Exception e) {
            System.err.println("❌ Erro ao abrir as telas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
