/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.text.DecimalFormat;

/**
 *
 * @author matc_
 */
public class TmovimientosTable {

    private String parte;
    private Double denominacion;
    private Integer cantidad;
    private String accion;
    private Long idTransaccion;

    public TmovimientosTable(String parte, Double denominacion, Integer cantidad, String accion, Long idTransaccion, Double valor) {
        this.parte = parte;
        this.denominacion = denominacion;
        this.cantidad = cantidad;
        this.accion = accion;
        this.idTransaccion = idTransaccion;
        this.valor = valor;
    }
    
    
    
    

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }




    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    public Double getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(Double denominacion) {
        this.denominacion = denominacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    private Double valor;
}
