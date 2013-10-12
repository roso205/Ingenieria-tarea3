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
 * @author yue
 */
public class AfiliacionesTest {
    
    public AfiliacionesTest() {
    }
    
    
  // Constantes para la prueba
    public static final String nombreCliente = "Pedro";
    public static final String nombreClienteMod = "Javier";
    public static final int rifCliente = 20666009;
    public static final int rifClienteMod = 20747701;
    public static final String dirCliente = "Guacara";
    public static final String dirClienteMod = "Caracas";
    public static final int codigoProd = 577997;
    public static final String nombreProd = "ProdPruebaServ";
    public static final String descripcionProd = "ProductoParaProbar";
    public static final int codigoPlan = 66477;
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
    public static Cliente ClienteMod;

    
    @BeforeClass
    public static void setUpClass() {
        
        // Creacion de objetos para las pruebas.
        
        
        ClienteP = new Cliente(nombreCliente,rifCliente,dirCliente);
        ClienteMod = new Cliente(nombreClienteMod,rifClienteMod,dirClienteMod);
        PlanP = new Plan(codigoPlan,nombrePlan,tipoPlan,tarifaPlan);
        ProductoP = new Producto(codigoProd,nombreProd,descripcionProd,
                                 codigoPlan,rifCliente,FechaAfiliacion,Saldo);

        
        cc = new ControladorConsumidores();
        cc.agregarCliente(ClienteP);
        cc.agregarProducto(codigoProd, nombreProd, descripcionProd, codigoPlan,
                           rifCliente, FechaAfiliacion, Saldo);
        cso = new ControladorServiciosOfrecidos();
        cso.agregarPlan(PlanP);

        
    }

    /**
     * Test of buscarPlan method, of class Afiliaciones.
     */
    @Test
    public void testBuscarPlan() {
        System.out.println("buscarPlan");
        int Codigo = codigoPlan;
        Afiliaciones instance = new Afiliaciones();
        Plan expResult = PlanP;
        Plan result = instance.buscarPlan(Codigo);
        assertEquals(expResult.getCodigo(), result.getCodigo());
    }

    /**
     * Test of modificarPlan method, of class Afiliaciones.
     */
    @Test
    public void testModificarPlan() {
        System.out.println("modificarPlan");
        int codigoProducto = 87560;
        int codigoPlan = 25649;
        Afiliaciones instance = new Afiliaciones();
        boolean expResult = true;
        boolean result = instance.modificarPlan(codigoProducto, codigoPlan);
        assertEquals(expResult, result);

    }

    /**
     * Test of afiliarPaquete method, of class Afiliaciones.
     */
    @Test
    public void testAfiliarPaquete() {
        System.out.println("afiliarPaquete");
        int codigoProducto = 87560;
        int codigoPq = 1546;
        String tipo = "segundos";
        Afiliaciones instance = new Afiliaciones();
        boolean expResult = false;
        boolean result = instance.afiliarPaquete(codigoProducto, codigoPq, tipo);
        assertEquals(expResult, result);

    }

    /**
     * Test of desafiliarPaquete method, of class Afiliaciones.
     */
    @Test
    public void testDesafiliarPaquete() {
        System.out.println("desafiliarPaquete");
        int codigoProducto = 74223;
        int codigoPq = 1546;
        Afiliaciones instance = new Afiliaciones();
        boolean expResult = true;
        boolean result = instance.desafiliarPaquete(codigoProducto, codigoPq);
        assertEquals(expResult, result);

    }

    /**
     * Test of BuscarPaquete method, of class Afiliaciones.
     */
    @Test
    public void testBuscarPaquete() {
        System.out.println("BuscarPaquete");
        int CodigoPlan = 25649;
        Afiliaciones instance = new Afiliaciones();
        List<String> expResult = new ArrayList<String>();
        expResult.add(Integer.toString(3248));
        List result = instance.BuscarPaquete(CodigoPlan);
        assertEquals(expResult, result);

    }

    /**
     * Test of listarPaquetesAfiliados method, of class Afiliaciones.
     */
    @Test
    public void testListarPaquetesAfiliados() {
        System.out.println("listarPaquetesAfiliados");
        int codigoProducto = 26549;
        Afiliaciones instance = new Afiliaciones();
        List<String> expResult = new ArrayList<String>();
        expResult.add(Integer.toString(2781));
        expResult.add(Integer.toString(1354));
        List result = instance.listarPaquetesAfiliados(codigoProducto);

        assertEquals(expResult, result);

    }

    /**
     * Test of buscarTipoPlan method, of class Afiliaciones.
     */
    @Test
    public void testBuscarTipoPlan() {
        System.out.println("buscarTipoPlan");
        int CodigoPlan = 27564;
        Afiliaciones instance = new Afiliaciones();
        String expResult = "POSTPAGO";
        String result = instance.buscarTipoPlan(CodigoPlan);
        assertEquals(expResult, result);
    }
}