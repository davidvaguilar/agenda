/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Anexo;
import model.Empleado;
import model.Persona;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class MainTest {
    
    public MainTest() {
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
     * Test of verMenu method, of class Main.
     */
//    @Test
//    public void testVerMenu() {
//        System.out.println("verMenu");
//        Main instance = new Main();
//        String expResult = "";
//        String result = instance.verMenu();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of registroEmpleado method, of class Main.
     */
    @Test
    public void testRegistroEmpleado() {
        System.out.println("registroEmpleado");
        Empleado empleado = null;
        Main instance = new Main();
        instance.registroEmpleado(new Empleado(Anexo.A510, "453", "sdasd", "sdasd", "sdads", "sdasd", Persona.SexoPersona.M));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of asignarAnexo method, of class Main.
//     */
//    @Test
//    public void testAsignarAnexo() {
//        System.out.println("asignarAnexo");
//        Main instance = new Main();
//        instance.asignarAnexo();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerUbicacion method, of class Main.
//     */
//    @Test
//    public void testObtenerUbicacion() {
//        System.out.println("obtenerUbicacion");
//        Main instance = new Main();
//        instance.obtenerUbicacion();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of modificarAsignacion method, of class Main.
//     */
//    @Test
//    public void testModificarAsignacion() {
//        System.out.println("modificarAsignacion");
//        Main instance = new Main();
//        instance.modificarAsignacion();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of desasignarAnexo method, of class Main.
//     */
//    @Test
//    public void testDesasignarAnexo() {
//        System.out.println("desasignarAnexo");
//        Main instance = new Main();
//        instance.desasignarAnexo();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listadoAsignaciones method, of class Main.
//     */
//    @Test
//    public void testListadoAsignaciones() {
//        System.out.println("listadoAsignaciones");
//        Main instance = new Main();
//        instance.listadoAsignaciones();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class Main.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Main.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
