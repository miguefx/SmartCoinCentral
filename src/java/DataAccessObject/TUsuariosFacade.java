/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.TUsuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author matc_
 */
@Stateless
public class TUsuariosFacade extends AbstractFacade<TUsuarios> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TUsuariosFacade() {
        super(TUsuarios.class);
    }

    public String ingresar(TUsuarios objVOUsuarios) {
        String resultado = "";
        try {
            String auxResultado = verificarEstado(objVOUsuarios.getUsuario());
            if (auxResultado.equals("1")) {
                StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("P_AdminValidarClave;1");
                storedProcedure.registerStoredProcedureParameter("Usuario", String.class, ParameterMode.INOUT);
                storedProcedure.registerStoredProcedureParameter("clave", String.class, ParameterMode.IN);

                storedProcedure.setParameter("Usuario", objVOUsuarios.getUsuario());
                storedProcedure.setParameter("clave", objVOUsuarios.getContraseña());
                storedProcedure.execute();
                resultado = (String) storedProcedure.getOutputParameterValue("Usuario");

            } else if (auxResultado.equals(null)) {
                resultado = "LOGINOFF";
            } else if (auxResultado.equals("0")) {
                resultado = "ESTADOOFF";
            }

        } catch (Exception e) {

        }
        return resultado;
    }

    public Long encontrar(Long identifiacion) {
        Long t = new Long(0);
        try {
            Query query = em.createQuery("SELECT u FROM TUsuarios u where u.documento = ?1");
            query.setParameter(1, identifiacion);
            List<TUsuarios> listUsuarios = query.getResultList();
            if (!listUsuarios.isEmpty()) {
                t = (listUsuarios.get(0).getDocumento());
            }
        } catch (Exception e) {
        }

        return t;
    }

    public Long encontrarCedula(String usuario) {
        Long t = new Long("0");
        try {
            Query query = em.createQuery("SELECT u FROM TUsuarios u where u.usuario = ?1");
            query.setParameter(1, usuario);
            List<TUsuarios> listUsuarios = query.getResultList();
            if (!listUsuarios.isEmpty()) {
                t = (listUsuarios.get(0).getDocumento());
            }
        } catch (Exception e) {
        }

        return t;
    }

    

    public void registrar(TUsuarios objVoUsuarios) {
        try {

            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("P_AdminRegistrarUsuario;1");
            storedProcedure.registerStoredProcedureParameter("DOCUMENTO", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("IDEMPRESA", Long.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("NOMBRES", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("APELLIDOS", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("USUARIO", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("USUARIOCREADOR", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("CLAVE", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("CARGO", String.class, ParameterMode.IN);

            storedProcedure.setParameter("DOCUMENTO", String.valueOf(objVoUsuarios.getDocumento()));
            storedProcedure.setParameter("IDEMPRESA", objVoUsuarios.getIdEmpresa().getIdEmpresa());
            storedProcedure.setParameter("NOMBRES", objVoUsuarios.getNombres());
            storedProcedure.setParameter("APELLIDOS", objVoUsuarios.getApellidos());
            storedProcedure.setParameter("USUARIO", objVoUsuarios.getUsuario());
            storedProcedure.setParameter("USUARIOCREADOR", objVoUsuarios.getUsuarioCreador());
            storedProcedure.setParameter("CLAVE", objVoUsuarios.getContraseña());
            storedProcedure.setParameter("CARGO", objVoUsuarios.getCargo());
            storedProcedure.execute();

        } catch (Exception e) {
        }
    }

    public String verificarEstado(String usuario) {
        try {
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("P_AdminValidarEstado;1");
            storedProcedure.registerStoredProcedureParameter("Usuario", String.class, ParameterMode.INOUT);
            storedProcedure.setParameter("Usuario", usuario);
            storedProcedure.execute();
            String resultado = (String) storedProcedure.getOutputParameterValue("Usuario");
            return resultado;
        } catch (Exception e) {
        }
        return null;
    }

    public String cambiarContra(TUsuarios objVoUsuarios) {
        try {
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("P_AdminRestaurarClave;1");
            storedProcedure.registerStoredProcedureParameter("Documento", String.class, ParameterMode.INOUT);
            storedProcedure.registerStoredProcedureParameter("clave", String.class, ParameterMode.IN);

            storedProcedure.setParameter("Documento", String.valueOf(objVoUsuarios.getDocumento()));
            storedProcedure.setParameter("clave", objVoUsuarios.getContraseña());
            storedProcedure.execute();

            String resultado = (String) storedProcedure.getOutputParameterValue("Documento");
            return resultado;
        } catch (Exception e) {
        }

        return null;
    }

    public Integer generarTocken() {
        try {
            Integer j = 3;
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("P_AdminGenerarToken;1");
            storedProcedure.registerStoredProcedureParameter("token", Integer.class, ParameterMode.INOUT);
            storedProcedure.execute();
            Integer resultado = (Integer) storedProcedure.getOutputParameterValue("token");
            return resultado;
        } catch (Exception e) {
        }
        return 0;
    }

    public String actualizarEstado(Long documento) {
        String resultado = "";
        try {
            Query query = em.createQuery("SELECT a FROM TUsuarios a where a.documento = ?1");
            query.setParameter(1, documento);
            List<TUsuarios> list = query.getResultList();
            if (!list.isEmpty()) {
                if (list.get(0).getEstado()) {
                    resultado = "Desactivar";
                } else {
                    resultado = "Activar";
                }
            }
            return resultado;

        } catch (Exception e) {
        }
        return resultado;
    }
}
