
package Dados;

/**
 *
 * @author Mac
 */
public class Vfuncionario extends vPessoa{
     Double salario;
     String acesso;
     String login;
     String password;
     String status;

    public Vfuncionario() {
    }

    public Vfuncionario(Double salario, String acesso, String login, String password, String status) {
        this.salario = salario;
        this.acesso = acesso;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
