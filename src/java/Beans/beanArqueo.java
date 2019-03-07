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
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean(name = "beanArqueo")
@ViewScoped
public class beanArqueo implements Serializable {

    @EJB
    TSedesFacade objDaoSede;

    @EJB
    TCiudadesFacade objDaoCiudades;

    @EJB
    TMovimientosFacade objDaoMovimientos;

    @EJB
    TArqueosFacade objDaoArqueos;

    @EJB
    TConfiguracionFacade objDaoConfiguracion;

    @EJB
    TTransaccionesFacade objDaoTransacciones;

    @EJB

    TPermisosFacade objDaoPermisos;

    @EJB
    TPartesFacade objDaoPartes;

    private List<TCiudades> listSedes;
    private List<TCiudades> listSedesSaldoEnLinea;
    private List<TConfiguracion> listModulos;
    private String totalauxSubFoot;
    private List<TTransacciones> listTransaccionesDeArqueos;
    private List<TArqueos> listArqueosFiltrado;
    private List<TArqueos> listArqueosFiltradoTable;
    private List<TSaldoEnLinea> listPartes;
    private List<TSaldoEnLinea> listPartesFiltrado;
    private List<TConfiguracion> listModulos2;
    private static Long cedulaEnSession;

    private Double totalDineroActualModulo = 0.0;
    private Double totalDineroActualPurga = 0.0;
    private Integer totalCantidadActualModulo = 0;
    private Double totalDineroActualCajones = 0.0;
    private Integer totalCantidadActualCajones = 0;
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

    public Double getTotalDineroActualPurga() {
        return totalDineroActualPurga;
    }

    public void setTotalDineroActualPurga(Double totalDineroActualPurga) {
        this.totalDineroActualPurga = totalDineroActualPurga;
    }

    public List<TCiudades> getListSedesSaldoEnLinea() {
        listSedesSaldoEnLinea = objDaoCiudades.listaCiudadesCargas(cedulaEnSession, "Saldos en linea");
        return listSedesSaldoEnLinea;
    }

    public void setListSedesSaldoEnLinea(List<TCiudades> listSedesSaldoEnLinea) {
        this.listSedesSaldoEnLinea = listSedesSaldoEnLinea;
    }

    public Double getTotalDineroActualModulo() {
        return totalDineroActualModulo;
    }

    public void setTotalDineroActualModulo(Double totalDineroActualModulo) {
        this.totalDineroActualModulo = totalDineroActualModulo;
    }

    public Integer getTotalCantidadActualModulo() {
        return totalCantidadActualModulo;
    }

    public void setTotalCantidadActualModulo(Integer totalCantidadActualModulo) {
        this.totalCantidadActualModulo = totalCantidadActualModulo;
    }

    public Double getTotalDineroActualCajones() {
        return totalDineroActualCajones;
    }

    public void setTotalDineroActualCajones(Double totalDineroActualCajones) {
        this.totalDineroActualCajones = totalDineroActualCajones;
    }

    public Integer getTotalCantidadActualCajones() {
        return totalCantidadActualCajones;
    }

    public void setTotalCantidadActualCajones(Integer totalCantidadActualCajones) {
        this.totalCantidadActualCajones = totalCantidadActualCajones;
    }

    public List<TConfiguracion> getListModulos2() {
        listModulos2 = objDaoConfiguracion.llenarReporteEstado();
        return listModulos2;
    }

    public void setListModulos2(List<TConfiguracion> listModulos2) {
        this.listModulos2 = listModulos2;
    }

    public List<TConfiguracion> getListModulos() {
        return listModulos;
    }

    public void setListModulos(List<TConfiguracion> listModulos) {
        this.listModulos = listModulos;
    }

    public String getTotalauxSubFoot() {
        return totalauxSubFoot;
    }

    public void setTotalauxSubFoot(String totalauxSubFoot) {
        this.totalauxSubFoot = totalauxSubFoot;
    }

    public List<TArqueos> getListArqueosFiltradoTable() {
        return listArqueosFiltradoTable;
    }

    public void setListArqueosFiltradoTable(List<TArqueos> listArqueosFiltradoTable) {
        this.listArqueosFiltradoTable = listArqueosFiltradoTable;
    }

    public List<TTransacciones> getListTransaccionesDeArqueos() {
        return listTransaccionesDeArqueos;
    }

    public void setListTransaccionesDeArqueos(List<TTransacciones> listTransaccionesDeArqueos) {
        this.listTransaccionesDeArqueos = listTransaccionesDeArqueos;
    }

    public List<TSaldoEnLinea> getListPartes() {
        return listPartes;
    }

    public void setListPartes(List<TSaldoEnLinea> listPartes) {
        this.listPartes = listPartes;
    }

    public List<TSaldoEnLinea> getListPartesFiltrado() {
        return listPartesFiltrado;
    }

    public void setListPartesFiltrado(List<TSaldoEnLinea> listPartesFiltrado) {
        this.listPartesFiltrado = listPartesFiltrado;
    }

    public List<TArqueos> getListArqueosFiltrado() {
        return listArqueosFiltrado;
    }

    public void setListArqueosFiltrado(List<TArqueos> listArqueosFiltrado) {
        this.listArqueosFiltrado = listArqueosFiltrado;
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

    public TArqueos getSeleccionArqueos() {
        return seleccionArqueos;
    }

    public void setSeleccionArqueos(TArqueos seleccionArqueos) {
        this.seleccionArqueos = seleccionArqueos;
    }

    public List<TArqueos> getListSeleccionArqueosParaMovimiento() {
        return listSeleccionArqueosParaMovimiento;
    }

    public void setListSeleccionArqueosParaMovimiento(List<TArqueos> listSeleccionArqueosParaMovimiento) {
        this.listSeleccionArqueosParaMovimiento = listSeleccionArqueosParaMovimiento;
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
    private Long totalMonedas;

    public Long getTotalMonedas() {
        return totalMonedas;
    }

    public void setTotalMonedas(Long totalMonedas) {
        this.totalMonedas = totalMonedas;
    }

    public String getTotalauxcomisionFoot() {
        return totalauxcomisionFoot;
    }

    public void setTotalauxcomisionFoot(String totalauxcomisionFoot) {
        this.totalauxcomisionFoot = totalauxcomisionFoot;
    }

    private TArqueos seleccionArqueos;
    private List<TArqueos> listSeleccionArqueosParaMovimiento;
    private Double totalcomisionFoot = 0.0;
    private Double totalivaFoot = 0.0;
    private Double totalRedondeoFoot = 0.0;
    private Double totalRecibidoFoot = 0.0;
    private String totalauxcomisionFoot;
    private List<TmovimientosTable> listMovimientosFiltrer;

    public List<TmovimientosTable> getListMovimientosFiltrer() {
        return listMovimientosFiltrer;
    }

    public void setListMovimientosFiltrer(List<TmovimientosTable> listMovimientosFiltrer) {
        this.listMovimientosFiltrer = listMovimientosFiltrer;
    }

    public List<TCiudades> getListSedes() {
        listSedes = objDaoCiudades.listaCiudadesCargas(cedulaEnSession, "Arqueos");
        return listSedes;
    }

    public void setListSedes(List<TCiudades> listSedes) {
        this.listSedes = listSedes;
    }

    private Double totalValorP = 0.0;
    private Double totalValorT = 0.0;

    public Double getTotalValorP() {
        return totalValorP;
    }

    public void setTotalValorP(Double totalValorP) {
        this.totalValorP = totalValorP;
    }

    public Double getTotalValorT() {
        return totalValorT;
    }

    public void setTotalValorT(Double totalValorT) {
        this.totalValorT = totalValorT;
    }

    public void buscarArqueo(ActionEvent egt) {
        try {
            totalValorP = 0.0;
            totalValorT = 0.0;
            if (calendarFin.before(calendarIni)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La fecha inicial debe ser menor que la fecha final", ""));

            } else if (calendarIni.after(new Date()) && calendarFin.after(new Date())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Las fechas no pueden superar la fecha actual", ""));
            } else {
                listArqueosFiltrado = objDaoArqueos.actualizarTablaArqueos(calendarIni, calendarFin, valorModulo, valorSedeIgual, cedulaEnSession, "Arqueos");
                for (int i = 0; i < listArqueosFiltrado.size(); i++) {
                    Character a = 'P';
                    int resultado = listArqueosFiltrado.get(i).getTipo().compareTo(a);
                    if (resultado == 0) {
                        totalValorP = totalValorP + listArqueosFiltrado.get(i).getValor();

                    } else {
                        totalValorT = totalValorT + listArqueosFiltrado.get(i).getValor();
                    }
                }
            }
        } catch (Exception e) {
        }

    }
    
        public void limpiar() {
            try {
                if (!listArqueosFiltrado.isEmpty()) {
                    listArqueosFiltrado.clear();
                    totalValorP=0.0;
                    totalValorT=0.0;
                }
            } catch (Exception e) {
            }
        }
        public void limpiartransaccion() {
            try {
                if (!listTransaccionesDeArqueos.isEmpty()) {
                   listTransaccionesDeArqueos.clear();
                   totalauxRecibidoFoot="";
                   totalauxSubFoot="";
                   totalauxcomisionFoot="";
                   totalauxRedondeoFoot="";
                   totalauxivaFoot="";
                   totalMonedas=new Long("0");
                }
            } catch (Exception e) {
            }
        }
        public void limpiar2() {
            try {
                if (!listMovimientosFiltrer.isEmpty()) {
                    listMovimientosFiltrer.clear();
                    totalValorP=0.0;
                    totalValorT=0.0;
                }
            } catch (Exception e) {
            }
        }


    public void generarTablaTransacciones(ActionEvent event) {
        try {
           limpiartransaccion();
           totalSubFoot=0.0;
           totalivaFoot=0.0;
           totalcomisionFoot=0.0;
           totalRedondeoFoot=0.0;
           totalRecibidoFoot=0.0;
           totalMonedas=new Long("0");
            listTransaccionesDeArqueos = objDaoTransacciones.listArqueosFinal(seleccionArqueos.getIdModulo().getIdModulo(), seleccionArqueos.getIdSede().getIdSede(), seleccionArqueos.getFechaInicio(), seleccionArqueos.getFechaFinAnterior());
            for (int i = 0; i < listTransaccionesDeArqueos.size(); i++) {

                if (listTransaccionesDeArqueos.get(i).getTotalPagado() != null) {
                    totalSubFoot = totalSubFoot + listTransaccionesDeArqueos.get(i).getTotalPagado();
                }
                if (listTransaccionesDeArqueos.get(i).getIva() != null) {
                    totalivaFoot = totalivaFoot + listTransaccionesDeArqueos.get(i).getIva();
                }
                if (listTransaccionesDeArqueos.get(i).getComision() != null) {
                    totalcomisionFoot = totalcomisionFoot + listTransaccionesDeArqueos.get(i).getComision();
                }
                if (listTransaccionesDeArqueos.get(i).getRedondeo() != null) {
                    totalRedondeoFoot = totalRedondeoFoot + listTransaccionesDeArqueos.get(i).getRedondeo();
                }
                totalRecibidoFoot = totalRecibidoFoot + listTransaccionesDeArqueos.get(i).getValorRecibido();

                DecimalFormat formatea = new DecimalFormat("###,###");
                totalauxRecibidoFoot = formatea.format(totalRecibidoFoot);
                totalauxcomisionFoot = formatea.format(totalcomisionFoot);
                totalauxRedondeoFoot = formatea.format(totalRedondeoFoot);
                totalauxRecibidoFoot = formatea.format(totalRecibidoFoot);
                totalauxivaFoot = formatea.format(totalivaFoot);
                totalauxSubFoot = formatea.format(totalSubFoot);
                Long suma = new Long("0");
                for (int j = 0; j < listTransaccionesDeArqueos.size(); j++) {
                    suma = suma + objDaoMovimientos.retornarTotalMonedasByIdTransaccion(listTransaccionesDeArqueos.get(j).getIdTransaccion());
                }
                totalMonedas = suma;

            }

        } catch (Exception e) {
        }
    }

    public void limpiarSaldoEnLinea() {
        try {
            if (!listPartes.isEmpty()) {
                listPartes.clear();
                totalDineroActualCajones=0.0;
                totalCantidadActualCajones=0;
                totalDineroActualModulo=0.0;
                totalDineroActualPurga=0.0;
                
            }
        } catch (Exception e) {
        }
    }

    public void limp() {
        try {
            if (!listTransaccionesDeArqueos.isEmpty()) {
                listTransaccionesDeArqueos.clear();
                totalSubFoot = 0.0;
                totalivaFoot = 0.0;
                totalcomisionFoot = 0.0;
                totalRedondeoFoot = 0.0;
                totalRecibidoFoot = 0.0;
                totalauxRecibidoFoot = "";
                totalauxcomisionFoot = "";
                totalauxRedondeoFoot = "";
                totalauxRecibidoFoot = "";
                totalauxivaFoot = "";
                totalauxSubFoot = "";
            }

        } catch (Exception e) {
        }
    }

    public void limpiarTablaMovimientos() {
        try {
            if (!listMovimientosFiltrer.isEmpty()) {
                            listMovimientosFiltrer.clear();
                            totalesCantidad=null;
                            totalesValor=0.0;
            }


        } catch (Exception e) {
        }
    }

    private Long totalesCantidad = new Long("0");
    private Double totalesValor = 0.0;

    public Long getTotalesCantidad() {
        return totalesCantidad;
    }

    public void setTotalesCantidad(Long totalesCantidad) {
        this.totalesCantidad = totalesCantidad;
    }

    public Double getTotalesValor() {
        return totalesValor;
    }

    public void setTotalesValor(Double totalesValor) {
        this.totalesValor = totalesValor;
    }

    public void generarListaMovimientoArqueo(ActionEvent egt) {
        try {
            listMovimientosFiltrer = objDaoMovimientos.retornarListaMovimientos(seleccionArqueos.getIdModulo().getIdModulo(),seleccionArqueos.getIdLocal());

            for (int i = 0; i < listMovimientosFiltrer.size(); i++) {
                if (listMovimientosFiltrer.get(i).getAccion().equals("Entrada")) {
                    totalesCantidad = totalesCantidad + listMovimientosFiltrer.get(i).getCantidad();
                    totalesValor = totalesValor + listMovimientosFiltrer.get(i).getValor();
                }
            }
        } catch (Exception e) {
        }
    }

    public void generarListaSaldosEnLinea(ActionEvent egt) {
        try {
            totalCantidadActualCajones = 0;
            totalDineroActualModulo = 0.0;
            totalCantidadActualModulo = 0;
            totalDineroActualCajones = 0.0;
            Long resultado = objDaoPermisos.traerCount(cedulaEnSession);
            listPartes = objDaoPartes.generarDatosTablaPartes(valorModulo, valorSedeIgual, cedulaEnSession, "Saldos en linea", resultado);
            for (int i = 0; i < listPartes.size(); i++) {
                if (listPartes.get(i).getTipoParte().equals("F56") || listPartes.get(i).getTipoParte().equals("Hopper")) {
                    totalDineroActualModulo = totalDineroActualModulo + listPartes.get(i).getDineroActual();
                } else if (listPartes.get(i).getTipoParte().equals("CtCoin")) {
                    totalCantidadActualCajones = totalCantidadActualCajones + listPartes.get(i).getCantidadActual();
                    totalDineroActualCajones = totalDineroActualCajones + listPartes.get(i).getDineroActual();
                } else if (listPartes.get(i).getTipoParte().equals("Purga")) {
                    totalDineroActualPurga = totalDineroActualPurga + listPartes.get(i).getDineroActual();
                }

            }
        } catch (Exception e) {
        }

    }

    public void changeMenu(ActionEvent egt) {
        try {
            listModulos = objDaoConfiguracion.listModulosPorCiudades(valorSedeIgual, cedulaEnSession, "Arqueos");
        } catch (Exception e) {
        }
    }

    public void changeMenuSaldoEnLinea(ActionEvent egt) {
        try {
            listModulos = objDaoConfiguracion.listModulosPorCiudades(valorSedeIgual, cedulaEnSession, "Saldos en linea");
        } catch (Exception e) {
        }
    }

    public beanArqueo() {
        cedulaEnSession = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cedula");
    }

}
