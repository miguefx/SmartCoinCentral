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

@ManagedBean(name = "beanRecargas")
@ViewScoped
public class beanRecargas implements Serializable {

    @EJB
    TSedesFacade objDaoSede;

    @EJB
    TCiudadesFacade objDaoCiudades;

    @EJB
    TMovimientosFacade objDaoMovimientos;

    @EJB
    TRecargasFacade objDaoRecargas;

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
    private List<TRecargas> listRecargasFiltrados;

    @Getter
    @Setter
    private List<TRecargas> listRecargasFiltradoTable;

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

    @PostConstruct
    public void init() {
            calendarFin=new Date();
    }

    public Date getCalendarIni() {
        calendarIni = new Date();
        calendarIni.setHours(0);
        calendarIni.setMinutes(0);
        calendarIni.setSeconds(0);
        return calendarIni;
    }

    public List<TCiudades> getListSedes() {
        listSedes = objDaoCiudades.listaCiudadesCargas(cedulaEnSession, "Recargas");
        return listSedes;
    }

    public void buscarRecargas(ActionEvent egt) {
        try {
            if (calendarFin.before(calendarIni)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La fecha inicial debe ser menor que la fecha final", ""));

            } else if (calendarIni.after(new Date()) && calendarFin.after(new Date())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Las fechas no pueden superar la fecha actual", ""));
            } else {
                listRecargasFiltrados = objDaoRecargas.actualizarRecargas(calendarIni, calendarFin, valorModulo, valorSedeIgual, cedulaEnSession, "Recargas");
                listRecargasFiltrados.stream().forEach(donacion
                        -> {
                    totalRecibidoFoot = totalRecibidoFoot + donacion.getValorOperacion();
                    totalMonedas = totalMonedas + objDaoMovimientos.retornarTotalMonedasByIdTransaccion(donacion.getIdTransaccion().getIdTransaccion());
                });
            }
            DecimalFormat formatea = new DecimalFormat("###,###");
            totalauxRecibidoFoot = formatea.format(totalRecibidoFoot);

        } catch (Exception e) {
        }
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


    public void limpiar() {
        try {
            if (!listRecargasFiltrados.isEmpty()) {
                listRecargasFiltrados.clear();
            }
        } catch (Exception e) {
        }
    }

    public void changeMenu(ActionEvent egt) {
        try {
            listModulos = objDaoConfiguracion.listModulosPorCiudades(valorSedeIgual, cedulaEnSession, "Donaciones");
        } catch (Exception e) {
        }
    }

    public beanRecargas() {
        cedulaEnSession = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cedula");
    }

}
