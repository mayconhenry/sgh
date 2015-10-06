/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author MayconHenry
 */
@Entity
@Table(name = "login", catalog = "sgh", schema = "")
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByIdUsuario", query = "SELECT l FROM Login l WHERE l.idUsuario = :idUsuario"),
    @NamedQuery(name = "Login.findByUsuario", query = "SELECT l FROM Login l WHERE l.usuario = :usuario"),
    @NamedQuery(name = "Login.findBySenha", query = "SELECT l FROM Login l WHERE l.senha = :senha"),
    @NamedQuery(name = "Login.findByMatricula", query = "SELECT l FROM Login l WHERE l.matricula = :matricula"),
    @NamedQuery(name = "Login.findByCpf", query = "SELECT l FROM Login l WHERE l.cpf = :cpf"),
    @NamedQuery(name = "Login.findByNome", query = "SELECT l FROM Login l WHERE l.nome = :nome"),
    @NamedQuery(name = "Login.findByTelefone", query = "SELECT l FROM Login l WHERE l.telefone = :telefone"),
    @NamedQuery(name = "Login.findByEndereco", query = "SELECT l FROM Login l WHERE l.endereco = :endereco"),
    @NamedQuery(name = "Login.findByCidade", query = "SELECT l FROM Login l WHERE l.cidade = :cidade"),
    @NamedQuery(name = "Login.findByEstado", query = "SELECT l FROM Login l WHERE l.estado = :estado"),
    @NamedQuery(name = "Login.findByDepartamento", query = "SELECT l FROM Login l WHERE l.departamento = :departamento"),
    @NamedQuery(name = "Login.findByCargo", query = "SELECT l FROM Login l WHERE l.cargo = :cargo"),
    @NamedQuery(name = "Login.findByHorarioDeEntrada", query = "SELECT l FROM Login l WHERE l.horarioDeEntrada = :horarioDeEntrada"),
    @NamedQuery(name = "Login.findByHorarioDeSaida", query = "SELECT l FROM Login l WHERE l.horarioDeSaida = :horarioDeSaida"),
    @NamedQuery(name = "Login.findBySalario", query = "SELECT l FROM Login l WHERE l.salario = :salario")})
public class Login implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "matricula")
    private int matricula;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "departamento")
    private String departamento;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "horarioDeEntrada")
    private String horarioDeEntrada;
    @Basic(optional = false)
    @Column(name = "horarioDeSaida")
    private String horarioDeSaida;
    @Basic(optional = false)
    @Column(name = "salario")
    private double salario;

    public Login() {
    }

    public Login(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Login(Integer idUsuario, String usuario, String senha, int matricula, String cpf, String nome, String endereco, String cidade, String estado, String departamento, String cargo, String horarioDeEntrada, String horarioDeSaida, double salario) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.senha = senha;
        this.matricula = matricula;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.departamento = departamento;
        this.cargo = cargo;
        this.horarioDeEntrada = horarioDeEntrada;
        this.horarioDeSaida = horarioDeSaida;
        this.salario = salario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        Integer oldIdUsuario = this.idUsuario;
        this.idUsuario = idUsuario;
        changeSupport.firePropertyChange("idUsuario", oldIdUsuario, idUsuario);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        String oldUsuario = this.usuario;
        this.usuario = usuario;
        changeSupport.firePropertyChange("usuario", oldUsuario, usuario);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String oldSenha = this.senha;
        this.senha = senha;
        changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        int oldMatricula = this.matricula;
        this.matricula = matricula;
        changeSupport.firePropertyChange("matricula", oldMatricula, matricula);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        String oldDepartamento = this.departamento;
        this.departamento = departamento;
        changeSupport.firePropertyChange("departamento", oldDepartamento, departamento);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        String oldCargo = this.cargo;
        this.cargo = cargo;
        changeSupport.firePropertyChange("cargo", oldCargo, cargo);
    }

    public String getHorarioDeEntrada() {
        return horarioDeEntrada;
    }

    public void setHorarioDeEntrada(String horarioDeEntrada) {
        String oldHorarioDeEntrada = this.horarioDeEntrada;
        this.horarioDeEntrada = horarioDeEntrada;
        changeSupport.firePropertyChange("horarioDeEntrada", oldHorarioDeEntrada, horarioDeEntrada);
    }

    public String getHorarioDeSaida() {
        return horarioDeSaida;
    }

    public void setHorarioDeSaida(String horarioDeSaida) {
        String oldHorarioDeSaida = this.horarioDeSaida;
        this.horarioDeSaida = horarioDeSaida;
        changeSupport.firePropertyChange("horarioDeSaida", oldHorarioDeSaida, horarioDeSaida);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        double oldSalario = this.salario;
        this.salario = salario;
        changeSupport.firePropertyChange("salario", oldSalario, salario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Visao.Login[ idUsuario=" + idUsuario + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
