/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "T_Paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPaises.findAll", query = "SELECT t FROM TPaises t")
    , @NamedQuery(name = "TPaises.findByIdpais", query = "SELECT t FROM TPaises t WHERE t.idpais = :idpais")
    , @NamedQuery(name = "TPaises.findByAbreviatura", query = "SELECT t FROM TPaises t WHERE t.abreviatura = :abreviatura")
    , @NamedQuery(name = "TPaises.findByPais", query = "SELECT t FROM TPaises t WHERE t.pais = :pais")})
public class TPaises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPAIS")
    private Long idpais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ABREVIATURA")
    private String abreviatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PAIS")
    private String pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpais")
    private List<TCiudades> tCiudadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPais")
    private List<TSedes> tSedesList;

    public TPaises() {
    }

    public TPaises(Long idpais) {
        this.idpais = idpais;
    }

    public TPaises(Long idpais, String abreviatura, String pais) {
        this.idpais = idpais;
        this.abreviatura = abreviatura;
        this.pais = pais;
    }

    public Long getIdpais() {
        return idpais;
    }

    public void setIdpais(Long idpais) {
        this.idpais = idpais;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @XmlTransient
    public List<TCiudades> getTCiudadesList() {
        return tCiudadesList;
    }

    public void setTCiudadesList(List<TCiudades> tCiudadesList) {
        this.tCiudadesList = tCiudadesList;
    }

    @XmlTransient
    public List<TSedes> getTSedesList() {
        return tSedesList;
    }

    public void setTSedesList(List<TSedes> tSedesList) {
        this.tSedesList = tSedesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpais != null ? idpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPaises)) {
            return false;
        }
        TPaises other = (TPaises) object;
        if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TPaises[ idpais=" + idpais + " ]";
    }
    
}
