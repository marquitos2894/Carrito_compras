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
public class Region__Beans {


    private int region_cd;


    private String zone_cd;
    private String region_ds;
    
    public Region__Beans(int region_cd,String zone_cd, String region_ds) {
        this.region_cd = region_cd;
        this.zone_cd = zone_cd;
        this.region_ds = region_ds;
    }


    public Region__Beans(){}

    public String getZone_cd() {
        return zone_cd;
    }

    public void setZone_cd(String zone_cd) {
        this.zone_cd = zone_cd;
    }

    public String getRegion_ds() {
        return region_ds;
    }

    public void setRegion_ds(String region_ds) {
        this.region_ds = region_ds;
    }
        public int getRegion_cd() {
        return region_cd;
    }

    public void setRegion_cd(int region_cd) {
        this.region_cd = region_cd;
    }

   
           
}
