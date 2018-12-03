/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.util.Date;

/**
 *
 * @author matc_
 */
public class TReporteArqueosExcel {
    
    private Long idArqueo ;

    public Long getIdArqueo() {
        return idArqueo;
    }

    public void setIdArqueo(Long idArqueo) {
        this.idArqueo = idArqueo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public Integer getCantTransacciones() {
        return cantTransacciones;
    }

    public void setCantTransacciones(Integer cantTransacciones) {
        this.cantTransacciones = cantTransacciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    private Date fechaInicio;
    private String usuario;
    private String idModulo;
    private Integer cantTransacciones;
    private String tipo;
    private String sede;
    private Date fechaFin;
    
}
