/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author miguel
 */
@Entity
@Table(name = "T_Permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPermisos.findAll", query = "SELECT t FROM TPermisos t")
    , @NamedQuery(name = "TPermisos.findByIdPermiso", query = "SELECT t FROM TPermisos t WHERE t.idPermiso = :idPermiso")
    , @NamedQuery(name = "TPermisos.findByDocumentoUsuario", query = "SELECT t FROM TPermisos t WHERE t.documentoUsuario = :documentoUsuario")
    , @NamedQuery(name = "TPermisos.findByNombreControl", query = "SELECT t FROM TPermisos t WHERE t.nombreControl = :nombreControl")
    , @NamedQuery(name = "TPermisos.findByIdModulo", query = "SELECT t FROM TPermisos t WHERE t.idModulo = :idModulo")
    , @NamedQuery(name = "TPermisos.findByIdCiudad", query = "SELECT t FROM TPermisos t WHERE t.idCiudad = :idCiudad")
    , @NamedQuery(name = "TPermisos.findByIdSede", query = "SELECT t FROM TPermisos t WHERE t.idSede = :idSede")
    , @NamedQuery(name = "TPermisos.findBySincronizacion", query = "SELECT t FROM TPermisos t WHERE t.sincronizacion = :sincronizacion")})
public class TPermisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "IdPermiso",insertable = false)
    private Long idPermiso;
    @Basic(optional = false)
    @Column(name = "DocumentoUsuario",nullable = false)
    private long documentoUsuario;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "NombreControl",nullable = false)
    private String nombreControl;
    @Size(max = 50)
    @Column(name = "IdModulo")
    private String idModulo;
    @Column(name = "IdCiudad")
    private BigInteger idCiudad;
    @Column(name = "IdSede")
    private BigInteger idSede;
    @Basic(optional = false)
    @Column(name = "Sincronizacion",nullable = false)
    private boolean sincronizacion;

    public TPermisos() {
    }

    public TPermisos(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public TPermisos(Long idPermiso, long documentoUsuario, String nombreControl, boolean sincronizacion) {
        this.idPermiso = idPermiso;
        this.documentoUsuario = documentoUsuario;
        this.nombreControl = nombreControl;
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

    public String getNombreControl() {
        return nombreControl;
    }

    public void setNombreControl(String nombreControl) {
        this.nombreControl = nombreControl;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public BigInteger getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(BigInteger idCiudad) {
        this.idCiudad = idCiudad;
    }

    public BigInteger getIdSede() {
        return idSede;
    }

    public void setIdSede(BigInteger idSede) {
        this.idSede = idSede;
    }

    public boolean getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(boolean sincronizacion) {
        this.sincronizacion = sincronizacion;
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
