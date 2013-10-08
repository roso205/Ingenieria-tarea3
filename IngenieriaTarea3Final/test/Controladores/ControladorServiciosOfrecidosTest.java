/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import ObjetosBase.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arturo
 */
public class ControladorServiciosOfrecidosTest {
    
    
    // Constantes para la prueba
    public static final String nombreCliente = "Pedro";
    public static final int rifCliente = 20666999;
    public static final String dirCliente = "Guacara";
    public static final int codigoProd = 4277;
    public static final String nombreProd = "ProdPruebaServ";
    public static final String descripcionProd = "ProductoParaProbar";
    public static final int codigoPlan = 1111;
    public static final String FechaAfiliacion = "2013-10-30";
    public static final int Saldo = 1337;
    public static final String tipoPlan = "PREPAGO";
    public static final double tarifaPlan = 200;
    public static final String nombrePlan = "PlanPrueba";
    
    // Variables para instanciar en la prueba
    public static Cliente ClienteP;
    public static Plan PlanP;
    public static Producto ProductoP;
    public static ControladorConsumidores cc;
    public static ControladorServiciosOfrecidos cso;
    
    public ControladorServiciosOfrecidosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        // Creacion de plan, producto y cliente para agregar a la base de datos
        ClienteP = new Cliente(nombreCliente,rifCliente,dirCliente);
        PlanP = new Plan(codigoPlan,nombrePlan,tipoPlan,tarifaPlan);
        ProductoP = new Producto(codigoProd,nombreProd,descripcionProd,
                                 codigoPlan,rifCliente,FechaAfiliacion,Saldo);
        
        cc = new ControladorConsumidores();
        cc.agregarCliente(ClienteP);
        cc.agregarProducto(codigoProd, nombreProd, descripcionProd, codigoPlan, 
                           rifCliente, FechaAfiliacion, Saldo);
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        cc = new ControladorConsumidores();
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of agregarPlan method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testAgregarPlan() {
        System.out.println("agregarPlan");
        PlanP = new Plan(codigoPlan,nombrePlan,tipoPlan,tarifaPlan);
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean result = instance.agregarPlan(PlanP);
        assertEquals(result,true);
    }

    /**
     * Test of mostrarClientesAfiliados method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testMostrarClientesAfiliados() {
        System.out.println("mostrarClientesAfiliados");
        int cop = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        instance.mostrarClientesAfiliados(cop);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of desafiliarClientesAfiliados method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testDesafiliarClientesAfiliados() {
        System.out.println("desafiliarClientesAfiliados");
        int cop = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = false;
        boolean result = instance.desafiliarClientesAfiliados(cop);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarPaquete method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testAgregarPaquete_int_int() {
        System.out.println("agregarPaquete");
        int co_plan = 0;
        int co_paq = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = false;
        boolean result = instance.agregarPaquete(co_plan, co_paq);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarPaquete method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testBorrarPaquete_int_int() {
        System.out.println("borrarPaquete");
        int co_plan = 0;
        int co_paq = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = false;
        boolean result = instance.borrarPaquete(co_plan, co_paq);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarProducto method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testModificarProducto() {
        System.out.println("modificarProducto");
        int co_pro = 0;
        int new_plan = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = false;
        boolean result = instance.modificarProducto(co_pro, new_plan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarProductos method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testMostrarProductos() {
        System.out.println("mostrarProductos");
        int cop = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        instance.mostrarProductos(cop);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarServicio method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testAgregarServicio() {
        System.out.println("agregarServicio");
        int codigoServ = 0;
        int codigoPaquete = 0;
        int cantidad = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = false;
        boolean result = instance.agregarServicio(codigoServ, codigoPaquete, cantidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarServicio method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testEliminarServicio() {
        System.out.println("eliminarServicio");
        int codigoServ = 0;
        int codigoPaquete = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = false;
        boolean result = instance.eliminarServicio(codigoServ, codigoPaquete);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerServicios method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testObtenerServicios() {
        System.out.println("obtenerServicios");
        int codigoPaquete = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerServicios(codigoPaquete);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPaquete method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testBuscarPaquete() {
        System.out.println("buscarPaquete");
        int codigoPaquete = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        Paquete expResult = null;
        Paquete result = instance.buscarPaquete(codigoPaquete);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarPaquete method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testAgregarPaquete_Paquete() {
        System.out.println("agregarPaquete");
        Paquete pq = null;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = false;
        boolean result = instance.agregarPaquete(pq);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarPaquete method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testBorrarPaquete_int() {
        System.out.println("borrarPaquete");
        int codigoPaquete = 0;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = false;
        boolean result = instance.borrarPaquete(codigoPaquete);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TarifaTotalPaquetesAdicionales method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testTarifaTotalPaquetesAdicionales() {
        System.out.println("TarifaTotalPaquetesAdicionales");
        List<String> Paquetes = null;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        int expResult = 0;
        int result = instance.TarifaTotalPaquetesAdicionales(Paquetes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
