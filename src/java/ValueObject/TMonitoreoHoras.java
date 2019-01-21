/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

/**
 *
 * @author miguel
 */
public class TMonitoreoHoras {
    
     private String modulo;
     private String estado;
     private String dateFinal;

    public TMonitoreoHoras(String modulo, String estado, String dateFinal) {
        this.modulo = modulo;
        this.estado = estado;
        this.dateFinal = dateFinal;
    }
     
     

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(String dateFinal) {
        this.dateFinal = dateFinal;
    }
     
     

 
     
     
     
    
    
}
