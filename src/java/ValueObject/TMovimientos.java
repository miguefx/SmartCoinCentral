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
 * @author miguel
 */
@Entity
@Table(name = "T_Movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMovimientos.findAll", query = "SELECT t FROM TMovimientos t")
    , @NamedQuery(name = "TMovimientos.findByIdMovimiento", query = "SELECT t FROM TMovimientos t WHERE t.idMovimiento = :idMovimiento")
    , @NamedQuery(name = "TMovimientos.findByIdTransaccion", query = "SELECT t FROM TMovimientos t WHERE t.idTransaccion = :idTransaccion")
    , @NamedQuery(name = "TMovimientos.findByIdSede", query = "SELECT t FROM TMovimientos t WHERE t.idSede = :idSede")
    , @NamedQuery(name = "TMovimientos.findByIdModulo", query = "SELECT t FROM TMovimientos t WHERE t.idModulo = :idModulo")
    , @NamedQuery(name = "TMovimientos.findByParte", query = "SELECT t FROM TMovimientos t WHERE t.parte = :parte")
    , @NamedQuery(name = "TMovimientos.findByAccion", query = "SELECT t FROM TMovimientos t WHERE t.accion = :accion")
    , @NamedQuery(name = "TMovimientos.findByDenominacion", query = "SELECT t FROM TMovimientos t WHERE t.denominacion = :denominacion")
    , @NamedQuery(name = "TMovimientos.findByCantidad", query = "SELECT t FROM TMovimientos t WHERE t.cantidad = :cantidad")
    , @NamedQuery(name = "TMovimientos.findByValor", query = "SELECT t FROM TMovimientos t WHERE t.valor = :valor")
    , @NamedQuery(name = "TMovimientos.findByFechaMovimiento", query = "SELECT t FROM TMovimientos t WHERE t.fechaMovimiento = :fechaMovimiento")
    , @NamedQuery(name = "TMovimientos.findBySincronizacion", query = "SELECT t FROM TMovimientos t WHERE t.sincronizacion = :sincronizacion")})
@SqlResultSetMapping(
            name = "mapeo", classes = @ConstructorResult(targetClass = TmovimientosTable.class, columns = {
        @ColumnResult(name = "parte", type = String.class)
        ,
                        @ColumnResult(name = "denominacion", type = Double.class)
        ,
                        @ColumnResult(name = "cantidad", type = Integer.class)
        ,
                                @ColumnResult(name = "accion", type = String.class)
        ,
                                 @ColumnResult(name = "idTransaccion", type = Long.class)
        ,

            @ColumnResult(name = "valor", type = Double.class)
    }))
public class TMovimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdMovimiento")
    private Long idMovimiento;
    @Column(name = "IdTransaccion")
    private BigInteger idTransaccion;
    @Column(name = "IdSede")
    private BigInteger idSede;
    @Size(max = 50)
    @Column(name = "IdModulo")
    private String idModulo;
    @Size(max = 50)
    @Column(name = "Parte")
    private String parte;
    @Size(max = 50)
    @Column(name = "Accion")
    private String accion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Denominacion")
    private Double denominacion;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Column(name = "Valor")
    private Double valor;
    @Column(name = "FechaMovimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sincronizacion")
    private boolean sincronizacion;
    @JoinColumn(name = "IdArqueo", referencedColumnName = "IdArqueo")
    @ManyToOne
    private TArqueos idArqueo;
    @JoinColumn(name = "IdCarga", referencedColumnName = "IdCarga")
    @ManyToOne
    private TCargas idCarga;

    public TMovimientos() {
    }

    public TMovimientos(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public TMovimientos(Long idMovimiento, boolean sincronizacion) {
        this.idMovimiento = idMovimiento;
        this.sincronizacion = sincronizacion;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public BigInteger getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(BigInteger idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public BigInteger getIdSede() {
        return idSede;
    }

    public void setIdSede(BigInteger idSede) {
        this.idSede = idSede;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Double getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(Double denominacion) {
        this.denominacion = denominacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public boolean getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(boolean sincronizacion) {
        this.sincronizacion = sincronizacion;
    }

    public TArqueos getIdArqueo() {
        return idArqueo;
    }

    public void setIdArqueo(TArqueos idArqueo) {
        this.idArqueo = idArqueo;
    }

    public TCargas getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(TCargas idCarga) {
        this.idCarga = idCarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimiento != null ? idMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMovimientos)) {
            return false;
        }
        TMovimientos other = (TMovimientos) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TMovimientos[ idMovimiento=" + idMovimiento + " ]";
    }
    
}
