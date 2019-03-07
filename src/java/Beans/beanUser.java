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
import java.math.BigInteger;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

@ManagedBean(name = "beanUser")
@SessionScoped
public class beanUser implements Serializable {

    //Inicializacion de EJB de las fachadas
    @EJB
    TUsuariosFacade objDaoUsuario;
    @EJB
    TEmpresasFacade objDaoEmpresas;
    @EJB
    TArqueosFacade objDaoArqueos;

    @EJB
    TCiudadesFacade objDaoCiudades;

    @EJB
    TConfiguracionFacade objDaoConfiguracion;

    @EJB
    TPermisosFacade objDaoPermisos;

    @EJB
    TSedesFacade objDaoSedes;

    //Atributos para usar en gestion de usuarios
    private static String mensajeEstado;
    private List<TUsuarios> listUsuarios;
    private List<TUsuarios> listFiltradaUsuarios;
    private TUsuarios objVoUsuarios;
    private Connection conexion = null;
    private TUsuarios seleccion;
    private Long valorSede, valorSedeIgual;
    private List<TCiudades> listSedes;
    private String valorModulo;
    private Boolean render = true;
    private Boolean render2 = true;
    private Boolean render3 = false;
    private Boolean renderpickList1 = false;
    private DualListModel<String> nombreBoton;
    private DualListModel<String> nombreBoton2;
    private static Long documentoElegido;
    private String nombreBtnRegistro;
    private String nombreBtnRegistro2;

    private List<TConfiguracion> listModulos;

    private static List<TPermisos> listPermisos;
    private static List<TPermisos> listPermisosDashBoard;

    private static List<String> listNombreControlSource = new ArrayList<>();
    private static List<String> listNombreControlTarget = new ArrayList<>();
    ;
    private static List<String> listNombreControlSource2 = new ArrayList<>();
    private static List<String> listNombreControlTarget2 = new ArrayList<>();
    ;

    //Lista Empresas
    private List<TEmpresas> listEmpresas;

    public String getMensajeEstado() {
        return mensajeEstado;
    }

    public void setMensajeEstado(String mensajeEstado) {
        this.mensajeEstado = mensajeEstado;
    }

    //Atributos para registrarUusario
    public String getNombreBtnRegistro2() {
        return nombreBtnRegistro2;
    }

    public Boolean getRenderpickList1() {
        return renderpickList1;
    }

    public void setRenderpickList1(Boolean renderpickList1) {
        this.renderpickList1 = renderpickList1;
    }

    public void setNombreBtnRegistro2(String nombreBtnRegistro2) {
        this.nombreBtnRegistro2 = nombreBtnRegistro2;
    }

    private Long identificacion;
    private String password;

    public static List<String> getListNombreControlSource2() {
        return listNombreControlSource2;
    }

    public static void setListNombreControlSource2(List<String> listNombreControlSource2) {
        beanUser.listNombreControlSource2 = listNombreControlSource2;
    }

    public static List<String> getListNombreControlTarget2() {
        return listNombreControlTarget2;
    }

    public static void setListNombreControlTarget2(List<String> listNombreControlTarget2) {
        beanUser.listNombreControlTarget2 = listNombreControlTarget2;
    }

    public DualListModel<String> getNombreBoton2() {
        return nombreBoton2;
    }

    public void setNombreBoton2(DualListModel<String> nombreBoton2) {
        this.nombreBoton2 = nombreBoton2;
    }

    public Boolean getRender3() {
        return render3;
    }

    public void setRender3(Boolean render3) {
        this.render3 = render3;
    }

    public String getNombreBtnRegistro() {
        return nombreBtnRegistro;
    }

    public void setNombreBtnRegistro(String nombreBtnRegistro) {
        this.nombreBtnRegistro = nombreBtnRegistro;
    }

    public Boolean getRender2() {
        return render2;
    }

    public void setRender2(Boolean render2) {
        this.render2 = render2;
    }

    public Boolean getRender() {
        return render;
    }

    public void setRender(Boolean render) {
        this.render = render;
    }

    public DualListModel<String> getNombreBoton() {
        return nombreBoton;
    }

    public void setNombreBoton(DualListModel<String> nombreBoton) {
        this.nombreBoton = nombreBoton;
    }

    public List<String> getListNombreControlSource() {
        return listNombreControlSource;
    }

    public void setListNombreControlSource(List<String> listNombreControlSource) {
        this.listNombreControlSource = listNombreControlSource;
    }

    public List<String> getListNombreControlTarget() {
        return listNombreControlTarget;
    }

    public void setListNombreControlTarget(List<String> listNombreControlTarget) {
        this.listNombreControlTarget = listNombreControlTarget;
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

    public List<TCiudades> getListSedes() {
        listSedes = objDaoCiudades.listaCiudadesPermisos();
        return listSedes;
    }

    public void setListSedes(List<TCiudades> listSedes) {
        this.listSedes = listSedes;
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

    public void changeMenu(ActionEvent egt) {
        try {
            listModulos = objDaoConfiguracion.listModulos(valorSedeIgual);
            render = false;
            render3 = false;
        } catch (Exception e) {
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TEmpresas> getListEmpresas() {
        listEmpresas = objDaoEmpresas.findAll();
        return listEmpresas;
    }

    public void setListEmpresas(List<TEmpresas> listEmpresas) {
        this.listEmpresas = listEmpresas;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public TUsuarios getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(TUsuarios seleccion) {
        this.seleccion = seleccion;
    }

    private String nombre;
    private String nombresParMostrar;
    private String cargo;
    private String apellido;
    private Long idEmpresa;
    private String contraseña;
    private String usuario;

    //Se crean boolean por cada uno de los botones
    private Boolean actualizacionDeDatos = false;
    private Boolean alarmas = false;
    private Boolean arqueos = false;
    private Boolean cargas = false;
    private Boolean gestionDeUsuarios = false;
    private Boolean registro = false;
    private Boolean reporteAnual = false;
    private Boolean reporteMensual = false;
    private Boolean saldoEnLinea = false;
    private Boolean transacciones = false;
    private Boolean claveDinamica = false;
    private Boolean btnConsultas = false;
    private Boolean btnReporte = false;
    private Boolean btnUsers = false;
    private Boolean reportesConsolidados = false;
    private Boolean reportesTransportadora = false;
    private Boolean drivers = false;
    private Boolean monitoreo = false;

    public Boolean getReportesTransportadora() {
        return reportesTransportadora;
    }

    public void setReportesTransportadora(Boolean reportesTransportadora) {
        this.reportesTransportadora = reportesTransportadora;
    }

    public Boolean getDrivers() {
        return drivers;
    }

    public void setDrivers(Boolean drivers) {
        this.drivers = drivers;
    }
    
    
    

    public Boolean getMonitoreo() {
        return monitoreo;
    }

    public void setMonitoreo(Boolean monitoreo) {
        this.monitoreo = monitoreo;
    }
    
    

    public Boolean getClaveDinamica() {
        return claveDinamica;
    }

    public Boolean getReportesConsolidados() {
        return reportesConsolidados;
    }

    public void setReportesConsolidados(Boolean reportesConsolidados) {
        this.reportesConsolidados = reportesConsolidados;
    }

    public void setClaveDinamica(Boolean claveDinamica) {
        this.claveDinamica = claveDinamica;
    }

    public Boolean getActualizacionDeDatos() {
        return actualizacionDeDatos;
    }

    public void setActualizacionDeDatos(Boolean actualizacionDeDatos) {
        this.actualizacionDeDatos = actualizacionDeDatos;
    }

    public Boolean getAlarmas() {
        return alarmas;
    }

    public void setAlarmas(Boolean alarmas) {
        this.alarmas = alarmas;
    }

    public Boolean getArqueos() {
        return arqueos;
    }

    public void setArqueos(Boolean arqueos) {
        this.arqueos = arqueos;
    }

    public Boolean getCargas() {
        return cargas;
    }

    public void setCargas(Boolean cargas) {
        this.cargas = cargas;
    }

    public Boolean getGestionDeUsuarios() {
        return gestionDeUsuarios;
    }

    public void setGestionDeUsuarios(Boolean gestionDeUsuarios) {
        this.gestionDeUsuarios = gestionDeUsuarios;
    }

    public Boolean getRegistro() {
        return registro;
    }

    public void setRegistro(Boolean registro) {
        this.registro = registro;
    }

    public Boolean getReporteAnual() {
        return reporteAnual;
    }

    public void setReporteAnual(Boolean reporteAnual) {
        this.reporteAnual = reporteAnual;
    }

    public Boolean getReporteMensual() {
        return reporteMensual;
    }

    public void setReporteMensual(Boolean reporteMensual) {
        this.reporteMensual = reporteMensual;
    }

    public Boolean getSaldoEnLinea() {
        return saldoEnLinea;
    }

    public void setSaldoEnLinea(Boolean saldoEnLinea) {
        this.saldoEnLinea = saldoEnLinea;
    }

    public Boolean getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Boolean transacciones) {
        this.transacciones = transacciones;
    }

    public String getNombresParMostrar() {
        return nombresParMostrar;
    }

    public void setNombresParMostrar(String nombresParMostrar) {
        this.nombresParMostrar = nombresParMostrar;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    private TEmpresas objVoEmpresas;

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<TUsuarios> getListFiltradaUsuarios() {
        return listFiltradaUsuarios;
    }

    public void setListFiltradaUsuarios(List<TUsuarios> listFiltradaUsuarios) {
        this.listFiltradaUsuarios = listFiltradaUsuarios;
    }

    public void session() {
        try {
            String resultad = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usr");
            if (resultad == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/login.xhtml");
                FacesContext context = FacesContext.getCurrentInstance();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Debe iniciar session."));
            }
        } catch (Exception e) {
        }
    }

    public void permiso() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String url = request.getRequestURL().toString();
            if (url.equals("http://107.180.70.70:9090/SmartCoin/alarmas.xhtml")) {
                if (alarmas == false) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/access.xhtml");
                }

            } else if (url.equals("http://107.180.70.70:9090/SmartCoin/arqueos.xhtml")) {
                if (arqueos == false) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/access.xhtml");
                }

            } else if (url.equals("http://107.180.70.70:9090/SmartCoin/transacciones.xhtml")) {
                if (transacciones == false) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/access.xhtml");
                }

            } else if (url.equals("http://107.180.70.70:9090/SmartCoin/cargas.xhtml")) {
                if (cargas == false) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/access.xhtml");
                }
            } else if (url.equals("http://107.180.70.70:9090/SmartCoin/saldosEnLinea.xhtml")) {
                if (saldoEnLinea == false) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/access.xhtml");
                }

            } else if (url.equals("http://107.180.70.70:9090/SmartCoin/registro.xhtml")) {
                if (registro == false) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/access.xhtml");
                }

            } else if (url.equals("http://107.180.70.70:9090/SmartCoin/gestionDeUsuarios.xhtml")) {
                if (gestionDeUsuarios == false) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/access.xhtml");
                }
            } else if (url.equals("http://107.180.70.70:9090/SmartCoin/reportesConsolidados.xhtml")) {
                if (reportesConsolidados == false) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/access.xhtml");
                }

            } else if (url.equals("http://107.180.70.70:9090/SmartCoin/reporteTransportadora.xhtml")) {
                if (reportesTransportadora == false) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/access.xhtml");
                }

            } else if (url.equals("http://107.180.70.70:9090/SmartCoin/monitoreo.xhtml")) {
                if (monitoreo == false) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/access.xhtml");
                }

            }

        } catch (Exception e) {
        }
    }

    public void eliminarSesion() {
        try {
            usuario = "";
            contraseña = "";
            HttpSession hs = sesion.getSession();
            hs.invalidate();

        } catch (Exception e) {
        }
    }

    public List<TUsuarios> getListUsuarios() {
        //Llenar tabla Gestion de usuarios
        listUsuarios = objDaoUsuario.findAll();
        return listUsuarios;
    }

    public void setListUsuarios(List<TUsuarios> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public void registrarUsuario(ActionEvent egt) {
        try {
            objVoUsuarios = new TUsuarios();
            objVoEmpresas = new TEmpresas();
            objVoUsuarios.setDocumento(identificacion);
            objVoUsuarios.setNombres(nombre);
            objVoUsuarios.setApellidos(apellido);
            objVoUsuarios.setCargo(cargo);
            objVoEmpresas = objDaoEmpresas.find(idEmpresa);
            objVoUsuarios.setIdEmpresa(objVoEmpresas);
            objVoUsuarios.setContraseña(password);
            objVoUsuarios.setUsuarioCreador(nombresParMostrar);
            objVoUsuarios.setUsuario(usuario);
            objDaoUsuario.registrar(objVoUsuarios);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfecto", "Usuario Registrado."));
            limpiar();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fallo", "Usuario No Registrado."));
        }
    }

    public void limpiar() {
        cargo = "";
        idEmpresa = Long.MIN_VALUE;
        identificacion = null;
        apellido = "";
        nombre = "";
        contraseña = "";
        usuario = "";
    }
    private static Long cedulaEnSession;
    private static List<String> listPermisosSession;

    public Boolean getBtnConsultas() {
        return btnConsultas;
    }

    public void setBtnConsultas(Boolean btnConsultas) {
        this.btnConsultas = btnConsultas;
    }

    public Boolean getBtnReporte() {
        return btnReporte;
    }

    public void setBtnReporte(Boolean btnReporte) {
        this.btnReporte = btnReporte;
    }

    public Boolean getBtnUsers() {
        return btnUsers;
    }

    public void setBtnUsers(Boolean btnUsers) {
        this.btnUsers = btnUsers;
    }

    public void ingresarLogin(ActionEvent egt) {
        try {
            objVoUsuarios = new TUsuarios();
            objVoUsuarios.setUsuario(usuario);
            objVoUsuarios.setContraseña(contraseña);
            String resultado = objDaoUsuario.ingresar(objVoUsuarios);

            if (resultado.equals("OK")) {
                cedulaEnSession = objDaoUsuario.encontrarCedula(usuario);
                objVoUsuarios = objDaoUsuario.find(cedulaEnSession);
                listPermisosSession = objDaoPermisos.buscarPermisosPorCedula(cedulaEnSession);
                List<Permisos> listaDePermisos = new ArrayList<>();

                listaDePermisos.add(new Permisos("Alarmas", false));
                listaDePermisos.add(new Permisos("Clave Dinamica", false));
                listaDePermisos.add(new Permisos("Arqueos", false));
                listaDePermisos.add(new Permisos("Transacciones", false));
                listaDePermisos.add(new Permisos("Cargas", false));
                listaDePermisos.add(new Permisos("Saldos en linea", false));
                listaDePermisos.add(new Permisos("Registro de usuarios", false));
                listaDePermisos.add(new Permisos("Gestion de usuarios", false));
                listaDePermisos.add(new Permisos("Reportes Consolidados", false));
                listaDePermisos.add(new Permisos("Reporte Transportadora", false));
                listaDePermisos.add(new Permisos("Monitoreo", false));
                if (listPermisosSession != null) {

                    for (int i = 0; i < listPermisosSession.size(); i++) {
                        for (int j = 0; j < listaDePermisos.size(); j++) {
                            if (listPermisosSession.get(i).equals(listaDePermisos.get(j).getNombrePermiso())) {
                                listaDePermisos.get(j).setEstado(true);
                            }
                        }
                    }
                    for (int i = 0; i < listaDePermisos.size(); i++) {
                        if (listaDePermisos.get(i).getNombrePermiso().equals("Alarmas")) {
                            alarmas = listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Clave Dinamica")) {
                            claveDinamica = listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Arqueos")) {
                            arqueos = listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Transacciones")) {
                            transacciones = listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Cargas")) {
                            cargas = listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Saldos en linea")) {
                            saldoEnLinea = listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Registro de usuarios")) {
                            registro = listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Gestion de usuarios")) {
                            gestionDeUsuarios = listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Reporte Mensual")) {
                            reporteMensual = listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Reporte Anual")) {
                            reporteAnual = listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Reportes Consolidados")) {
                            reportesConsolidados = listaDePermisos.get(i).getEstado();
                        }else if (listaDePermisos.get(i).getNombrePermiso().equals("Reporte Transportadora")) {
                            reportesTransportadora=listaDePermisos.get(i).getEstado();
                        } else if (listaDePermisos.get(i).getNombrePermiso().equals("Monitoreo")) {
                            monitoreo = listaDePermisos.get(i).getEstado();
                        }
                    }

                    if (arqueos || transacciones || saldoEnLinea || cargas || monitoreo) {
                        btnConsultas = true;
                    }
                    if (registro || gestionDeUsuarios) {
                        btnUsers = true;
                    }
                    if (reportesConsolidados || reportesTransportadora) {
                        btnReporte = true;
                    }
                }

                nombresParMostrar = objVoUsuarios.getNombres() + " " + objVoUsuarios.getApellidos();
                HttpSession hs = sesion.getSession();
                hs.setAttribute("usr", nombresParMostrar);
                hs.setAttribute("cedula", cedulaEnSession);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfecto", ""));
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/dashboard.xhtml");
                FacesContext context = FacesContext.getCurrentInstance();
            } else if (resultado.equals("LOGINOFF")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hubo un error", "El usuario o la contraseña son incorrectos."));
            } else if (resultado.equals("ESTADOOFF")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hubo un error", "El usuario al que intenta ingresar esta desactivado."));

            }

        } catch (Exception e) {
        }
    }

    public void ir() {
        try {
            HttpSession hs = sesion.getSession();
            hs.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SmartCoin/error.xhtml");
        } catch (Exception e) {
        }
    }

    public void cambiarContraseña(ActionEvent egt) {
        try {
            objVoUsuarios = new TUsuarios();
            objVoUsuarios.setDocumento(identificacion);
            objVoUsuarios.setContraseña(password);
            String respuesta = objDaoUsuario.cambiarContra(objVoUsuarios);
            if (respuesta.equals("OK")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Contraseña Actualizada"));
                identificacion = null;
                password = "";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo cambiar la contraseña", " "));
            }

        } catch (Exception e) {

        }
    }

    @EJB
    TTransaccionesFacade objDaoTransacciones;

    private Date fechaFin;
    private TPermisos objVoPermisos;
    private Date fechaInicio;
    private static List<TTransacciones> listReport;

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

    private List<Persona> personas = new ArrayList<Persona>();

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public beanUser() {
    }

    private Boolean banderaDisa = true;

    public Boolean getBanderaDisa() {
        return banderaDisa;
    }

    public void setBanderaDisa(Boolean banderaDisa) {
        this.banderaDisa = banderaDisa;
    }

    public void encontrarActualizar(ActionEvent egt) {

        try {
            objVoUsuarios = new TUsuarios();
            objVoUsuarios = objDaoUsuario.find(cedulaEnSession);
            cargo = objVoUsuarios.getCargo();
            apellido = objVoUsuarios.getApellidos();
            nombre = objVoUsuarios.getNombres();
            usuario = objVoUsuarios.getUsuario();
            idEmpresa = objVoUsuarios.getIdEmpresa().getIdEmpresa();

        } catch (Exception e) {
        }
    }

    private Boolean editar = false;

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public void actulizarRegistro(ActionEvent egt) {
        try {
            objVoEmpresas = new TEmpresas();
            objVoUsuarios = new TUsuarios();
            objVoUsuarios = objDaoUsuario.find(cedulaEnSession);
            objVoUsuarios.setCargo(cargo);
            objVoUsuarios.setNombres(nombre);
            objVoUsuarios.setApellidos(apellido);
            objVoUsuarios.setUsuario(usuario);
            objVoEmpresas = objDaoEmpresas.find(idEmpresa);
            objVoUsuarios.setIdEmpresa(objVoEmpresas);
            objVoUsuarios.setDocumento(cedulaEnSession);
            objDaoUsuario.edit(objVoUsuarios);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Usuario Actualizado"));
            banderaDisa = true;
            editar = false;cargo="";
            nombre="";
            apellido="";
            usuario="";
            

        } catch (Exception e) {
        }
    }

    public void editarCampos(ActionEvent egt) {
        try {
            banderaDisa = false;
            editar = true;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bien", "Edita los valores de los campos que desees modificar"));

        } catch (Exception e) {
        }
    }

    public void actualizarEstado(ActionEvent egt) {
        try {
            objVoUsuarios = new TUsuarios();
            objVoUsuarios = objDaoUsuario.find(documentoElegido);
            Boolean bandera;
            if (mensajeEstado.equals("Desactivar")) {
                bandera = false;
            } else {
                bandera = true;
            }
            objVoUsuarios.setEstado(bandera);
            objDaoUsuario.edit(objVoUsuarios);
            FacesMessage msg = new FacesMessage("Usuario Actualizado");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
        }
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public String onflowBackProcess(FlowEvent event) {
        return event.getOldStep();
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Usuario elegido", ((TUsuarios) event.getObject()).getUsuario());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        documentoElegido = ((TUsuarios) event.getObject()).getDocumento();
        render2 = false;
        render = true;
        valorSedeIgual = null;
        valorModulo = "";
        renderpickList1 = false;
        if (!listNombreControlSource.isEmpty()) {
            listNombreControlSource.clear();
        }
        if (!listNombreControlTarget.isEmpty()) {
            listNombreControlTarget.clear();
        }
        if (!listNombreControlSource2.isEmpty()) {
            listNombreControlSource2.clear();
        }
        if (!listNombreControlTarget2.isEmpty()) {
            listNombreControlTarget2.clear();
        }
        mensajeEstado = objDaoUsuario.actualizarEstado(documentoElegido);

    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Ya no esta elegido", ((TUsuarios) event.getObject()).getUsuario());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void regitrarPermisos(ActionEvent egt) {
        try {

            List<String> auxListPermisos = new ArrayList<>();
            List<String> auxDataTarget = nombreBoton.getTarget();
            for (int i = 0; i < listaPrimera.size(); i++) {
                for (int j = 0; j < nombreBoton.getSource().size(); j++) {
                    if (listaPrimera.get(i).equals(nombreBoton.getSource().get(j))) {
                        auxListPermisos.add(listaPrimera.get(i));
                    }
                }

            }
            for (int q = 0; q < listPermisos.size(); q++) {
                for (int l = 0; l < nombreBoton.getTarget().size(); l++) {
                    if (listPermisos.get(q).getNombreControl().equals(nombreBoton.getTarget().get(l))) {
                        nombreBoton.getTarget().remove(l);
                    }
                }

            }
            Long numeroSede = objDaoConfiguracion.averiguarSedePorNombre(valorModulo);
            for (int i = 0; i < nombreBoton.getTarget().size(); i++) {
                objVoPermisos = new TPermisos();
                objVoPermisos.setDocumentoUsuario(documentoElegido);
                objVoPermisos.setSincronizacion(false);
                objVoPermisos.setNombreControl(nombreBoton.getTarget().get(i));
                objVoPermisos.setIdModulo(valorModulo);
                objVoPermisos.setIdCiudad(BigInteger.valueOf(valorSedeIgual));
                objVoPermisos.setIdSede(BigInteger.valueOf(numeroSede));
                objDaoPermisos.create(objVoPermisos);
            }
            for (int i = 0; i < listPermisos.size(); i++) {
                for (int j = 0; j < auxListPermisos.size(); j++) {
                    if (auxListPermisos.get(j).equals(listPermisos.get(i).getNombreControl())) {
                        objVoPermisos = new TPermisos();
                        objVoPermisos = objDaoPermisos.find(listPermisos.get(i).getIdPermiso());
                        objDaoPermisos.remove(objVoPermisos);
                    }
                }
            }
            if (!nombreBoton.getTarget().isEmpty()) {
                nombreBoton.getTarget().clear();
                listNombreControlTarget.clear();
            }
            FacesMessage msg = new FacesMessage("Los permisos fueron registrados");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            render = true;
            valorSedeIgual = null;
            valorModulo = null;

        } catch (Exception e) {
        }
    }

    public void regitrarPermisos2(ActionEvent egt) {
        try {

            List<String> auxListPermisos = new ArrayList<>();
            List<String> auxDataTarget = nombreBoton2.getTarget();
            for (int i = 0; i < listaPrimera2.size(); i++) {
                for (int j = 0; j < nombreBoton2.getSource().size(); j++) {
                    if (listaPrimera2.get(i).equals(nombreBoton2.getSource().get(j))) {
                        auxListPermisos.add(listaPrimera2.get(i));
                    }
                }

            }
            for (int q = 0; q < listPermisosDashBoard.size(); q++) {
                for (int l = 0; l < nombreBoton2.getTarget().size(); l++) {
                    if (listPermisosDashBoard.get(q).getNombreControl().equals(nombreBoton2.getTarget().get(l))) {
                        nombreBoton2.getTarget().remove(l);
                    }
                }

            }
            for (int i = 0; i < nombreBoton2.getTarget().size(); i++) {
                objVoPermisos = new TPermisos();
                objVoPermisos.setDocumentoUsuario(documentoElegido);
                objVoPermisos.setSincronizacion(false);
                objVoPermisos.setNombreControl(nombreBoton2.getTarget().get(i));
                objVoPermisos.setIdModulo("DashBoard");
                objVoPermisos.setIdCiudad(new BigInteger("0"));
                objVoPermisos.setIdSede(new BigInteger("0"));
                objDaoPermisos.create(objVoPermisos);
            }
            for (int i = 0; i < listPermisosDashBoard.size(); i++) {
                for (int j = 0; j < auxListPermisos.size(); j++) {
                    if (auxListPermisos.get(j).equals(listPermisosDashBoard.get(i).getNombreControl())) {
                        objVoPermisos = new TPermisos();
                        objVoPermisos = objDaoPermisos.find(listPermisosDashBoard.get(i).getIdPermiso());
                        objDaoPermisos.remove(objVoPermisos);
                    }
                }
            }
            if (!nombreBoton2.getTarget().isEmpty()) {
                nombreBoton2.getTarget().clear();
                listNombreControlTarget2.clear();
            }
            FacesMessage msg = new FacesMessage("Los permisos fueron registrados");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            render3 = true;

        } catch (Exception e) {
        }
    }
    public static List<String> listaPrimera;
    public static List<String> listaPrimera2;

    public void changePick(ActionEvent egt) {
        try {
            nombreBoton = new DualListModel<String>(listNombreControlSource, listNombreControlTarget);
            nombreBoton2 = new DualListModel<String>(listNombreControlSource2, listNombreControlTarget2);

            if (!listNombreControlSource.isEmpty()) {
                listNombreControlSource.clear();
            }
            if (!listNombreControlTarget.isEmpty()) {
                listNombreControlTarget.clear();
            }
            if (!listNombreControlSource2.isEmpty()) {
                listNombreControlSource2.clear();
            }
            if (!listNombreControlTarget2.isEmpty()) {
                listNombreControlTarget2.clear();
            }
            listPermisos = objDaoPermisos.buscarPermisos(documentoElegido, valorModulo);
            listPermisosDashBoard = objDaoPermisos.buscarPermisos(documentoElegido, "DashBoard");
            listNombreControlSource.add("Alarmas");
            listNombreControlSource.add("Arqueos");
            listNombreControlSource.add("Transacciones");
            listNombreControlSource.add("Cargas");
            listNombreControlSource.add("Saldos en linea");
            listNombreControlSource2.add("Clave Dinamica");
            listNombreControlSource2.add("Registro de usuarios");
            listNombreControlSource2.add("Gestion de usuarios");
            listNombreControlSource2.add("Reportes Consolidados");
            listNombreControlSource2.add("Reporte Transportadora");
            listNombreControlSource2.add("Monitoreo");

            for (int i = 0; i < listPermisos.size(); i++) {
                for (int j = 0; j < listNombreControlSource.size(); j++) {
                    if (listPermisos.get(i).getNombreControl().equals(listNombreControlSource.get(j))) {
                        listNombreControlTarget.add(listNombreControlSource.get(j));
                        listNombreControlSource.remove(j);
                    }
                }
            }

            for (int i = 0; i < listPermisosDashBoard.size(); i++) {
                for (int j = 0; j < listNombreControlSource2.size(); j++) {
                    if (listPermisosDashBoard.get(i).getNombreControl().equals(listNombreControlSource2.get(j))) {
                        listNombreControlTarget2.add(listNombreControlSource2.get(j));
                        listNombreControlSource2.remove(j);
                    }
                }
            }

            if (!listPermisos.isEmpty()) {
                nombreBtnRegistro = "Actualizar Permisos";
            } else {
                nombreBtnRegistro = "Registrar Permisos";
            }

            if (!listPermisosDashBoard.isEmpty()) {
                nombreBtnRegistro2 = "Actualizar Permisos";
            } else {
                nombreBtnRegistro2 = "Registrar Permisos";
            }
            listaPrimera = listNombreControlTarget;
            listaPrimera2 = listNombreControlTarget2;
            renderpickList1 = true;
        } catch (Exception e) {
        }
    }

}
