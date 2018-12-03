/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.TTransacciones;
import ValueObject.TreporteTransacciones;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author matc_
 */
@Stateless
public class TTransaccionesFacade extends AbstractFacade<TTransacciones> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TTransaccionesFacade() {
        super(TTransacciones.class);
    }

    public List<TTransacciones> listArqueosFinal(String idModulo, Long idSede, Date fechaInicialMax, Date fechaFinalMax) {
        try {
            Query query = em.createQuery("SELECT  a FROM TTransacciones a where a.idModulo.idModulo=?1 AND a.idSede.idSede = ?2 AND a.fechaTransaccion BETWEEN ?3 AND ?4 ");
            query.setParameter(1, idModulo);
            query.setParameter(2, idSede);
            query.setParameter(3, fechaFinalMax, TemporalType.TIMESTAMP);
            query.setParameter(4, fechaInicialMax, TemporalType.TIMESTAMP);
            List<TTransacciones> listTransacciones = query.getResultList();
            return listTransacciones;
        } catch (Exception e) {
        }
        return null;
    }

    public List<TTransacciones> actualizarTablaTransacciones(Date fechaInicio, Date fechaFinal, String idModulo, Long idSede, Long cedulaEnSession, String nombrePermiso) {
        try {
            String query2 = "";
            int casee = 0;
            if (idModulo == null && idSede == null) {
                query2 = "SELECT  a FROM TTransacciones AS a , TPermisos as b  WHERE  (a.fechaTransaccion BETWEEN ?1 and ?2)  and (b.idModulo=a.idModulo.idModulo) and (a.idSede.idCiudad.idciudad=b.idCiudad) and (b.documentoUsuario=?3) and (b.nombreContol=?4) and (a.totalPagado > 0)";
                casee = 1;
            } else if (idModulo == null && idSede != null) {
                query2 = "SELECT  a FROM TTransacciones AS a , TPermisos as b  WHERE  (a.fechaTransaccion BETWEEN ?1 and ?2) and (b.documentoUsuario=?3) and (b.nombreContol=?4) and (b.idModulo=a.idModulo.idModulo) and (a.idSede.idCiudad.idciudad=?5) and (a.totalPagado > 0)";
                casee = 2;
            } else if (idModulo != null && idSede == null) {
                query2 = "SELECT  a FROM TTransacciones AS a , TPermisos as b  WHERE  (a.fechaTransaccion BETWEEN ?1 and ?2) and (b.documentoUsuario=?3) and (b.nombreContol=?4) and (a.idModulo.idModulo=?5) and (a.idSede.idCiudad.idciudad=b.idCiudad) and (a.totalPagado > 0)";
                casee = 3;
            } else if (idModulo != null && idSede != null) {
                query2 = "SELECT DISTINCT  a FROM TTransacciones AS a , TPermisos as b  WHERE  (a.fechaTransaccion BETWEEN ?1 and ?2) and (b.documentoUsuario=?3) and (b.nombreContol=?4) and (a.idModulo.idModulo=?5) and (a.idSede.idCiudad.idciudad=?6) and (a.totalPagado > 0)";
                casee = 4;
            }
            Query query = em.createQuery(query2);
            query.setParameter(1, fechaInicio, TemporalType.TIMESTAMP);
            query.setParameter(2, fechaFinal, TemporalType.TIMESTAMP);
            query.setParameter(3, cedulaEnSession);
            query.setParameter(4, nombrePermiso);
            switch (casee) {
                case 1:
                    break;
                case 2:
                    query.setParameter(5, idSede);
                    break;
                case 3:
                    query.setParameter(5, idModulo);
                    break;
                case 4:
                    query.setParameter(5, idModulo);
                    query.setParameter(6, idSede);
                    break;
            }
            List<TTransacciones> listAlarmasFiltradas = query.getResultList();
            return listAlarmasFiltradas;
        } catch (Exception e) {
        }
        return null;
    }

    public List<TreporteTransacciones> listReporteTransacciones(Date fecha) {

        try {
            Date fechaEmpezandoMes;
            Date fechaTerminandoMes;
            fecha.setHours(0);
            fecha.setMinutes(0);
            fecha.setSeconds(0);

            Calendar a = Calendar.getInstance();
            a.setTime(fecha);

            a.set(a.get(Calendar.YEAR), a.get(Calendar.MONTH), a.getActualMaximum(Calendar.DAY_OF_MONTH));
            fechaTerminandoMes = a.getTime();

            a.set(a.get(Calendar.YEAR), a.get(Calendar.MONTH), a.getActualMinimum(Calendar.DAY_OF_MONTH));
            fechaEmpezandoMes = a.getTime();
            Query query = em.createNativeQuery("SELECT a.IdModulo,Count(*) as conteo from T_Transacciones as a, T_Configuracion as b where a.IdModulo=b.IdModulo and b.estado='1' and a.FechaTransaccion between ? and ? GROUP BY a.IdModulo order by a.IdModulo", "mapeoReporte2");
            query.setParameter(1, fechaEmpezandoMes);
            query.setParameter(2, fechaTerminandoMes);
            List<TreporteTransacciones> listReporte = query.getResultList();
            return listReporte;
        } catch (Exception e) {
        }
        return null;
    }

    public Double listReporteValor(String idModulo) {
        try {
            Date fechaCeros = new Date(), fechaActual = new Date();
            fechaCeros.setHours(0);
            fechaCeros.setMinutes(0);
            fechaCeros.setDate(fechaCeros.getDate());
            TypedQuery<Double> query = em.createQuery("SELECT SUM(a.valorRecibido) as valorTotal  from TTransacciones as a where a.idModulo.idModulo = ?1 and a.fechaTransaccion between ?2 and ?3", Double.class);
            query.setParameter(1, idModulo);
            query.setParameter(2, fechaCeros);
            query.setParameter(3, fechaActual);
            Double resultado = query.getSingleResult();
            if (resultado == null) {
                resultado = 0.0;
            }
            return resultado;

        } catch (Exception e) {
        }
        return null;
    }

}
