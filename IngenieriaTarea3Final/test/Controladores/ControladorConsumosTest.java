/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.ArrayList;
import java.util.Date;
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
public class ControladorConsumosTest {
    
    public ControladorConsumosTest() {
    }
    
   

    /**
     * Test of agregarConsumo method, of class ControladorConsumos.
     */
    @Test
    public void testAgregarConsumo() {
        System.out.println("agregarConsumo");
        int cantidad = 10;
        int codServicio = 1014;
        Date fecha = new Date();
        int codProducto = 74223;
        ControladorConsumos instance = new ControladorConsumos();
        boolean expResult = true;
        boolean result = instance.agregarConsumo(cantidad, codServicio, fecha, codProducto);
        assertEquals(expResult, result);

    }

    /**
     * Test of consultarConsumo method, of class ControladorConsumos.
     */
    @Test
    public void testConsultarConsumo() {
        System.out.println("consultarConsumo");
        int codProducto = 74223;
        ControladorConsumos instance = new ControladorConsumos();
        ArrayList expResult = null;
        ArrayList result = instance.consultarConsumo(codProducto);
        System.out.println(result);
        assertEquals(expResult, result);

    }

    /**
     * Test of listarConsumos method, of class ControladorConsumos.
     */
    @Test
    public void testListarConsumos() {
        System.out.println("listarConsumos");
        ControladorConsumos instance = new ControladorConsumos();
        instance.listarConsumos();

    }
}