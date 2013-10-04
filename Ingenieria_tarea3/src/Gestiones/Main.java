/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestiones;

import ObjetosBase.Paquete;

/**
 *
 * @author arturo
 */
public class Main {
    
    public static void main(String[] args) {
        
        gestionarPaquete gestion = new gestionarPaquete();
        

        //Creamos las listas para guardar las consultas

        int CodigoServ = 1014;
        int CodigoPQ = 1354;
        int Cantidad = 500;
        boolean resultado;

        resultado = gestion.agregarServicio(CodigoServ, CodigoPQ, Cantidad);

        System.out.println("Agregar: " + resultado);
    
        resultado = gestion.eliminarServicio(CodigoServ, CodigoPQ);
        
        System.out.println("Eliminar: "+ resultado);
        
        gestion.agregarServicio(1154, 1354, 666);
        gestion.agregarServicio(1012, 1354, 666);
        gestion.agregarServicio(1075, 1354, 666);
        
        System.out.println(gestion.obtenerServicios(1354));
        
        gestion.buscarPaquete(1354).imprimir();
        
        Paquete pq = new Paquete(1111,42,"PAQUETONGO","POSTPAGO");
        gestion.agregarPaquete(pq);
        gestion.borrarPaquete(1111);
    }
        
}

//1354 1014 500