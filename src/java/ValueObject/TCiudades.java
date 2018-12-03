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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author matc_
 */
@Entity
@Table(name = "T_Ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCiudades.findAll", query = "SELECT t FROM TCiudades t")
    , @NamedQuery(name = "TCiudades.findByIdciudad", query = "SELECT t FROM TCiudades t WHERE t.idciudad = :idciudad")
    , @NamedQuery(name = "TCiudades.findByCiudad", query = "SELECT t FROM TCiudades t WHERE t.ciudad = :ciudad")})
public class TCiudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCIUDAD")
    private Long idciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CIUDAD")
    private String ciudad;
    @JoinColumn(name = "IDPAIS", referencedColumnName = "IDPAIS")
    @ManyToOne(optional = false)
    private TPaises idpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private List<TSedes> tSedesList;

    public TCiudades() {
    }

    public TCiudades(Long idciudad) {
        this.idciudad = idciudad;
    }

    public TCiudades(Long idciudad, String ciudad) {
        this.idciudad = idciudad;
        this.ciudad = ciudad;
    }

    public Long getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Long idciudad) {
        this.idciudad = idciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public TPaises getIdpais() {
        return idpais;
    }

    public void setIdpais(TPaises idpais) {
        this.idpais = idpais;
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
        hash += (idciudad != null ? idciudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCiudades)) {
            return false;
        }
        TCiudades other = (TCiudades) object;
        if ((this.idciudad == null && other.idciudad != null) || (this.idciudad != null && !this.idciudad.equals(other.idciudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TCiudades[ idciudad=" + idciudad + " ]";
    }
    
}
