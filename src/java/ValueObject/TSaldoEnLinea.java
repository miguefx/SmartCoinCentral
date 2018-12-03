/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

/**
 *
 * @author matc_
 */
public class TSaldoEnLinea {
    
    
    private Integer cantidadActual;
    private Double denominacion;
    private String nombreParte;
    private Double dineroActual;
    private String tipoParte;

    public TSaldoEnLinea(Integer cantidadActual, Double denominacion, String nombreParte, Double dineroActual, String tipoParte) {
        this.cantidadActual = cantidadActual;
        this.denominacion = denominacion;
        this.nombreParte = nombreParte;
        this.dineroActual = dineroActual;
        this.tipoParte = tipoParte;
    }
    
    
    

    public String getTipoParte() {
        return tipoParte;
    }

    public void setTipoParte(String tipoParte) {
        this.tipoParte = tipoParte;
    }


    
    
    
    public Double getDineroActual() {
        return dineroActual;
    }

    public void setDineroActual(Double dineroActual) {
        this.dineroActual = dineroActual;
    }

  
    public Double getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(Double denominacion) {
        this.denominacion = denominacion;
    }

  
    

    

    public Integer getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Integer cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public String getNombreParte() {
        return nombreParte;
    }

    public void setNombreParte(String nombreParte) {
        this.nombreParte = nombreParte;
    }
    
    
    
}
