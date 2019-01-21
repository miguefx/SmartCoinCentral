/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import ValueObject.TUsuarios;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miguel
 */
public class TUsuariosFacadeTest {
    
    public TUsuariosFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class TUsuariosFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        TUsuarios entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of edit method, of class TUsuariosFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        TUsuarios entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class TUsuariosFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        TUsuarios entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class TUsuariosFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        TUsuarios expResult = null;
        TUsuarios result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class TUsuariosFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        List<TUsuarios> expResult = null;
        List<TUsuarios> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class TUsuariosFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        List<TUsuarios> expResult = null;
        List<TUsuarios> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class TUsuariosFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresar method, of class TUsuariosFacade.
     */
    @Test
    public void testIngresar() throws Exception {
        System.out.println("ingresar");
        TUsuarios objVOUsuarios = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        String expResult = "";
        String result = instance.ingresar(objVOUsuarios);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of encontrar method, of class TUsuariosFacade.
     */
    @Test
    public void testEncontrar() throws Exception {
        System.out.println("encontrar");
        Long identifiacion = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        Long expResult = null;
        Long result = instance.encontrar(identifiacion);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encontrarCedula method, of class TUsuariosFacade.
     */
    @Test
    public void testEncontrarCedula() throws Exception {
        System.out.println("encontrarCedula");
        String usuario = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        Long expResult = null;
        Long result = instance.encontrarCedula(usuario);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrar method, of class TUsuariosFacade.
     */
    @Test
    public void testRegistrar() throws Exception {
        System.out.println("registrar");
        TUsuarios objVoUsuarios = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        instance.registrar(objVoUsuarios);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarEstado method, of class TUsuariosFacade.
     */
    @Test
    public void testVerificarEstado() throws Exception {
        System.out.println("verificarEstado");
        String usuario = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        String expResult = "";
        String result = instance.verificarEstado(usuario);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarContra method, of class TUsuariosFacade.
     */
    @Test
    public void testCambiarContra() throws Exception {
        System.out.println("cambiarContra");
        TUsuarios objVoUsuarios = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        String expResult = "";
        String result = instance.cambiarContra(objVoUsuarios);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarTocken method, of class TUsuariosFacade.
     */
    @Test
    public void testGenerarTocken() throws Exception {
        System.out.println("generarTocken");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        Integer expResult = null;
        Integer result = instance.generarTocken();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarEstado method, of class TUsuariosFacade.
     */
    @Test
    public void testActualizarEstado() throws Exception {
        System.out.println("actualizarEstado");
        Long documento = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TUsuariosFacade instance = (TUsuariosFacade)container.getContext().lookup("java:global/classes/TUsuariosFacade");
        String expResult = "";
        String result = instance.actualizarEstado(documento);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
