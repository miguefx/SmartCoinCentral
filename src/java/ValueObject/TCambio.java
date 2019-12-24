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
@Table(name = "T_Cambio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCambio.findAll", query = "SELECT t FROM TCambio t"),
    @NamedQuery(name = "TCambio.findByIdCambio", query = "SELECT t FROM TCambio t WHERE t.idCambio = :idCambio"),
    @NamedQuery(name = "TCambio.findByIdTipoTransaccion", query = "SELECT t FROM TCambio t WHERE t.idTipoTransaccion = :idTipoTransaccion"),
    @NamedQuery(name = "TCambio.findByFechaOperacion", query = "SELECT t FROM TCambio t WHERE t.fechaOperacion = :fechaOperacion"),
    @NamedQuery(name = "TCambio.findByValorRetirado", query = "SELECT t FROM TCambio t WHERE t.valorRetirado = :valorRetirado"),
    @NamedQuery(name = "TCambio.findByIva", query = "SELECT t FROM TCambio t WHERE t.iva = :iva"),
    @NamedQuery(name = "TCambio.findByComision", query = "SELECT t FROM TCambio t WHERE t.comision = :comision"),
    @NamedQuery(name = "TCambio.findByRedondeo", query = "SELECT t FROM TCambio t WHERE t.redondeo = :redondeo"),
    @NamedQuery(name = "TCambio.findByCodigoBarras", query = "SELECT t FROM TCambio t WHERE t.codigoBarras = :codigoBarras"),
    @NamedQuery(name = "TCambio.findByNumeroFactura", query = "SELECT t FROM TCambio t WHERE t.numeroFactura = :numeroFactura"),
    @NamedQuery(name = "TCambio.findByAnulada", query = "SELECT t FROM TCambio t WHERE t.anulada = :anulada"),
    @NamedQuery(name = "TCambio.findByEstadoTransaccion", query = "SELECT t FROM TCambio t WHERE t.estadoTransaccion = :estadoTransaccion"),
    @NamedQuery(name = "TCambio.findBySincronizacion", query = "SELECT t FROM TCambio t WHERE t.sincronizacion = :sincronizacion")})
public class TCambio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCambio")
    private Long idCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTipoTransaccion")
    private long idTipoTransaccion;
    @Column(name = "FechaOperacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOperacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorRetirado")
    private Double valorRetirado;
    @Column(name = "Iva")
    private Double iva;
    @Column(name = "Comision")
    private Double comision;
    @Column(name = "Redondeo")
    private Double redondeo;
    @Size(max = 50)
    @Column(name = "CodigoBarras")
    private String codigoBarras;
    @Size(max = 50)
    @Column(name = "NumeroFactura")
    private String numeroFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Anulada")
    private boolean anulada;
    @Column(name = "EstadoTransaccion")
    private Integer estadoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sincronizacion")
    private boolean sincronizacion;
    @JoinColumn(name = "IdModulo", referencedColumnName = "IdModulo")
    @ManyToOne(optional = false)
    private TConfiguracion idModulo;
    @JoinColumn(name = "IdSede", referencedColumnName = "IdSede")
    @ManyToOne(optional = false)
    private TSedes idSede;
    @JoinColumn(name = "IdTransaccion", referencedColumnName = "IdTransaccion")
    @ManyToOne(optional = false)
    private TTransacciones idTransaccion;

    public TCambio() {
    }

    public TCambio(Long idCambio) {
        this.idCambio = idCambio;
    }

    public TCambio(Long idCambio, long idTipoTransaccion, boolean anulada, boolean sincronizacion) {
        this.idCambio = idCambio;
        this.idTipoTransaccion = idTipoTransaccion;
        this.anulada = anulada;
        this.sincronizacion = sincronizacion;
    }

    public Long getIdCambio() {
        return idCambio;
    }

    public void setIdCambio(Long idCambio) {
        this.idCambio = idCambio;
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

    public Double getValorRetirado() {
        return valorRetirado;
    }

    public void setValorRetirado(Double valorRetirado) {
        this.valorRetirado = valorRetirado;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Double getRedondeo() {
        return redondeo;
    }

    public void setRedondeo(Double redondeo) {
        this.redondeo = redondeo;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(boolean anulada) {
        this.anulada = anulada;
    }

    public Integer getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(Integer estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public boolean getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(boolean sincronizacion) {
        this.sincronizacion = sincronizacion;
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
        hash += (idCambio != null ? idCambio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCambio)) {
            return false;
        }
        TCambio other = (TCambio) object;
        if ((this.idCambio == null && other.idCambio != null) || (this.idCambio != null && !this.idCambio.equals(other.idCambio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TCambio[ idCambio=" + idCambio + " ]";
    }
    
}
