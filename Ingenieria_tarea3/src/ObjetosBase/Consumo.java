 package ObjetosBase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
/**
 *
 * @author nilver
 */
public class Consumo {
    private int cantidad;
    private int codServicio; 
    private Date fecha; 
    private int codProducto; 

public Consumo(int cantidad,int codServicio,Date fecha,int codProducto){
   
    this.cantidad= cantidad;
    this.codProducto= codProducto; 
    this.fecha= fecha;
    this.codServicio= codServicio;
}

public int getcodServicio(){

    return this.codServicio;
}

public int getcodProducto(){

    return this.codProducto;
}

public Date getFecha(){

    return this.fecha;
}

}
