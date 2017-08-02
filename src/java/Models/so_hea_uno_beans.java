/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author LAB07-01
 */
public class so_hea_uno_beans {

    private int so_no;
    private String cus_id;
    private String cus_name;
    private String cus_address;
    private String cus_mail;
    private String zone_ds;
    private String region_ds;
    private String paymet_ds;
    
    
    
    public so_hea_uno_beans(int so_no, String cus_id, String cus_name, String cus_address, String cus_mail, String zone_ds, String region_ds, String paymet_ds) {
        this.so_no = so_no;
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_address = cus_address;
        this.cus_mail = cus_mail;
        this.zone_ds = zone_ds;
        this.region_ds = region_ds;
        this.paymet_ds = paymet_ds;
    }

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

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_address() {
        return cus_address;
    }

    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    public String getCus_mail() {
        return cus_mail;
    }

    public void setCus_mail(String cus_mail) {
        this.cus_mail = cus_mail;
    }

    public String getZone_ds() {
        return zone_ds;
    }

    public void setZone_ds(String zone_ds) {
        this.zone_ds = zone_ds;
    }

    public String getRegion_ds() {
        return region_ds;
    }

    public void setRegion_ds(String region_ds) {
        this.region_ds = region_ds;
    }

    public String getPaymet_ds() {
        return paymet_ds;
    }

    public void setPaymet_ds(String paymet_ds) {
        this.paymet_ds = paymet_ds;
    }
    
    
    
    
    
}
