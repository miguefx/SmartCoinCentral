/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.TConfiguracion;
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
public class TConfiguracionFacade extends AbstractFacade<TConfiguracion> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TConfiguracionFacade() {
        super(TConfiguracion.class);
    }
    
    
    
     public List<TConfiguracion> llenarReporte() {
        try {
            Query query = em.createQuery("SELECT a FROM TConfiguracion  a order by a.idModulo");
            List<TConfiguracion> listaModulos = query.getResultList();

        } catch (Exception e) {
        }
        return null;
    }

    public List<TConfiguracion> llenarReporteEstado() {
        try {
            Query query = em.createQuery("SELECT a FROM TConfiguracion  a WHERE a.estado=true order by a.idModulo");
            List<TConfiguracion> listaModulos = query.getResultList();
            return listaModulos;
        } catch (Exception e) {
        }
        return null;
    }

    public Long retirarCount() {
        Long resultado = new Long("0");
        try {
            TypedQuery<Long> query = em.createQuery("SELECT count(a.idModulo)  from TConfiguracion  a where a.estado = true", Long.class);
            resultado = query.getSingleResult();
        } catch (Exception e) {
        }
        return resultado;
    }
    
    public List<TConfiguracion> listModulosPorCiudades(Long idCiudad,Long documentoSession,String nombrePermiso)
    {
        List<TConfiguracion> listModulos=null;
        try {
            Query query = em.createQuery("SELECT DISTINCT a from TConfiguracion AS a, TPermisos as b where  a.idSede.idCiudad.idciudad = ?1 AND a.idModulo=b.idModulo AND b.documentoUsuario = ?2 AND b.nombreContol = ?3");
            query.setParameter(1, idCiudad);
            query.setParameter(2, documentoSession);
            query.setParameter(3, nombrePermiso);
            listModulos=query.getResultList();
            
        } catch (Exception e) {
        }
        return listModulos;
    }
    public List<TConfiguracion> listModulos(Long idCiudad)
    {
        List<TConfiguracion> listModulos=null;
        try {
            Query query = em.createQuery("SELECT DISTINCT a from TConfiguracion AS a where  a.idSede.idCiudad.idciudad = ?1");
            query.setParameter(1, idCiudad);
            listModulos=query.getResultList();
            
        } catch (Exception e) {
        }
        return listModulos;
    }

    public Long averiguarSedePorNombre(String valorModulo) {
        Long resultado=new Long("0");
        try {
            Query query= em.createQuery("SELECT a from TConfiguracion a where a.idModulo = ?1");
            query.setParameter(1, valorModulo);
            List<TConfiguracion> list =query.getResultList();
            if (!list.isEmpty()) {
                resultado=list.get(0).getIdSede().getIdSede();
            }
        } catch (Exception e) {
        }
        return resultado;
    }

}
