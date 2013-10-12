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
public class ControladorConsumidoresTest {
    
    public ControladorConsumidoresTest() {
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
     * Test of agregarCliente method, of class ControladorConsumidores.
     */
    @Test
    public void testAgregarCliente() {
        System.out.println("agregarCliente");


        ControladorConsumidores instance = new ControladorConsumidores();
        boolean expResult = true;
        boolean result = instance.agregarCliente(ClienteMod);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarCliente method, of class ControladorConsumidores.
     */
    @Test
    public void testBuscarCliente() {
        System.out.println("buscarCliente");
        int rif = rifCliente;
        ControladorConsumidores instance = new ControladorConsumidores();
        Cliente expResult = ClienteP;
        Cliente result = instance.buscarCliente(rif);
        assertEquals(expResult.getRif(), result.getRif());
    }

    /**
     * Test of mostrarCliente method, of class ControladorConsumidores.
     */
    @Test
    public void testMostrarCliente() {
        System.out.println("mostrarCliente");
        ControladorConsumidores instance = new ControladorConsumidores();
        instance.mostrarCliente(ClienteP);

    }

    /**
     * Test of buscarProducto method, of class ControladorConsumidores.
     */
    @Test
    public void testBuscarProducto() {
        System.out.println("buscarProducto");
        int Codigo = codigoProd;
        ControladorConsumidores instance = new ControladorConsumidores();
        Producto expResult = ProductoP;
        Producto result = instance.buscarProducto(Codigo);
        assertEquals(expResult.getCodigo(), result.getCodigo());

    }

    /**
     * Test of agregarProducto method, of class ControladorConsumidores.
     */
    @Test
    public void testAgregarProducto() {
        System.out.println("agregarProducto");
        int Codigo = 5687;
        String Nombre = "ProductoNuevo";
        String Descripcion = "Es bonito, bueno y barato";
        int CodigoPlan = 25649;
        int RifCliente = 19965084;
        String FechaAfiliacion = "2013-10-20";
        int Saldo = 150;
        ControladorConsumidores instance = new ControladorConsumidores();
        boolean expResult = true;
        boolean result = instance.agregarProducto(Codigo, Nombre, Descripcion,
                                CodigoPlan, RifCliente, FechaAfiliacion, Saldo);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of mostrarProducto method, of class ControladorConsumidores.
     */
    @Test
    public void testMostrarProducto() {
        System.out.println("mostrarProducto");
        int codigoProducto = 74223;
        ControladorConsumidores instance = new ControladorConsumidores();
        instance.mostrarProducto(codigoProducto);
    }

    /**
     * Test of BuscarPaquetesAdicionales method, of class ControladorConsumidores.
     */
    @Test
    public void testBuscarPaquetesAdicionales() {
        System.out.println("BuscarPaquetesAdicionales");
        int CodigoProducto = 74223;
        ControladorConsumidores instance = new ControladorConsumidores();
        List<String> expResult = new ArrayList<String>();
        expResult.add(Integer.toString(3248));
        expResult.add(Integer.toString(1546));      
        List<String>  result = instance.BuscarPaquetesAdicionales(CodigoProducto);
        assertEquals(expResult, result);


    }

    /**
     * Test of buscarNombreServicios method, of class ControladorConsumidores.
     */
    @Test
    public void testBuscarNombreServicios() {
        System.out.println("buscarNombreServicios");
        ArrayList<String> Servicios = new ArrayList<String>();  
        ControladorConsumidores instance = new ControladorConsumidores();
        Servicios.add(Integer.toString(1014));
        Servicios.add(Integer.toString(1054));
        ArrayList<String> expResult = new ArrayList<String>();  
        expResult.add("SEGUNDOS-MOVIL-MOCEL");
        expResult.add("SEGUNDOS-OTROS");
        ArrayList<String> result = instance.buscarNombreServicios(Servicios);
        assertEquals(expResult, result);

    }
}