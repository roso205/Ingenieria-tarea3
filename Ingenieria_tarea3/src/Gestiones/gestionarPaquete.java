package Gestiones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import BaseDatos.gestionarBaseDatos;
import ObjetosBase.Paquete;

/**
 *
 * @author arturo
 */
public class gestionarPaquete {
    
    
    // Metodos
    
    // Agrega un servicio al paquete.
    public boolean agregarServicio(int codigoServ, int codigoPaquete,
                                   int cantidad) {
        
        // Crear el gestor para la base de datos
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        
        // Verificar si existe el servicio
        
        String consultaServ = "SELECT * FROM SERVICIO WHERE"+
                "(CODIGO = "+Integer.toString(codigoServ)+");";
        
        try {
            
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultaServ);

            if (!rs.next()) {
                gestorBD.cerrarConexion(conexion);
                return false;
            }
            
            stmt.close();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Verificar si existe el paquete
        
        String consultaPaquete = "SELECT * FROM PAQUETE WHERE"+
                "(CODIGO = "+Integer.toString(codigoPaquete)+");";
        
        try {
        
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultaPaquete);

            if (!rs.next()) {
                gestorBD.cerrarConexion(conexion);
                return false;
            }
            
            stmt.close();            
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        String interrelacion = "INSERT INTO CONFORMA VALUES ("
                                +Integer.toString(codigoPaquete)+","+
                                Integer.toString(codigoServ)+","+
                                Integer.toString(cantidad)+")";
        
        // Se agrega la interrelacion entre el servicio y paquete.
        
        try {
            
            Statement stmt = conexion.createStatement();
            int resultado = stmt.executeUpdate(interrelacion);
            gestorBD.cerrarConexion(conexion);
            return resultado > 0;
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        
        return false;
        
    }
    
    public boolean eliminarServicio(int codigoServ, int codigoPaquete) {
        
        // Crear el gestor para la base de datos
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        
        // Verificar si existe el servicio
        
        String consultaServ = "SELECT * FROM SERVICIO WHERE"+
                "(CODIGO = "+Integer.toString(codigoServ)+");";
        
        try {
            
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultaServ);

            if (!rs.next()) {
                gestorBD.cerrarConexion(conexion);
                return false;
            }
            
            stmt.close();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Verificar si existe el paquete
        
        String consultaPaquete = "SELECT * FROM PAQUETE WHERE"+
                "(CODIGO = "+Integer.toString(codigoPaquete)+");";
        
        try {
        
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultaPaquete);

            if (!rs.next()) {
                gestorBD.cerrarConexion(conexion);
                return false;
            }
            
            stmt.close();            
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        String eliminar = "DELETE FROM CONFORMA WHERE "+
                                "(CODIGO_PQ = "+Integer.toString(codigoPaquete)+") AND "+
                                "(CODIGO_S = "+Integer.toString(codigoServ)+");";
        
        // Se agrega la interrelacion entre el servicio y paquete.
        
        try {
            
            Statement stmt = conexion.createStatement();
            int resultado = stmt.executeUpdate(eliminar);
            gestorBD.cerrarConexion(conexion);
            return resultado > 0;
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        
        return false;
    }
    
    public ArrayList<String> obtenerServicios(int codigoPaquete) {
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        

        
        // Verificar si existe el paquete
        
        String consultaPaquete = "SELECT * FROM PAQUETE WHERE"+
                "(CODIGO = "+Integer.toString(codigoPaquete)+");";
        
        try {
        
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultaPaquete);

            if (!rs.next()) {
                gestorBD.cerrarConexion(conexion);
                return null;
            }
            
            stmt.close();            
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Obtener los codigos de los servicios 
        
        String consultarCodigos = "SELECT CODIGO_S FROM CONFORMA WHERE "+
                                  "CODIGO_PQ = "+Integer.toString(codigoPaquete)+
                                  ";";
        
        ArrayList<String> listaCod = new ArrayList();
        
        try {
        
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultarCodigos);
            
            while (rs.next()) {
                listaCod.add(rs.getString(1));
            }
            
            stmt.close();            
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
                                          
        return listaCod;         
        
    }
    
    public Paquete buscarPaquete(int codigoPaquete) {
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        

        
        // Verificar si existe el paquete
        
        String busquedaPaquete = "SELECT * FROM PAQUETE WHERE "+
                "(CODIGO = "+Integer.toString(codigoPaquete)+");";
        
        try {
        
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(busquedaPaquete);

            if (rs.next()) {
                int codigoPQ = rs.getInt(1);
                int tarifaPQ = rs.getInt(3);
                String nombrePQ = rs.getString(4);
                String tipoPQ = rs.getString(2);
                Paquete pq = new Paquete(codigoPQ,tarifaPQ,nombrePQ,tipoPQ);
                stmt.close();
                gestorBD.cerrarConexion(conexion);
                return pq;
            }
            

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        
        return null;
    }
    
    public boolean agregarPaquete(Paquete pq) {
        
        int codigoPQ = pq.getCodigo();
        int tarifaPQ = pq.getTarifa();
        String nombrePQ = pq.getNombre();
        String tipoPQ = pq.getTipo();
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        
        String insertPaquete = "INSERT INTO PAQUETE VALUES (" +
                                Integer.toString(codigoPQ)+ ", '"+
                                tipoPQ + "', " + 
                                Integer.toString(tarifaPQ)+ ", '"+
                                nombrePQ + "');";
        System.out.println(insertPaquete);
        
        try {
        
            Statement stmt = conexion.createStatement();
            int resultado = stmt.executeUpdate(insertPaquete);
            gestorBD.cerrarConexion(conexion);
            return resultado > 0;
            

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        return false;
    }
    
    public boolean borrarPaquete(int codigoPaquete) {
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        
        String borrarPaquete = "DELETE FROM PAQUETE WHERE "+
                                "CODIGO = "+Integer.toString(codigoPaquete)+";";
        System.out.println(borrarPaquete);
        
        try {
        
            Statement stmt = conexion.createStatement();
            int resultado = stmt.executeUpdate(borrarPaquete);
            gestorBD.cerrarConexion(conexion);
            return resultado > 0;
            

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        return false;
    }
    
}
