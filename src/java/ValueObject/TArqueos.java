/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "T_Arqueos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TArqueos.findAll", query = "SELECT t FROM TArqueos t")
    , @NamedQuery(name = "TArqueos.findByIdArqueo", query = "SELECT t FROM TArqueos t WHERE t.idArqueo = :idArqueo")
    , @NamedQuery(name = "TArqueos.findByFechaInicio", query = "SELECT t FROM TArqueos t WHERE t.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "TArqueos.findByFechaFin", query = "SELECT t FROM TArqueos t WHERE t.fechaFin = :fechaFin")
    , @NamedQuery(name = "TArqueos.findByValor", query = "SELECT t FROM TArqueos t WHERE t.valor = :valor")
    , @NamedQuery(name = "TArqueos.findByIdUsuario", query = "SELECT t FROM TArqueos t WHERE t.idUsuario = :idUsuario")
    , @NamedQuery(name = "TArqueos.findByCantTransacciones", query = "SELECT t FROM TArqueos t WHERE t.cantTransacciones = :cantTransacciones")
    , @NamedQuery(name = "TArqueos.findByProducido", query = "SELECT t FROM TArqueos t WHERE t.producido = :producido")
    , @NamedQuery(name = "TArqueos.findByTipo", query = "SELECT t FROM TArqueos t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TArqueos.findByConteo", query = "SELECT t FROM TArqueos t WHERE t.conteo = :conteo")
    , @NamedQuery(name = "TArqueos.findBySincronizacion", query = "SELECT t FROM TArqueos t WHERE t.sincronizacion = :sincronizacion")
    , @NamedQuery(name = "TArqueos.findByFechaFinAnterior", query = "SELECT t FROM TArqueos t WHERE t.fechaFinAnterior = :fechaFinAnterior")})
@SqlResultSetMapping(
        name = "mapeoReporte1", classes = @ConstructorResult(targetClass = TreporteArqueos.class, columns = {
    @ColumnResult(name = "idModulo", type = String.class)
    ,
                    @ColumnResult(name = "valor2", type = Double.class)

}))
public class TArqueos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdArqueo")
    private Long idArqueo;
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
    @Column(name = "CantTransacciones")
    private Integer cantTransacciones;
    @Column(name = "Producido")
    private Double producido;
    @Column(name = "Tipo")
    private Character tipo;
    @Column(name = "Conteo")
    private Double conteo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sincronizacion")
    private boolean sincronizacion;
    @Column(name = "fechaFinAnterior")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinAnterior;
    @JoinColumn(name = "IdModulo", referencedColumnName = "IdModulo")
    @ManyToOne
    private TConfiguracion idModulo;
    @JoinColumn(name = "IdSede", referencedColumnName = "IdSede")
    @ManyToOne
    private TSedes idSede;
    @OneToMany(mappedBy = "idArqueo")
    private List<TMovimientos> tMovimientosList;

    public TArqueos() {
    }

    public TArqueos(Long idArqueo) {
        this.idArqueo = idArqueo;
    }

    public TArqueos(Long idArqueo, boolean sincronizacion) {
        this.idArqueo = idArqueo;
        this.sincronizacion = sincronizacion;
    }

    public Long getIdArqueo() {
        return idArqueo;
    }

    public void setIdArqueo(Long idArqueo) {
        this.idArqueo = idArqueo;
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

    public Integer getCantTransacciones() {
        return cantTransacciones;
    }

    public void setCantTransacciones(Integer cantTransacciones) {
        this.cantTransacciones = cantTransacciones;
    }

    public Double getProducido() {
        return producido;
    }

    public void setProducido(Double producido) {
        this.producido = producido;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Double getConteo() {
        return conteo;
    }

    public void setConteo(Double conteo) {
        this.conteo = conteo;
    }

    public boolean getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(boolean sincronizacion) {
        this.sincronizacion = sincronizacion;
    }

    public Date getFechaFinAnterior() {
        return fechaFinAnterior;
    }

    public void setFechaFinAnterior(Date fechaFinAnterior) {
        this.fechaFinAnterior = fechaFinAnterior;
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

    @XmlTransient
    public List<TMovimientos> getTMovimientosList() {
        return tMovimientosList;
    }

    public void setTMovimientosList(List<TMovimientos> tMovimientosList) {
        this.tMovimientosList = tMovimientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArqueo != null ? idArqueo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TArqueos)) {
            return false;
        }
        TArqueos other = (TArqueos) object;
        if ((this.idArqueo == null && other.idArqueo != null) || (this.idArqueo != null && !this.idArqueo.equals(other.idArqueo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TArqueos[ idArqueo=" + idArqueo + " ]";
    }
    
}
