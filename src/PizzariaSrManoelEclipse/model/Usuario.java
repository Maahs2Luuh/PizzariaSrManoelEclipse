package PizzariaSrManoelEclipse.model;

import java.time.LocalDateTime;

public class Usuario {

    private int id;
    private String username;
    private String senha;
    private String email;
    private LocalDateTime dataCriacao;

    // Construtores
    public Usuario() {
    }

    public Usuario(int id, String username, String senha, String email, LocalDateTime dataCriacao) {
        this.id = id;
        this.username = username;
        this.senha = senha;
        this.email = email;
        this.dataCriacao = dataCriacao;
    }

    public Usuario(String username, String senha, String email) {
        this.username = username;
        this.senha = senha;
        this.email = email;
        this.dataCriacao = LocalDateTime.now(); // Define a data de criação como o momento atual
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    // Método para representação como String
    @Override
    public String toString() {
        return "Usuario{"
                + "id=" + id
                + ", username='" + username + '\''
                + ", email='" + email + '\''
                + ", dataCriacao=" + dataCriacao
                + '}';
    }
}
