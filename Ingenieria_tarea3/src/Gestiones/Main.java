/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestiones;

import ObjetosBase.Paquete;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        int codigoPlan = 10;
        int codigoProducto = 20;
        String fecha_a = (dateFormat.format(date)).toString();
                String afiliacion = "UPDATE PRODUCTO SET CODIGO_P = "+
                            Integer.toString(codigoPlan) + ", FECHA_A = '"+
                            fecha_a + "' WHERE CODIGO = " +
                            Integer.toString(codigoProducto) +";";
                System.out.println(afiliacion);
                
         //77854 25649 ---> 27564
         Afiliaciones af = new Afiliaciones();
         af.modificarPlan(77854, 27564);
         // 12301 2781
         System.out.println(af.afiliarPaquete(57895, 2781, "UNICO"));
         System.out.println(af.afiliarPaquete(57895, 1354, "UNICO"));
         System.out.println(af.desafiliarPaquete(57895, 2781));
         
         
    }

        
}

//1354 1014 500