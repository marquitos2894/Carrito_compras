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
public class Payment_Beans {

    private String payment_cd;
    private String payment_ds;
    
    public String getPayment_cd() {
        return payment_cd;
    }

    public void setPayment_cd(String payment_cd) {
        this.payment_cd = payment_cd;
    }

    public String getPayment_ds() {
        return payment_ds;
    }

    public void setPayment_ds(String payment_ds) {
        this.payment_ds = payment_ds;
    }

    public Payment_Beans(String payment_cd, String payment_ds) {
        this.payment_cd = payment_cd;
        this.payment_ds = payment_ds;
    }
    
    public Payment_Beans(){}
 

    
    
}
