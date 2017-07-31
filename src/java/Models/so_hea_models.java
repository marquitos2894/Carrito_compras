
package Models;

import Beans.so_hea_beans;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Models.Conexion;
/**
 *
 * @author Marco
 */
public class so_hea_models 
{

        public static boolean Reg_so_hea(so_hea_beans shb) {
        boolean resp = false;
        Conexion cn;
        Conexion con = new Conexion();
        cn = (Conexion) con.getConnection();
        
        try {
            //String sql = "call I_SO_HEA(?,?,?,?)";
            
            CallableStatement cs = cn.getConnection().prepareCall("call I_SO_HEA(?,?,?,?)");
            //    CallableStatement st=Conexion.Conecta().prepareCall("{call spadicion(?,?,?,?)}");

            cs.setInt(1, shb.getSo_no());
            cs.setString(2, shb.getCus_id());
            cs.setString(3, shb.getZone_cd());
            cs.setString(4, shb.getPaymet_cd());

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

    
}
