
package Models;

import Beans.so_hea_uno_beans;
import Beans.max_no;
import Beans.so_hea_beans;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.Statement;
/**
 *
 * @author Marco
 */
public class so_hea_models 
{

        public static boolean Reg_so_hea(so_hea_beans shb) {
        boolean resp = false;
        Connection cn;
        Conexion con = new Conexion();
        cn =  con.conectar();
        
        try {
            //String sql = "call I_SO_HEA(?,?,?,?)";
            
            CallableStatement cs = cn.prepareCall("call I_SO_HEA(?,?,?,?,?)");
            //    CallableStatement st=Conexion.Conecta().prepareCall("{call spadicion(?,?,?,?)}");

            cs.setInt(1, shb.getSo_no());
            cs.setString(2, shb.getCus_id());
            cs.setString(3, shb.getZone_cd());
            cs.setString(4, shb.getPaymet_cd());
            cs.setInt(5, shb.getRegion_cd());

            int i = cs.executeUpdate();
            if( i == 1) {
                resp = true;
            }else{
                resp = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }
        
     public static ArrayList<so_hea_beans> getAllSo_he_det(){
        
         ArrayList<so_hea_beans> so_he_det = new ArrayList<>();
       
        Connection cn;
        Conexion con = new Conexion();
        cn =  con.conectar();
        
        try{
            CallableStatement cs = cn.prepareCall("CALL max_so_no_hea()");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                so_he_det.add( new so_hea_beans (rs.getInt("so_no"),rs.getString("cus_id"), rs.getString("zone_cd"), rs.getString("paymet_cd"),rs.getInt("region_cd")));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return so_he_det;
    }  
     
        public static ArrayList<max_no> getMax_so(){
        
         ArrayList<max_no> max = new ArrayList<>();
       
        Connection cn;
        Conexion con = new Conexion();
        cn =  con.conectar();
        
        try{
           
            CallableStatement cs = cn.prepareCall("CALL V_SO_HEA_2()");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                max.add( new max_no(rs.getInt("so_no")));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return max;
    }  
        
//     public so_hea_uno_beans getso_hea_beans(String so_no)
//        {
//            Connection cn;
//            Conexion con = new Conexion();
//            cn =  con.conectar();
//            
//            
//            so_hea_uno_beans  so_hea_uno = null;
//            PreparedStatement pst = null;
//            ResultSet rs = null;
//            try{
//                String sql = "call V_SO_HEA_UNO(?,?,?,?,?,?,?,?)";
//                pst = cn.prepareCall(sql);
//                pst.setString(1,so_no);
//                rs = pst.executeQuery();
//                while(rs.next())
//                {
//                    so_hea_uno = new so_hea_uno_beans(rs.getInt("so_no"),rs.getString("cus_id"),rs.getString("cus_name"),rs.getString("cus_address"),rs.getString("cus_mail"),rs.getString("zone_ds"),rs.getString("region_ds"),rs.getString("paymet_ds"));
//                }
//
//            }catch (Exception e) {
//
//            } finally {
//                    try{
//                        if(rs != null){ rs.close();}
//                        if(pst !=null){pst.close();}
//                       
//
//                    }catch (Exception e){
//
//                    }
//            }
//
//           return so_hea_uno; 
//        }    
        
     
     
//    public ArrayList<max_no> getMax_so_hea(){
//        
//        ArrayList<max_no> max = new ArrayList<>();
//       
//        Connection cn;
//        Conexion con = new Conexion();
//        cn =  con.conectar();
//        
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//
//        try{
//            
//            String sql = "call V_SO_HEA_MAX()";
//            pst =cn.prepareCall(sql);
//            rs = pst.executeQuery();
//            
//            while(rs.next()){
//                max.add(new max_no(rs.getInt("so_no")));
//            }
//         } catch (Exception e) {
//          
//        }
//        finally
//        {
//           try{
//            if(rs != null) rs.close();
//            if(pst != null) pst.close();
//           
//           }catch (Exception e){}
//        
//    
//        }   
// 
//        return max;
//    }   
//     
//    public ArrayList<so_hea_beans> getMax_so_no()
//    {
//        ArrayList<so_hea_beans> list_max = new ArrayList<>();
//        
//        Connection cn;
//        Conexion con = new Conexion();
//        cn =  con.conectar();
//        
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        try
//        {
//            String sql = "CALL V_SO_HEA_MAX()";
//            pst =cn.prepareCall(sql);
//            rs = pst.executeQuery();
//            while(rs.next())
//            {
//                //list_max.add(new so_hea_beans(rs.getInt("so_no")));
//            }
//            
//        } catch (Exception e){
//        
//        }
//        finally
//        {
//            try 
//            {
//                if(rs != null) rs.close();
//                if(pst != null) pst.close();
//               
//            } catch (Exception e){    
//            }
//        
//        }
//        
//        return list_max;
//    }
//        
//   public max_no getMax()
//    {
//        Connection cn;
//        Conexion con = new Conexion();
//        cn =  con.conectar();
//        
//        max_no Max_no = null;
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        try{
//            String sql = "call V_SO_HEA_MAX()";
//            pst = cn.prepareCall(sql);
//            rs = pst.executeQuery();
//            while(rs.next())
//            {
//                 Max_no = new max_no(rs.getInt("so_no"));
//            }
//            
//        }catch (Exception e) {
//            
//        } finally {
//                try{
//                    if(rs != null){ rs.close();}
//                    if(pst !=null){pst.close();}
//                    
//                                
//                }catch (Exception e){
//                
//                }
//        }
//       
//       return Max_no; 
//    }     
        
public so_hea_uno_beans getAllhea_uno(int so_no)
        {
            Connection cn;
            Conexion con = new Conexion();
            cn =  con.conectar();
            
            
            so_hea_uno_beans s_hea_uno = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            try{
                String sql = "call V_SO_HEA_UNO(?)";
                pst = cn.prepareCall(sql);
                pst.setInt(1,so_no);
                rs = pst.executeQuery();
                while(rs.next())
                {
                    s_hea_uno = new so_hea_uno_beans(rs.getInt("so_no"),rs.getString("cus_id"),rs.getString("cus_name"),rs.getString("cus_address"),rs.getString("cus_mail"),rs.getString("zone_ds"),rs.getString("region_ds"),rs.getString("paymet_ds"));
                }

            }catch (Exception e) {

            } finally {
                    try{
                        if(rs != null){ rs.close();}
                        if(pst !=null){pst.close();}
                      

                    }catch (Exception e){

                    }
            }

           return s_hea_uno; 
        }        

        
        
        
        
    
}
