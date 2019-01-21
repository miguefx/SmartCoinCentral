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
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede1", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede1 = :sincronizacionSede1")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede2", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede2 = :sincronizacionSede2")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede3", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede3 = :sincronizacionSede3")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede4", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede4 = :sincronizacionSede4")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede5", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede5 = :sincronizacionSede5")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede6", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede6 = :sincronizacionSede6")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede7", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede7 = :sincronizacionSede7")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede8", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede8 = :sincronizacionSede8")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede9", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede9 = :sincronizacionSede9")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede10", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede10 = :sincronizacionSede10")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede11", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede11 = :sincronizacionSede11")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede12", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede12 = :sincronizacionSede12")
    , @NamedQuery(name = "TUsuarios.findBySincronizacionSede13", query = "SELECT t FROM TUsuarios t WHERE t.sincronizacionSede13 = :sincronizacionSede13")})
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SincronizacionSede1")
    private boolean sincronizacionSede1;
    @Column(name = "SincronizacionSede2")
    private Boolean sincronizacionSede2;
    @Column(name = "SincronizacionSede3")
    private Boolean sincronizacionSede3;
    @Column(name = "SincronizacionSede4")
    private Boolean sincronizacionSede4;
    @Column(name = "SincronizacionSede5")
    private Boolean sincronizacionSede5;
    @Column(name = "SincronizacionSede6")
    private Boolean sincronizacionSede6;
    @Column(name = "SincronizacionSede7")
    private Boolean sincronizacionSede7;
    @Column(name = "SincronizacionSede8")
    private Boolean sincronizacionSede8;
    @Column(name = "SincronizacionSede9")
    private Boolean sincronizacionSede9;
    @Column(name = "SincronizacionSede10")
    private Boolean sincronizacionSede10;
    @Column(name = "SincronizacionSede11")
    private Boolean sincronizacionSede11;
    @Column(name = "SincronizacionSede12")
    private Boolean sincronizacionSede12;
    @Column(name = "SincronizacionSede13")
    private Boolean sincronizacionSede13;
    @JoinColumn(name = "IdEmpresa", referencedColumnName = "IdEmpresa")
    @ManyToOne
    private TEmpresas idEmpresa;

    public TUsuarios() {
    }

    public TUsuarios(Long documento) {
        this.documento = documento;
    }

    public TUsuarios(Long documento, long idUsuario, boolean estado, boolean sincronizacionSede1) {
        this.documento = documento;
        this.idUsuario = idUsuario;
        this.estado = estado;
        this.sincronizacionSede1 = sincronizacionSede1;
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getSincronizacionSede1() {
        return sincronizacionSede1;
    }

    public void setSincronizacionSede1(boolean sincronizacionSede1) {
        this.sincronizacionSede1 = sincronizacionSede1;
    }

    public Boolean getSincronizacionSede2() {
        return sincronizacionSede2;
    }

    public void setSincronizacionSede2(Boolean sincronizacionSede2) {
        this.sincronizacionSede2 = sincronizacionSede2;
    }

    public Boolean getSincronizacionSede3() {
        return sincronizacionSede3;
    }

    public void setSincronizacionSede3(Boolean sincronizacionSede3) {
        this.sincronizacionSede3 = sincronizacionSede3;
    }

    public Boolean getSincronizacionSede4() {
        return sincronizacionSede4;
    }

    public void setSincronizacionSede4(Boolean sincronizacionSede4) {
        this.sincronizacionSede4 = sincronizacionSede4;
    }

    public Boolean getSincronizacionSede5() {
        return sincronizacionSede5;
    }

    public void setSincronizacionSede5(Boolean sincronizacionSede5) {
        this.sincronizacionSede5 = sincronizacionSede5;
    }

    public Boolean getSincronizacionSede6() {
        return sincronizacionSede6;
    }

    public void setSincronizacionSede6(Boolean sincronizacionSede6) {
        this.sincronizacionSede6 = sincronizacionSede6;
    }

    public Boolean getSincronizacionSede7() {
        return sincronizacionSede7;
    }

    public void setSincronizacionSede7(Boolean sincronizacionSede7) {
        this.sincronizacionSede7 = sincronizacionSede7;
    }

    public Boolean getSincronizacionSede8() {
        return sincronizacionSede8;
    }

    public void setSincronizacionSede8(Boolean sincronizacionSede8) {
        this.sincronizacionSede8 = sincronizacionSede8;
    }

    public Boolean getSincronizacionSede9() {
        return sincronizacionSede9;
    }

    public void setSincronizacionSede9(Boolean sincronizacionSede9) {
        this.sincronizacionSede9 = sincronizacionSede9;
    }

    public Boolean getSincronizacionSede10() {
        return sincronizacionSede10;
    }

    public void setSincronizacionSede10(Boolean sincronizacionSede10) {
        this.sincronizacionSede10 = sincronizacionSede10;
    }

    public Boolean getSincronizacionSede11() {
        return sincronizacionSede11;
    }

    public void setSincronizacionSede11(Boolean sincronizacionSede11) {
        this.sincronizacionSede11 = sincronizacionSede11;
    }

    public Boolean getSincronizacionSede12() {
        return sincronizacionSede12;
    }

    public void setSincronizacionSede12(Boolean sincronizacionSede12) {
        this.sincronizacionSede12 = sincronizacionSede12;
    }

    public Boolean getSincronizacionSede13() {
        return sincronizacionSede13;
    }

    public void setSincronizacionSede13(Boolean sincronizacionSede13) {
        this.sincronizacionSede13 = sincronizacionSede13;
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
