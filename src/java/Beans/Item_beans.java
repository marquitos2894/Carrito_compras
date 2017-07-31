/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Marco
 */
public class Item_beans 
{
    private String item_cd;
    private String item_ds;
    private String itemtype_cd;
    private String item_cur_cd;
    private Double item_unit_price_va;
    private Double item_stock_va;
    private int item_web_fg;
    private Double item_tax_pe;

    public Item_beans(String item_cd, String item_ds, String itemtype_cd, String item_cur_cd, Double item_unit_price_va, Double item_stock_va, int item_web_fg, Double item_tax_pe) 
    {
        this.item_cd = item_cd;
        this.item_ds = item_ds;
        this.itemtype_cd = itemtype_cd;
        this.item_cur_cd = item_cur_cd;
        this.item_unit_price_va = item_unit_price_va;
        this.item_stock_va = item_stock_va;
        this.item_web_fg = item_web_fg;
        this.item_tax_pe = item_tax_pe;
    }
    
    public Item_beans(){
        
    }

    public String getItem_cd() {
        return item_cd;
    }

    public void setItem_cd(String item_cd) {
        this.item_cd = item_cd;
    }

    public String getItem_ds() {
        return item_ds;
    }

    public void setItem_ds(String item_ds) {
        this.item_ds = item_ds;
    }

    public String getItemtype_cd() {
        return itemtype_cd;
    }

    public void setItemtype_cd(String itemtype_cd) {
        this.itemtype_cd = itemtype_cd;
    }

    public String getItem_cur_cd() {
        return item_cur_cd;
    }

    public void setItem_cur_cd(String item_cur_cd) {
        this.item_cur_cd = item_cur_cd;
    }

    public Double getItem_unit_price_va() {
        return item_unit_price_va;
    }

    public void setItem_unit_price_va(Double item_unit_price_va) {
        this.item_unit_price_va = item_unit_price_va;
    }

    public Double getItem_stock_va() {
        return item_stock_va;
    }

    public void setItem_stock_va(Double item_stock_va) {
        this.item_stock_va = item_stock_va;
    }

    public int getItem_web_fg() {
        return item_web_fg;
    }

    public void setItem_web_fg(int item_web_fg) {
        this.item_web_fg = item_web_fg;
    }

    public Double getItem_tax_pe() {
        return item_tax_pe;
    }

    public void setItem_tax_pe(Double item_tax_pe) {
        this.item_tax_pe = item_tax_pe;
    }
    
        
    
    
}
