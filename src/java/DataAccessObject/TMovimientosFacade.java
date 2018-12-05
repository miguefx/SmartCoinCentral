/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.TMovimientos;
import ValueObject.TmovimientosTable;
import ValueObject.TreporteArqueos;
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
public class TMovimientosFacade extends AbstractFacade<TMovimientos> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TMovimientosFacade() {
        super(TMovimientos.class);
    }

    public List<TmovimientosTable> retornarListaMovimientos(String idModulo, Long idArqueo) {
        try {
            Query query = em.createNativeQuery("select Parte, Denominacion, SUM(Cantidad) as cantidad, Accion, SUM(Valor) as valor from T_Movimientos WHERE (IdModulo = ?) and (IdArqueo = ?) group by Denominacion,Parte,Accion", "mapeo");
            query.setParameter(1, idModulo);
            query.setParameter(2, idArqueo);
            List<TmovimientosTable> listMovimientos = query.getResultList();
            return listMovimientos;
        } catch (Exception e) {
        }
        return null;
    }

    public List<TmovimientosTable> retornarListaMovimientosById(Long idTransaccion, String idModulo) {
        try {
            Query query = em.createNativeQuery("select IdMovimiento, Parte, Denominacion, SUM(Cantidad) as cantidad, SUM(Valor) as valor, Accion from T_Movimientos WHERE IdTransaccion = ? and IdModulo = ?  group by Denominacion,Parte, IdMovimiento,Accion", "mapeo");
            query.setParameter(1, idTransaccion);
            query.setParameter(2, idModulo);
            List<TmovimientosTable> listMovimientos = query.getResultList();
            return listMovimientos;
        } catch (Exception e) {
        }
        return null;
    }

    public List<TmovimientosTable> retornarListaMovimientosByIdCarga(Long idCarga, String idModulo) {
        try {
            Query query = em.createNativeQuery("select Parte, Denominacion, SUM(Cantidad) as cantidad, SUM(Valor) as valor from T_Movimientos WHERE IdCarga = ? and IdModulo = ? group by Denominacion,Parte", "mapeo");
            query.setParameter(1, idCarga);
            query.setParameter(2, idModulo);
            List<TmovimientosTable> listMovimientos = query.getResultList();
            return listMovimientos;
        } catch (Exception e) {
        }
        return null;
    }

    public List<TreporteArqueos> listReporte3Transacciones(int primeraHora, int segundaHora, Date fecha) {

        Date fechaPrimera = new Date();
        Date fechaSegunda = new Date();
        fechaPrimera.setMinutes(0);
        fechaPrimera.setSeconds(0);
        fechaSegunda.setSeconds(0);
        fechaSegunda.setMinutes(0);
        fechaPrimera.setHours(primeraHora);
        fechaSegunda.setHours(segundaHora);

        try {
            Query query = em.createNativeQuery("select a.IdModulo, SUM(a.ValorRecibido) as valor2 from T_Transacciones as a, T_Configuracion as b  where a.IdModulo=b.IdModulo and b.estado='1' and a.FechaTransaccion between ? and ?  group by a.IdModulo ", "mapeoReporte1");
            query.setParameter(1, fechaPrimera);
            query.setParameter(2, fechaSegunda);
            List<TreporteArqueos> listMovimientosRepport = query.getResultList();
            return listMovimientosRepport;
        } catch (Exception e) {
        }
        return null;
    }

    public Long totalMonedas(Date fechaInicio, Date fechaFinal, String idModulo, Long idSede, Long cedulaEnSession, String nombrePermiso, Long idCiudad) {
        Long resultado = new Long("0");
        String query2 = "";
        int caso = 0;
        if (idModulo == null && idSede == null) {
            query2 = "SELECT DISTINCT SUM(a.cantidad) from TMovimientos AS a , TPermisos as b  where (a.parte='CtCoin') and (a.accion = 'Entrada') and (a.fechaMovimiento BETWEEN ?1 and ?2) and (a.idModulo=b.idModulo) and (a.idSede=b.idSede) and (b.documentoUsuario=?3) and (b.nombreControl=?4) ";
            caso = 1;
        } else if (idModulo == null && idSede != null) {
            query2 = "SELECT DISTINCT SUM(a.cantidad) from TMovimientos AS a , TPermisos as b, TSedes as d   where (a.parte='CtCoin') and (a.accion = 'Entrada') and (a.fechaMovimiento BETWEEN ?1 and ?2)  and (b.documentoUsuario=?3) and (b.nombreControl=?4) and (a.idModulo=b.idModulo) and (a.idSede=d.idSede) and (d.idCiudad.idciudad=?5)";
            caso = 2;
        } else if (idModulo != null && idSede == null) {
            query2 = "SELECT DISTINCT SUM(a.cantidad) from TMovimientos AS a , TPermisos as b  where (a.parte='CtCoin') and (a.accion = 'Entrada') and (a.fechaMovimiento BETWEEN ?1 and ?2)  and (b.documentoUsuario=?3) and (b.nombreControl=?4) and (a.idModulo=?5) and (a.idSede=b.idSede)";
            caso = 3;
        } else if (idModulo != null && idSede != null) {
            query2 = "SELECT DISTINCT SUM(a.cantidad) from TMovimientos AS a , TPermisos as b  where (a.parte='CtCoin') and (a.accion = 'Entrada') and (a.fechaMovimiento BETWEEN ?1 and ?2)  and (b.documentoUsuario=?3) and (b.nombreControl=?4) and (a.idModulo=?5) and (a.idSede=?6)";
            caso = 4;
        }

        try {
            TypedQuery<Long> query = em.createQuery(query2, Long.class);
            query.setParameter(1, fechaInicio, TemporalType.TIMESTAMP);
            query.setParameter(2, fechaFinal, TemporalType.TIMESTAMP);
            query.setParameter(3, cedulaEnSession);
            query.setParameter(4, nombrePermiso);
            switch (caso) {
                case 1:
                    break;
                case 2:
                    query.setParameter(5, idCiudad);
                    break;
                case 3:
                    query.setParameter(5, idModulo);
                    break;
                case 4:
                    query.setParameter(5, idModulo);
                    query.setParameter(6, idSede);
                    break;
            }

            resultado = query.getSingleResult();
        } catch (Exception e) {
        }
        return resultado;
    }

    public void asdasd() {
        try {
            Query query = em.createQuery("select a from TMovimientos as a, TPermisos as b, TCiudades AS c,TSedes as d where a.idModulo=b.idModulo and a.idSede=b.idSede and a.idSede=d.idSede and d.idCiudad.idciudad?1 ");
        } catch (Exception e) {
        }
    }

    public Long retornarTotalMonedasByIdTransaccion(Long idTransaccion) {
        try {
            TypedQuery<Long> query = (TypedQuery<Long>) em.createQuery("SELECT SUM(a.cantidad) from TMovimientos as a where a.idTransaccion = ?1 and a.accion='Entrada' and a.parte='CtCoin'", Long.class);
            query.setParameter(1, idTransaccion);
            Long resultado = query.getSingleResult();
            if (resultado==null) {
                 resultado= new Long("0");
            }
            return resultado;
        } catch (Exception e) {
        }
        return null;
    }
}
