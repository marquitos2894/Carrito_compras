/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.Zone_beans;
import Beans.Region__Beans;
import java.sql.Connection;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class Zone_models 
{
    public ArrayList<Zone_beans> getAllZone_models()
    {
        
         ArrayList<Zone_beans> Zone = new ArrayList<>();
         
        Connection cn;
        Conexion con = new Conexion();
        cn =  con.conectar();
         
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            String sql = "call V_ZONE()";
            pst = cn.prepareCall(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                Zone.add(new Zone_beans(rs.getString("zone_cd"),rs.getString("zone_ds")));
            }
            
        }catch (Exception e) 
        {
            
        }
        finally
        {
            try
            {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
               
            } catch (Exception e){}
        
        
        }
        return Zone;
    }
    
    public ArrayList<Region__Beans> getAllRegion_models(String zone_cd) 
    {
        ArrayList<Region__Beans> rb = new ArrayList<>();
        
        Connection cn;
        Conexion con = new Conexion();
        cn =  con.conectar();
         
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
        String sql = "call V_REGION(?)";
        pst = cn.prepareCall(sql);
        pst.setString(1,zone_cd);
        rs = pst.executeQuery();
        while(rs.next())
        {   //rb.add(new Zone_beans(rs.getString("zone_cd"),rs.getString("zone_ds")));
            rb.add(new Region__Beans(rs.getInt("region_cd"),rs.getString("zone_cd"),rs.getString("region_ds")));
        }
        
        }catch (Exception e){}  
        
        finally
        {
            try{
                if(rs != null){rs.close();}
                if(pst !=null){pst.close();}
              
            } catch (Exception e)
            {}
        
        }
    
    return rb;
    }
    
//        public Region__Beans getRegion_models(String zone_cd)
//    {
//        Connection cn;
//        Conexion con = new Conexion();
//        cn =  con.conectar();
//         
//        
//        Region__Beans rb = null;
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        try{
//            String sql = "call V_REGION(?)";
//            pst = getConnection().prepareCall(sql);
//            pst.setString(1,zone_cd);
//            rs = pst.executeQuery();
//            while(rs.next())
//            {
//                rb = new Region__Beans(rs.getString("zone_cd"),rs.getString("region_ds"));
//            }
//            
//        }catch (Exception e) {
//            
//        } finally {
//                try{
//                    if(rs != null){ rs.close();}
//                    if(pst !=null){pst.close();}
//                    if(getConnection() != null) getConnection().close();
//                                
//                }catch (Exception e){
//                
//                }
//        }
//       
//       return rb; 
//    }
//    
    
    
}
