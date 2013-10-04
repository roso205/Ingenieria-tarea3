package Gestiones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import ObjetosBase.Cliente;
import BaseDatos.Conexion;
import java.sql.*;
/**
 *
 * @author Karla alzuro
 */
public class GestionarCliente {
    
    public boolean agregarCliente(Cliente cli){
        
         try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(); 
        
         stm.executeQuery("INSERT INTO CLIENTE (RIF,NOMBRE,DIRECCION)"
          + "VALUES ('"+ cli.getRif() +"','"+cli.getNombre()+"','"+cli.getDirec()+"') ");
        
         cn.close();
         
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
        
        return true;
    } 

    public Cliente buscarCliente(int rif){
        Cliente cli = new Cliente();
         try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(); 
        
        ResultSet rs = stm.executeQuery("SELECT * FROM CLIENTE WHERE RIF="+rif);
        rs.next();
        cli.SetNombre(rs.getString("NOMBRE"));
        cli.setRif(rs.getInt("RIF"));
        cli.setDirec(rs.getString("DIRECCION"));
      
         cn.close();
         
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
        
        return cli;
    }

    public void mostrarCliente(Cliente cli ){
       
        System.out.println("Nombre: "+ cli.getNombre()+" Rif: "+cli.getRif()
                +" Direccion: "+cli.getDirec());
        
    }
}
