/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.TCargas;
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
public class TCargasFacade extends AbstractFacade<TCargas> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TCargasFacade() {
        super(TCargas.class);
    }

    public List<TCargas> actualizarTablaCargas(Date fechaInicio, Date fechaFinal, String idModulo, Long idSede, Long cedulaEnSession, String nombrePermiso) {
        try {
            String query2 = "";
            int casee = 0;
            if (idModulo == null && idSede == null) {
                query2 = "SELECT  a FROM TCargas AS a , TPermisos as b  WHERE  (a.fechaInicio BETWEEN ?1 and ?2)  and (b.idModulo=a.idModulo.idModulo) and (a.idSede.idCiudad.idciudad=b.idCiudad) and (b.documentoUsuario=?3) and (b.nombreControl=?4)";
                casee = 1;
            } else if (idModulo == null && idSede != null) {
                query2 = "SELECT  a FROM TCargas AS a , TPermisos as b  WHERE  (a.fechaInicio BETWEEN ?1 and ?2) and (b.documentoUsuario=?3) and (b.nombreControl=?4) and (b.idModulo=a.idModulo.idModulo) and (a.idSede.idCiudad.idciudad=?5)";
                casee = 2;
            } else if (idModulo != null && idSede == null) {
                query2 = "SELECT  a FROM TCargas AS a , TPermisos as b  WHERE  (a.fechaInicio BETWEEN ?1 and ?2) and (b.documentoUsuario=?3) and (b.nombreControl=?4) and (a.idModulo.idModulo=?5) and (a.idSede.idCiudad.idciudad=b.idCiudad)";
                casee = 3;
            } else if (idModulo != null && idSede != null) {
                query2 = "SELECT DISTINCT  a FROM TCargas AS a , TPermisos as b  WHERE  (a.fechaInicio BETWEEN ?1 and ?2) and (b.documentoUsuario=?3) and (b.nombreControl=?4) and (a.idModulo.idModulo=?5) and (a.idSede.idCiudad.idciudad=?6)";
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
            List<TCargas> listAlarmasFiltradas = query.getResultList();
            return listAlarmasFiltradas;
        } catch (Exception e) {
        }
        return null;
    }
}
