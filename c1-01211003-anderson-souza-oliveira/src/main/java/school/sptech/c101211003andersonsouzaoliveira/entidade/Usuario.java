package school.sptech.c101211003andersonsouzaoliveira.entidade;

public class Usuario {

    private int idCliente;
    private String login;
    private String senha;

    public Usuario(int idCliente, String login, String senha) {
        this.idCliente = idCliente;
        this.login = login;
        this.senha = senha;
    }

    public boolean validaUsuario(String login, String senha){

        return false;
    }


    public boolean realizaLogoff(){

        return false;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
