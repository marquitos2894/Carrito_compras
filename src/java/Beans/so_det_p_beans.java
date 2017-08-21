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
public class so_det_p_beans {

    private int so_no;
    private int line_no;
    private String item_cd;
    private Double qty_no;
    private Double item_unit_price_va;
    private Double item_tax_pe;
    private Double tax_va;
    
    public so_det_p_beans(int so_no, int line_no, String item_cd, Double qty_no, Double item_unit_price_va, Double item_tax_pe, Double tax_va) {
        this.so_no = so_no;
        this.line_no = line_no;
        this.item_cd = item_cd;
        this.qty_no = qty_no;
        this.item_unit_price_va = item_unit_price_va;
        this.item_tax_pe = item_tax_pe;
        this.tax_va = tax_va;
    }
    
    public so_det_p_beans(){}

    public int getSo_no() {
        return so_no;
    }

    public void setSo_no(int so_no) {
        this.so_no = so_no;
    }

    public int getLine_no() {
        return line_no;
    }

    public void setLine_no(int line_no) {
        this.line_no = line_no;
    }

    public String getItem_cd() {
        return item_cd;
    }

    public void setItem_cd(String item_cd) {
        this.item_cd = item_cd;
    }

    public Double getQty_no() {
        return qty_no;
    }

    public void setQty_no(Double qty_no) {
        this.qty_no = qty_no;
    }

    public Double getItem_unit_price_va() {
        return item_unit_price_va;
    }

    public void setItem_unit_price_va(Double item_unit_price_va) {
        this.item_unit_price_va = item_unit_price_va;
    }

    public Double getItem_tax_pe() {
        return item_tax_pe;
    }

    public void setItem_tax_pe(Double item_tax_pe) {
        this.item_tax_pe = item_tax_pe;
    }

    public Double getTax_va() {
        return tax_va;
    }

    public void setTax_va(Double tax_va) {
        this.tax_va = tax_va;
    }
    
    

      
  
    
    
}
