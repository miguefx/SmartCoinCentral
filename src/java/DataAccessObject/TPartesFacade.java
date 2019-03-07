/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.*;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author matc_
 */
@Stateless
public class TPartesFacade extends AbstractFacade<TPartes> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TPartesFacade() {
        super(TPartes.class);
    }

    public Double listReporteValor(String idModulo) {
        try {
            TypedQuery<Double> query = em.createQuery("SELECT SUM(a.dineroActual)  from TPartes as a where a.idModulo.idModulo = ?1 and a.tipoParte='F56'", Double.class);
            query.setParameter(1, idModulo);
            Double resultado = query.getSingleResult();
            if (resultado == null) {
                resultado = 0.0;
            }
            resultado = resultado + listReporteValor2(idModulo);
            return resultado;

        } catch (Exception e) {
        }
        return null;
    }

    public Double listReporteValor2(String idModulo) {
        try {
            TypedQuery<Double> query = em.createQuery("SELECT SUM(a.dineroActual)  from TPartes as a where a.idModulo.idModulo = ?1 and a.tipoParte='Hopper'", Double.class);
            query.setParameter(1, idModulo);
            Double resultado = query.getSingleResult();
            if (resultado == null) {
                resultado = 0.0;
            }
            return resultado;

        } catch (Exception e) {
        }
        return null;
    }

    public List<TSaldoEnLinea> generarDatosTablaPartes(String idModulo, Long idSede, Long cedulaEnSession, String nombrePermiso, Long count) {
        try {
            String query2 = "";
            int caso = 0;
            if (idModulo == null && idSede == null) {
                query2 = "select  NombreParte , Denominacion, SUM(CantidadActual) as cantidadActual, SUM(DineroActual) as dineroActual, TipoParte   from T_Partes as a, T_Permisos as b , T_Sedes as c  where (c.IdCiudad=b.IdCiudad) and (a.IdSede=c.IdSede) and (b.idModulo=a.idModulo) and (b.documentoUsuario=" + cedulaEnSession + ") and (b.nombreControl='" + nombrePermiso + "') group by NombreParte , TipoParte , Denominacion";
                caso = 1;
            } else if (idModulo == null && idSede != null) {
                query2 = "select  NombreParte, Denominacion, SUM(CantidadActual) as cantidadActual, SUM(DineroActual) as dineroActual , TipoParte   from T_Partes as a, T_Permisos as b , T_Sedes as c where   (b.idModulo=a.idModulo) and (b.documentoUsuario=" + cedulaEnSession + ") and (b.nombreControl='" + nombrePermiso + "') and (c.IdCiudad=" + idSede + ") and (a.IdSede=c.IdSede) group by NombreParte,TipoParte,Denominacion";
                caso = 2;
            } else if (idModulo != null && idSede == null) {
                query2 = "select  NombreParte, Denominacion, SUM(CantidadActual) as cantidadActual, SUM(DineroActual) as dineroActual , TipoParte   from T_Partes as a, T_Permisos as b , T_Sedes as c where   (a.idModulo='" + idModulo + "') and (b.documentoUsuario=" + cedulaEnSession + ") and (b.nombreControl='" + nombrePermiso + "') and (c.IdCiudad=b.IdCiudad) and (a.IdSede=c.IdSede) group by NombreParte,TipoParte,Denominacion";
                caso = 3;
            } else if (idModulo != null && idSede != null) {
                query2 = "select  NombreParte , Denominacion, SUM(CantidadActual)/" + count + " as cantidadActual, SUM(DineroActual)/" + count + " as dineroActual , TipoParte   from T_Partes as a, T_Permisos as b , T_Sedes as c where   (b.documentoUsuario=" + cedulaEnSession + ") and (b.nombreControl='" + nombrePermiso + "') and (a.idModulo='" + idModulo + "') and  (c.IdCiudad=" + idSede + ") and (a.IdSede=c.IdSede) group by NombreParte, TipoParte, Denominacion";
                caso = 4;
            }
            Query query = em.createNativeQuery(query2, "mapeo67");
            List<TSaldoEnLinea> listSaldos = query.getResultList();

            return listSaldos;

        } catch (Exception e) {
        }

        return null;
    }

    public void asd() {
        Query query = em.createQuery("SELECT a from TPartes a where a.idModulo.idModulo");
    }
}
