/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author matc_
 */
@Entity
@Table(name = "T_Usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUsuarios.findAll", query = "SELECT t FROM TUsuarios t")
    , @NamedQuery(name = "TUsuarios.findByIdUsuario", query = "SELECT t FROM TUsuarios t WHERE t.idUsuario = :idUsuario")
    , @NamedQuery(name = "TUsuarios.findByDocumento", query = "SELECT t FROM TUsuarios t WHERE t.documento = :documento")
    , @NamedQuery(name = "TUsuarios.findByNombres", query = "SELECT t FROM TUsuarios t WHERE t.nombres = :nombres")
    , @NamedQuery(name = "TUsuarios.findByApellidos", query = "SELECT t FROM TUsuarios t WHERE t.apellidos = :apellidos")
    , @NamedQuery(name = "TUsuarios.findByUsuario", query = "SELECT t FROM TUsuarios t WHERE t.usuario = :usuario")
    , @NamedQuery(name = "TUsuarios.findByContrase\u00f1a", query = "SELECT t FROM TUsuarios t WHERE t.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "TUsuarios.findByCargo", query = "SELECT t FROM TUsuarios t WHERE t.cargo = :cargo")
    , @NamedQuery(name = "TUsuarios.findByUsuarioCreador", query = "SELECT t FROM TUsuarios t WHERE t.usuarioCreador = :usuarioCreador")
    , @NamedQuery(name = "TUsuarios.findByFechaCreacion", query = "SELECT t FROM TUsuarios t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "TUsuarios.findByEstado", query = "SELECT t FROM TUsuarios t WHERE t.estado = :estado")
    , @NamedQuery(name = "TUsuarios.findBySincronizacion", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacion = :sincronizacion")})
public class TUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdUsuario")
    private long idUsuario;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Documento")
    private Long documento;
    @Size(max = 50)
    @Column(name = "Nombres")
    private String nombres;
    @Size(max = 50)
    @Column(name = "Apellidos")
    private String apellidos;
    @Size(max = 50)
    @Column(name = "Usuario")
    private String usuario;
    @Size(max = 50)
    @Column(name = "Contrase\u00f1a")
    private String contraseña;
    @Size(max = 50)
    @Column(name = "Cargo")
    private String cargo;
    @Size(max = 50)
    @Column(name = "UsuarioCreador")
    private String usuarioCreador;
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "Estado")
    private Boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sincronizacion")
    private boolean sincronizacion;
    @OneToMany(mappedBy = "idUsuario")
    private List<TEventos> tEventosList;
    @JoinColumn(name = "IdEmpresa", referencedColumnName = "IdEmpresa")
    @ManyToOne
    private TEmpresas idEmpresa;

    public TUsuarios() {
    }

    public TUsuarios(Long documento) {
        this.documento = documento;
    }

    public TUsuarios(Long documento, long idUsuario, boolean sincronizacion) {
        this.documento = documento;
        this.idUsuario = idUsuario;
        this.sincronizacion = sincronizacion;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public boolean getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(boolean sincronizacion) {
        this.sincronizacion = sincronizacion;
    }

    @XmlTransient
    public List<TEventos> getTEventosList() {
        return tEventosList;
    }

    public void setTEventosList(List<TEventos> tEventosList) {
        this.tEventosList = tEventosList;
    }

    public TEmpresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(TEmpresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documento != null ? documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUsuarios)) {
            return false;
        }
        TUsuarios other = (TUsuarios) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TUsuarios[ documento=" + documento + " ]";
    }
    
}
