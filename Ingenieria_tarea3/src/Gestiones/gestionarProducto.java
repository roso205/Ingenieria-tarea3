/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarProducto;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ConexionBaseDatos.gestionarBaseDatos;





/**
 *
 * @author yue
 */
public class gestionarProducto {
   
    
    public List<String> buscarProducto(int Codigo) {
        

        try{

        gestionarBaseDatos BaseDatos = new gestionarBaseDatos();
        
        Connection connection = BaseDatos.establecerConexion();
                
        Statement stmt = connection.createStatement();
        String consulta = "SELECT * FROM PRODUCTO "
                  + " WHERE (PRODUCTO.CODIGO = " +Integer.toString(Codigo)+") ";

                    
        ResultSet rs = stmt.executeQuery(consulta);

        List<String> resultado = new ArrayList<String>();


        while (rs.next()){

            for (int i = 1; i < 8; i++) {

                resultado.add(rs.getString(i));

            }
        }

        stmt.close();
        BaseDatos.cerrarConexion(connection); 
        return resultado;
        }

        catch ( Exception e ) {
            System.out.println(e.getMessage());
            List<String> resultado = new ArrayList<String>();
            return resultado;
        } 

  
    }
    
    public boolean agregarProducto(int Codigo, String Nombre, 
                   String Descripcion, int CodigoPlan, int RifCliente, 
                                        String FechaAfiliacion, int Saldo) {
       

         // Crear el gestor para la base de datos
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        
        // Verificar si existe el producto
        
        String consultaProducto = "SELECT * FROM PRODUCTO WHERE"+
                "(CODIGO = "+Integer.toString(Codigo)+");";
        
        try {
            
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultaProducto);

            if (rs.next()) {
             System.out.println("El producto ya existe");
                return false;

            }
            
            stmt.close();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Verificar si existe el cliente
        
        String consultaCliente = "SELECT * FROM CLIENTE WHERE"+
                "(RIF = "+Integer.toString(RifCliente)+");";
        
        try {
        
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultaCliente);

            if (!rs.next()) {
                System.out.println("No existe el cliente asociado al producto");
                return false;
            }
            
            stmt.close();            
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Verificar si existe el plan
        
        String consultaPlan = "SELECT * FROM PLAN WHERE"+
                "(CODIGO = "+Integer.toString(CodigoPlan)+");";
        
        try {
        
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultaPlan);

            if (!rs.next()) {
                System.out.println("No existe el plan ingresado");
                return false;
            }
            
            stmt.close();            
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
  
        String producto = "INSERT INTO PRODUCTO VALUES ("
                               +Integer.toString(Codigo)+","+Nombre+","
                               +Descripcion+","+Integer.toString(CodigoPlan)+","
                           +Integer.toString(RifCliente)+","+FechaAfiliacion+","
                               +Integer.toString(Saldo)+")";

        // Se agrega el producto
        
        try {
            
            Statement stmt = conexion.createStatement();
            int resultado = stmt.executeUpdate(producto);
            return resultado > 0;
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        
        return false;
        

    }
    
    public void mostrarProducto(int codigoPaquete) {
        
        gestionarProducto Consulta = new gestionarProducto();

        //Creamos las listas para guardar las consultas
        List<String> resultado = new ArrayList<String>();

        resultado = Consulta.buscarProducto(codigoPaquete);

        System.out.println(resultado);
        
    }
    
    
    
    
    
    
    
   public static void main(String[] args) {
 
    gestionarProducto Consulta = new gestionarProducto();

    int Codigo = 77854;
    
    Consulta.mostrarProducto(Codigo);

    
    
    boolean goal; 
    goal = Consulta.agregarProducto(8995, "'puta'", "'soy puta'", 25649, 19065084,"DATE '2013-06-01'", 2);
      
    System.out.println(goal); 
    } 
    
}

