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
@Table(name = "T_TipoTransaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTipoTransaccion.findAll", query = "SELECT t FROM TTipoTransaccion t")
    , @NamedQuery(name = "TTipoTransaccion.findByIdTipoTransaccion", query = "SELECT t FROM TTipoTransaccion t WHERE t.idTipoTransaccion = :idTipoTransaccion")
    , @NamedQuery(name = "TTipoTransaccion.findByTipoTransaccion", query = "SELECT t FROM TTipoTransaccion t WHERE t.tipoTransaccion = :tipoTransaccion")})
public class TTipoTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTipoTransaccion")
    private Long idTipoTransaccion;
    @Size(max = 50)
    @Column(name = "TipoTransaccion")
    private String tipoTransaccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTransaccion")
    private List<TTransacciones> tTransaccionesList;

    public TTipoTransaccion() {
    }

    public TTipoTransaccion(Long idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public Long getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(Long idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @XmlTransient
    public List<TTransacciones> getTTransaccionesList() {
        return tTransaccionesList;
    }

    public void setTTransaccionesList(List<TTransacciones> tTransaccionesList) {
        this.tTransaccionesList = tTransaccionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTransaccion != null ? idTipoTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTipoTransaccion)) {
            return false;
        }
        TTipoTransaccion other = (TTipoTransaccion) object;
        if ((this.idTipoTransaccion == null && other.idTipoTransaccion != null) || (this.idTipoTransaccion != null && !this.idTipoTransaccion.equals(other.idTipoTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TTipoTransaccion[ idTipoTransaccion=" + idTipoTransaccion + " ]";
    }
    
}
