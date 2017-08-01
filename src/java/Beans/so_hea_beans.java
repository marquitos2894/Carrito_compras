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
public class so_hea_beans {
    
    private int so_no;
    private String cus_id;
    private String zone_cd;
    private String paymet_cd;

    public so_hea_beans(int so_no, String cus_id, String zone_cd, String paymet_cd) {
        this.so_no = so_no;
        this.cus_id = cus_id;
        this.zone_cd = zone_cd;
        this.paymet_cd = paymet_cd;
    }

    
    public so_hea_beans() {}

      

    public int getSo_no() {
        return so_no;
    }

    public void setSo_no(int so_no) {
        this.so_no = so_no;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getZone_cd() {
        return zone_cd;
    }

    public void setZone_cd(String zone_cd) {
        this.zone_cd = zone_cd;
    }

    public String getPaymet_cd() {
        return paymet_cd;
    }

    public void setPaymet_cd(String paymet_cd) {
        this.paymet_cd = paymet_cd;
    }
    

    
    
    
    
    
    
}
