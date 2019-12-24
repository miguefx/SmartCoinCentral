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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "beanCambios")
@ViewScoped
public class beanCambios implements Serializable {

    @EJB
    TSedesFacade objDaoSede;

    @EJB
    TCiudadesFacade objDaoCiudades;

    @EJB
    TMovimientosFacade objDaoMovimientos;

    @EJB
    TCambioFacade objDaoCambio;

    @EJB
    TConfiguracionFacade objDaoConfiguracion;

    @EJB
    TTransaccionesFacade objDaoTransacciones;

    @EJB

    TPermisosFacade objDaoPermisos;

    @EJB
    TPartesFacade objDaoPartes;

    @Setter
    private List<TCiudades> listSedes;

    @Getter
    @Setter
    private Long totalMonedas = new Long("0");

    @Getter
    @Setter
    private Double totalRecibidoFoot = 0.0;

    @Getter
    @Setter
    private Long totalesCantidad = new Long("0");

    @Getter
    @Setter
    private Double totalesValor = 0.0;

    @Getter
    @Setter
    private List<TConfiguracion> listModulos;

    @Getter
    @Setter
    private List<TCambio> listCambiosFiltrados;

    @Getter
    @Setter
    private List<TDonaciones> listCambiosFiltradoTable;

    @Getter
    @Setter
    private Date today = new Date();

    @Getter
    @Setter
    private static Long cedulaEnSession;

    @Setter
    private Date calendarIni;

    @Getter
    @Setter
    private Date calendarFin;

    @Getter
    @Setter
    private Long valorSede, valorSedeIgual;

    @Getter
    @Setter
    private String totalauxRecibidoFoot;

    @Getter
    @Setter
    private String totalauxComisionFoot;

    @Getter
    @Setter
    private String totalauxIvaFoot;

    @Getter
    @Setter
    private String totalauxRedondeoFoot;

    @Getter
    @Setter
    private String totalauxMonedas;

    @Getter
    @Setter
    private String valorModulo;

    @Getter
    @Setter
    private Date fechaInicialAux;

    @Getter
    @Setter
    private Date fechaFinalAux;

    private Double totalComisionFoot = 0.0;

    private Double totalIvaFoot = 0.0;


    @PostConstruct
    public void init() {
        calendarFin = new Date();
    }

    public List<TCiudades> getListSedes() {
        listSedes = objDaoCiudades.listaCiudadesCargas(cedulaEnSession, "Cambios");
        return listSedes;
    }

    public String obtenerEstado(Integer estado) {
        String estadoString = "";
        switch (estado) {
            case 1:
                estadoString = "Aprobado";
                break;
            case 2:
                estadoString = "Cancelado";
                break;
            case 3:
                estadoString = "Error Dispositivo";
                break;
            case 4:
                estadoString = "Error WebService";
                break;
            default:
                estadoString = "Desconocido";
        }
        return estadoString;
    }

    public Date getCalendarIni() {
        calendarIni = new Date();
        calendarIni.setHours(0);
        calendarIni.setMinutes(0);
        calendarIni.setSeconds(0);
        return calendarIni;
    }

    public void buscarCambios(ActionEvent egt) {
        try {
            if (calendarFin.before(calendarIni)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La fecha inicial debe ser menor que la fecha final", ""));

            } else if (calendarIni.after(new Date()) && calendarFin.after(new Date())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Las fechas no pueden superar la fecha actual", ""));
            } else {
                listCambiosFiltrados = objDaoCambio.actualizarCambios(calendarIni, calendarFin, valorModulo, valorSedeIgual, cedulaEnSession, "Cambios");
                listCambiosFiltrados.stream().forEach(cambio
                        -> {
                    totalRecibidoFoot = totalRecibidoFoot + cambio.getValorRetirado();
                    totalIvaFoot = totalIvaFoot + cambio.getIva();
                    totalComisionFoot = totalComisionFoot + cambio.getComision();
                    totalMonedas = totalMonedas + objDaoMovimientos.retornarTotalMonedasByIdTransaccion(cambio.getIdTransaccion().getIdTransaccion());
                });
            }
            DecimalFormat formatea = new DecimalFormat("###,###");
            totalauxRecibidoFoot = formatea.format(totalRecibidoFoot);
            totalauxComisionFoot = formatea.format(totalComisionFoot);
            totalauxIvaFoot = formatea.format(totalIvaFoot);
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        try {
            if (!listCambiosFiltrados.isEmpty()) {
                listCambiosFiltrados.clear();
                totalIvaFoot = 0.0;
                totalComisionFoot = 0.0;
                totalRecibidoFoot = 0.0;
                totalauxRecibidoFoot = "";
                totalauxComisionFoot = "";
                totalauxRedondeoFoot = "";
                totalauxRecibidoFoot = "";
                totalauxIvaFoot = "";
            }
        } catch (Exception e) {
        }
    }

    public void changeMenu(ActionEvent egt) {
        try {
            listModulos = objDaoConfiguracion.listModulosPorCiudades(valorSedeIgual, cedulaEnSession, "Cambios");
        } catch (Exception e) {
        }
    }

    public beanCambios() {
        cedulaEnSession = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cedula");
    }

}
