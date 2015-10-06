/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "suite", catalog = "sishotel", schema = "")
@NamedQueries({
    @NamedQuery(name = "Suite.findAll", query = "SELECT s FROM Suite s"),
    @NamedQuery(name = "Suite.findByIdsuites", query = "SELECT s FROM Suite s WHERE s.idsuites = :idsuites"),
    @NamedQuery(name = "Suite.findByTipoSuites", query = "SELECT s FROM Suite s WHERE s.tipoSuites = :tipoSuites"),
    @NamedQuery(name = "Suite.findByNumero", query = "SELECT s FROM Suite s WHERE s.numero = :numero"),
    @NamedQuery(name = "Suite.findByPiso", query = "SELECT s FROM Suite s WHERE s.piso = :piso"),
    @NamedQuery(name = "Suite.findByDescricao", query = "SELECT s FROM Suite s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Suite.findByPrecoDiario", query = "SELECT s FROM Suite s WHERE s.precoDiario = :precoDiario"),
    @NamedQuery(name = "Suite.findByStatus", query = "SELECT s FROM Suite s WHERE s.status = :status")})
public class Suite implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsuites")
    private Integer idsuites;
    @Basic(optional = false)
    @Column(name = "tipoSuites")
    private String tipoSuites;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Column(name = "piso")
    private String piso;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precoDiario")
    private BigDecimal precoDiario;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public Suite() {
    }

    public Suite(Integer idsuites) {
        this.idsuites = idsuites;
    }

    public Suite(Integer idsuites, String tipoSuites, String numero, BigDecimal precoDiario, String status) {
        this.idsuites = idsuites;
        this.tipoSuites = tipoSuites;
        this.numero = numero;
        this.precoDiario = precoDiario;
        this.status = status;
    }

    public Integer getIdsuites() {
        return idsuites;
    }

    public void setIdsuites(Integer idsuites) {
        Integer oldIdsuites = this.idsuites;
        this.idsuites = idsuites;
        changeSupport.firePropertyChange("idsuites", oldIdsuites, idsuites);
    }

    public String getTipoSuites() {
        return tipoSuites;
    }

    public void setTipoSuites(String tipoSuites) {
        String oldTipoSuites = this.tipoSuites;
        this.tipoSuites = tipoSuites;
        changeSupport.firePropertyChange("tipoSuites", oldTipoSuites, tipoSuites);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        String oldNumero = this.numero;
        this.numero = numero;
        changeSupport.firePropertyChange("numero", oldNumero, numero);
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        String oldPiso = this.piso;
        this.piso = piso;
        changeSupport.firePropertyChange("piso", oldPiso, piso);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public BigDecimal getPrecoDiario() {
        return precoDiario;
    }

    public void setPrecoDiario(BigDecimal precoDiario) {
        BigDecimal oldPrecoDiario = this.precoDiario;
        this.precoDiario = precoDiario;
        changeSupport.firePropertyChange("precoDiario", oldPrecoDiario, precoDiario);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsuites != null ? idsuites.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suite)) {
            return false;
        }
        Suite other = (Suite) object;
        if ((this.idsuites == null && other.idsuites != null) || (this.idsuites != null && !this.idsuites.equals(other.idsuites))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Visao.Suite[ idsuites=" + idsuites + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
