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
 * @author matc_
 */
@Entity
@Table(name = "T_Empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEmpresas.findAll", query = "SELECT t FROM TEmpresas t")
    , @NamedQuery(name = "TEmpresas.findByIdEmpresa", query = "SELECT t FROM TEmpresas t WHERE t.idEmpresa = :idEmpresa")
    , @NamedQuery(name = "TEmpresas.findByEmpresa", query = "SELECT t FROM TEmpresas t WHERE t.empresa = :empresa")})
public class TEmpresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEmpresa")
    private Long idEmpresa;
    @Size(max = 100)
    @Column(name = "Empresa")
    private String empresa;
    @OneToMany(mappedBy = "idEmpresa")
    private List<TUsuarios> tUsuariosList;

    public TEmpresas() {
    }

    public TEmpresas(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @XmlTransient
    public List<TUsuarios> getTUsuariosList() {
        return tUsuariosList;
    }

    public void setTUsuariosList(List<TUsuarios> tUsuariosList) {
        this.tUsuariosList = tUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEmpresas)) {
            return false;
        }
        TEmpresas other = (TEmpresas) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TEmpresas[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
