/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import DataAccessObject.*;
import ValueObject.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Instance;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
 *
 * @author matc_
 */
@ManagedBean
@SessionScoped
public class beanAlarma implements Serializable {

    @PostConstruct
    public void init() {
        listAlarma = objDaoAlarmas.listAlarmas(cedulaEnSession, "Alarmas");
    }

    @Inject
    transient Instance<FacesContext> facesContext;

    @EJB
    TAlarmasFacade objDaoAlarmas;

    private TAlarmas objVOAlarmas;

    private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    List<TAlarmas> listAlarma;
    List<TAlarmas> listAlarmaHistorico;
    List<TAlarmas> listalarmasSolicitudes;
    List<TAlarmas> listalarmasMenu;
    List<TAlarmas> listalarmasUpdate;
    List<TAlarmas> listalarmasHaceUnaSemana;
    List<TAlarmas> listFiltrer;
    private Date dateInicio;
    private Date dateFin;

    private static int alarmasNuevas = 0;

    public Date getDateInicio() {
        return dateInicio;
    }

    public void setDateInicio(Date dateInicio) {
        this.dateInicio = dateInicio;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getAlarmasNuevas() {
        return alarmasNuevas;
    }

    public List<TAlarmas> getListFiltrer() {
        return listFiltrer;
    }

    public void setListFiltrer(List<TAlarmas> listFiltrer) {
        this.listFiltrer = listFiltrer;
    }

    public void setAlarmasNuevas(int alarmasNuevas) {
        this.alarmasNuevas = alarmasNuevas;
    }

    public List<TAlarmas> getListalarmasHaceUnaSemana() {
        listalarmasHaceUnaSemana = objDaoAlarmas.actualizarTablaSemana();
        return listalarmasHaceUnaSemana;
    }

    public void setListalarmasHaceUnaSemana(List<TAlarmas> listalarmasHaceUnaSemana) {
        this.listalarmasHaceUnaSemana = listalarmasHaceUnaSemana;
    }

    public List<TAlarmas> getListalarmasMenu() {
        listalarmasMenu = objDaoAlarmas.actualizarTablaMensual();
        return listalarmasMenu;
    }

    public void setListalarmasMenu(List<TAlarmas> listalarmasMenu) {
        this.listalarmasMenu = listalarmasMenu;
    }
    private static Date fechaInicial;
    private static Date fechaFinal;
    private TAlarmas alarmaSelected;

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public List<TAlarmas> getListAlarma() {
        return listAlarma;
    }

    public void setListAlarma(List<TAlarmas> listAlarma) {
        this.listAlarma = listAlarma;
    }

    public List<TAlarmas> getListAlarmaHistorico() {
        return listAlarmaHistorico;
    }

    public void setListAlarmaHistorico(List<TAlarmas> listAlarmaHistorico) {
        this.listAlarmaHistorico = listAlarmaHistorico;
    }

    public List<TAlarmas> getListalarmasSolicitudes() {
        return listalarmasSolicitudes;
    }

    public void setListalarmasSolicitudes(List<TAlarmas> listalarmasSolicitudes) {
        this.listalarmasSolicitudes = listalarmasSolicitudes;
    }

    public List<TAlarmas> getListalarmasUpdate() {

        return listalarmasUpdate;
    }

    public void setListalarmasUpdate(List<TAlarmas> listalarmasUpdate) {
        this.listalarmasUpdate = listalarmasUpdate;
    }

    public void actualizarTabla(ActionEvent egt) {
        try {
            if (fechaFinal.before(fechaInicial)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La fecha inicial debe ser menor que la fecha final", ""));

            } else if (fechaInicial.after(new Date()) && fechaFinal.after(new Date())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Las fechas no pueden superar la fecha actual", ""));
            } else {
                listAlarmaHistorico = objDaoAlarmas.actualizarTabla(fechaInicial, fechaFinal, cedulaEnSession, "Alarmas");
            }

        } catch (Exception e) {
        }
    }

    public void actualizarAlarma(ActionEvent egt) {
        try {
            objVOAlarmas = new TAlarmas();
            objVOAlarmas = objDaoAlarmas.find(alarmaSelected.getIdAlarma());
            objVOAlarmas.setObservacion(observacion);
            objDaoAlarmas.edit(objVOAlarmas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bien", "Se actualizo la alarma"));

        } catch (Exception e) {
        }
    }

    
    public void limpiar(ActionEvent egt)
    {
        try {
            fechaFinal=null;
            fechaInicial=null;
            alarmasFiltro(egt);
        } catch (Exception e) {
        }
    }
    public void alarmasFiltro(ActionEvent egt) {
        try {
            if (fechaInicial == null && fechaFinal == null) {
                listAlarma = objDaoAlarmas.listAlarmas(cedulaEnSession, "Alarmas");
            } else if (fechaInicial == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "Debe llenar el campo fecha inicial"));
            }

            if (fechaInicial != null || fechaFinal != null) {
                if (fechaFinal.before(fechaInicial)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La fecha inicial debe ser menor que la fecha final", ""));
                } else if (fechaInicial.after(new Date()) && fechaFinal.after(new Date())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Las fechas no pueden superar la fecha actual", ""));
                } else {
                    listAlarma = objDaoAlarmas.listAlarmasFiltrer(cedulaEnSession, "Alarmas", fechaInicial, fechaFinal);
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Creates a new instance of beanAlarma
     */
    private static Long cedulaEnSession;

    public beanAlarma() {
        cedulaEnSession = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cedula");
    }

    public TAlarmas getAlarmaSelected() {
        return alarmaSelected;
    }

    public void setAlarmaSelected(TAlarmas alarmaSelected) {
        this.alarmaSelected = alarmaSelected;
    }

    public void alarmaNueva(ActionEvent egt) {
        try {
            listalarmasUpdate = objDaoAlarmas.alarmasNuevas();
            for (int i = 0; i < listalarmasUpdate.size(); i++) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nueva alarma", "" + listalarmasUpdate.get(i).getDescripcion()));
            }
            alarmasNuevas = listalarmasUpdate.size();

        } catch (Exception e) {
        }
    }

}
