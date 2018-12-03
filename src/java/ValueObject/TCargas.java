/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matc_
 */
@Entity
@Table(name = "T_Cargas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCargas.findAll", query = "SELECT t FROM TCargas t")
    , @NamedQuery(name = "TCargas.findById", query = "SELECT t FROM TCargas t WHERE t.id = :id")
    , @NamedQuery(name = "TCargas.findByIdCarga", query = "SELECT t FROM TCargas t WHERE t.idCarga = :idCarga")
    , @NamedQuery(name = "TCargas.findByFechaInicio", query = "SELECT t FROM TCargas t WHERE t.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "TCargas.findByFechaFin", query = "SELECT t FROM TCargas t WHERE t.fechaFin = :fechaFin")
    , @NamedQuery(name = "TCargas.findByValor", query = "SELECT t FROM TCargas t WHERE t.valor = :valor")
    , @NamedQuery(name = "TCargas.findByIdUsuario", query = "SELECT t FROM TCargas t WHERE t.idUsuario = :idUsuario")
    , @NamedQuery(name = "TCargas.findBySincronizacion", query = "SELECT t FROM TCargas t WHERE t.sincronizacion = :sincronizacion")
    , @NamedQuery(name = "TCargas.findByFechaUltimaAnterior", query = "SELECT t FROM TCargas t WHERE t.fechaUltimaAnterior = :fechaUltimaAnterior")})
public class TCargas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCarga")
    private long idCarga;
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor")
    private Double valor;
    @Column(name = "IdUsuario")
    private BigInteger idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sincronizacion")
    private boolean sincronizacion;
    @Column(name = "fechaUltimaAnterior")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaAnterior;
    @JoinColumn(name = "IdModulo", referencedColumnName = "IdModulo")
    @ManyToOne
    private TConfiguracion idModulo;
    @JoinColumn(name = "IdSede", referencedColumnName = "IdSede")
    @ManyToOne
    private TSedes idSede;

    public TCargas() {
    }

    public TCargas(Long id) {
        this.id = id;
    }

    public TCargas(Long id, long idCarga, boolean sincronizacion) {
        this.id = id;
        this.idCarga = idCarga;
        this.sincronizacion = sincronizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(long idCarga) {
        this.idCarga = idCarga;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public BigInteger getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(boolean sincronizacion) {
        this.sincronizacion = sincronizacion;
    }

    public Date getFechaUltimaAnterior() {
        return fechaUltimaAnterior;
    }

    public void setFechaUltimaAnterior(Date fechaUltimaAnterior) {
        this.fechaUltimaAnterior = fechaUltimaAnterior;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCargas)) {
            return false;
        }
        TCargas other = (TCargas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TCargas[ id=" + id + " ]";
    }
    
}
