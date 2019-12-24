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
@Table(name = "T_Donaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDonaciones.findAll", query = "SELECT t FROM TDonaciones t"),
    @NamedQuery(name = "TDonaciones.findByIdDonacion", query = "SELECT t FROM TDonaciones t WHERE t.idDonacion = :idDonacion"),
    @NamedQuery(name = "TDonaciones.findByIdTipoTransaccion", query = "SELECT t FROM TDonaciones t WHERE t.idTipoTransaccion = :idTipoTransaccion"),
    @NamedQuery(name = "TDonaciones.findByFechaOperacion", query = "SELECT t FROM TDonaciones t WHERE t.fechaOperacion = :fechaOperacion"),
    @NamedQuery(name = "TDonaciones.findByValorOperacion", query = "SELECT t FROM TDonaciones t WHERE t.valorOperacion = :valorOperacion"),
    @NamedQuery(name = "TDonaciones.findByFundacion", query = "SELECT t FROM TDonaciones t WHERE t.fundacion = :fundacion"),
    @NamedQuery(name = "TDonaciones.findBySincronizacion", query = "SELECT t FROM TDonaciones t WHERE t.sincronizacion = :sincronizacion")})
public class TDonaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdDonacion")
    private Long idDonacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTipoTransaccion")
    private long idTipoTransaccion;
    @Column(name = "FechaOperacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOperacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorOperacion")
    private Double valorOperacion;
    @Size(max = 50)
    @Column(name = "Fundacion")
    private String fundacion;
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

    public TDonaciones() {
    }

    public TDonaciones(Long idDonacion) {
        this.idDonacion = idDonacion;
    }

    public TDonaciones(Long idDonacion, long idTipoTransaccion, boolean sincronizacion) {
        this.idDonacion = idDonacion;
        this.idTipoTransaccion = idTipoTransaccion;
        this.sincronizacion = sincronizacion;
    }

    public Long getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Long idDonacion) {
        this.idDonacion = idDonacion;
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

    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
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
        hash += (idDonacion != null ? idDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDonaciones)) {
            return false;
        }
        TDonaciones other = (TDonaciones) object;
        if ((this.idDonacion == null && other.idDonacion != null) || (this.idDonacion != null && !this.idDonacion.equals(other.idDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TDonaciones[ idDonacion=" + idDonacion + " ]";
    }
    
}
