/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matc_
 */
@Entity
@Table(name = "T_Permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPermisos.findAll", query = "SELECT t FROM TPermisos t")
    , @NamedQuery(name = "TPermisos.findByIdPermiso", query = "SELECT t FROM TPermisos t WHERE t.idPermiso = :idPermiso")
    , @NamedQuery(name = "TPermisos.findByDocumentoUsuario", query = "SELECT t FROM TPermisos t WHERE t.documentoUsuario = :documentoUsuario")
    , @NamedQuery(name = "TPermisos.findByNombreContol", query = "SELECT t FROM TPermisos t WHERE t.nombreContol = :nombreContol")
    , @NamedQuery(name = "TPermisos.findByIdModulo", query = "SELECT t FROM TPermisos t WHERE t.idModulo = :idModulo")
    , @NamedQuery(name = "TPermisos.findBySincronizacion", query = "SELECT t FROM TPermisos t WHERE t.sincronizacion = :sincronizacion")
    , @NamedQuery(name = "TPermisos.findByIdCiudad", query = "SELECT t FROM TPermisos t WHERE t.idCiudad = :idCiudad")
    , @NamedQuery(name = "TPermisos.findByIdSede", query = "SELECT t FROM TPermisos t WHERE t.idSede = :idSede")})
public class TPermisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPermiso", nullable = false)
    private Long idPermiso;
    @Basic(optional = false)
    @Column(name = "DocumentoUsuario",nullable = true)
    private long documentoUsuario;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "NombreContol",nullable = false)
    private String nombreContol;
    @Size(max = 50)
    @Column(name = "IdModulo")
    private String idModulo;
    @Basic(optional = false)
    @Column(name = "Sincronizacion",nullable = false)
    private boolean sincronizacion;
    @Column(name = "IdCiudad")
    private Long idCiudad;
    @Column(name = "IdSede")
    private Long idSede;

    public TPermisos() {
    }

    public TPermisos(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public TPermisos(Long idPermiso, long documentoUsuario, String nombreContol, boolean sincronizacion) {
        this.idPermiso = idPermiso;
        this.documentoUsuario = documentoUsuario;
        this.nombreContol = nombreContol;
        this.sincronizacion = sincronizacion;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public long getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(long documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getNombreContol() {
        return nombreContol;
    }

    public void setNombreContol(String nombreContol) {
        this.nombreContol = nombreContol;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public boolean getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(boolean sincronizacion) {
        this.sincronizacion = sincronizacion;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Long getIdSede() {
        return idSede;
    }

    public void setIdSede(Long idSede) {
        this.idSede = idSede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPermisos)) {
            return false;
        }
        TPermisos other = (TPermisos) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TPermisos[ idPermiso=" + idPermiso + " ]";
    }

}
