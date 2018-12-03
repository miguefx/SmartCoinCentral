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
public class Permisos {
    
    private String nombrePermiso;
    private Boolean estado;

    public Permisos(String nombrePermiso, Boolean estado) {
        this.nombrePermiso = nombrePermiso;
        this.estado = estado;
    }
    
    
    

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
