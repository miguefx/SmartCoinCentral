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
@Table(name = "T_Recargas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TRecargas.findAll", query = "SELECT t FROM TRecargas t"),
    @NamedQuery(name = "TRecargas.findByIdRecarga", query = "SELECT t FROM TRecargas t WHERE t.idRecarga = :idRecarga"),
    @NamedQuery(name = "TRecargas.findByIdTipoTransaccion", query = "SELECT t FROM TRecargas t WHERE t.idTipoTransaccion = :idTipoTransaccion"),
    @NamedQuery(name = "TRecargas.findByFechaOperacion", query = "SELECT t FROM TRecargas t WHERE t.fechaOperacion = :fechaOperacion"),
    @NamedQuery(name = "TRecargas.findByValorOperacion", query = "SELECT t FROM TRecargas t WHERE t.valorOperacion = :valorOperacion"),
    @NamedQuery(name = "TRecargas.findByOperador", query = "SELECT t FROM TRecargas t WHERE t.operador = :operador"),
    @NamedQuery(name = "TRecargas.findByLineaReferencia", query = "SELECT t FROM TRecargas t WHERE t.lineaReferencia = :lineaReferencia"),
    @NamedQuery(name = "TRecargas.findByDescripcion", query = "SELECT t FROM TRecargas t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TRecargas.findByNumeroFactura", query = "SELECT t FROM TRecargas t WHERE t.numeroFactura = :numeroFactura"),
    @NamedQuery(name = "TRecargas.findByEstadoTransaccion", query = "SELECT t FROM TRecargas t WHERE t.estadoTransaccion = :estadoTransaccion"),
    @NamedQuery(name = "TRecargas.findBySinccronizacion", query = "SELECT t FROM TRecargas t WHERE t.sinccronizacion = :sinccronizacion")})
public class TRecargas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdRecarga")
    private Long idRecarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTipoTransaccion")
    private long idTipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaOperacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOperacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorOperacion")
    private Double valorOperacion;
    @Size(max = 50)
    @Column(name = "Operador")
    private String operador;
    @Size(max = 50)
    @Column(name = "LineaReferencia")
    private String lineaReferencia;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "NumeroFactura")
    private String numeroFactura;
    @Column(name = "EstadoTransaccion")
    private Integer estadoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sinccronizacion")
    private boolean sinccronizacion;
    @JoinColumn(name = "IdModulo", referencedColumnName = "IdModulo")
    @ManyToOne(optional = false)
    private TConfiguracion idModulo;
    @JoinColumn(name = "IdSede", referencedColumnName = "IdSede")
    @ManyToOne(optional = false)
    private TSedes idSede;
    @JoinColumn(name = "IdTransaccion", referencedColumnName = "IdTransaccion")
    @ManyToOne(optional = false)
    private TTransacciones idTransaccion;

    public TRecargas() {
    }

    public TRecargas(Long idRecarga) {
        this.idRecarga = idRecarga;
    }

    public TRecargas(Long idRecarga, long idTipoTransaccion, Date fechaOperacion, boolean sinccronizacion) {
        this.idRecarga = idRecarga;
        this.idTipoTransaccion = idTipoTransaccion;
        this.fechaOperacion = fechaOperacion;
        this.sinccronizacion = sinccronizacion;
    }

    public Long getIdRecarga() {
        return idRecarga;
    }

    public void setIdRecarga(Long idRecarga) {
        this.idRecarga = idRecarga;
    }

    public long getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(long idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Double getValorOperacion() {
        return valorOperacion;
    }

    public void setValorOperacion(Double valorOperacion) {
        this.valorOperacion = valorOperacion;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getLineaReferencia() {
        return lineaReferencia;
    }

    public void setLineaReferencia(String lineaReferencia) {
        this.lineaReferencia = lineaReferencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Integer getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(Integer estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public boolean getSinccronizacion() {
        return sinccronizacion;
    }

    public void setSinccronizacion(boolean sinccronizacion) {
        this.sinccronizacion = sinccronizacion;
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

    public TTransacciones getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(TTransacciones idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecarga != null ? idRecarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRecargas)) {
            return false;
        }
        TRecargas other = (TRecargas) object;
        if ((this.idRecarga == null && other.idRecarga != null) || (this.idRecarga != null && !this.idRecarga.equals(other.idRecarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TRecargas[ idRecarga=" + idRecarga + " ]";
    }
    
}
