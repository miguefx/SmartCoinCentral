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

import ValueObject.*;
import DataAccessObject.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "beanReporte")
@ViewScoped
public class beanReporte implements Serializable {

    @EJB
    TArqueosFacade objDaoArqueos;

    @EJB
    TConfiguracionFacade objDaoConfiguracion;

    private static List<TArqueos> listReportArqueos;
    private List<TReporteArqueosExcel> personas2 = new ArrayList<TReporteArqueosExcel>();
    private Connection conexion = null;

    private Date fechaFin;
    private Date fechaInicio;

    private String numeroMesSeleccionado;
    private String letraMesSeleccionado;
    private String anoSeleccionado;

    public String getNumeroMesSeleccionado() {
        return numeroMesSeleccionado;
    }

    public void setNumeroMesSeleccionado(String numeroMesSeleccionado) {
        this.numeroMesSeleccionado = numeroMesSeleccionado;
    }

    public String getLetraMesSeleccionado() {
        return letraMesSeleccionado;
    }

    public void setLetraMesSeleccionado(String letraMesSeleccionado) {
        this.letraMesSeleccionado = letraMesSeleccionado;
    }

    public String getAnoSeleccionado() {
        return anoSeleccionado;
    }

    public void setAnoSeleccionado(String anoSeleccionado) {
        this.anoSeleccionado = anoSeleccionado;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<TReporteArqueosExcel> getPersonas2() {
        return personas2;
    }

    public void setPersonas2(List<TReporteArqueosExcel> personas2) {
        this.personas2 = personas2;
    }

    public String traerMes(int numero) {
        String resultado = "";
        try {
            switch (numero) {
                case 1:
                    resultado = "Enero";
                    break;
                case 2:
                    resultado = "Febrero";
                    break;
                case 3:
                    resultado = "Marzo";
                    break;
                case 4:
                    resultado = "Abril";
                    break;
                case 5:
                    resultado = "Mayo";
                    break;
                case 6:
                    resultado = "Junio";
                    break;
                case 7:
                    resultado = "Julio";
                    break;
                case 8:
                    resultado = "Agosto";
                    break;
                case 9:
                    resultado = "Septiembre";
                    break;
                case 10:
                    resultado = "Octubre";
                    break;
                case 11:
                    resultado = "Noviembre";
                    break;
                case 12:
                    resultado = "Diciembre";
                    break;
            }
        } catch (Exception e) {
        }
        return resultado;
    }

    public void exportarExcelMensual(ActionEvent actionEvent) throws JRException, IOException {
        letraMesSeleccionado = traerMes(Integer.valueOf(numeroMesSeleccionado));
        List<TConfiguracion> list = objDaoConfiguracion.llenarReporteEstado();

        try {
            this.conexion = Conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(beanUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("parametro2", numeroMesSeleccionado);
        parametros.put("mesEnCurso", letraMesSeleccionado);
        parametros.put("anoelegido", anoSeleccionado);
        parametros.put("idModuloprimero", list.get(0).getIdModulo());
        parametros.put("idModulosegundo", list.get(1).getIdModulo());
        parametros.put("idModulotercera", list.get(2).getIdModulo());

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporteMensualdos.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, conexion);

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=ReporteComportamiento" + letraMesSeleccionado + ".xls");
        ServletOutputStream stream = response.getOutputStream();

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPdfMensual(ActionEvent actionEvent) throws JRException, IOException {
        letraMesSeleccionado = traerMes(Integer.valueOf(numeroMesSeleccionado));
        List<TConfiguracion> list = objDaoConfiguracion.llenarReporteEstado();

        try {
            this.conexion = Conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(beanUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("parametro2", numeroMesSeleccionado);
        parametros.put("mesEnCurso", letraMesSeleccionado);
        parametros.put("anoelegido", anoSeleccionado);
        parametros.put("idModuloprimero", list.get(0).getIdModulo());
        parametros.put("idModulosegundo", list.get(1).getIdModulo());
        parametros.put("idModulotercera", list.get(2).getIdModulo());

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporteMensualdos.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, conexion);

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=ReporteComportamiento" + letraMesSeleccionado + ".pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarExcelAnual(ActionEvent actionEvent) throws JRException, IOException {
        List<TConfiguracion> list = objDaoConfiguracion.llenarReporteEstado();
        try {
            this.conexion = Conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(beanUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("anoelegido", anoSeleccionado);
        parametros.put("idModuloprimero", list.get(0).getIdModulo());
        parametros.put("idModulosegundo", list.get(1).getIdModulo());
        parametros.put("idModulotercera", list.get(2).getIdModulo());

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporteAnual.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, conexion);

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=ReporteComportamiento" + anoSeleccionado + ".xls");
        ServletOutputStream stream = response.getOutputStream();

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPdfAnual(ActionEvent actionEvent) throws JRException, IOException {
        List<TConfiguracion> list = objDaoConfiguracion.llenarReporteEstado();
        try {
            this.conexion = Conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(beanUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("anoelegido", anoSeleccionado);
        parametros.put("idModuloprimero", list.get(0).getIdModulo());
        parametros.put("idModulosegundo", list.get(1).getIdModulo());
        parametros.put("idModulotercera", list.get(2).getIdModulo());

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporteAnual.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, conexion);

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=ReporteComportamiento" + anoSeleccionado + ".pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
    private StreamedContent file;

    public StreamedContent getFile() {
        return file;
    }
    private StreamedContent file2;

    public StreamedContent getFile2() {
        return file2;
    }
    private StreamedContent file3;

    public StreamedContent getFile3() {
        return file3;
    }
    private StreamedContent file4;
    private StreamedContent file5;

    public StreamedContent getFile5() {
        return file5;
    }

    public void setFile5(StreamedContent file5) {
        this.file5 = file5;
    }
    

    public StreamedContent getFile4() {
        return file4;
    }

    public beanReporte() {
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/ReporteCompilado.xlsx");
        file = new DefaultStreamedContent(stream, "xlsx/xlsx", "ReporteCompilado.xlsx");
        InputStream stream2 = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/ReporteTransportadora.rar");
        file2 = new DefaultStreamedContent(stream2, "rar/rar", "ReporteTransportadora.rar");
        InputStream stream3 = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/Drivers.rar");
        file3= new DefaultStreamedContent(stream3, "rar/rar", "Drivers.rar");
        InputStream stream4 = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/ReporteHistoricoSaldos.rar");
        file4= new DefaultStreamedContent(stream4, "rar/rar", "ReporteHistoricoSaldos.rar");
        InputStream stream5 = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/ReporteHistoricoSaldos.rar");
        file5= new DefaultStreamedContent(stream5, "rar/rar", "ReporteGerencial.rar");
        
        
    }

}
