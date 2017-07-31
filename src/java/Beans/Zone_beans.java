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
public class Zone_beans {

       private String zone_cd;
    private String zone_ds;
    
    
    public Zone_beans(String zone_cd, String zone_ds) {
        this.zone_cd = zone_cd;
        this.zone_ds = zone_ds;
    }
    
    public Zone_beans(){}

    public String getZone_cd() {
        return zone_cd;
    }

    public void setZone_cd(String zone_cd) {
        this.zone_cd = zone_cd;
    }

    public String getZone_ds() {
        return zone_ds;
    }

    public void setZone_ds(String zone_ds) {
        this.zone_ds = zone_ds;
    }
    
 
    
    
    
    
}
