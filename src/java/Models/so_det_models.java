


package Models;

import Beans.so_det_p_beans;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.Statement;

public class so_det_models {
    
     public ArrayList<so_det_p_beans> getAllso_d_p(int so_no) 
    {
        ArrayList<so_det_p_beans> sd = new ArrayList<>();
        
        Connection cn;
        Conexion con = new Conexion();
        cn =  con.conectar();
         
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
        String sql = "call V_SO_DET_P(?)";
        pst = cn.prepareCall(sql);
        pst.setInt(1,so_no);
        rs = pst.executeQuery();
        while(rs.next())
        {   //rb.add(new Zone_beans(rs.getString("zone_cd"),rs.getString("zone_ds")));
            sd.add(new so_det_p_beans(rs.getInt("so_no"),rs.getInt("line_no"),rs.getString("item_cd"),rs.getDouble("qty_no"),rs.getDouble("item_unit_price_va"),rs.getDouble("item_tax_pe"),rs.getDouble("tax_va")));
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
    
    return sd;
    }
    
}
