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
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.util.ComponentUtils;

@ManagedBean(name = "beanTransacciones")
@ViewScoped
public class beanTransacciones implements Serializable {

    @EJB
    TSedesFacade objDaoSede;

    @EJB
    TMovimientosFacade objDaoMovimientos;
    
      @EJB
    TUsuariosFacade objDaoUsuario;

    @EJB
    TArqueosFacade objDaoArqueos;

    @EJB
    TConfiguracionFacade objDaoConfiguracion;

    @EJB
    TTransaccionesFacade objDaoTransacciones;

    @EJB
    TCiudadesFacade objDaoCiudades;

    private List<TCiudades> listSedes;
    private List<TTransacciones> listTransaccionesFil;
    private List<TConfiguracion> listModulos;
    private String totalauxSubFoot;
    private List<TTransacciones> listTransacciones;
    private List<TmovimientosTable> listMovimientosFiltrer;
    private Date calendarIni;
    private Date calendarFin;
    private Long arqueoFinal;
    private Long valorSede, valorSedeIgual;
    private Double totalSubFoot = 0.0;
    private Date today = new Date();
    private static Long cedulaEnSession;

    private String totalauxivaFoot;
    private String totalauxRedondeoFoot;
    private String totalauxRecibidoFoot;
    private String totalauxMonedas;
    private String valorModulo;
    private Date fechaInicialAux;
    private Date fechaFinalAux;
    private Long idArqueosAux;
    private Boolean render = false;
    private ExcelOptions excelOpt;
    private PDFOptions pdfOpt;

    @PostConstruct
    public void init() {
        customizationOptions();

    }

    public ExcelOptions getExcelOpt() {
        return excelOpt;
    }

    public void setExcelOpt(ExcelOptions excelOpt) {
        this.excelOpt = excelOpt;
    }

    public PDFOptions getPdfOpt() {
        return pdfOpt;
    }

    public Long getCedulaEnSession() {
        return cedulaEnSession;
    }

    public void setCedulaEnSession(Long cedulaEnSession) {
        this.cedulaEnSession = cedulaEnSession;
    }

    public void setPdfOpt(PDFOptions pdfOpt) {
        this.pdfOpt = pdfOpt;
    }

    private Long totalMonedas;

    public Long getTotalMonedas() {
        return totalMonedas;
    }

    public void setTotalMonedas(Long totalMonedas) {
        this.totalMonedas = totalMonedas;
    }

    public List<TTransacciones> getListTransaccionesFil() {
        return listTransaccionesFil;
    }

    private Integer tocken;

    public Integer getTocken() {
        return tocken;
    }

    public void setTocken(Integer tocken) {
        this.tocken = tocken;
    }

    private static int numeroScon = 0;

    public void generarTocken(ActionEvent egt) {
        try {
            tocken = objDaoUsuario.generarTocken();
            cancel();
        } catch (Exception e) {
        }
    }

    private Integer progress;
    private static int seconds = 0;
    private Boolean bandera = false;

    public Integer getProgress() {
        if (progress == null) {
            seconds = new Date().getSeconds();
            seconds = seconds * 100;
            seconds = seconds / 60;
            progress = seconds;
        } else {
            progress = progress + (int) (5);

            if (progress > 100) {
                progress = 100;
            }
        }

        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Progress Completed"));
    }

    public void cancel() {
        progress = null;
    }

    public void setListTransaccionesFil(List<TTransacciones> listTransaccionesFil) {
        this.listTransaccionesFil = listTransaccionesFil;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
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

    public String getTotalauxcomisionFoot() {
        return totalauxcomisionFoot;
    }

    public void setTotalauxcomisionFoot(String totalauxcomisionFoot) {
        this.totalauxcomisionFoot = totalauxcomisionFoot;
    }

    private TTransacciones seleccionTransacciones;
    private Double totalcomisionFoot = 0.0;

    public TTransacciones getSeleccionTransacciones() {
        return seleccionTransacciones;
    }

    public void setSeleccionTransacciones(TTransacciones seleccionTransacciones) {
        this.seleccionTransacciones = seleccionTransacciones;
    }
    private Double totalivaFoot = 0.0;
    private Double totalRedondeoFoot = 0.0;
    private Double totalRecibidoFoot = 0.0;
    private String totalauxcomisionFoot;

    public List<TCiudades> getListSedes() {
        listSedes = objDaoCiudades.listaCiudadesCargas(cedulaEnSession, "Transacciones");
        return listSedes;
    }

    public void setListSedes(List<TCiudades> listSedes) {
        this.listSedes = listSedes;
    }

    public void borrar() {
        try {
            if (!listMovimientosFiltrer.isEmpty()) {
                listMovimientosFiltrer.clear();
                totalesCantidad=null;
                totalesValor=0.0;
            }
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        try {
            if (!listTransacciones.isEmpty()) {
                listTransacciones.clear();
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

    public void customizationOptions() {
        excelOpt = new ExcelOptions();
        excelOpt.setFacetFontSize("18");
        excelOpt.setFacetFontColor("#07190B");
        excelOpt.setFacetFontStyle("BOLD");
        excelOpt.setCellFontColor("#07190B");
        excelOpt.setCellFontSize("15");

        pdfOpt = new PDFOptions();
        pdfOpt.setFacetFontSize("18");
        pdfOpt.setFacetBgColor("#FFFFFF");
        pdfOpt.setFacetFontColor("#07190B");
        pdfOpt.setFacetFontStyle("BOLD");
        pdfOpt.setCellFontSize("15");
    }

    public void buscarTransacciones(ActionEvent egt) {
        try {
            limpiar();
            if (calendarFin.before(calendarIni)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La fecha inicial debe ser menor que la fecha final", ""));

            } else if (calendarIni.after(new Date()) && calendarFin.after(new Date())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Las fechas no pueden superar la fecha actual", ""));
            } else {
                listTransacciones = objDaoTransacciones.actualizarTablaTransacciones(calendarIni, calendarFin, valorModulo, valorSedeIgual, cedulaEnSession, "Transacciones");
                for (int i = 0; i < listTransacciones.size(); i++) {
                    if (listTransacciones.get(i).getTotalPagado() != null) {
                        totalSubFoot = totalSubFoot + listTransacciones.get(i).getTotalPagado();
                    }
                    if (listTransacciones.get(i).getIva() != null) {
                        totalivaFoot = totalivaFoot + listTransacciones.get(i).getIva();
                    }
                    if (listTransacciones.get(i).getComision() != null) {
                        totalcomisionFoot = totalcomisionFoot + listTransacciones.get(i).getComision();
                    }
                    if (listTransacciones.get(i).getRedondeo() != null) {
                        totalRedondeoFoot = totalRedondeoFoot + listTransacciones.get(i).getRedondeo();
                    }
                    totalRecibidoFoot = totalRecibidoFoot + listTransacciones.get(i).getValorRecibido();

                }
                DecimalFormat formatea = new DecimalFormat("###,###");
                totalauxRecibidoFoot = formatea.format(totalRecibidoFoot);
                totalauxcomisionFoot = formatea.format(totalcomisionFoot);
                totalauxRedondeoFoot = formatea.format(totalRedondeoFoot);
                totalauxRecibidoFoot = formatea.format(totalRecibidoFoot);
                totalauxivaFoot = formatea.format(totalivaFoot);
                totalauxSubFoot = formatea.format(totalSubFoot);
                render = true;
                Long suma = new Long("0");
                for (int i = 0; i < listTransacciones.size(); i++) {
                    suma = suma + objDaoMovimientos.retornarTotalMonedasByIdTransaccion(listTransacciones.get(i).getIdTransaccion());
                }
                totalMonedas = suma;

            }
        } catch (Exception e) {
        }

    }

    public List<TTransacciones> getListTransacciones() {
        return listTransacciones;
    }

    public void setListTransacciones(List<TTransacciones> listTransacciones) {
        this.listTransacciones = listTransacciones;
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

    public void generarListaMovimientoTransaccion(ActionEvent egt) {
        try {
            listMovimientosFiltrer = objDaoMovimientos.retornarListaMovimientosById(seleccionTransacciones.getIdTransaccion(), seleccionTransacciones.getIdModulo().getIdModulo());

            for (int i = 0; i < listMovimientosFiltrer.size(); i++) {
                if (listMovimientosFiltrer.get(i).getAccion().equals("Entrada")) {
                    totalesCantidad = totalesCantidad + listMovimientosFiltrer.get(i).getCantidad();
                    totalesValor = totalesValor + listMovimientosFiltrer.get(i).getValor();
                }
            }

        } catch (Exception e) {
        }
    }

    public void changeMenu(ActionEvent egt) {
        try {
            listModulos = objDaoConfiguracion.listModulosPorCiudades(valorSedeIgual, cedulaEnSession, "Transacciones");
        } catch (Exception e) {
        }
    }

    public beanTransacciones() {
        cedulaEnSession = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cedula");

    }

}
