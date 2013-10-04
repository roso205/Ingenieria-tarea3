/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

/**
 *
 * @author yue
 */
public class servicio {
    
    private int Codigo;
    private String Nombre;
    private int Costo;
    private int CodigoTipo;
   
    //Constructor
    servicio(int Codigo, String Nombre, int Costo, int CodigoTipo){
        
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Costo = Costo;
        this.CodigoTipo = CodigoTipo;
        
    }
          
      // Metodos
    
    public void setCodigo(int Codigo) {
        
        this.Codigo = Codigo;
                   
    }

    public int getCodigo() {
       
        return this.Codigo;
              
    }  
     
    public void setNombre(String Nombre) {
        
        this.Nombre = Nombre;
                   
    }

    public String getNombre() {
       
        return this.Nombre;
              
    }  
    
    public void setCosto(int Costo) {
        
        this.Costo = Costo;
                   
    }

    public int getCosto() {
       
        return this.Costo;
              
    } 

     public void setCodigo_TS(int CodigoTipo) {
        
        this.CodigoTipo = CodigoTipo;
                   
    }

    public int getCodigo_TS() {
       
        return this.CodigoTipo;
              
    }    
    
     
}