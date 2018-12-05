/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "T_TipoModulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTipoModulo.findAll", query = "SELECT t FROM TTipoModulo t")
    , @NamedQuery(name = "TTipoModulo.findByIdTipoModulo", query = "SELECT t FROM TTipoModulo t WHERE t.idTipoModulo = :idTipoModulo")
    , @NamedQuery(name = "TTipoModulo.findByTipoModulo", query = "SELECT t FROM TTipoModulo t WHERE t.tipoModulo = :tipoModulo")
    , @NamedQuery(name = "TTipoModulo.findByEstado", query = "SELECT t FROM TTipoModulo t WHERE t.estado = :estado")})
public class TTipoModulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTipoModulo")
    private Long idTipoModulo;
    @Size(max = 50)
    @Column(name = "TipoModulo")
    private String tipoModulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @OneToMany(mappedBy = "idTipoModulo")
    private List<TConfiguracion> tConfiguracionList;

    public TTipoModulo() {
    }

    public TTipoModulo(Long idTipoModulo) {
        this.idTipoModulo = idTipoModulo;
    }

    public TTipoModulo(Long idTipoModulo, boolean estado) {
        this.idTipoModulo = idTipoModulo;
        this.estado = estado;
    }

    public Long getIdTipoModulo() {
        return idTipoModulo;
    }

    public void setIdTipoModulo(Long idTipoModulo) {
        this.idTipoModulo = idTipoModulo;
    }

    public String getTipoModulo() {
        return tipoModulo;
    }

    public void setTipoModulo(String tipoModulo) {
        this.tipoModulo = tipoModulo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<TConfiguracion> getTConfiguracionList() {
        return tConfiguracionList;
    }

    public void setTConfiguracionList(List<TConfiguracion> tConfiguracionList) {
        this.tConfiguracionList = tConfiguracionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoModulo != null ? idTipoModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTipoModulo)) {
            return false;
        }
        TTipoModulo other = (TTipoModulo) object;
        if ((this.idTipoModulo == null && other.idTipoModulo != null) || (this.idTipoModulo != null && !this.idTipoModulo.equals(other.idTipoModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TTipoModulo[ idTipoModulo=" + idTipoModulo + " ]";
    }
    
}
