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
 * @author miguel
 */
@Entity
@Table(name = "T_Eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEventos.findAll", query = "SELECT t FROM TEventos t")
    , @NamedQuery(name = "TEventos.findByIdEvento", query = "SELECT t FROM TEventos t WHERE t.idEvento = :idEvento")
    , @NamedQuery(name = "TEventos.findByEvento", query = "SELECT t FROM TEventos t WHERE t.evento = :evento")
    , @NamedQuery(name = "TEventos.findByFechaEvento", query = "SELECT t FROM TEventos t WHERE t.fechaEvento = :fechaEvento")
    , @NamedQuery(name = "TEventos.findBySincronizacion", query = "SELECT t FROM TEventos t WHERE t.sincronizacion = :sincronizacion")})
public class TEventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEvento")
    private Long idEvento;
    @Size(max = 50)
    @Column(name = "Evento")
    private String evento;
    @Column(name = "FechaEvento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sincronizacion")
    private boolean sincronizacion;
    @JoinColumn(name = "IdModulo", referencedColumnName = "IdModulo")
    @ManyToOne
    private TConfiguracion idModulo;
    @JoinColumn(name = "IdSede", referencedColumnName = "IdSede")
    @ManyToOne
    private TSedes idSede;
    @JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne
    private TUsuarios idUsuario;

    public TEventos() {
    }

    public TEventos(Long idEvento) {
        this.idEvento = idEvento;
    }

    public TEventos(Long idEvento, boolean sincronizacion) {
        this.idEvento = idEvento;
        this.sincronizacion = sincronizacion;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
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

    public TUsuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TUsuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEventos)) {
            return false;
        }
        TEventos other = (TEventos) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TEventos[ idEvento=" + idEvento + " ]";
    }
    
}
