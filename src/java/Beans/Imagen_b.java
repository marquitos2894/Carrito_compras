/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Blob;

/**
 *
 * @author Marco
 */
public class Imagen_b {
    
    private String item_cd;
    private int image_no;
    private Blob image_im;
    

    public Imagen_b(String item_cd, int image_no, Blob image_im) {
        this.item_cd = item_cd;
        this.image_no = image_no;
        this.image_im = image_im;
    }
    
    
    

    public String getItem_cd() {
        return item_cd;
    }

    public void setItem_cd(String item_cd) {
        this.item_cd = item_cd;
    }

    public int getImage_no() {
        return image_no;
    }

    public void setImage_no(int image_no) {
        this.image_no = image_no;
    }

    public Blob getImage_im() {
        return image_im;
    }

    public void setImage_im(Blob image_im) {
        this.image_im = image_im;
    }
    
    
    
    
}
