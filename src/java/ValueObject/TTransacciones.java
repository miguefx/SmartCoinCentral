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
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
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
@Table(name = "T_Transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTransacciones.findAll", query = "SELECT t FROM TTransacciones t")
    , @NamedQuery(name = "TTransacciones.findByIdTransaccion", query = "SELECT t FROM TTransacciones t WHERE t.idTransaccion = :idTransaccion")
    , @NamedQuery(name = "TTransacciones.findByFechaTransaccion", query = "SELECT t FROM TTransacciones t WHERE t.fechaTransaccion = :fechaTransaccion")
    , @NamedQuery(name = "TTransacciones.findByValorRecibido", query = "SELECT t FROM TTransacciones t WHERE t.valorRecibido = :valorRecibido")
    , @NamedQuery(name = "TTransacciones.findByIva", query = "SELECT t FROM TTransacciones t WHERE t.iva = :iva")
    , @NamedQuery(name = "TTransacciones.findByComision", query = "SELECT t FROM TTransacciones t WHERE t.comision = :comision")
    , @NamedQuery(name = "TTransacciones.findByRedondeo", query = "SELECT t FROM TTransacciones t WHERE t.redondeo = :redondeo")
    , @NamedQuery(name = "TTransacciones.findByTotalPagado", query = "SELECT t FROM TTransacciones t WHERE t.totalPagado = :totalPagado")
    , @NamedQuery(name = "TTransacciones.findByCodigoBarras", query = "SELECT t FROM TTransacciones t WHERE t.codigoBarras = :codigoBarras")
    , @NamedQuery(name = "TTransacciones.findByNumeroFactura", query = "SELECT t FROM TTransacciones t WHERE t.numeroFactura = :numeroFactura")
    , @NamedQuery(name = "TTransacciones.findByAnulada", query = "SELECT t FROM TTransacciones t WHERE t.anulada = :anulada")
    , @NamedQuery(name = "TTransacciones.findBySincronizacion", query = "SELECT t FROM TTransacciones t WHERE t.sincronizacion = :sincronizacion")
    , @NamedQuery(name = "TTransacciones.findByEstadoTransaccion", query = "SELECT t FROM TTransacciones t WHERE t.estadoTransaccion = :estadoTransaccion")
    , @NamedQuery(name = "TTransacciones.findBySincronizacionPago", query = "SELECT t FROM TTransacciones t WHERE t.sincronizacionPago = :sincronizacionPago")})
@SqlResultSetMapping(
        name = "mapeoReporte2", classes = @ConstructorResult(targetClass = TreporteTransacciones.class, columns = {
    @ColumnResult(name = "idModulo", type = String.class)
    ,
                    @ColumnResult(name = "conteo", type = Integer.class)
    ,
                    @ColumnResult(name = "valorTotal", type = Double.class)

}))

public class TTransacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTransaccion")
    private Long idTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaTransaccion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransaccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorRecibido")
    private Double valorRecibido;
    @Column(name = "Iva")
    private Double iva;
    @Column(name = "Comision")
    private Double comision;
    @Column(name = "Redondeo")
    private Double redondeo;
    @Column(name = "TotalPagado")
    private Double totalPagado;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sincronizacion")
    private boolean sincronizacion;
    @Column(name = "EstadoTransaccion")
    private Integer estadoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SincronizacionPago")
    private boolean sincronizacionPago;
    @JoinColumn(name = "IdModulo", referencedColumnName = "IdModulo")
    @ManyToOne(optional = false)
    private TConfiguracion idModulo;
    @JoinColumn(name = "IdSede", referencedColumnName = "IdSede")
    @ManyToOne(optional = false)
    private TSedes idSede;
    @JoinColumn(name = "IdTipoTransaccion", referencedColumnName = "IdTipoTransaccion")
    @ManyToOne(optional = false)
    private TTipoTransaccion idTipoTransaccion;

    public TTransacciones() {
    }

    public TTransacciones(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public TTransacciones(Long idTransaccion, Date fechaTransaccion, boolean anulada, boolean sincronizacion, boolean sincronizacionPago) {
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.anulada = anulada;
        this.sincronizacion = sincronizacion;
        this.sincronizacionPago = sincronizacionPago;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Double getValorRecibido() {
        return valorRecibido;
    }

    public void setValorRecibido(Double valorRecibido) {
        this.valorRecibido = valorRecibido;
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

    public Double getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(Double totalPagado) {
        this.totalPagado = totalPagado;
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

    public boolean getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(boolean sincronizacion) {
        this.sincronizacion = sincronizacion;
    }

    public Integer getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(Integer estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public boolean getSincronizacionPago() {
        return sincronizacionPago;
    }

    public void setSincronizacionPago(boolean sincronizacionPago) {
        this.sincronizacionPago = sincronizacionPago;
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

    public TTipoTransaccion getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(TTipoTransaccion idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTransacciones)) {
            return false;
        }
        TTransacciones other = (TTransacciones) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TTransacciones[ idTransaccion=" + idTransaccion + " ]";
    }

}
