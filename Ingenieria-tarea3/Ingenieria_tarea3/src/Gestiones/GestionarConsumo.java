package Gestiones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import BaseDatos.Conexion;
import ObjetosBase.Consumo;
import java.util.Date;
import java.sql.*;
/**
 *
 * @author nilver
 */
public class GestionarConsumo{
    
      
    public boolean agregarConsumo(int cantidad,int codServicio,Date fecha,int codProducto){
        
        Connection conectar = new Conexion().getConexion();
            
        try{
            
            Statement  s = conectar.createStatement() ; 
            
            
            String validarServicio="SELECT * FROM SERVICIO"
                                    +" WHERE CODIGO ="+codServicio;
          
                                   
            ResultSet resultado = s.executeQuery(validarServicio);
                                                          
            if(!resultado.next()){  
                System.out.println("El servicio no existe");
                return false;
            }    
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            
            Statement  s = conectar.createStatement() ; 
            
            String validarProducto=" SELECT * FROM PRODUCTO "
                                     +"WHERE CODIGO ="+codProducto;
              
            ResultSet resultado = s.executeQuery(validarProducto);
                                                          
            if(!resultado.next()){  
                System.out.println("El producto no existe");
                return false;
            }    
         
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            
        String agregar = "INSERT INTO CONSUMO (CODIGO_S,CODIGO_PR,FECHA,CANTIDAD)"
                + "VALUES ("+Integer.toString(codServicio)+","+Integer.toString(codProducto)+",now(),"+cantidad+")";
        
         
        try{
            
           Statement  s = conectar.createStatement() ; 
            
           int resultado = s.executeUpdate(agregar);
            
           return resultado>0;                
         
             
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
         
         return false;
    }
    
        
    public void consultarConsumo(int codProducto){
        
        Connection conectar = new Conexion().getConexion();
            
         try{
     
        Statement stm = conectar.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY); 
        String consulta= "SELECT C.CODIGO_PR,P.NOMBRE,S.CODIGO AS CS,"
                + "S.NOMBRE,C.CANTIDAD,C.FECHA "
                + "FROM SERVICIO S,CONSUMO C,PRODUCTO P WHERE "
                + "C.CODIGO_PR= P.CODIGO AND CODIGO_S= S.CODIGO AND C.CODIGO_PR ="+codProducto;
        
        ResultSet resultado = stm.executeQuery(consulta);
       
         resultado.last();
        
        if(0<resultado.getRow()){
            resultado.beforeFirst();
            System.out.println("Consumos del plan "+ codProducto );
            while(resultado.next()){
                
                System.out.println(resultado.getString("CODIGO_PR")+"  "+
                        resultado.getString("CS")+" "+
                        resultado.getString("NOMBRE")+" "+resultado.getString("FECHA")+
                        resultado.getString("CANTIDAD"));

            }
        }else {
            System.out.println("No existen consumos  asociados al producto "+ codProducto);
        }
     conectar.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
         
               
    }
    
    
    public void listarConsumos(){
        
           Connection conectar = new Conexion().getConexion();
            
         try{
     
        Statement stm = conectar.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY); 
       
        String consulta1 =" SELECT C.CODIGO_PR,P.NOMBRE,S.CODIGO,S.NOMBRE,C.CANTIDAD,C.FECHA "
               + "FROM CONSUMO C "
               +"JOIN PRODUCTO P (C.CODIGO_PR=P.CODIGO) "
               + "JOIN SERVICIO S(C.CODIGO_S= S.CODIGO)";
        
        ResultSet resultado = stm.executeQuery(consulta1);
       
        System.out.print(consulta1);
        
        resultado.last();
        
        if(0<resultado.getRow()){
            resultado.beforeFirst();
            System.out.println("Consumos ");
            while(resultado.next()){
                
                System.out.println(resultado.getString("CODIGO_ṔR")+"  "+
                        resultado.getString("CODIGO_S")+" "+
                        resultado.getString("NOMPRO")+" "+
                        resultado.getNString("FECHA")+
                        resultado.getNString("CATIDAD"));

            }
        }else {
            System.out.println("No existen consumos  ");
        }
     conectar.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
          
    }
}
