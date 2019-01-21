/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Beans;

import DataAccessObject.*;
import ValueObject.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean(name = "beanCarga")
@ViewScoped
public class beanCarga implements Serializable {

    @EJB
    TSedesFacade objDaoSede;

    @EJB
    TMovimientosFacade objDaoMovimientos;

    @EJB
    TCargasFacade objDaoCarga;

    @EJB
    TArqueosFacade objDaoArqueos;

    @EJB
    TConfiguracionFacade objDaoConfiguracion;

    @EJB
    TTransaccionesFacade objDaoTransacciones;

    @EJB
    TCiudadesFacade objDaoCiudades;

    private List<TCiudades> listSedes;
    private List<TConfiguracion> listModulos;
    private String totalauxSubFoot;
    private List<TCargas> listCargas;
    private List<TCargas> listCargasFiltrer;

    private List<TmovimientosTable> listMovimientosFiltrer;
    private Date calendarIni;
    private Date calendarFin;
    private Long arqueoFinal;
    private Long valorSede, valorSedeIgual;
    private Double totalSubFoot = 0.0;
    private String totalauxivaFoot;
    private String totalauxRedondeoFoot;
    private String totalauxRecibidoFoot;
    private String totalauxMonedas;
    private String valorModulo;
    private Date fechaInicialAux;
    private Date fechaFinalAux;
    private Long idArqueosAux;
    private Boolean disable = false;
    private Boolean render = false;
    private static Long cedulaEnSession;

    public Boolean getDisable() {
        return disable;
    }

    public List<TCargas> getListCargasFiltrer() {
        return listCargasFiltrer;
    }

    public void setListCargasFiltrer(List<TCargas> listCargasFiltrer) {
        this.listCargasFiltrer = listCargasFiltrer;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public List<TConfiguracion> getListModulos() {
        return listModulos;
    }

    public Boolean getRender() {
        return render;
    }

    public void setRender(Boolean render) {
        this.render = render;
    }

    public void setListModulos(List<TConfiguracion> listModulos) {
        this.listModulos = listModulos;
    }

    public String getTotalauxSubFoot() {
        return totalauxSubFoot;
    }

    public List<TmovimientosTable> getListMovimientosFiltrer() {
        return listMovimientosFiltrer;
    }

    public void setListMovimientosFiltrer(List<TmovimientosTable> listMovimientosFiltrer) {
        this.listMovimientosFiltrer = listMovimientosFiltrer;
    }

    public void setTotalauxSubFoot(String totalauxSubFoot) {
        this.totalauxSubFoot = totalauxSubFoot;
    }

    public Date getCalendarIni() {
        calendarIni = new Date();
        calendarIni.setHours(0);
        calendarIni.setMinutes(0);
        calendarIni.setSeconds(0);
        return calendarIni;
    }

    public void setCalendarIni(Date calendarIni) {
        this.calendarIni = calendarIni;
    }

    public Date getCalendarFin() {
        calendarFin = new Date();
        return calendarFin;
    }

    public void setCalendarFin(Date calendarFin) {
        this.calendarFin = calendarFin;
    }

    public Long getArqueoFinal() {
        return arqueoFinal;
    }

    public void setArqueoFinal(Long arqueoFinal) {
        this.arqueoFinal = arqueoFinal;
    }

    public Long getValorSede() {
        return valorSede;
    }

    public void setValorSede(Long valorSede) {
        this.valorSede = valorSede;
    }

    public Long getValorSedeIgual() {
        return valorSedeIgual;
    }

    public void setValorSedeIgual(Long valorSedeIgual) {
        this.valorSedeIgual = valorSedeIgual;
    }

    public Double getTotalSubFoot() {
        return totalSubFoot;
    }

    public void setTotalSubFoot(Double totalSubFoot) {
        this.totalSubFoot = totalSubFoot;
    }

    public String getTotalauxivaFoot() {
        return totalauxivaFoot;
    }

    public void setTotalauxivaFoot(String totalauxivaFoot) {
        this.totalauxivaFoot = totalauxivaFoot;
    }

    public String getTotalauxRedondeoFoot() {
        return totalauxRedondeoFoot;
    }

    public void setTotalauxRedondeoFoot(String totalauxRedondeoFoot) {
        this.totalauxRedondeoFoot = totalauxRedondeoFoot;
    }

    public String getTotalauxRecibidoFoot() {
        return totalauxRecibidoFoot;
    }

    public void setTotalauxRecibidoFoot(String totalauxRecibidoFoot) {
        this.totalauxRecibidoFoot = totalauxRecibidoFoot;
    }

    public String getTotalauxMonedas() {
        return totalauxMonedas;
    }

    public void setTotalauxMonedas(String totalauxMonedas) {
        this.totalauxMonedas = totalauxMonedas;
    }

    public String getValorModulo() {
        return valorModulo;
    }

    public void setValorModulo(String valorModulo) {
        this.valorModulo = valorModulo;
    }

    public Date getFechaInicialAux() {
        return fechaInicialAux;
    }

    public void setFechaInicialAux(Date fechaInicialAux) {
        this.fechaInicialAux = fechaInicialAux;
    }

    public Date getFechaFinalAux() {
        return fechaFinalAux;
    }

    public void setFechaFinalAux(Date fechaFinalAux) {
        this.fechaFinalAux = fechaFinalAux;
    }

    public Long getIdArqueosAux() {
        return idArqueosAux;
    }

    public void setIdArqueosAux(Long idArqueosAux) {
        this.idArqueosAux = idArqueosAux;
    }

    public Double getTotalcomisionFoot() {
        return totalcomisionFoot;
    }

    public void setTotalcomisionFoot(Double totalcomisionFoot) {
        this.totalcomisionFoot = totalcomisionFoot;
    }

    public Double getTotalivaFoot() {
        return totalivaFoot;
    }

    public void setTotalivaFoot(Double totalivaFoot) {
        this.totalivaFoot = totalivaFoot;
    }

    public Double getTotalRedondeoFoot() {
        return totalRedondeoFoot;
    }

    public void setTotalRedondeoFoot(Double totalRedondeoFoot) {
        this.totalRedondeoFoot = totalRedondeoFoot;
    }

    public Double getTotalRecibidoFoot() {
        return totalRecibidoFoot;
    }

    public void setTotalRecibidoFoot(Double totalRecibidoFoot) {
        this.totalRecibidoFoot = totalRecibidoFoot;
    }

    public Double getTotalMonedas() {
        return totalMonedas;
    }

    public void setTotalMonedas(Double totalMonedas) {
        this.totalMonedas = totalMonedas;
    }

    public String getTotalauxcomisionFoot() {
        return totalauxcomisionFoot;
    }

    public void setTotalauxcomisionFoot(String totalauxcomisionFoot) {
        this.totalauxcomisionFoot = totalauxcomisionFoot;
    }

    private TCargas seleccionCarga;
    private Double totalcomisionFoot = 0.0;

    private Double totalivaFoot = 0.0;
    private Double totalRedondeoFoot = 0.0;
    private Double totalRecibidoFoot = 0.0;
    private Double totalMonedas = 0.0;
    private String totalauxcomisionFoot;

    public List<TCiudades> getListSedes() {
        listSedes = objDaoCiudades.listaCiudadesCargas(cedulaEnSession,"Cargas");
        return listSedes;
    }

    public TCargas getSeleccionCarga() {
        return seleccionCarga;
    }

    public void setSeleccionCarga(TCargas seleccionCarga) {
        this.seleccionCarga = seleccionCarga;
    }

    public void setListSedes(List<TCiudades> listSedes) {
        this.listSedes = listSedes;
    }

    public void buscarTransacciones(ActionEvent egt) {
    }

    public List<TCargas> getListCargas() {
        return listCargas;
    }

    public void setListCargas(List<TCargas> listCargas) {
        this.listCargas = listCargas;
    }

    public void changeMenu(ActionEvent egt) {
        try {
            listModulos = objDaoConfiguracion.listModulosPorCiudades(valorSedeIgual, cedulaEnSession,"Cargas");
        } catch (Exception e) {
        }
    }

    public void buscarCarga(ActionEvent egt) {
        try {
            if (calendarFin.before(calendarIni)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La fecha inicial debe ser menor que la fecha final", ""));

            } else if (calendarIni.after(new Date()) && calendarFin.after(new Date())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Las fechas no pueden superar la fecha actual", ""));
            } else {
                listCargas = objDaoCarga.actualizarTablaCargas(calendarIni, calendarFin, valorModulo, valorSedeIgual,cedulaEnSession,"Cargas");
            }
        } catch (Exception e) {
        }

    }

    public void generarListaMovimientoCarga(ActionEvent egt) {
        try {
            listMovimientosFiltrer = objDaoMovimientos.retornarListaMovimientosByIdCarga(seleccionCarga.getIdLocal(),seleccionCarga.getIdModulo().getIdModulo());
        } catch (Exception e) {
        }
    }

    public void clearListMovimientosCarg(ActionEvent egt) {
        try {
            listMovimientosFiltrer.clear();
        } catch (Exception e) {
        }
    }
    
    public void clearCarga(ActionEvent egt)
    {
        try {
            if (!listCargas.isEmpty()) {
                listCargas.clear();
            }
        } catch (Exception e) {
        }
    }

    public beanCarga() {
        cedulaEnSession = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cedula");
    }

}
