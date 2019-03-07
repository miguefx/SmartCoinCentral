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
import javax.faces.event.ActionEvent;

/**
 *
 * @author miguel
 */
@Named(value = "beanMonitoreo")
@ViewScoped
public class beanMonitoreo implements Serializable {

    @EJB
    TMonitoreoFacade objDaoMonitoreo;
    @EJB
    TCiudadesFacade objDaoCiudades;
    @EJB
    TConfiguracionFacade objDaoConfiguracion;

    private Boolean color;
    private Boolean pollPrincipal;
    private Boolean pollRestringido;
    private TMonitoreo objVoMonitoreo;
    private Long valorSedeIgual;
    private String valorModulo;
    private List<TConfiguracion> listModulos;
    private List<TCiudades> listSedes;

    public Long getValorSedeIgual() {
        return valorSedeIgual;
    }

    public void setValorSedeIgual(Long valorSedeIgual) {
        this.valorSedeIgual = valorSedeIgual;
    }

    public String getValorModulo() {
        return valorModulo;
    }

    public void setValorModulo(String valorModulo) {
        this.valorModulo = valorModulo;
    }

    public List<TConfiguracion> getListModulos() {
        return listModulos;
    }

    public void setListModulos(List<TConfiguracion> listModulos) {
        this.listModulos = listModulos;
    }

    public List<TCiudades> getListSedes() {
        listSedes = objDaoCiudades.listaCiudadesPermisos();
        return listSedes;
    }

    public void setListSedes(List<TCiudades> listSedes) {
        this.listSedes = listSedes;
    }

    public beanMonitoreo() {
    }

    @PostConstruct
    public void init() {
        objVoMonitoreo = new TMonitoreo();
        listMonitoreo = objDaoMonitoreo.listMonitoreo(objVoMonitoreo, null, null);
    }

    private List<TMonitoreoHoras> listMonitoreo;
    private List<TMonitoreoHoras> listMonitoreoFiltrer;

    private String estadoElegido;

    public List<TMonitoreoHoras> getListMonitoreoFiltrer() {
        return listMonitoreoFiltrer;
    }

    public String getEstadoElegido() {
        return estadoElegido;
    }

    public void setEstadoElegido(String estadoElegido) {
        this.estadoElegido = estadoElegido;
    }

    public void setListMonitoreoFiltrer(List<TMonitoreoHoras> listMonitoreoFiltrer) {
        this.listMonitoreoFiltrer = listMonitoreoFiltrer;
    }

    public Boolean getPollPrincipal() {
        return pollPrincipal;
    }

    public void setPollPrincipal(Boolean pollPrincipal) {
        this.pollPrincipal = pollPrincipal;
    }

    public Boolean getPollRestringido() {
        return pollRestringido;
    }

    public void setPollRestringido(Boolean pollRestringido) {
        this.pollRestringido = pollRestringido;
    }

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

    public void actualizarTabla() {
        try {
            objVoMonitoreo = new TMonitoreo();
            objVoMonitoreo.setEstadoPantalla(estadoElegido);
            listMonitoreo = objDaoMonitoreo.listMonitoreo(objVoMonitoreo, valorModulo, valorSedeIgual);
        } catch (Exception e) {
        }
    }

    public String calculaColor(String estado) {
        try {
            if (estado.equals("EN LINEA")) {
                return "#01DF01";
            } else if (estado.equals("MENU SISTEMA")) {
                return "#FE9A2E";
            } else {
                return "#FE0505";
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void changeMenu(ActionEvent egt) {
        try {
            if (valorSedeIgual == null && !listModulos.isEmpty()) {
                listModulos.clear();
            } else {
                listModulos = objDaoConfiguracion.listModulos(valorSedeIgual);
            }

        } catch (Exception e) {
        }
    }
}
