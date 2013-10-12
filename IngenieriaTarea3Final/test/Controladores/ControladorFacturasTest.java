/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yue
 */
public class ControladorFacturasTest {
    
    public ControladorFacturasTest() {
    }
    

    /**
     * Test of ImprimirFactura method, of class ControladorFacturas.
     */
    @Test
    public void testImprimirFactura() {
        System.out.println("ImprimirFactura");
        int CodigoProducto = 74223;
        ControladorFacturas instance = new ControladorFacturas();
        instance.ImprimirFactura(CodigoProducto);

    }
}