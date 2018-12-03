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
 * @author matc_
 */
@Entity
@Table(name = "T_Sedes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSedes.findAll", query = "SELECT t FROM TSedes t")
    , @NamedQuery(name = "TSedes.findByIdSede", query = "SELECT t FROM TSedes t WHERE t.idSede = :idSede")
    , @NamedQuery(name = "TSedes.findByNombre", query = "SELECT t FROM TSedes t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TSedes.findByDireccion", query = "SELECT t FROM TSedes t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TSedes.findByUsuarioAsigando", query = "SELECT t FROM TSedes t WHERE t.usuarioAsigando = :usuarioAsigando")
    , @NamedQuery(name = "TSedes.findByTelefonoContacto", query = "SELECT t FROM TSedes t WHERE t.telefonoContacto = :telefonoContacto")
    , @NamedQuery(name = "TSedes.findByEstado", query = "SELECT t FROM TSedes t WHERE t.estado = :estado")})
public class TSedes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdSede")
    private Long idSede;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "UsuarioAsigando")
    private String usuarioAsigando;
    @Size(max = 50)
    @Column(name = "TelefonoContacto")
    private String telefonoContacto;
    @Column(name = "Estado")
    private Boolean estado;
    @OneToMany(mappedBy = "idSede")
    private List<TCargas> tCargasList;
    @OneToMany(mappedBy = "idSede")
    private List<TEventos> tEventosList;
    @OneToMany(mappedBy = "idSede")
    private List<TAlarmas> tAlarmasList;
    @OneToMany(mappedBy = "idSede")
    private List<TConfiguracion> tConfiguracionList;
    @OneToMany(mappedBy = "idSede")
    private List<TPartes> tPartesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSede")
    private List<TTransacciones> tTransaccionesList;
    @OneToMany(mappedBy = "idSede")
    private List<TParametros> tParametrosList;
    @OneToMany(mappedBy = "idSede")
    private List<TArqueos> tArqueosList;
    @JoinColumn(name = "IdCiudad", referencedColumnName = "IDCIUDAD")
    @ManyToOne(optional = false)
    private TCiudades idCiudad;
    @JoinColumn(name = "IdPais", referencedColumnName = "IDPAIS")
    @ManyToOne(optional = false)
    private TPaises idPais;
    @OneToMany(mappedBy = "idSede")
    private List<TFacturacion> tFacturacionList;

    public TSedes() {
    }

    public TSedes(Long idSede) {
        this.idSede = idSede;
    }

    public TSedes(Long idSede, String nombre, String usuarioAsigando) {
        this.idSede = idSede;
        this.nombre = nombre;
        this.usuarioAsigando = usuarioAsigando;
    }

    public Long getIdSede() {
        return idSede;
    }

    public void setIdSede(Long idSede) {
        this.idSede = idSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuarioAsigando() {
        return usuarioAsigando;
    }

    public void setUsuarioAsigando(String usuarioAsigando) {
        this.usuarioAsigando = usuarioAsigando;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
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

    @XmlTransient
    public List<TConfiguracion> getTConfiguracionList() {
        return tConfiguracionList;
    }

    public void setTConfiguracionList(List<TConfiguracion> tConfiguracionList) {
        this.tConfiguracionList = tConfiguracionList;
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

    public TCiudades getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(TCiudades idCiudad) {
        this.idCiudad = idCiudad;
    }

    public TPaises getIdPais() {
        return idPais;
    }

    public void setIdPais(TPaises idPais) {
        this.idPais = idPais;
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
        hash += (idSede != null ? idSede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSedes)) {
            return false;
        }
        TSedes other = (TSedes) object;
        if ((this.idSede == null && other.idSede != null) || (this.idSede != null && !this.idSede.equals(other.idSede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TSedes[ idSede=" + idSede + " ]";
    }
    
}
