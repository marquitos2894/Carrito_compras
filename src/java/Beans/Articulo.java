/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author LAB07-01
 */
public class Articulo {


    
    private int li_no;
    private String idProducto;
    private int cantidad;
    
    
    
    public Articulo(String idProducto, int cantidad,int li_no) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.li_no = li_no;
    }
    
    public Articulo()
    {}
  

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
        public int getLi_no() {
        return li_no;
    }

    public void setLi_no(int li_no) {
        this.li_no = li_no;
    }

    public void getLi_no(String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
