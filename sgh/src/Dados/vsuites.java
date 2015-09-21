
package Dados;


public class vsuites {
    private int idsuites;
    private String tipoSuites;
    private String numero;
    private String piso;
    private String descricao;
    private Double precoDiario;
    private String status;

    public vsuites(int idsuites, String tipoSuites, String numero, String piso, String descricao, Double precoDiario, String status) {
        this.idsuites = idsuites;
        this.tipoSuites = tipoSuites;
        this.numero = numero;
        this.piso = piso;
        this.descricao = descricao;
        this.precoDiario = precoDiario;
        this.status = status;
    }

    public vsuites() {
    }

    public int getIdsuites() {
        return idsuites;
    }

    public void setIdsuites(int idsuites) {
        this.idsuites = idsuites;
    }

    public String getTipoSuites() {
        return tipoSuites;
    }

    public void setTipoSuites(String tipoSuites) {
        this.tipoSuites = tipoSuites;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoDiario() {
        return precoDiario;
    }

    public void setPrecoDiario(Double precoDiario) {
        this.precoDiario = precoDiario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
