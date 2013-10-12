/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BaseDatos.Conexion;
import BaseDatos.gestionarBaseDatos;
import ObjetosBase.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arturo
 */
public class ControladorServiciosOfrecidos {
    
    public ControladorServiciosOfrecidos() {
        
    }
    
    // Agrega un plan a la base de datos, y su referencia en prepago o postpago
    public boolean agregarPlan(Plan p) {
        
        int codigoP = p.getCodigo();
        double tarifaP = p.getTarifa();
        String nombreP = p.getNombre();
        String tipoP = p.getTipo();
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        int tarifa = (int) tarifaP;
        Connection conexion = gestorBD.establecerConexion();
        
        String insertPlan = "INSERT INTO PLAN VALUES (" +
                                Integer.toString(codigoP)+ ", '"+
                                nombreP + "', " +
                                Integer.toString(tarifa)+ ");";
        
        String insertRef = "INSERT INTO "+ tipoP + " VALUES (" + codigoP + ");";
                            
               
        try {
        
            Statement stmt = conexion.createStatement();
            int resultado = stmt.executeUpdate(insertPlan);
            resultado = resultado * stmt.executeUpdate(insertRef);
            stmt.close();
            gestorBD.cerrarConexion(conexion);
            return resultado > 0;
            

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        return false;
        
    }
    
    // Agrega un tipo de servicio a la base de datos
    public boolean agregarTipoServicio(TipoServicio tp) {
        int codigo = tp.getCodigo();
        String nombre = tp.getNombre();
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        
        String insertTs = "INSERT INTO TIPO_SERVICIO VALUES ('" +
                                nombre + "', " +
                                Integer.toString(codigo)+ "); ";
        
        try {
        
            Statement stmt = conexion.createStatement();
            int resultado = stmt.executeUpdate(insertTs);
            stmt.close();
            gestorBD.cerrarConexion(conexion);
            return resultado > 0;
            

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        return false;    
        
    }
    
    // Agrega un servicio a la base de datos
    public boolean agregarServicio(Servicio s) {
        
        int codigo = s.getCodigo();
        String nombre = s.getNombre();
        int costo = s.getCosto();
        int codigoTipo = s.getCodigo_TS();
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        
        String insertS = "INSERT INTO SERVICIO VALUES (" +
                                Integer.toString(codigo) + ", '"+
                                nombre + "', " +
                                Integer.toString(costo) + ", "+
                                Integer.toString(codigoTipo) + ");";
        
        try {
        
            Statement stmt = conexion.createStatement();
            int resultado = stmt.executeUpdate(insertS);
            stmt.close();
            gestorBD.cerrarConexion(conexion);
            return resultado > 0;
            

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        return false;  
        
    }
    
    // Elimina el plan y sus interrelaciones de la base de datos
    // NOTA IMPORTANTE : No se debe usar a la ligera ya que borra un producto
    // sin borrar sus interrelaciones.
    public boolean eliminarPlan(Plan p) {
        
        String cod = Integer.toString(p.getCodigo());
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        
        String borrarAfilia = "DELETE FROM AFILIA WHERE CODIGO_P = "+cod+";";
        String borrarContiene = "DELETE FROM CONTIENE WHERE CODIGO_P = "+cod+";";
        String borrarPostpago = "DELETE FROM POSTPAGO WHERE CODIGO_P = "+cod+";";
        String borrarPrepago = "DELETE FROM PREPAGO WHERE CODIGO_P = "+cod+";";
        String borrarProducto = "DELETE FROM PRODUCTO WHERE CODIGO_P = "+cod+";";
        String borrarPlan = "DELETE FROM PLAN WHERE CODIGO = "+cod+";";
        
        try {
        
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(borrarAfilia);
            stmt.executeUpdate(borrarContiene);
            stmt.executeUpdate(borrarPostpago);
            stmt.executeUpdate(borrarPrepago);
            stmt.executeUpdate(borrarProducto);
            int resultado = stmt.executeUpdate(borrarPlan);
            stmt.close();
            gestorBD.cerrarConexion(conexion);
            return resultado > 0;
            

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        return false;  
    }
    
    // Elimina el servicio y sus interrelaciones de la base de datos
    public boolean eliminarServicio(Servicio s) {
        
        String cod = Integer.toString(s.getCodigo());
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        
        String borrarServicio = "DELETE FROM SERVICIO WHERE CODIGO = "+cod+";";
        String borrarConforma = "DELETE FROM CONFORMA WHERE CODIGO_S = "+cod+";";
        String borrarConsumo = "DELETE FROM CONSUMO WHERE CODIGO_S = "+cod+";";
        
        try {
        
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(borrarConforma);
            stmt.executeUpdate(borrarConsumo);
            int resultado = stmt.executeUpdate(borrarServicio);
            stmt.close();
            gestorBD.cerrarConexion(conexion);
            return resultado > 0;
            

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        return false;  
        
    }
    
    // Elimina el tipo de servicio y sus interrelaciones de la base de datos
    public boolean eliminarTipoServicio(TipoServicio tp) {
        
        String cod = Integer.toString(tp.getCodigo());
        
        gestionarBaseDatos gestorBD = new gestionarBaseDatos();
        
        Connection conexion = gestorBD.establecerConexion();
        
        Servicio serv; 
        ControladorServiciosOfrecidos cso = new ControladorServiciosOfrecidos();
        
        String borrarTipoServicio = "DELETE FROM TIPO_SERVICIO WHERE CODIGO = "+cod+";";
        String buscarServicios = "SELECT CODIGO FROM SERVICIO WHERE CODIGO_TS = "+cod+";";
        
        try {
        
            Statement stmt = conexion.createStatement();
            
            // Borrar los servicios asociados a el tipo de servicio
            ResultSet rs = stmt.executeQuery(buscarServicios);
            
            while (rs.next()) {
                serv = new Servicio(rs.getInt(1),null,0,0);
                cso.eliminarServicio(serv);
            }       
            
            stmt.executeUpdate(borrarTipoServicio);
            int resultado = stmt.executeUpdate(borrarTipoServicio);
            stmt.close();
            gestorBD.cerrarConexion(conexion);
            return resultado > 0;
            

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        return false;  
        
    }
    
    // Muestra los clientes afiliados al plan
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
    
    //Utilizar con cuidado, porque queda aun el producto afiliado
    public boolean desafiliarClientesAfiliados(int cop){
    
        try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(); 
        
         stm.executeQuery("DELETE FROM AFILIA WHERE CODIGO_P ="+cop);
       
      
     cn.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public boolean agregarPaqueteAPlan(int co_plan,int co_paq){
        
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
           System.out.println("Ya el paquete:" +co_paq+" esta asociado al plan: "+co_plan);
           return false;
       }
      
     cn.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
    
        return true;
    }
    
    // Borra la asociacion entre el plan y el paquete.
    public boolean borrarPaqueteDePlan(int co_plan,int co_paq){
        
        try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(); 
        
        String borrarContiene = "DELETE FROM CONTIENE WHERE"
                + " CODIGO_P ="+co_plan+" AND CODIGO_PQ="+co_paq;
        
        stm.executeQuery(borrarContiene);
      
      
         cn.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    // Modifica el Plan del producto
    public boolean modificarProducto(int co_pro, int new_plan){
        try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(); 
        System.out.println("UPDATE PRODUCTO SET CODIGO_P = " +new_plan+" WHERE"
                + " CODIGO = " +co_pro +";");
        stm.executeQuery("UPDATE PRODUCTO SET CODIGO_P = " +new_plan+" WHERE"
                + " CODIGO = " +co_pro +";");
      
      
         cn.close();
        } catch (Exception e ) { 
            System.out.println("Se ha producido un error en la  base de datos !");
            System.out.println(e.getMessage());
        }
        
        return true;
    }
    
    public void mostrarProductos( int cop){
        
          try{
            
        Connection cn = new Conexion().getConexion();
        
        Statement stm = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
   ResultSet.CONCUR_READ_ONLY); 
        
        System.out.println("SELECT * FROM PRODUCTO WHERE "
                + "CODIGO_P = "+Integer.toString(cop)+";");
        ResultSet rs = stm.executeQuery("SELECT * FROM PRODUCTO WHERE "
                + "CODIGO_P = "+Integer.toString(cop)+";");
       
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
    
    // Agrega un servicio al paquete.
    public boolean agregarServicioAPaquete(int codigoServ, int codigoPaquete,
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
                stmt.close();
                return false;
            }
                      
        
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
                stmt.close();
                return false;
            }
                       
        
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
    
    public boolean eliminarServicioDePaquete(int codigoServ, int codigoPaquete) {
        
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
                stmt.close();
                return false;
            }
                    
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
                stmt.close(); 
                return false;                
            }
                                  
        
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
                stmt.close();
                return null;
            }
                                  
        
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
        
        try {
        
            Statement stmt = conexion.createStatement();
            int resultado = stmt.executeUpdate(insertPaquete);
            stmt.close();
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
        
        String codPq = Integer.toString(codigoPaquete);
        String borrarContrata = "DELETE FROM CONTRATA WHERE CODIGO_PQ = "+codPq+";";
        String borrarContiene = "DELETE FROM CONTIENE WHERE CODIGO_PQ = "+codPq+";";
        String borrarConforma = "DELETE FROM CONFORMA WHERE CODIGO_PQ = "+codPq+";";
        String borrarPaquete = "DELETE FROM PAQUETE WHERE "+
                                "CODIGO = "+codPq+";";
        System.out.println(borrarPaquete);
        
        try {
        
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(borrarContrata);
            stmt.executeUpdate(borrarContiene);
            stmt.executeUpdate(borrarConforma);
            int resultado = stmt.executeUpdate(borrarPaquete);
            gestorBD.cerrarConexion(conexion);
            stmt.close();
            return resultado > 0;
            

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        gestorBD.cerrarConexion(conexion);
        return false;
    }
    
    public int TarifaTotalPaquetesAdicionales(List<String> Paquetes) {
        
        
        try{

        gestionarBaseDatos BaseDatos = new gestionarBaseDatos();
        
        Connection connection = BaseDatos.establecerConexion();
                
        Statement stmt = connection.createStatement();    
        int resultado = 0; 
        
        for (int j = 0; j < Paquetes.size(); j++) {
            
         
            String consulta = "SELECT TARIFA FROM PAQUETE "
                     + " WHERE (PAQUETE.CODIGO = " +Paquetes.get(j)+") ";

            
        
             ResultSet rs = stmt.executeQuery(consulta);


             while (rs.next()){

                resultado+= rs.getInt(1);

            }
             
        }
        

        
        stmt.close();
        BaseDatos.cerrarConexion(connection); 
        return resultado;
        }

        catch ( Exception e ) {
            System.out.println(e.getMessage());
            int resultado = 5;
            return resultado;
        } 
        

    
    }
    
}
