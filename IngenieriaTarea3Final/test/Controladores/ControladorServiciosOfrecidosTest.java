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
    public static final int codigoPaquete = 8888;
    public static final int codigoPaqueteMod = 9999;
    public static final int tarifaPaquete = 2222;
    public static final String nombrePaquete = "PaquetePrueba";
    public static final String tipoPaquete = "POSTPAGO";
    public static final int codigoServ = 33;
    public static final int codigoServP = 66;
    public static final String nombreServ = "ServicioPrueba";
    public static final int costoServ = 3000;
    public static final int codigoTipoServ = 55;
    public static final String nombreTipoServ = "TipoServicioPrueba";
    public static final int cantidadServicio = 111;
    public static final int codigoPlanMod = 1112;
    public static final String tipoPlanMod = "PREPAGO";
    public static final double tarifaPlanMod = 500;
    public static final String nombrePlanMod = "PlanModificar";
    
    // Variables para instanciar en la prueba
    public static Cliente ClienteP;
    public static Plan PlanP;
    public static Producto ProductoP;
    public static ControladorConsumidores cc;
    public static ControladorServiciosOfrecidos cso;
    public static Paquete PaqueteP;
    public static Paquete PaqueteMod;
    public static TipoServicio TipoServicioMod;
    public static Servicio ServicioMod;
    public static Servicio ServicioP;
    public static Plan PlanMod;
    
    public ControladorServiciosOfrecidosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        // Creacion de objetos para las pruebas.
        
        /* Nota: las variables terminadas en "P" se agregan a la base de datos
        para su uso, las terminadas en "Mod" se usan para probar metodos de 
        agregar */
        
        ClienteP = new Cliente(nombreCliente,rifCliente,dirCliente);
        PlanP = new Plan(codigoPlan,nombrePlan,tipoPlan,tarifaPlan);
        PlanMod = new Plan(codigoPlanMod,nombrePlanMod,tipoPlanMod,tarifaPlanMod);
        ProductoP = new Producto(codigoProd,nombreProd,descripcionProd,
                                 codigoPlan,rifCliente,FechaAfiliacion,Saldo);
        PaqueteP = new Paquete(codigoPaquete,tarifaPaquete,nombrePaquete,tipoPaquete);
        PaqueteMod = new Paquete(codigoPaqueteMod,tarifaPaquete,nombrePaquete,tipoPaquete);
        TipoServicioMod = new TipoServicio(codigoTipoServ,nombreTipoServ);
        ServicioMod = new Servicio(codigoServ,nombreServ,costoServ,codigoTipoServ);
        ServicioP = new Servicio(codigoServP,nombreServ,costoServ,codigoTipoServ);
        
        
        cc = new ControladorConsumidores();
        cc.agregarCliente(ClienteP);
        cc.agregarProducto(codigoProd, nombreProd, descripcionProd, codigoPlan, 
                           rifCliente, FechaAfiliacion, Saldo);
        cso = new ControladorServiciosOfrecidos();
        cso.agregarPaquete(PaqueteP);
        cso.agregarPlan(PlanP);
        cso.agregarServicio(ServicioP);
        
        
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
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean result = instance.agregarPlan(PlanMod);
        assertEquals(true,result);
    }
    
     /**
     * Test of agregarTipoServicio method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testAgregarTipoServicio() {
        System.out.println("agregarTipoServicio");
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean result = instance.agregarTipoServicio(TipoServicioMod);
        assertEquals(true,result);
    }
    
    /**
     * Test of agregarServicio method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testAgregarServicio() {
        System.out.println("agregarServicio");
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean result = instance.agregarServicio(ServicioMod);
        assertEquals(true,result);
    }
    

    /**
     * Test of mostrarClientesAfiliados method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testMostrarClientesAfiliados() {
        System.out.println("mostrarClientesAfiliados");
        int cop = PlanP.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        instance.mostrarClientesAfiliados(cop);
        boolean res = true;
        assertEquals(res,true);
    }

    /**
     * Test of desafiliarClientesAfiliados method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testDesafiliarClientesAfiliados() {
        System.out.println("desafiliarClientesAfiliados");
        int cop = PlanP.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = true;
        boolean result = instance.desafiliarClientesAfiliados(cop);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarPaqueteAPlan method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testAgregarPaqueteAPlan_int_int() {
        System.out.println("agregarPaqueteAPlan");
        int co_plan = PlanP.getCodigo();
        int co_paq = PaqueteP.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = true;
        boolean result = instance.agregarPaqueteAPlan(co_plan, co_paq);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarPaquete method, of class ControladorServiciosOfrecidos.
     */
    /**
    @Test
    public void testBorrarPaquete_int_int() {
        System.out.println("borrarPaquete");
        int co_plan = PlanP.getCodigo();
        int co_paq = PaqueteP.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = true;
        boolean result = instance.borrarPaquete(co_plan, co_paq);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of modificarProducto method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testModificarProducto() {
        System.out.println("modificarProducto");
        int co_pro = ProductoP.getCodigo();
        int new_plan = PlanMod.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = true;
        boolean result = instance.modificarProducto(co_pro, new_plan);
        assertEquals(expResult, result);
    }

    /**
     * Test of mostrarProductos method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testMostrarProductos() {
        System.out.println("mostrarProductos");
        int cop = PlanP.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        instance.mostrarProductos(cop);
        assertEquals(true,true);
    }

    /**
     * Test of agregarServicioAPaquete method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testAgregarServicioAPaquete() {
        System.out.println("agregarServicioAPaquete");
        int codigoServ = ServicioP.getCodigo();
        int codigoPaquete = PaqueteP.getCodigo();
        int cantidad = cantidadServicio;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = true;
        boolean result = instance.agregarServicioAPaquete(codigoServ, codigoPaquete, cantidad);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminarServicio method, of class ControladorServiciosOfrecidos.
     */
    
    /*
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
    */

    /**
     * Test of obtenerServicios method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testObtenerServicios() {
        System.out.println("obtenerServicios");
        int codigoPaquete = PaqueteP.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        ArrayList<String> expResult = new ArrayList();
        expResult.add(Integer.toString(66));
        ArrayList result = instance.obtenerServicios(codigoPaquete);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarPaquete method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testBuscarPaquete() {
        System.out.println("buscarPaquete");
        int codigoPaquete = PaqueteP.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        Paquete expResult = PaqueteP;
        Paquete result = instance.buscarPaquete(codigoPaquete);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarPaquete method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testAgregarPaquete_Paquete() {
        System.out.println("agregarPaquete");
        Paquete pq = PaqueteMod;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = true;
        boolean result = instance.agregarPaquete(pq);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarPaquete method, of class ControladorServiciosOfrecidos.
     */
    /*
    @Test
    public void testBorrarPaquete_int() {
        System.out.println("borrarPaquete");
        int codigoPaquete = PaqueteMod.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = true;
        boolean result = instance.borrarPaquete(codigoPaquete);
        assertEquals(expResult, result);
    }
    */

    /**
     * Test of TarifaTotalPaquetesAdicionales method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testTarifaTotalPaquetesAdicionales() {
        System.out.println("TarifaTotalPaquetesAdicionales");
        List<String> Paquetes = new ArrayList();
        Paquetes.add(Integer.toString(PaqueteP.getCodigo()));
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        int expResult = 2222;
        int result = instance.TarifaTotalPaquetesAdicionales(Paquetes);
        assertEquals(expResult, result);
    }
}
