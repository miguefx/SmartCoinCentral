/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "T_Facturacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TFacturacion.findAll", query = "SELECT t FROM TFacturacion t")
    , @NamedQuery(name = "TFacturacion.findByIdFacturacion", query = "SELECT t FROM TFacturacion t WHERE t.idFacturacion = :idFacturacion")
    , @NamedQuery(name = "TFacturacion.findByPrefijo", query = "SELECT t FROM TFacturacion t WHERE t.prefijo = :prefijo")
    , @NamedQuery(name = "TFacturacion.findByFacturaInicial", query = "SELECT t FROM TFacturacion t WHERE t.facturaInicial = :facturaInicial")
    , @NamedQuery(name = "TFacturacion.findByFacturaFinal", query = "SELECT t FROM TFacturacion t WHERE t.facturaFinal = :facturaFinal")
    , @NamedQuery(name = "TFacturacion.findByFacturaActual", query = "SELECT t FROM TFacturacion t WHERE t.facturaActual = :facturaActual")
    , @NamedQuery(name = "TFacturacion.findByNumeroResolucion", query = "SELECT t FROM TFacturacion t WHERE t.numeroResolucion = :numeroResolucion")
    , @NamedQuery(name = "TFacturacion.findByFechaResolucion", query = "SELECT t FROM TFacturacion t WHERE t.fechaResolucion = :fechaResolucion")
    , @NamedQuery(name = "TFacturacion.findByEstado", query = "SELECT t FROM TFacturacion t WHERE t.estado = :estado")
    , @NamedQuery(name = "TFacturacion.findByFechaFinResolucion", query = "SELECT t FROM TFacturacion t WHERE t.fechaFinResolucion = :fechaFinResolucion")})
public class TFacturacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdFacturacion")
    private Long idFacturacion;
    @Size(max = 50)
    @Column(name = "Prefijo")
    private String prefijo;
    @Size(max = 50)
    @Column(name = "FacturaInicial")
    private String facturaInicial;
    @Size(max = 50)
    @Column(name = "FacturaFinal")
    private String facturaFinal;
    @Size(max = 50)
    @Column(name = "FacturaActual")
    private String facturaActual;
    @Size(max = 50)
    @Column(name = "NumeroResolucion")
    private String numeroResolucion;
    @Size(max = 50)
    @Column(name = "FechaResolucion")
    private String fechaResolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @Size(max = 50)
    @Column(name = "FechaFinResolucion")
    private String fechaFinResolucion;
    @JoinColumn(name = "IdModulo", referencedColumnName = "IdModulo")
    @ManyToOne
    private TConfiguracion idModulo;
    @JoinColumn(name = "IdSede", referencedColumnName = "IdSede")
    @ManyToOne
    private TSedes idSede;

    public TFacturacion() {
    }

    public TFacturacion(Long idFacturacion) {
        this.idFacturacion = idFacturacion;
    }

    public TFacturacion(Long idFacturacion, boolean estado) {
        this.idFacturacion = idFacturacion;
        this.estado = estado;
    }

    public Long getIdFacturacion() {
        return idFacturacion;
    }

    public void setIdFacturacion(Long idFacturacion) {
        this.idFacturacion = idFacturacion;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getFacturaInicial() {
        return facturaInicial;
    }

    public void setFacturaInicial(String facturaInicial) {
        this.facturaInicial = facturaInicial;
    }

    public String getFacturaFinal() {
        return facturaFinal;
    }

    public void setFacturaFinal(String facturaFinal) {
        this.facturaFinal = facturaFinal;
    }

    public String getFacturaActual() {
        return facturaActual;
    }

    public void setFacturaActual(String facturaActual) {
        this.facturaActual = facturaActual;
    }

    public String getNumeroResolucion() {
        return numeroResolucion;
    }

    public void setNumeroResolucion(String numeroResolucion) {
        this.numeroResolucion = numeroResolucion;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFechaFinResolucion() {
        return fechaFinResolucion;
    }

    public void setFechaFinResolucion(String fechaFinResolucion) {
        this.fechaFinResolucion = fechaFinResolucion;
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
        hash += (idFacturacion != null ? idFacturacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TFacturacion)) {
            return false;
        }
        TFacturacion other = (TFacturacion) object;
        if ((this.idFacturacion == null && other.idFacturacion != null) || (this.idFacturacion != null && !this.idFacturacion.equals(other.idFacturacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TFacturacion[ idFacturacion=" + idFacturacion + " ]";
    }
    
}
