/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.TMonitoreo;
import ValueObject.TMonitoreoHoras;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author miguel
 */
@Stateless
public class TMonitoreoFacade extends AbstractFacade<TMonitoreo> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TMonitoreoFacade() {
        super(TMonitoreo.class);
    }

    public List<TMonitoreoHoras> listMonitoreo(TMonitoreo objVoMonitoreo, String modulo, Long idCiudad) {
        try {
            String queryAux = "SELECT DISTINCT right('0'+ SUBSTRING(CONVERT(VARCHAR(50),CAST(DATEDIFF(hour, FechaReporte ,GETDATE()) % 24 AS MONEY),1),1,Len(CONVERT(VARCHAR(50),CAST(DATEDIFF(hour, FechaReporte ,GETDATE()) % 24 AS MONEY),1))-3),2) + ':' + right('0' + SUBSTRING(CONVERT(VARCHAR(50),CAST(DATEDIFF(minute, FechaReporte ,GETDATE()) % 60 AS MONEY),1),1,Len(CONVERT(VARCHAR(50),CAST(DATEDIFF(minute, FechaReporte ,GETDATE()) % 60 AS MONEY),1))-3),2) + ':' + right('0' + SUBSTRING(CONVERT(VARCHAR(50),CAST(DATEDIFF(second, FechaReporte ,GETDATE()) % 60 AS MONEY),1),1,Len(CONVERT(VARCHAR(50),CAST(DATEDIFF(second, FechaReporte ,GETDATE()) % 60 AS MONEY),1))-3),2) AS dateFinal,a.IdModulo as modulo,EstadoPantalla as estado from T_Monitoreo as a , T_Configuracion as b , T_Sedes as c , T_Ciudades as d WHERE d.IDCIUDAD=c.IdCiudad and c.IdSede=b.IdSede and b.IdModulo=a.IdModulo";
            String queryWhere = "";
            int caso = 0;
            if (modulo == null && idCiudad == null) {

            } else if (modulo != null && idCiudad == null) {
                queryWhere = " and b.IdModulo='" + modulo + "' ";

            } else if (modulo == null && idCiudad != null) {
                queryWhere = " and d.IDCIUDAD=" + idCiudad + "";

            } else if (modulo != null && idCiudad != null) {
                queryWhere = " and b.IdModulo='" + modulo + "'  and d.IDCIUDAD=" + idCiudad + " ";

            }
            
            if (objVoMonitoreo.getEstadoPantalla()!=null) {
                queryWhere=queryWhere+" and a.EstadoPantalla = '" + objVoMonitoreo.getEstadoPantalla() + "'" ;
            }

            Query query = em.createNativeQuery(queryAux + queryWhere + " order by dateFinal desc", "mapeoMonitoreo");
            List<TMonitoreoHoras> listHoras = query.getResultList();
            for (int i = 0; i <listHoras.size(); i++) {
                
            }
            return listHoras;
        } catch (Exception e) {
        }
        return null;
    }

}
