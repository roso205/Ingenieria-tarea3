package Gestiones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import BaseDatos.Conexion;
import java.sql.*;
/**
 * @author roso
 */
public class GestionarPlan {
    
    
    public boolean afiliarCliete(){
        
        Connection cn = new Conexion().getConexion();
        return true;
    }
    
    public void mostrarClientesAfiliados (int cop){
        
        try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
   ResultSet.CONCUR_READ_ONLY); 
        
        ResultSet rs = stm.executeQuery("SELECT * FROM CLIENTE WHERE"
                + " RIF IN (SELECT RIF_C FROM AFILIA WHERE CODIGO_P ="+cop+")");
       
        rs.last();
        
        if(0<rs.getRow()){
            rs.beforeFirst();
            System.out.println("Clientes Asociados al plan "+ cop+
             " \n Nombre                   |  Documento ");
            while(rs.next()){
                
                System.out.println(rs.getString("NOMBRE")+"             "+rs.getString("RIF"));

            }
        }else {
            System.out.println("No existen clientes Asociados al plan "+ cop);
        }
     cn.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
    
        
    }
    
   
    public boolean desafiliarClientesAfiliados(int cop){
    
        try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(); 
        
         stm.executeQuery("DELETE * FROM AFILIA WHERE CODIGO_P ="+cop);
       
      
     cn.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public boolean agregarPaquete(int co_plan,int co_paq){
        
                try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY); 
        
        ResultSet rs = stm.executeQuery("SELECT * FROM CONTIENE WHERE"
                + " CODIGO_P ="+co_plan+" AND CODIGO_PQ="+co_paq);
       rs.last();
       if(0==rs.getRow()){
          stm.executeQuery("INSERT INTO CONTIENE (CODIGO_P, CODIGO_PQ) "
                  + "VALUES ("+co_plan+","+co_paq+")" );
       
       }else{
           System.out.println("Ya el paquete:"+co_paq+" esta asociado al plan: "+co_plan);
           return false;
       }
      
     cn.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
    
        return true;
    }
    
    public boolean borrarPaquete(int co_plan,int co_paq){
        
         try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(); 
        
        stm.executeQuery("DELETE * FROM CONTIENE WHERE"
                + " CODIGO_P ="+co_plan+" AND CODIGO_PQ="+co_paq);
      
      
         cn.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public boolean modificarProducto(int co_pro, int new_plan){
        try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(); 
        
        stm.executeQuery("UPDATE PRODUCTO SET CODIGO_P="+new_plan+" WHERE"
                + " CODIGO="+co_pro);
      
      
         cn.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
        
        return true;
    }
    
    public boolean borrarProducto(){
        return true;
    }    
    
    public boolean buscarProducto(){
        return true;
    }
    
    public void mostrarProductos( int cop){
        
          try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
   ResultSet.CONCUR_READ_ONLY); 
        
        ResultSet rs = stm.executeQuery("SELECT * FROM PRODUCTO WHERE"
                + "CODIGO_P="+cop);
       
        rs.last();
        
        if(0<rs.getRow()){
            rs.beforeFirst();
            System.out.println("Productos Asociados al plan "+ cop+
             " \n Codigo      |        Nombre     |    Desc     ");
            while(rs.next()){
                
                System.out.println(rs.getString("CODIGO")+"   |    "+
                        rs.getString("NOMBRE")+"        "+rs.getString("DESCRIPCION"));

            }
        }else { System.out.println("No existen productos Asociados al plan "+ cop); 
        }
     cn.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
    
        
        
    }
    
    
}
