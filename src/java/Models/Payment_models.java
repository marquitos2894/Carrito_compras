/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.Payment_Beans;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Marco
 */
public class Payment_models 
{
    
    public ArrayList<Payment_Beans> listar_payment()
    {
        
            ArrayList<Payment_Beans> pb = new ArrayList<>();
            
            Connection cn;
            Conexion con = new Conexion();
            cn =  con.conectar();
            
            PreparedStatement pst = null;
            ResultSet rs = null;
        try { 
            String sql = "call V_PAYMENT()";
            pst =cn.prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
               pb.add(new Payment_Beans(rs.getString("paymet_cd"),rs.getString("paymet_ds")));
            }
        } catch (Exception e) {
          
        }
        finally
        {
           try{
            if(rs != null) rs.close();
            if(pst != null) pst.close();
           
           }catch (Exception e){}
        
    
        }
    
    return pb;
    }
}