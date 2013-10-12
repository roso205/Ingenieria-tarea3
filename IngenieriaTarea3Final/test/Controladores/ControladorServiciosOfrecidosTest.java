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
    public static final String nombrePlan = "PlanGuardadoPrueba";
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
    public static final int codigoTipoServGuardado = 110;
    public static final String nombreTipoServ = "TipoServicioPrueba";
    public static final int cantidadServicio = 111;
    public static final int codigoPlanMod = 1112;
    public static final String tipoPlanMod = "PREPAGO";
    public static final double tarifaPlanMod = 500;
    public static final String nombrePlanMod = "PlanModificar";
    
    // Variables para instanciar en la prueba
    public static Cliente ClienteGuardado;
    public static Plan PlanGuardado;
    public static Producto ProductoGuardado;
    public static ControladorConsumidores cc;
    public static ControladorServiciosOfrecidos cso;
    public static Paquete PaqueteGuardado;
    public static Paquete PaqueteMod;
    public static TipoServicio TipoServicioMod;
    public static TipoServicio TipoServicioGuardado;
    public static Servicio ServicioMod;
    public static Servicio ServicioGuardado;
    public static Plan PlanMod;
    
    public ControladorServiciosOfrecidosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        // Creacion de objetos para las pruebas.
        
        /* Nota: las variables terminadas en "P" se agregan a la base de datos
        para su uso, las terminadas en "Mod" se usan para probar metodos de 
        agregar */
        
        ClienteGuardado = new Cliente(nombreCliente,rifCliente,dirCliente);
        PlanGuardado = new Plan(codigoPlan,nombrePlan,tipoPlan,tarifaPlan);
        PlanMod = new Plan(codigoPlanMod,nombrePlanMod,tipoPlanMod,tarifaPlanMod);
        ProductoGuardado = new Producto(codigoProd,nombreProd,descripcionProd,
                                 codigoPlan,rifCliente,FechaAfiliacion,Saldo);
        PaqueteGuardado = new Paquete(codigoPaquete,tarifaPaquete,nombrePaquete,tipoPaquete);
        PaqueteMod = new Paquete(codigoPaqueteMod,tarifaPaquete,nombrePaquete,tipoPaquete);
        TipoServicioMod = new TipoServicio(codigoTipoServ,nombreTipoServ);
        TipoServicioGuardado = new TipoServicio(codigoTipoServGuardado,nombreTipoServ);
        ServicioMod = new Servicio(codigoServ,nombreServ,costoServ,codigoTipoServ);
        ServicioGuardado = new Servicio(codigoServP,nombreServ,costoServ,codigoTipoServGuardado);
        
        
        cc = new ControladorConsumidores();
        cso = new ControladorServiciosOfrecidos();
        cc.agregarCliente(ClienteGuardado);
        cso.agregarPlan(PlanGuardado);
        cc.agregarProducto(codigoProd, nombreProd, descripcionProd, codigoPlan, 
                           rifCliente, FechaAfiliacion, Saldo);
        cso.agregarTipoServicio(TipoServicioGuardado);
        cso.agregarPaquete(PaqueteGuardado);
        cso.agregarServicio(ServicioGuardado);
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        cc = new ControladorConsumidores();
        cso = new ControladorServiciosOfrecidos();
        
        cso.borrarPaquete(PaqueteGuardado.getCodigo());
        cso.eliminarPlan(PlanGuardado);
        cso.eliminarServicio(ServicioGuardado);
        cso.borrarPaquete(codigoPaqueteMod);
        cso.eliminarPlan(PlanMod);
        cso.eliminarServicio(ServicioMod);
        cso.eliminarTipoServicio(TipoServicioMod);
        cso.eliminarServicioDePaquete(codigoServP, codigoPaquete);
        cso.eliminarTipoServicio(TipoServicioGuardado);
        
        
        
        
        
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
        int cop = PlanGuardado.getCodigo();
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
        int cop = PlanGuardado.getCodigo();
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
        int co_plan = PlanGuardado.getCodigo();
        int co_paq = PaqueteGuardado.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = true;
        boolean result = instance.agregarPaqueteAPlan(co_plan, co_paq);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarPaqueteDePlan method, of class ControladorServiciosOfrecidos.
     */
  
    @Test
    public void testBorrarPaqueteDePlan_int_int() {
        System.out.println("borrarPaqueteDePlan");
        int co_plan = PlanGuardado.getCodigo();
        int co_paq = PaqueteGuardado.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = true;
        boolean result = instance.borrarPaqueteDePlan(co_plan, co_paq);
        assertEquals(expResult, result);
    }

    /**
     * Test of modificarProducto method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testModificarProducto() {
        System.out.println("modificarProducto");
        int co_pro = ProductoGuardado.getCodigo();
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
        int cop = PlanGuardado.getCodigo();
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
        int codigoServ = ServicioGuardado.getCodigo();
        int codigoPaquete = PaqueteGuardado.getCodigo();
        int cantidad = cantidadServicio;
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        boolean expResult = true;
        boolean result = instance.agregarServicioAPaquete(codigoServ, codigoPaquete, cantidad);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminarServicioDePaquete method, of class ControladorServiciosOfrecidos.
     */
    
    /*
    @Test
    public void testEliminarServicioDePaquete() {
        System.out.println("eliminarServicioDePaquete");
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
        int codigoPaquete = PaqueteGuardado.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        int expResult = codigoServP;
        ArrayList<String> serv = instance.obtenerServicios(codigoPaquete);
        int result = Integer.parseInt(serv.get(0));
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarPaquete method, of class ControladorServiciosOfrecidos.
     */
    @Test
    public void testBuscarPaquete() {
        System.out.println("buscarPaquete");
        int codigoPaquete = PaqueteGuardado.getCodigo();
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        Paquete pq = instance.buscarPaquete(codigoPaquete);
        
        String expResult = Integer.toString(PaqueteGuardado.getCodigo());
        expResult += PaqueteGuardado.getTipo();
        expResult += Integer.toString(PaqueteGuardado.getTarifa());
        expResult += PaqueteGuardado.getNombre();
        
        String result = Integer.toString(pq.getCodigo());
        result += pq.getTipo();
        result += Integer.toString(pq.getTarifa());
        result += pq.getNombre();
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
        Paquetes.add(Integer.toString(PaqueteGuardado.getCodigo()));
        ControladorServiciosOfrecidos instance = new ControladorServiciosOfrecidos();
        int expResult = 2222;
        int result = instance.TarifaTotalPaquetesAdicionales(Paquetes);
        assertEquals(expResult, result);
    }
}
