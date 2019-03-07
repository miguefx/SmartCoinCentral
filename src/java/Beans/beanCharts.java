/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import DataAccessObject.*;
import javax.ejb.EJB;
import ValueObject.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author matc_
 */
@ManagedBean
@SessionScoped
public class beanCharts {

    @EJB
    TArqueosFacade objDaoArqueos;

    @EJB
    TTransaccionesFacade objDaoTransacciones;

    @EJB
    TConfiguracionFacade objDaoConfiguracion;

    @EJB
    TMovimientosFacade objDaoMovimientos;

    @EJB

    TPartesFacade objDaoPartes;

    @PostConstruct
    public void init() {
        createBarModel2();
        createBarModel3();

    }

    private BarChartModel barModel;
    private BarChartModel barModel2;
    private BarChartModel barModel3;

    private DonutChartModel donutModel1;
    private LineChartModel lineModel1;
    private static List<String> listFechasEscritas = new ArrayList();
    private static String titulo = " ";

    public BarChartModel getBarModel3() {
        return barModel3;
    }

    public void setBarModel3(BarChartModel barModel3) {
        this.barModel3 = barModel3;
    }

    public BarChartModel getBarModel2() {
        return barModel2;
    }

    public void setBarModel2(BarChartModel barModel2) {
        this.barModel2 = barModel2;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    private void createBarModels() {
        createBarModel();
    }

    public DonutChartModel getDonutModel1() {
        return donutModel1;
    }

    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    private void createBarModel3() {
        barModel3 = initBarModel3();
        barModel3.setAnimate(true);
        barModel3.setTitle("Total Dinero Actual");
        barModel3.setLegendPosition("s");
        barModel3.setShowDatatip(true);
        barModel3.setShowPointLabels(true);
        barModel3.setAnimate(true);
        barModel3.setDatatipFormat("%d - $ %i");
        List<TConfiguracion> listModulos = objDaoConfiguracion.llenarReporteEstado();
        barModel3.setLegendCols(listModulos.size());

        barModel3.setLegendPlacement(LegendPlacement.OUTSIDEGRID);

        Axis yAxis = barModel3.getAxis(AxisType.Y);
        Axis xAxis = barModel3.getAxis(AxisType.X);

        yAxis.setLabel("Valor");
        yAxis.setMin(0);
        yAxis.setMax(10000000);
    }

    private BarChartModel initBarModel3() {
        BarChartModel model2 = new BarChartModel();
        try {
            ChartSeries cajeros = new ChartSeries();
            ChartSeries cajeros2 = new ChartSeries();
            ChartSeries cajeros3 = new ChartSeries();
            ChartSeries cajeros4 = new ChartSeries();
            ChartSeries cajeros5 = new ChartSeries();
            ChartSeries cajeros6 = new ChartSeries();
            ChartSeries cajeros7 = new ChartSeries();
            ChartSeries cajeros8 = new ChartSeries();
            ChartSeries cajeros9 = new ChartSeries();
            ChartSeries cajeros10 = new ChartSeries();
            ChartSeries cajeros11 = new ChartSeries();
            ChartSeries cajeros12 = new ChartSeries();
            ChartSeries cajeros13 = new ChartSeries();
            Double resultado = null;
            TreporteTransacciones objVoReporteTransacciones;
            List<TreporteTransacciones> listTransaccionesReport = new ArrayList<>();
            List<TConfiguracion> listModulos = objDaoConfiguracion.llenarReporteEstado();
            for (int i = 0; i < listModulos.size(); i++) {
                resultado = objDaoPartes.listReporteValor(listModulos.get(i).getIdModulo());
                objVoReporteTransacciones = new TreporteTransacciones(listModulos.get(i).getIdModulo(), 0, resultado);
                listTransaccionesReport.add(objVoReporteTransacciones);
            }
            for (int i = 0; i < listTransaccionesReport.size(); i++) {
                if (i == 0) {
                    cajeros.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros.set("Cajeros", listTransaccionesReport.get(i).getValorTotal());

                } else if (i == 1) {
                    cajeros2.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros2.set("Cajeros1", listTransaccionesReport.get(i).getValorTotal());

                } else if (i == 2) {
                    cajeros3.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros3.set("Cajeros2", listTransaccionesReport.get(i).getValorTotal());

                } else if (i == 3) {
                    cajeros4.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros4.set("Cajeros3", listTransaccionesReport.get(i).getValorTotal());

                } else if (i == 4) {
                    cajeros5.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros5.set("Cajeros4", listTransaccionesReport.get(i).getValorTotal());
                } else if (i == 5) {
                    cajeros6.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros6.set("Cajeros5", listTransaccionesReport.get(i).getValorTotal());

                } else if (i == 6) {

                    cajeros7.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros7.set("Cajeros6", listTransaccionesReport.get(i).getValorTotal());

                } else if (i == 7) {
                    cajeros8.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros8.set("Cajeros7", listTransaccionesReport.get(i).getValorTotal());

                } else if (i == 8) {
                    cajeros9.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros9.set("Cajeros8", listTransaccionesReport.get(i).getValorTotal());
                } else if (i == 9) {
                    cajeros10.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros10.set("Cajeros9", listTransaccionesReport.get(i).getValorTotal());
                } else if (i == 10) {
                    cajeros11.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros11.set("Cajeros10", listTransaccionesReport.get(i).getValorTotal());
                } else if (i == 11) {
                    cajeros12.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros12.set("Cajeros11", listTransaccionesReport.get(i).getValorTotal());
                } else if (i == 12) {
                    cajeros13.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                    cajeros13.set("Cajeros12", listTransaccionesReport.get(i).getValorTotal());
                }

            }

            switch (listModulos.size()) {
                case 10:
                    model2.addSeries(cajeros);
                    model2.addSeries(cajeros2);
                    model2.addSeries(cajeros3);
                    model2.addSeries(cajeros4);
                    model2.addSeries(cajeros5);
                    model2.addSeries(cajeros6);
                    model2.addSeries(cajeros7);
                    model2.addSeries(cajeros8);
                    model2.addSeries(cajeros9);
                    model2.addSeries(cajeros10);
                    model2.addSeries(cajeros11);
                    break;
                case 11:
                    model2.addSeries(cajeros);
                    model2.addSeries(cajeros2);
                    model2.addSeries(cajeros3);
                    model2.addSeries(cajeros4);
                    model2.addSeries(cajeros5);
                    model2.addSeries(cajeros6);
                    model2.addSeries(cajeros7);
                    model2.addSeries(cajeros8);
                    model2.addSeries(cajeros9);
                    model2.addSeries(cajeros10);
                    model2.addSeries(cajeros11);
                    break;
                case 12:
                    model2.addSeries(cajeros);
                    model2.addSeries(cajeros2);
                    model2.addSeries(cajeros3);
                    model2.addSeries(cajeros4);
                    model2.addSeries(cajeros5);
                    model2.addSeries(cajeros6);
                    model2.addSeries(cajeros7);
                    model2.addSeries(cajeros8);
                    model2.addSeries(cajeros9);
                    model2.addSeries(cajeros10);
                    model2.addSeries(cajeros11);
                    model2.addSeries(cajeros12);
                    break;
                case 13:
                    model2.addSeries(cajeros);
                    model2.addSeries(cajeros2);
                    model2.addSeries(cajeros3);
                    model2.addSeries(cajeros4);
                    model2.addSeries(cajeros5);
                    model2.addSeries(cajeros6);
                    model2.addSeries(cajeros7);
                    model2.addSeries(cajeros8);
                    model2.addSeries(cajeros9);
                    model2.addSeries(cajeros10);
                    model2.addSeries(cajeros11);
                    model2.addSeries(cajeros12);
                    model2.addSeries(cajeros13);
                    break;
            }

        } catch (Exception e) {
        }
        return model2;
    }

    private BarChartModel initBarModel2() {
        BarChartModel model2 = new BarChartModel();
        ChartSeries cajeros = new ChartSeries();
        ChartSeries cajeros2 = new ChartSeries();
        ChartSeries cajeros3 = new ChartSeries();
        ChartSeries cajeros4 = new ChartSeries();
        ChartSeries cajeros5 = new ChartSeries();
        ChartSeries cajeros6 = new ChartSeries();
        ChartSeries cajeros7 = new ChartSeries();
        ChartSeries cajeros8 = new ChartSeries();
        ChartSeries cajeros9 = new ChartSeries();
        ChartSeries cajeros10 = new ChartSeries();
        ChartSeries cajeros11 = new ChartSeries();
        ChartSeries cajeros12 = new ChartSeries();
        ChartSeries cajeros13 = new ChartSeries();
        Double resultado = null;
        TreporteTransacciones objVoReporteTransacciones;
        List<TreporteTransacciones> listTransaccionesReport = new ArrayList<>();
        List<TConfiguracion> listModulos = objDaoConfiguracion.llenarReporteEstado();
        for (int i = 0; i < listModulos.size(); i++) {
            resultado = objDaoTransacciones.listReporteValor(listModulos.get(i).getIdModulo());
            objVoReporteTransacciones = new TreporteTransacciones(listModulos.get(i).getIdModulo(), 0, resultado);
            listTransaccionesReport.add(objVoReporteTransacciones);
        }
        for (int i = 0; i < listTransaccionesReport.size(); i++) {
            if (i == 0) {
                cajeros.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros.set("Cajeros", listTransaccionesReport.get(i).getValorTotal());

            } else if (i == 1) {
                cajeros2.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros2.set("Cajeros1", listTransaccionesReport.get(i).getValorTotal());

            } else if (i == 2) {
                cajeros3.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros3.set("Cajeros2", listTransaccionesReport.get(i).getValorTotal());

            } else if (i == 3) {
                cajeros4.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros4.set("Cajeros3", listTransaccionesReport.get(i).getValorTotal());

            } else if (i == 4) {
                cajeros5.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros5.set("Cajeros4", listTransaccionesReport.get(i).getValorTotal());
            } else if (i == 5) {
                cajeros6.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros6.set("Cajeros5", listTransaccionesReport.get(i).getValorTotal());

            } else if (i == 6) {

                cajeros7.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros7.set("Cajeros6", listTransaccionesReport.get(i).getValorTotal());

            } else if (i == 7) {
                cajeros8.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros8.set("Cajeros7", listTransaccionesReport.get(i).getValorTotal());

            } else if (i == 8) {
                cajeros9.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros9.set("Cajeros8", listTransaccionesReport.get(i).getValorTotal());
            } else if (i == 9) {
                cajeros10.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros10.set("Cajeros9", listTransaccionesReport.get(i).getValorTotal());
            } else if (i == 10) {
                cajeros11.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros11.set("Cajeros10", listTransaccionesReport.get(i).getValorTotal());
            } else if (i == 11) {
                cajeros12.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros12.set("Cajeros11", listTransaccionesReport.get(i).getValorTotal());
            } else if (i == 12) {
                cajeros13.setLabel(listTransaccionesReport.get(i).getIdModulo().substring(9));
                cajeros13.set("Cajeros12", listTransaccionesReport.get(i).getValorTotal());
            }

        }

        switch (listModulos.size()) {
            case 8:
                model2.addSeries(cajeros);
                model2.addSeries(cajeros2);
                model2.addSeries(cajeros3);
                model2.addSeries(cajeros4);
                model2.addSeries(cajeros5);
                model2.addSeries(cajeros6);
                model2.addSeries(cajeros7);
                model2.addSeries(cajeros8);
                model2.addSeries(cajeros9);
                break;
            case 9:
                model2.addSeries(cajeros);
                model2.addSeries(cajeros2);
                model2.addSeries(cajeros3);
                model2.addSeries(cajeros4);
                model2.addSeries(cajeros5);
                model2.addSeries(cajeros6);
                model2.addSeries(cajeros7);
                model2.addSeries(cajeros8);
                model2.addSeries(cajeros9);

                break;
            case 10:
                model2.addSeries(cajeros);
                model2.addSeries(cajeros2);
                model2.addSeries(cajeros3);
                model2.addSeries(cajeros4);
                model2.addSeries(cajeros5);
                model2.addSeries(cajeros6);
                model2.addSeries(cajeros7);
                model2.addSeries(cajeros8);
                model2.addSeries(cajeros9);
                model2.addSeries(cajeros10);
                model2.addSeries(cajeros11);
                break;
            case 11:
                model2.addSeries(cajeros);
                model2.addSeries(cajeros2);
                model2.addSeries(cajeros3);
                model2.addSeries(cajeros4);
                model2.addSeries(cajeros5);
                model2.addSeries(cajeros6);
                model2.addSeries(cajeros7);
                model2.addSeries(cajeros8);
                model2.addSeries(cajeros9);
                model2.addSeries(cajeros10);
                model2.addSeries(cajeros11);
                break;
            case 12:
                model2.addSeries(cajeros);
                model2.addSeries(cajeros2);
                model2.addSeries(cajeros3);
                model2.addSeries(cajeros4);
                model2.addSeries(cajeros5);
                model2.addSeries(cajeros6);
                model2.addSeries(cajeros7);
                model2.addSeries(cajeros8);
                model2.addSeries(cajeros9);
                model2.addSeries(cajeros10);
                model2.addSeries(cajeros11);
                model2.addSeries(cajeros12);
                break;
            case 13:
                model2.addSeries(cajeros);
                model2.addSeries(cajeros2);
                model2.addSeries(cajeros3);
                model2.addSeries(cajeros4);
                model2.addSeries(cajeros5);
                model2.addSeries(cajeros6);
                model2.addSeries(cajeros7);
                model2.addSeries(cajeros8);
                model2.addSeries(cajeros9);
                model2.addSeries(cajeros10);
                model2.addSeries(cajeros11);
                model2.addSeries(cajeros12);
                model2.addSeries(cajeros13);
                break;

        }

        return model2;
    }

    private void createBarModel2() {
        Date hoy = new Date();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

        barModel2 = initBarModel2();

        barModel2.setTitle("Transacciones  " + data.format(hoy) + " SmartCoin");
        barModel2.setLegendPosition("s");
        barModel2.setShowDatatip(true);
        barModel2.setShowPointLabels(true);
        barModel2.setAnimate(true);
        barModel2.setDatatipFormat("%d - $ %i");
        List<TConfiguracion> listModulos = objDaoConfiguracion.llenarReporteEstado();
        barModel2.setLegendCols(listModulos.size());

        barModel2.setLegendPlacement(LegendPlacement.OUTSIDEGRID);

        Axis yAxis = barModel2.getAxis(AxisType.Y);
        Axis xAxis = barModel2.getAxis(AxisType.X);

        yAxis.setLabel("Valor");
        yAxis.setMin(0);
        yAxis.setMax(10000000);
    }

    private BarChartModel initBarModel() {
        donutModel1 = initDonutModel();
        donutModel1.setTitle("Arqueos realizados en " + titulo);
        donutModel1.setLegendPosition("w");

        BarChartModel model = new BarChartModel();

        Date hoy = new Date();
        Date haceUnMes = quitarUnMes(hoy);
        Date haceDosMeses = quitarUnMes(haceUnMes);
        List<Date> listFechas = new ArrayList();
        listFechas.add(haceDosMeses);
        listFechas.add(haceUnMes);
        listFechas.add(hoy);
        ChartSeries uno = new ChartSeries();
        ChartSeries dos = new ChartSeries();
        ChartSeries tres = new ChartSeries();
        ChartSeries cuatro = new ChartSeries();
        ChartSeries cinco = new ChartSeries();
        ChartSeries seis = new ChartSeries();
        ChartSeries siete = new ChartSeries();
        ChartSeries ocho = new ChartSeries();
        ChartSeries nueve = new ChartSeries();
        ChartSeries diez = new ChartSeries();
        ChartSeries once = new ChartSeries();
        ChartSeries doce = new ChartSeries();
        setYu(objDaoConfiguracion.retirarCount());
        String ja = Long.toString(yu);
        int c = Integer.valueOf(ja);
        int k = 0;
        List<TreporteTransacciones> listReporAux = new ArrayList();
        List<TreporteTransacciones> listReporAux2 = new ArrayList();
        List<TConfiguracion> list = objDaoConfiguracion.llenarReporteEstado();

        for (int i = 0; i < listFechas.size(); i++) {
            List<TreporteTransacciones> listReport = objDaoTransacciones.listReporteTransacciones(listFechas.get(i));
            if (c != listReport.size()) {
                listReporAux2 = listReport;
                listReporAux.clear();
                for (int t = 0; t < list.size(); t++) {
                    TreporteTransacciones objVo = new TreporteTransacciones(list.get(t).getIdModulo(), 0, 0.0);
                    listReporAux.add(objVo);
                }
                for (int u = 0; u < listReport.size(); u++) {
                    for (int a = 0; a < listReporAux.size(); a++) {
                        if (listReport.get(u).getIdModulo().equals(listReporAux.get(a).getIdModulo())) {
                            listReporAux.remove(a);
                        }
                    }
                }
                for (int w = 0; w < listReporAux.size(); w++) {
                    TreporteTransacciones objVo2 = new TreporteTransacciones(listReporAux.get(w).getIdModulo(), listReporAux.get(w).getConteo(), 0.0);
                    listReporAux2.add(objVo2);
                }
                listReport = listReporAux2;
            }
            switch (c) {
                case 1:
                    while (list.size() > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        uno.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                    }
                    break;

                case 2:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        }
                    }
                    break;
                case 3:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        }
                    }
                    break;
                case 5:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        }
                    }
                    break;
                case 6:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                        k++;
                        seis.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (cinco.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else {
                            seis.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        }

                    }
                    break;
                case 9:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                        k++;
                        seis.setLabel(list.get(k).getIdModulo());
                        k++;
                        siete.setLabel(list.get(k).getIdModulo());
                        k++;
                        ocho.setLabel(list.get(k).getIdModulo());
                        k++;
                        nueve.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (cinco.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (seis.getLabel().equals(listReport.get(j).getIdModulo())) {
                            seis.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (siete.getLabel().equals(listReport.get(j).getIdModulo())) {
                            siete.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (ocho.getLabel().equals(listReport.get(j).getIdModulo())) {
                            ocho.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (nueve.getLabel().equals(listReport.get(j).getIdModulo())) {
                            nueve.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        }

                    }
                    break;
                case 10:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                        k++;
                        seis.setLabel(list.get(k).getIdModulo());
                        k++;
                        siete.setLabel(list.get(k).getIdModulo());
                        k++;
                        ocho.setLabel(list.get(k).getIdModulo());
                        k++;
                        nueve.setLabel(list.get(k).getIdModulo());
                        k++;
                        diez.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (cinco.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (seis.getLabel().equals(listReport.get(j).getIdModulo())) {
                            seis.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (siete.getLabel().equals(listReport.get(j).getIdModulo())) {
                            siete.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (ocho.getLabel().equals(listReport.get(j).getIdModulo())) {
                            ocho.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (nueve.getLabel().equals(listReport.get(j).getIdModulo())) {
                            nueve.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (diez.getLabel().equals(listReport.get(j).getIdModulo())) {
                            diez.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        }
                    }

                    break;
                case 11:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                        k++;
                        seis.setLabel(list.get(k).getIdModulo());
                        k++;
                        siete.setLabel(list.get(k).getIdModulo());
                        k++;
                        ocho.setLabel(list.get(k).getIdModulo());
                        k++;
                        nueve.setLabel(list.get(k).getIdModulo());
                        k++;
                        diez.setLabel(list.get(k).getIdModulo());
                        k++;
                        once.setLabel(list.get(k).getIdModulo());

                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (cinco.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (seis.getLabel().equals(listReport.get(j).getIdModulo())) {
                            seis.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (siete.getLabel().equals(listReport.get(j).getIdModulo())) {
                            siete.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (ocho.getLabel().equals(listReport.get(j).getIdModulo())) {
                            ocho.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (nueve.getLabel().equals(listReport.get(j).getIdModulo())) {
                            nueve.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (diez.getLabel().equals(listReport.get(j).getIdModulo())) {
                            diez.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (once.getLabel().equals(listReport.get(j).getIdModulo())) {
                            once.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        }

                    }
                    break;
                case 12:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                        k++;
                        seis.setLabel(list.get(k).getIdModulo());
                        k++;
                        siete.setLabel(list.get(k).getIdModulo());
                        k++;
                        ocho.setLabel(list.get(k).getIdModulo());
                        k++;
                        nueve.setLabel(list.get(k).getIdModulo());
                        k++;
                        diez.setLabel(list.get(k).getIdModulo());
                        k++;
                        once.setLabel(list.get(k).getIdModulo());
                        k++;
                        doce.setLabel(list.get(k).getIdModulo());

                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (cinco.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getConteo());

                        } else if (seis.getLabel().equals(listReport.get(j).getIdModulo())) {
                            seis.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (siete.getLabel().equals(listReport.get(j).getIdModulo())) {
                            siete.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (ocho.getLabel().equals(listReport.get(j).getIdModulo())) {
                            ocho.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (nueve.getLabel().equals(listReport.get(j).getIdModulo())) {
                            nueve.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (diez.getLabel().equals(listReport.get(j).getIdModulo())) {
                            diez.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (once.getLabel().equals(listReport.get(j).getIdModulo())) {
                            once.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        } else if (doce.getLabel().equals(listReport.get(j).getIdModulo())) {
                            doce.set(listFechasEscritas.get(i), listReport.get(j).getConteo());
                        }

                    }
                    break;
            }

        }
        switch (c) {
            case 1:
                model.addSeries(uno);
                break;
            case 2:
                model.addSeries(uno);
                model.addSeries(dos);
                break;
            case 3:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                break;
            case 5:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                break;
            case 6:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                model.addSeries(seis);
                break;
            case 9:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                model.addSeries(seis);
                model.addSeries(siete);
                model.addSeries(ocho);
                model.addSeries(nueve);
                break;
            case 10:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                model.addSeries(seis);
                model.addSeries(siete);
                model.addSeries(ocho);
                model.addSeries(nueve);
                model.addSeries(diez);
                break;
            case 11:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                model.addSeries(seis);
                model.addSeries(siete);
                model.addSeries(ocho);
                model.addSeries(nueve);
                model.addSeries(diez);
                model.addSeries(once);
                break;
            case 12:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                model.addSeries(seis);
                model.addSeries(siete);
                model.addSeries(ocho);
                model.addSeries(nueve);
                model.addSeries(diez);
                model.addSeries(once);
                model.addSeries(doce);
                break;

        }
        return model;
    }

    private Date quitarUnMes(Date fecha) {

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            calendar.add(Calendar.MONTH, -1);
            fecha = calendar.getTime();
        } catch (Exception e) {
        }
        return fecha;
    }

    private void tituloCompuesto(List<Date> listFechas) {
        try {

            for (int i = 0; i < listFechas.size(); i++) {
                switch (listFechas.get(i).getMonth()) {
                    case 0:
                        titulo = titulo + " | Enero";
                        listFechasEscritas.add("Enero");
                        break;
                    case 1:
                        titulo = titulo + " | Febrero";
                        listFechasEscritas.add("Febrero");
                        break;
                    case 2:
                        titulo = titulo + " | Marzo";
                        listFechasEscritas.add("Marzo");
                        break;
                    case 3:
                        titulo = titulo + " | Abril";
                        listFechasEscritas.add("Abril");
                        break;
                    case 4:
                        titulo = titulo + " | Mayo";
                        listFechasEscritas.add("Mayo");
                        break;
                    case 5:
                        titulo = titulo + " | Junio";
                        listFechasEscritas.add("Junio");
                        break;
                    case 6:
                        titulo = titulo + " | Julio";
                        listFechasEscritas.add("Julio");
                        break;
                    case 7:
                        titulo = titulo + " | Agosto";
                        listFechasEscritas.add("Agosto");
                        break;
                    case 8:
                        titulo = titulo + " | Septiembre";
                        listFechasEscritas.add("Septiembre");
                        break;
                    case 9:
                        titulo = titulo + " | Octubre";
                        listFechasEscritas.add("Octubre");
                        break;
                    case 10:
                        titulo = titulo + " | Noviembre";
                        listFechasEscritas.add("Noviembre");
                        break;
                    case 11:
                        titulo = titulo + " | Diciembre";
                        listFechasEscritas.add("Diciembre");
                        break;
                }
            }
        } catch (Exception e) {
        }
    }

    private DonutChartModel initDonutModel() {
        DonutChartModel model = new DonutChartModel();
        Map<String, Number> circle1 = new LinkedHashMap<String, Number>();
        Map<String, Number> circle2 = new LinkedHashMap<String, Number>();
        Map<String, Number> circle3 = new LinkedHashMap<String, Number>();
        Map<String, Number> circle4 = new LinkedHashMap<String, Number>();
        Map<String, Number> circle5 = new LinkedHashMap<String, Number>();

        Date hoy = new Date();
        Date haceUnMes = quitarUnMes(hoy);
        Date haceDosMeses = quitarUnMes(haceUnMes);
        List<Date> listFechas = new ArrayList();
        listFechas.add(haceDosMeses);
        listFechas.add(haceUnMes);
        listFechas.add(hoy);
        setYu(objDaoConfiguracion.retirarCount());
        String ja = Long.toString(yu);
        int c = Integer.valueOf(ja);
        int k = 0;
        List<TreporteArqueos> listReporAux = new ArrayList();
        List<TreporteArqueos> listReporAux2 = new ArrayList();
        List<TreporteArqueos> listReporAux3 = new ArrayList();

        List<TConfiguracion> list = objDaoConfiguracion.llenarReporteEstado();

        if (titulo.equals(" ") && listFechasEscritas.isEmpty()) {
            tituloCompuesto(listFechas);
        }

        boolean bandera = false;

        for (int i = 0; i < listFechas.size(); i++) {
            List<TreporteArqueos> listReport = objDaoArqueos.listReporte1(listFechas.get(i));
            if (c != listReport.size()) {
                listReporAux.clear();
                for (int t = 0; t < list.size(); t++) {
                    TreporteArqueos objVo = new TreporteArqueos(list.get(t).getIdModulo(), 0.0);
                    listReporAux.add(objVo);
                    if (listReporAux3.size() < yu) {
                        listReporAux3.add(objVo);
                    }

                }
                for (int u = 0; u < listReport.size(); u++) {
                    for (int a = 0; a < listReporAux.size(); a++) {
                        if (listReport.get(u).getIdModulo().equals(listReporAux.get(a).getIdModulo())) {
                            listReporAux.remove(a);
                        }
                    }
                }
                listReporAux2 = listReport;
                listReport = listReporAux;
                for (int yu = 0; yu < listReporAux2.size(); yu++) {
                    TreporteArqueos objVo2 = new TreporteArqueos(listReporAux2.get(yu).getIdModulo(), listReporAux2.get(yu).getValor());
                    listReport.add(objVo2);
                    bandera = true;

                }

                if (bandera) {
                    for (int masacre = 0; masacre < listReport.size(); masacre++) {
                        for (int kraken = 0; kraken < listReporAux3.size(); kraken++) {
                            if (listReporAux3.get(kraken).getIdModulo().equals(listReport.get(masacre).getIdModulo())) {
                                listReporAux3.get(kraken).setValor(listReport.get(masacre).getValor());
                            }

                        }

                    }
                    listReport = listReporAux3;
                }
            }
            switch (i) {
                case 0:
                    for (int j = 0; j < listReport.size(); j++) {
                        circle1.put(listReport.get(j).getIdModulo(), listReport.get(j).getValor());
                    }
                    break;
                case 1:
                    for (int j = 0; j < listReport.size(); j++) {
                        circle2.put(listReport.get(j).getIdModulo(), listReport.get(j).getValor());
                    }
                    break;
                case 2:
                    for (int j = 0; j < listReport.size(); j++) {
                        circle3.put(listReport.get(j).getIdModulo(), listReport.get(j).getValor());
                    }
                    break;

            }
        }
        model.addCircle(circle1);
        model.addCircle(circle2);
        model.addCircle(circle3);

        return model;

    }
    private Long yu;

    public Long getYu() {
        return yu;
    }

    public void setYu(Long yu) {
        this.yu = yu;
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        LineChartSeries uno = new LineChartSeries();
        LineChartSeries dos = new LineChartSeries();
        LineChartSeries tres = new LineChartSeries();
        LineChartSeries cuatro = new LineChartSeries();
        LineChartSeries cinco = new LineChartSeries();
        LineChartSeries seis = new LineChartSeries();
        LineChartSeries siete = new LineChartSeries();
        LineChartSeries ocho = new LineChartSeries();
        LineChartSeries nueve = new LineChartSeries();
        LineChartSeries diez = new LineChartSeries();
        LineChartSeries once = new LineChartSeries();
        LineChartSeries doce = new LineChartSeries();

        Date hoy = new Date();
        hoy.setHours(0);
        hoy.setMinutes(0);
        hoy.setSeconds(0);
        setYu(objDaoConfiguracion.retirarCount());
        String ja = Long.toString(yu);
        int c = Integer.valueOf(ja);
        int k = 0;
        List<TreporteArqueos> listReporAux = new ArrayList();
        List<TreporteArqueos> listReporAux2 = new ArrayList();
        List<TConfiguracion> list = objDaoConfiguracion.llenarReporteEstado();
        List<Integer> listFechas = new ArrayList();
        List<String> listFechasEscritas = new ArrayList();
        int qu = 8;
        int yu = 0;
        while (qu <= 20) {
            listFechas.add(qu);
            qu++;
            switch (listFechas.get(yu)) {
                case 8:
                    listFechasEscritas.add("8AM");
                    break;
                case 9:
                    listFechasEscritas.add("9AM");
                    break;
                case 10:
                    listFechasEscritas.add("10AM");
                    break;
                case 11:
                    listFechasEscritas.add("11AM");
                    break;
                case 12:
                    listFechasEscritas.add("12PM");
                    break;
                case 13:
                    listFechasEscritas.add("1PM");
                    break;
                case 14:
                    listFechasEscritas.add("2PM");
                    break;
                case 15:
                    listFechasEscritas.add("3PM");
                    break;
                case 16:
                    listFechasEscritas.add("4PM");
                    break;
                case 17:
                    listFechasEscritas.add("5PM");
                    break;
                case 18:
                    listFechasEscritas.add("6PM");
                    break;
                case 19:
                    listFechasEscritas.add("7PM");
                    break;
                case 20:
                    listFechasEscritas.add("8PM");
                    break;
            }
            yu++;
        }
        for (int i = 0; i < listFechas.size(); i++) {
            List<TreporteArqueos> listReport = objDaoMovimientos.listReporte3Transacciones(listFechas.get(i), listFechas.get(i) + 1, hoy);
            if (c != listReport.size()) {
                listReporAux2 = listReport;
                listReporAux.clear();
                for (int t = 0; t < list.size(); t++) {
                    TreporteArqueos objVo = new TreporteArqueos(list.get(t).getIdModulo(), 0.0);
                    listReporAux.add(objVo);
                }
                for (int u = 0; u < listReport.size(); u++) {
                    for (int a = 0; a < listReporAux.size(); a++) {
                        if (listReport.get(u).getIdModulo().equals(listReporAux.get(a).getIdModulo())) {
                            listReporAux.remove(a);
                        }
                    }
                }
                for (int w = 0; w < listReporAux.size(); w++) {
                    TreporteArqueos objVo2 = new TreporteArqueos(listReporAux.get(w).getIdModulo(), listReporAux.get(w).getValor());
                    listReporAux2.add(objVo2);
                }
                listReport = listReporAux2;
            }
            switch (c) {
                case 1:
                    while (list.size() > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        uno.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                    }
                    break;

                case 2:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        }
                    }
                    break;
                case 3:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        }
                    }
                    break;
                case 5:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        }
                    }
                    break;
                case 6:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                        k++;
                        seis.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else {
                            seis.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        }
                    }
                    break;
                case 9:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                        k++;
                        seis.setLabel(list.get(k).getIdModulo());
                        k++;
                        siete.setLabel(list.get(k).getIdModulo());
                        k++;
                        ocho.setLabel(list.get(k).getIdModulo());
                        k++;
                        nueve.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (cinco.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (seis.getLabel().equals(listReport.get(j).getIdModulo())) {
                            seis.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (siete.getLabel().equals(listReport.get(j).getIdModulo())) {
                            siete.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (ocho.getLabel().equals(listReport.get(j).getIdModulo())) {
                            ocho.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else {
                            nueve.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        }
                    }
                    break;
                case 10:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                        k++;
                        seis.setLabel(list.get(k).getIdModulo());
                        k++;
                        siete.setLabel(list.get(k).getIdModulo());
                        k++;
                        ocho.setLabel(list.get(k).getIdModulo());
                        k++;
                        nueve.setLabel(list.get(k).getIdModulo());
                        k++;
                        diez.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (cinco.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (seis.getLabel().equals(listReport.get(j).getIdModulo())) {
                            seis.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (siete.getLabel().equals(listReport.get(j).getIdModulo())) {
                            siete.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (ocho.getLabel().equals(listReport.get(j).getIdModulo())) {
                            ocho.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (nueve.getLabel().equals(listReport.get(j).getIdModulo())) {
                            nueve.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (diez.getLabel().equals(listReport.get(j).getIdModulo())) {
                            diez.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        }
                    }

                    break;
                case 11:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                        k++;
                        seis.setLabel(list.get(k).getIdModulo());
                        k++;
                        siete.setLabel(list.get(k).getIdModulo());
                        k++;
                        ocho.setLabel(list.get(k).getIdModulo());
                        k++;
                        nueve.setLabel(list.get(k).getIdModulo());
                        k++;
                        diez.setLabel(list.get(k).getIdModulo());
                        k++;
                        once.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (cinco.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (seis.getLabel().equals(listReport.get(j).getIdModulo())) {
                            seis.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (siete.getLabel().equals(listReport.get(j).getIdModulo())) {
                            siete.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (ocho.getLabel().equals(listReport.get(j).getIdModulo())) {
                            ocho.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (nueve.getLabel().equals(listReport.get(j).getIdModulo())) {
                            nueve.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (diez.getLabel().equals(listReport.get(j).getIdModulo())) {
                            diez.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (once.getLabel().equals(listReport.get(j).getIdModulo())) {
                            once.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        }
                    }
                    break;
                case 12:
                    while (list.size() - 1 > k) {
                        uno.setLabel(list.get(k).getIdModulo());
                        k++;
                        dos.setLabel(list.get(k).getIdModulo());
                        k++;
                        tres.setLabel(list.get(k).getIdModulo());
                        k++;
                        cuatro.setLabel(list.get(k).getIdModulo());
                        k++;
                        cinco.setLabel(list.get(k).getIdModulo());
                        k++;
                        seis.setLabel(list.get(k).getIdModulo());
                        k++;
                        siete.setLabel(list.get(k).getIdModulo());
                        k++;
                        ocho.setLabel(list.get(k).getIdModulo());
                        k++;
                        nueve.setLabel(list.get(k).getIdModulo());
                        k++;
                        diez.setLabel(list.get(k).getIdModulo());
                        k++;
                        once.setLabel(list.get(k).getIdModulo());
                        k++;
                        doce.setLabel(list.get(k).getIdModulo());
                    }
                    for (int j = 0; j < listReport.size(); j++) {
                        if (uno.getLabel().equals(listReport.get(j).getIdModulo())) {
                            uno.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (dos.getLabel().equals(listReport.get(j).getIdModulo())) {
                            dos.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (tres.getLabel().equals(listReport.get(j).getIdModulo())) {
                            tres.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (cuatro.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cuatro.set(listFechasEscritas.get(i), listReport.get(j).getValor());

                        } else if (cinco.getLabel().equals(listReport.get(j).getIdModulo())) {
                            cinco.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (seis.getLabel().equals(listReport.get(j).getIdModulo())) {
                            seis.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (siete.getLabel().equals(listReport.get(j).getIdModulo())) {
                            siete.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (ocho.getLabel().equals(listReport.get(j).getIdModulo())) {
                            ocho.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (nueve.getLabel().equals(listReport.get(j).getIdModulo())) {
                            nueve.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (diez.getLabel().equals(listReport.get(j).getIdModulo())) {
                            diez.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (once.getLabel().equals(listReport.get(j).getIdModulo())) {
                            once.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        } else if (doce.getLabel().equals(listReport.get(j).getIdModulo())) {
                            doce.set(listFechasEscritas.get(i), listReport.get(j).getValor());
                        }
                    }
                    break;

            }

        }
        switch (c) {
            case 1:
                model.addSeries(uno);
                break;
            case 2:
                model.addSeries(uno);
                model.addSeries(dos);
                break;
            case 3:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                break;
            case 5:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                break;
            case 6:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                model.addSeries(seis);
                break;
            case 9:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                model.addSeries(seis);
                model.addSeries(siete);
                model.addSeries(ocho);
                model.addSeries(nueve);
                break;
            case 10:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                model.addSeries(seis);
                model.addSeries(siete);
                model.addSeries(ocho);
                model.addSeries(nueve);
                model.addSeries(diez);
                break;
            case 11:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                model.addSeries(seis);
                model.addSeries(siete);
                model.addSeries(ocho);
                model.addSeries(nueve);
                model.addSeries(diez);
                model.addSeries(once);
                break;
            case 12:
                model.addSeries(uno);
                model.addSeries(dos);
                model.addSeries(tres);
                model.addSeries(cuatro);
                model.addSeries(cinco);
                model.addSeries(seis);
                model.addSeries(siete);
                model.addSeries(ocho);
                model.addSeries(nueve);
                model.addSeries(diez);
                model.addSeries(once);
                model.addSeries(doce);
                break;
        }

        return model;
    }

    private void createBarModel() {
        barModel = initBarModel();
        barModel.setTitle("Cantidad de transacciones en " + titulo);
        barModel.setLegendPosition("e");
        barModel.setShowPointLabels(true);
        barModel.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
        barModel.setAnimate(true);
        barModel2 = initBarModel2();
        barModel2.setTitle("Transacciones  " + new Date().getDay() + " / " + new Date().getMonth() + " / " + new Date().getYear());
        barModel2.setLegendPosition("e");
        barModel2.setAnimate(true);

        lineModel1 = initLinearModel();
        Axis yAxis = lineModel1.getAxis(AxisType.Y);

        lineModel1.setTitle("Comisiones cobradas");
        lineModel1.setLegendPosition("e");
        lineModel1.setShowPointLabels(true);
        lineModel1.setLegendPosition("e");
        lineModel1.setZoom(true);
        lineModel1.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Horas"));
        yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Valor");
        yAxis.setMin(0);
        yAxis.setMax(1000000);
    }

    public beanCharts() {
    }

}
