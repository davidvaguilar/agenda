/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class EmpleadoTest {
    
    public EmpleadoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Empleado e=new Empleado();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEmpCodigo method, of class Empleado.
     */
    @Test
    public void testGetEmpCodigo() {
        System.out.println("getEmpCodigo");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.getEmpCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpAnexo method, of class Empleado.
     */
    @Test
    public void testGetEmpAnexo() {
        System.out.println("getEmpAnexo");
        Empleado instance = new Empleado();
        Anexo expResult = null;
        Anexo result = instance.getEmpAnexo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpAnexo method, of class Empleado.
     */
    @Test
    public void testSetEmpAnexo() {
        System.out.println("setEmpAnexo");
        String anexo = "";
        Empleado instance = new Empleado();
        instance.setEmpAnexo(anexo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Empleado.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reporte method, of class Empleado.
     */
    @Test
    public void testReporte() {
        System.out.println("reporte");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.reporte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
