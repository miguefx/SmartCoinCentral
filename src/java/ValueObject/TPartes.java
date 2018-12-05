/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "T_Partes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPartes.findAll", query = "SELECT t FROM TPartes t")
    , @NamedQuery(name = "TPartes.findByIdParte", query = "SELECT t FROM TPartes t WHERE t.idParte = :idParte")
    , @NamedQuery(name = "TPartes.findByTipoParte", query = "SELECT t FROM TPartes t WHERE t.tipoParte = :tipoParte")
    , @NamedQuery(name = "TPartes.findByNombreParte", query = "SELECT t FROM TPartes t WHERE t.nombreParte = :nombreParte")
    , @NamedQuery(name = "TPartes.findByDenominacion", query = "SELECT t FROM TPartes t WHERE t.denominacion = :denominacion")
    , @NamedQuery(name = "TPartes.findByCantidadMin", query = "SELECT t FROM TPartes t WHERE t.cantidadMin = :cantidadMin")
    , @NamedQuery(name = "TPartes.findByCantidadMax", query = "SELECT t FROM TPartes t WHERE t.cantidadMax = :cantidadMax")
    , @NamedQuery(name = "TPartes.findByNumParte", query = "SELECT t FROM TPartes t WHERE t.numParte = :numParte")
    , @NamedQuery(name = "TPartes.findByIPDispositivo", query = "SELECT t FROM TPartes t WHERE t.iPDispositivo = :iPDispositivo")
    , @NamedQuery(name = "TPartes.findByCantidadAlarma", query = "SELECT t FROM TPartes t WHERE t.cantidadAlarma = :cantidadAlarma")
    , @NamedQuery(name = "TPartes.findByDineroActual", query = "SELECT t FROM TPartes t WHERE t.dineroActual = :dineroActual")
    , @NamedQuery(name = "TPartes.findByCantidadActual", query = "SELECT t FROM TPartes t WHERE t.cantidadActual = :cantidadActual")
    , @NamedQuery(name = "TPartes.findByPrioritario", query = "SELECT t FROM TPartes t WHERE t.prioritario = :prioritario")
    , @NamedQuery(name = "TPartes.findByEstado", query = "SELECT t FROM TPartes t WHERE t.estado = :estado")
    , @NamedQuery(name = "TPartes.findBySincronizacion", query = "SELECT t FROM TPartes t WHERE t.sincronizacion = :sincronizacion")})
 @SqlResultSetMapping(
        name = "mapeo67", classes = @ConstructorResult(targetClass = TSaldoEnLinea.class, columns = {
    @ColumnResult(name = "cantidadActual", type = Integer.class)
    ,
            @ColumnResult(name = "denominacion", type = Double.class)
    ,
        @ColumnResult(name = "nombreParte", type = String.class)
    ,
                @ColumnResult(name = "dineroActual", type = Double.class)
    ,
                @ColumnResult(name = "tipoParte", type = String.class)

}))
public class TPartes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdParte")
    private Long idParte;
    @Size(max = 50)
    @Column(name = "TipoParte")
    private String tipoParte;
    @Size(max = 50)
    @Column(name = "NombreParte")
    private String nombreParte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Denominacion")
    private Double denominacion;
    @Column(name = "CantidadMin")
    private Double cantidadMin;
    @Column(name = "CantidadMax")
    private Double cantidadMax;
    @Column(name = "NumParte")
    private Integer numParte;
    @Size(max = 50)
    @Column(name = "IPDispositivo")
    private String iPDispositivo;
    @Column(name = "CantidadAlarma")
    private Double cantidadAlarma;
    @Column(name = "DineroActual")
    private Double dineroActual;
    @Column(name = "CantidadActual")
    private Integer cantidadActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prioritario")
    private boolean prioritario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sincronizacion")
    private boolean sincronizacion;
    @JoinColumn(name = "IdModulo", referencedColumnName = "IdModulo")
    @ManyToOne(optional = false)
    private TConfiguracion idModulo;
    @JoinColumn(name = "IdSede", referencedColumnName = "IdSede")
    @ManyToOne
    private TSedes idSede;

    public TPartes() {
    }

    public TPartes(Long idParte) {
        this.idParte = idParte;
    }

    public TPartes(Long idParte, boolean prioritario, boolean estado, boolean sincronizacion) {
        this.idParte = idParte;
        this.prioritario = prioritario;
        this.estado = estado;
        this.sincronizacion = sincronizacion;
    }

    public Long getIdParte() {
        return idParte;
    }

    public void setIdParte(Long idParte) {
        this.idParte = idParte;
    }

    public String getTipoParte() {
        return tipoParte;
    }

    public void setTipoParte(String tipoParte) {
        this.tipoParte = tipoParte;
    }

    public String getNombreParte() {
        return nombreParte;
    }

    public void setNombreParte(String nombreParte) {
        this.nombreParte = nombreParte;
    }

    public Double getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(Double denominacion) {
        this.denominacion = denominacion;
    }

    public Double getCantidadMin() {
        return cantidadMin;
    }

    public void setCantidadMin(Double cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

    public Double getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(Double cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public Integer getNumParte() {
        return numParte;
    }

    public void setNumParte(Integer numParte) {
        this.numParte = numParte;
    }

    public String getIPDispositivo() {
        return iPDispositivo;
    }

    public void setIPDispositivo(String iPDispositivo) {
        this.iPDispositivo = iPDispositivo;
    }

    public Double getCantidadAlarma() {
        return cantidadAlarma;
    }

    public void setCantidadAlarma(Double cantidadAlarma) {
        this.cantidadAlarma = cantidadAlarma;
    }

    public Double getDineroActual() {
        return dineroActual;
    }

    public void setDineroActual(Double dineroActual) {
        this.dineroActual = dineroActual;
    }

    public Integer getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Integer cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public boolean getPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParte != null ? idParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPartes)) {
            return false;
        }
        TPartes other = (TPartes) object;
        if ((this.idParte == null && other.idParte != null) || (this.idParte != null && !this.idParte.equals(other.idParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TPartes[ idParte=" + idParte + " ]";
    }
    
}
