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
 * @author matc_
 */
@Entity
@Table(name = "T_Parametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TParametros.findAll", query = "SELECT t FROM TParametros t")
    , @NamedQuery(name = "TParametros.findByIdParametro", query = "SELECT t FROM TParametros t WHERE t.idParametro = :idParametro")
    , @NamedQuery(name = "TParametros.findByCodigo", query = "SELECT t FROM TParametros t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TParametros.findByValor", query = "SELECT t FROM TParametros t WHERE t.valor = :valor")
    , @NamedQuery(name = "TParametros.findByDescripcion", query = "SELECT t FROM TParametros t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TParametros.findByEstado", query = "SELECT t FROM TParametros t WHERE t.estado = :estado")
    , @NamedQuery(name = "TParametros.findBySincronizacion", query = "SELECT t FROM TParametros t WHERE t.sincronizacion = :sincronizacion")})
public class TParametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdParametro")
    private Long idParametro;
    @Size(max = 50)
    @Column(name = "Codigo")
    private String codigo;
    @Size(max = 300)
    @Column(name = "Valor")
    private String valor;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
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

    public TParametros() {
    }

    public TParametros(Long idParametro) {
        this.idParametro = idParametro;
    }

    public TParametros(Long idParametro, boolean estado, boolean sincronizacion) {
        this.idParametro = idParametro;
        this.estado = estado;
        this.sincronizacion = sincronizacion;
    }

    public Long getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Long idParametro) {
        this.idParametro = idParametro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TParametros)) {
            return false;
        }
        TParametros other = (TParametros) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValueObject.TParametros[ idParametro=" + idParametro + " ]";
    }
    
}
