package planekeys.com.dreamhouse.entidade;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private boolean autenticado;

    public Usuario(String nome, String email, String senha, Boolean autenticado) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.autenticado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String capturaSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}
