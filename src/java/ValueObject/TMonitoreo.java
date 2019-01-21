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
@Table(name = "T_Monitoreo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMonitoreo.findAll", query = "SELECT t FROM TMonitoreo t")
    , @NamedQuery(name = "TMonitoreo.findByIdModulo", query = "SELECT t FROM TMonitoreo t WHERE t.idModulo = :idModulo")
    , @NamedQuery(name = "TMonitoreo.findByEstadoPantalla", query = "SELECT t FROM TMonitoreo t WHERE t.estadoPantalla = :estadoPantalla")
    , @NamedQuery(name = "TMonitoreo.findByFechaReporte", query = "SELECT t FROM TMonitoreo t WHERE t.fechaReporte = :fechaReporte")})
@SqlResultSetMapping(
        name = "mapeoMonitoreo", classes = @ConstructorResult(targetClass = TMonitoreoHoras.class, columns = {
    @ColumnResult(name = "modulo", type = String.class)
    ,
                    @ColumnResult(name = "estado", type = String.class)
    ,
                    @ColumnResult(name = "dateFinal", type = String.class)

}))
public class TMonitoreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IdModulo")
    private String idModulo;
    @Size(max = 50)
    @Column(name = "EstadoPantalla")
    private String estadoPantalla;
    @Column(name = "FechaReporte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReporte;

    public TMonitoreo() {
    }

    public TMonitoreo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getEstadoPantalla() {
        return estadoPantalla;
    }

    public void setEstadoPantalla(String estadoPantalla) {
        this.estadoPantalla = estadoPantalla;
    }

    public Date getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(Date fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModulo != null ? idModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMonitoreo)) {
            return false;
        }
        TMonitoreo other = (TMonitoreo) object;
        if ((this.idModulo == null && other.idModulo != null) || (this.idModulo != null && !this.idModulo.equals(other.idModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TMonitoreo[ idModulo=" + idModulo + " ]";
    }

}
