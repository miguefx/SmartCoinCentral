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

    public List<TMonitoreoHoras> listMonitoreo() {
        try {
            Query query = em.createNativeQuery("SELECT SUBSTRING(CONVERT(VARCHAR(50),CAST(DATEDIFF(hour, FechaReporte ,GETDATE()) % 24 AS MONEY),1),1,Len(CONVERT(VARCHAR(50),CAST(DATEDIFF(hour, FechaReporte ,GETDATE()) % 24 AS MONEY),1))-3) + ':' + SUBSTRING(CONVERT(VARCHAR(50),CAST(DATEDIFF(minute, FechaReporte ,GETDATE()) % 60 AS MONEY),1),1,Len(CONVERT(VARCHAR(50),CAST(DATEDIFF(minute, FechaReporte ,GETDATE()) % 60 AS MONEY),1))-3)+ ':' + SUBSTRING(CONVERT(VARCHAR(50),CAST(DATEDIFF(second, FechaReporte ,GETDATE()) % 60 AS MONEY),1),1,Len(CONVERT(VARCHAR(50),CAST(DATEDIFF(second, FechaReporte ,GETDATE()) % 60 AS MONEY),1))-3) AS dateFinal,IdModulo as modulo,EstadoPantalla as estado from T_Monitoreo", "mapeoMonitoreo");
            List<TMonitoreoHoras> listHoras = query.getResultList();
            return listHoras;
        } catch (Exception e) {
        }
        return null;
    }

}
