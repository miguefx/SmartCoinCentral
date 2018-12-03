/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matc_
 */
@Entity
@Table(name = "T_Alarmas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TAlarmas.findAll", query = "SELECT t FROM TAlarmas t")
    , @NamedQuery(name = "TAlarmas.findByIdAlarma", query = "SELECT t FROM TAlarmas t WHERE t.idAlarma = :idAlarma")
    , @NamedQuery(name = "TAlarmas.findByTipoError", query = "SELECT t FROM TAlarmas t WHERE t.tipoError = :tipoError")
    , @NamedQuery(name = "TAlarmas.findByParte", query = "SELECT t FROM TAlarmas t WHERE t.parte = :parte")
    , @NamedQuery(name = "TAlarmas.findByDescripcion", query = "SELECT t FROM TAlarmas t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TAlarmas.findByNivelError", query = "SELECT t FROM TAlarmas t WHERE t.nivelError = :nivelError")
    , @NamedQuery(name = "TAlarmas.findByFechaRegistro", query = "SELECT t FROM TAlarmas t WHERE t.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "TAlarmas.findByObservacion", query = "SELECT t FROM TAlarmas t WHERE t.observacion = :observacion")
    , @NamedQuery(name = "TAlarmas.findByFechaAtencion", query = "SELECT t FROM TAlarmas t WHERE t.fechaAtencion = :fechaAtencion")
    , @NamedQuery(name = "TAlarmas.findByUsuarioObservacion", query = "SELECT t FROM TAlarmas t WHERE t.usuarioObservacion = :usuarioObservacion")
    , @NamedQuery(name = "TAlarmas.findByFechaSolucion", query = "SELECT t FROM TAlarmas t WHERE t.fechaSolucion = :fechaSolucion")})
public class TAlarmas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdAlarma")
    private Long idAlarma;
    @Size(max = 50)
    @Column(name = "TipoError")
    private String tipoError;
    @Size(max = 50)
    @Column(name = "Parte")
    private String parte;
    @Size(max = 500)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "NivelError")
    private Integer nivelError;
    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 500)
    @Column(name = "Observacion")
    private String observacion;
    @Column(name = "FechaAtencion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAtencion;
    @Size(max = 50)
    @Column(name = "UsuarioObservacion")
    private String usuarioObservacion;
    @Column(name = "FechaSolucion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolucion;
    @JoinColumn(name = "IdModulo", referencedColumnName = "IdModulo")
    @ManyToOne
    private TConfiguracion idModulo;
    @JoinColumn(name = "IdSede", referencedColumnName = "IdSede")
    @ManyToOne
    private TSedes idSede;

    public TAlarmas() {
    }

    public TAlarmas(Long idAlarma) {
        this.idAlarma = idAlarma;
    }

    public Long getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(Long idAlarma) {
        this.idAlarma = idAlarma;
    }

    public String getTipoError() {
        return tipoError;
    }

    public void setTipoError(String tipoError) {
        this.tipoError = tipoError;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNivelError() {
        return nivelError;
    }

    public void setNivelError(Integer nivelError) {
        this.nivelError = nivelError;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getUsuarioObservacion() {
        return usuarioObservacion;
    }

    public void setUsuarioObservacion(String usuarioObservacion) {
        this.usuarioObservacion = usuarioObservacion;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public TConfiguracion getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(TConfiguracion idModulo) {
        this.idModulo = idModulo;
    }

    public TSedes getIdSede() {
        return idSede;
    }

    public void setIdSede(TSedes idSede) {
        this.idSede = idSede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlarma != null ? idAlarma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAlarmas)) {
            return false;
        }
        TAlarmas other = (TAlarmas) object;
        if ((this.idAlarma == null && other.idAlarma != null) || (this.idAlarma != null && !this.idAlarma.equals(other.idAlarma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TAlarmas[ idAlarma=" + idAlarma + " ]";
    }
    
}
