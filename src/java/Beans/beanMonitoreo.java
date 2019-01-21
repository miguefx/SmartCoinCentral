/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import ValueObject.*;
import DataAccessObject.*;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author miguel
 */
@Named(value = "beanMonitoreo")
@ViewScoped
public class beanMonitoreo implements Serializable {

    @EJB
    TMonitoreoFacade objDaoMonitoreo;
    
    
    
    private Boolean color;
    
    
    

    public beanMonitoreo() {
    }

    @PostConstruct
    public void init() {
        listMonitoreo = objDaoMonitoreo.listMonitoreo();
    }

    private List<TMonitoreoHoras> listMonitoreo;

    public Boolean getColor() {
        return color;
    }

    public void setColor(Boolean color) {
        this.color = color;
    }

    
    
    public List<TMonitoreoHoras> getListMonitoreo() {
        return listMonitoreo;
    }

    public void setListMonitoreo(List<TMonitoreoHoras> listMonitoreo) {
        this.listMonitoreo = listMonitoreo;
    }
    
    
    public void actualizarTabla()
    {
        try {
            listMonitoreo=objDaoMonitoreo.listMonitoreo();
        } catch (Exception e) {
        }
    }
    
    
    public String calculaColor(String estado)
    {
        try {
            if (estado.equals("EN LINEA")) {
                return "#01DF01";
            }
            else 
            {
            return "#FE0505";
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
    

}
