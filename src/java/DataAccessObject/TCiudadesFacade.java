/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.TCiudades;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author matc_
 */
@Stateless
public class TCiudadesFacade extends AbstractFacade<TCiudades> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TCiudadesFacade() {
        super(TCiudades.class);
    }

    public List<TCiudades> listaCiudadesCargas(Long documento,String nombrePermiso) {
        List<TCiudades> listCiudades= null;
        
        try {
            Query query =em.createQuery("select DISTINCT a from  TCiudades as a, TConfiguracion as b, TSedes as c,TPermisos as d where (b.idSede.idSede = c.idSede) and (c.idCiudad.idciudad=a.idciudad) and d.documentoUsuario = ?1 and d.idModulo=b.idModulo and d.nombreContol=?2");
            query.setParameter(1, documento);
            query.setParameter(2, nombrePermiso);
            listCiudades=query.getResultList();
            
        } catch (Exception e) {
        }
        return listCiudades;
    }
   
     public List<TCiudades> listaCiudadesPermisos() {
        List<TCiudades> listCiudades= null;
        
        try {
            Query query =em.createQuery("SELECT DISTINCT a from TCiudades AS a, TSedes AS b WHERE b.idCiudad.idciudad = a.idciudad");
            listCiudades=query.getResultList();
            
        } catch (Exception e) {
        }
        return listCiudades;
    }
    
}
