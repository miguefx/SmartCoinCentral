/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.TPermisos;
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
public class TPermisosFacade extends AbstractFacade<TPermisos> {

    @PersistenceContext(unitName = "SmartCoinCentralPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TPermisosFacade() {
        super(TPermisos.class);
    }

    public List<TPermisos> buscarPermisos(Long documento, String idModulo) {
        try {
            Query query = em.createQuery("SELECT a FROM TPermisos a where a.documentoUsuario = ?1 and a.idModulo = ?2");
            query.setParameter(1, documento);
            query.setParameter(2, idModulo);
            List<TPermisos> listPermisos = query.getResultList();
            return listPermisos;
        } catch (Exception e) {
        }
        return null;
    }

    public List<String> buscarPermisosPorCedula(Long documentoElegido) {
        try {
            Query query = em.createQuery("select DISTINCT a.nombreControl from TPermisos a where a.documentoUsuario = ?1");
            query.setParameter(1, documentoElegido);
            List<String> listPermisos = query.getResultList();
            return listPermisos;
        } catch (Exception e) {
        }
        return null;
    }

    public Long traerCount(Long cedula) {
        Long resultado=new Long("0");
        try {
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(a.idModulo) from TPermisos a where a.documentoUsuario=?1 and a.nombreContol='Saldos en linea' ", Long.class);
            query.setParameter(1, cedula);
            resultado=query.getSingleResult();
        } catch (Exception e) {
        }
        return resultado;

    }

}
