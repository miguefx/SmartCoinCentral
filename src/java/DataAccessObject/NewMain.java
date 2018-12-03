/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author matc_
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartCoinCentralPU");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        StoredProcedureQuery storedProcedure=em.createStoredProcedureQuery("P_AdminRegistrarUsuario;1");
        storedProcedure.registerStoredProcedureParameter("@DOCUMENTO", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("@IDEMPRESA", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("@NOMBRES", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("@APELLIDOS", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("@USUARIO", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("@USUARIOCREADOR", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("@CLAVE", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("@CARGO", String.class, ParameterMode.IN);
        
        storedProcedure.setParameter("@DOCUMENTO", "98765");
        storedProcedure.setParameter("@IDEMPRESA", new Long("1"));
        storedProcedure.setParameter("@NOMBRES", "IUU");
        storedProcedure.setParameter("@APELLIDOS", "ASDH");
        storedProcedure.setParameter("@USUARIO", "8888");
        storedProcedure.setParameter("@USUARIOCREADOR", "MARTIN");
        storedProcedure.setParameter("@CLAVE", "MARTINI");
        storedProcedure.setParameter("@CARGO", "ASDASD");
        
        storedProcedure.execute();
    }
    
}
