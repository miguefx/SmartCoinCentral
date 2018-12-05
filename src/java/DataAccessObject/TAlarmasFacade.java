/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.TAlarmas;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author matc_
 */
@Stateless
public class TAlarmasFacade extends AbstractFacade<TAlarmas> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TAlarmasFacade() {
        super(TAlarmas.class);
    }

    public List<TAlarmas> actualizarTabla(Date fechaInicio, Date fechaFinal, Long cedula, String nombre) {
        try {
            Query query = em.createQuery("SELECT a from TAlarmas a , TPermisos as b where (a.fechaRegistro BETWEEN ?1 AND ?2) and (a.idModulo.idModulo=b.idModulo) and (b.documentoUsuario=?3) and (b.nombreControl=?4) ");
            query.setParameter(1, fechaInicio, TemporalType.TIMESTAMP);
            query.setParameter(2, fechaFinal, TemporalType.TIMESTAMP);
            query.setParameter(3, cedula);
            query.setParameter(4, nombre);
            List<TAlarmas> listAlarmasFiltradas = query.getResultList();
            return listAlarmasFiltradas;
        } catch (Exception e) {
        }
        return null;
    }

    public List<TAlarmas> actualizarTablaMensual() {
        try {
            Calendar cal = Calendar.getInstance();
            Date fechaHaceUnMes = cal.getTime();
            cal.setTime(fechaHaceUnMes);
            cal.add(Calendar.DAY_OF_MONTH, -30);
            fechaHaceUnMes = cal.getTime();
            Date hoy = new Date();

            Query query = em.createQuery("SELECT a from TAlarmas a where a.fechaRegistro BETWEEN ?1 AND ?2 ");
            query.setParameter(1, fechaHaceUnMes, TemporalType.TIMESTAMP);
            query.setParameter(2, hoy, TemporalType.TIMESTAMP);
            List<TAlarmas> listAlarmasFiltradas = query.getResultList();
            return listAlarmasFiltradas;
        } catch (Exception e) {
        }
        return null;
    }

    public List<TAlarmas> actualizarTablaSemana() {
        try {
            Calendar cal = Calendar.getInstance();
            Date fechaHaceUnMes = cal.getTime();
            cal.setTime(fechaHaceUnMes);
            cal.add(Calendar.DAY_OF_MONTH, -1);
            fechaHaceUnMes = cal.getTime();
            Date hoy = new Date();

            Query query = em.createQuery("SELECT a from TAlarmas a where a.fechaRegistro BETWEEN ?1 AND ?2 ");
            query.setParameter(1, fechaHaceUnMes, TemporalType.TIMESTAMP);
            query.setParameter(2, hoy, TemporalType.TIMESTAMP);
            List<TAlarmas> listAlarmasFiltradas = query.getResultList();
            return listAlarmasFiltradas;
        } catch (Exception e) {
        }
        return null;
    }

    public List<TAlarmas> alarmasNuevas() {
        try {
            Calendar cal = Calendar.getInstance();
            Date fechaHaceUnMes = cal.getTime();
            Date fechaActual = cal.getTime();
            cal.setTime(fechaHaceUnMes);
            cal.add(Calendar.HOUR, -1);
            fechaHaceUnMes = cal.getTime();

            Query query = em.createQuery("SELECT a from TAlarmas a WHERE a.fechaRegistro BETWEEN ?1 AND ?2  ");
            query.setParameter(1, fechaHaceUnMes, TemporalType.TIMESTAMP);
            query.setParameter(2, fechaActual, TemporalType.TIMESTAMP);
            List<TAlarmas> listAlarmasFiltradas = query.getResultList();
            return listAlarmasFiltradas;
        } catch (Exception e) {
        }
        return null;
    }

    public List<TAlarmas> listAlarmas(Long cedulaEnSession, String nombrePermiso) {
        try {
            Query query = em.createQuery("SELECT a from TAlarmas as a , TPermisos as b  where  (a.idModulo.idModulo=b.idModulo) and (b.documentoUsuario = ?1) and (b.nombreControl=?2)");
            query.setParameter(1, cedulaEnSession);
            query.setParameter(2, nombrePermiso);
            List<TAlarmas> list = query.getResultList();

            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
