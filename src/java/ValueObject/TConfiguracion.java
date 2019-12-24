/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "T_Configuracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TConfiguracion.findAll", query = "SELECT t FROM TConfiguracion t")
    , @NamedQuery(name = "TConfiguracion.findByIdModulo", query = "SELECT t FROM TConfiguracion t WHERE t.idModulo = :idModulo")
    , @NamedQuery(name = "TConfiguracion.findByIp", query = "SELECT t FROM TConfiguracion t WHERE t.ip = :ip")
    , @NamedQuery(name = "TConfiguracion.findByMac", query = "SELECT t FROM TConfiguracion t WHERE t.mac = :mac")
    , @NamedQuery(name = "TConfiguracion.findByExtension", query = "SELECT t FROM TConfiguracion t WHERE t.extension = :extension")
    , @NamedQuery(name = "TConfiguracion.findByEstado", query = "SELECT t FROM TConfiguracion t WHERE t.estado = :estado")})
public class TConfiguracion implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModulo")
    private List<TRecargas> tRecargasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModulo")
    private List<TCambio> tCambioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModulo")
    private List<TDonaciones> tDonacionesList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IdModulo")
    private String idModulo;
    @Size(max = 50)
    @Column(name = "IP")
    private String ip;
    @Size(max = 50)
    @Column(name = "MAC")
    private String mac;
    @Column(name = "Extension")
    private Integer extension;
    @Column(name = "Estado")
    private Boolean estado;
    @OneToMany(mappedBy = "idModulo")
    private List<TCargas> tCargasList;
    @OneToMany(mappedBy = "idModulo")
    private List<TEventos> tEventosList;
    @OneToMany(mappedBy = "idModulo")
    private List<TAlarmas> tAlarmasList;
    @JoinColumn(name = "IdSede", referencedColumnName = "IdSede")
    @ManyToOne
    private TSedes idSede;
    @JoinColumn(name = "IdTipoModulo", referencedColumnName = "IdTipoModulo")
    @ManyToOne
    private TTipoModulo idTipoModulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModulo")
    private List<TPartes> tPartesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModulo")
    private List<TTransacciones> tTransaccionesList;
    @OneToMany(mappedBy = "idModulo")
    private List<TParametros> tParametrosList;
    @OneToMany(mappedBy = "idModulo")
    private List<TArqueos> tArqueosList;
    @OneToMany(mappedBy = "idModulo")
    private List<TFacturacion> tFacturacionList;

    public TConfiguracion() {
    }

    public TConfiguracion(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getIdModulo() {
        
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<TCargas> getTCargasList() {
        return tCargasList;
    }

    public void setTCargasList(List<TCargas> tCargasList) {
        this.tCargasList = tCargasList;
    }

    @XmlTransient
    public List<TEventos> getTEventosList() {
        return tEventosList;
    }

    public void setTEventosList(List<TEventos> tEventosList) {
        this.tEventosList = tEventosList;
    }

    @XmlTransient
    public List<TAlarmas> getTAlarmasList() {
        return tAlarmasList;
    }

    public void setTAlarmasList(List<TAlarmas> tAlarmasList) {
        this.tAlarmasList = tAlarmasList;
    }

    public TSedes getIdSede() {
        return idSede;
    }

    public void setIdSede(TSedes idSede) {
        this.idSede = idSede;
    }

    public TTipoModulo getIdTipoModulo() {
        return idTipoModulo;
    }

    public void setIdTipoModulo(TTipoModulo idTipoModulo) {
        this.idTipoModulo = idTipoModulo;
    }

    @XmlTransient
    public List<TPartes> getTPartesList() {
        return tPartesList;
    }

    public void setTPartesList(List<TPartes> tPartesList) {
        this.tPartesList = tPartesList;
    }

    @XmlTransient
    public List<TTransacciones> getTTransaccionesList() {
        return tTransaccionesList;
    }

    public void setTTransaccionesList(List<TTransacciones> tTransaccionesList) {
        this.tTransaccionesList = tTransaccionesList;
    }

    @XmlTransient
    public List<TParametros> getTParametrosList() {
        return tParametrosList;
    }

    public void setTParametrosList(List<TParametros> tParametrosList) {
        this.tParametrosList = tParametrosList;
    }

    @XmlTransient
    public List<TArqueos> getTArqueosList() {
        return tArqueosList;
    }

    public void setTArqueosList(List<TArqueos> tArqueosList) {
        this.tArqueosList = tArqueosList;
    }

    @XmlTransient
    public List<TFacturacion> getTFacturacionList() {
        return tFacturacionList;
    }

    public void setTFacturacionList(List<TFacturacion> tFacturacionList) {
        this.tFacturacionList = tFacturacionList;
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
        if (!(object instanceof TConfiguracion)) {
            return false;
        }
        TConfiguracion other = (TConfiguracion) object;
        if ((this.idModulo == null && other.idModulo != null) || (this.idModulo != null && !this.idModulo.equals(other.idModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TConfiguracion[ idModulo=" + idModulo + " ]";
    }

    @XmlTransient
    public List<TRecargas> getTRecargasList() {
        return tRecargasList;
    }

    public void setTRecargasList(List<TRecargas> tRecargasList) {
        this.tRecargasList = tRecargasList;
    }

    @XmlTransient
    public List<TCambio> getTCambioList() {
        return tCambioList;
    }

    public void setTCambioList(List<TCambio> tCambioList) {
        this.tCambioList = tCambioList;
    }

    @XmlTransient
    public List<TDonaciones> getTDonacionesList() {
        return tDonacionesList;
    }

    public void setTDonacionesList(List<TDonaciones> tDonacionesList) {
        this.tDonacionesList = tDonacionesList;
    }
    
}
