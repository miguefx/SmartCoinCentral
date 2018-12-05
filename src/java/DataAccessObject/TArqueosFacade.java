/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.*;
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
public class TArqueosFacade extends AbstractFacade<TArqueos> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TArqueosFacade() {
        super(TArqueos.class);
    }
     public List<TArqueos> actualizarTablaArqueos(Date fechaInicio, Date fechaFinal, String idModulo, Long idSede,Long cedulaEnSession,String nombrePermiso) {
        try {
            String query2 = "";
            int casee = 0;
            if (idModulo == null && idSede == null) {
                query2 = "SELECT  a FROM TArqueos AS a , TPermisos as b  WHERE  (a.fechaInicio BETWEEN ?1 and ?2)  and (b.idModulo=a.idModulo.idModulo) and (a.idSede.idCiudad.idciudad=b.idCiudad) and (b.documentoUsuario=?3) and (b.nombreControl=?4)";
                casee = 1;
            } else if (idModulo == null && idSede != null) {
                query2 = "SELECT  a FROM TArqueos AS a , TPermisos as b  WHERE  (a.fechaInicio BETWEEN ?1 and ?2) and (b.documentoUsuario=?3) and (b.nombreControl=?4) and (b.idModulo=a.idModulo.idModulo) and (a.idSede.idCiudad.idciudad=?5)";
                casee = 2;
            } else if (idModulo != null && idSede == null) {
                query2 = "SELECT  a FROM TArqueos AS a , TPermisos as b  WHERE  (a.fechaInicio BETWEEN ?1 and ?2) and (b.documentoUsuario=?3) and (b.nombreControl=?4) and (a.idModulo.idModulo=?5) and (a.idSede.idCiudad.idciudad=b.idCiudad)";
                casee = 3;
            } else if (idModulo != null && idSede != null) {
                query2 = "SELECT DISTINCT  a FROM TArqueos AS a , TPermisos as b  WHERE  (a.fechaInicio BETWEEN ?1 and ?2) and (b.documentoUsuario=?3) and (b.nombreControl=?4) and (a.idModulo.idModulo=?5) and (a.idSede.idCiudad.idciudad=?6)";
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
                    query.setParameter(5,idSede);
                    break;
                case 3:
                    query.setParameter(5, idModulo);
                    break;
                case 4:
                    query.setParameter(5, idModulo);
                    query.setParameter(6, idSede);
                    break;
            }
            List<TArqueos> listAlarmasFiltradas = query.getResultList();
            return listAlarmasFiltradas;
        } catch (Exception e) {
        }
        return null;
    }

    public Date retornarUltimoFechaArqueo(String idModulo, Long idSede) {
        Date ultimaFecha;
        try {
            TypedQuery<Date> query = em.createQuery("SELECT max(a.fechaFin)FROM TArqueos a WHERE (a.idModulo.idModulo = ?1 AND a.idSede.idCiudad.idciudad = ?2)  ", Date.class);
            query.setParameter(1, idModulo);
            query.setParameter(2, idSede);
            ultimaFecha = query.getSingleResult();
            return ultimaFecha;
        } catch (Exception e) {
        }
        return null;
    }

        public List<TreporteArqueos> listReporte1(Date fecha) {
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
            Query query = em.createNativeQuery("SELECT a.IdModulo,SUM(a.Valor) as valor2 from T_Arqueos as a , T_Configuracion as b WHERE a.IdModulo=b.IdModulo and b.estado='1' and a.FechaInicio between ? and ? GROUP BY a.IdModulo", "mapeoReporte1");
            query.setParameter(1, fechaEmpezandoMes);
            query.setParameter(2, fechaTerminandoMes);
            List<TreporteArqueos> listReportes1 = query.getResultList();
            return listReportes1;
        } catch (Exception e) {
        }
        return null;
    }

    
}
