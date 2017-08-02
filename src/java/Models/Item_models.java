/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.Item_beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Conexion.Conexion;

/**
 *
 * @author Marco
 */
public class Item_models  {
    
    public ArrayList<Item_beans> getAllItem_models()
    {
        ArrayList<Item_beans> Items = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
        {       Connection cn;
            Conexion con = new Conexion();
            cn =  con.conectar();
            
            String sql = "call V_ITEM()";
            pst =cn.prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                Items.add(new Item_beans(rs.getString("item_cd"),rs.getString("item_ds"),rs.getString("itemtype_cd"),rs.getString("item_cur_cd"),rs.getDouble("item_unit_price_va"),rs.getDouble("item_stock_va"),rs.getInt("item_web_fg"),rs.getDouble("item_tax_pe")));
            }
            
        } catch (Exception e){
        
        }
        finally
        {
            try 
            {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
            
            } catch (Exception e){    
            }
        
        }
        
        return Items;
    }
    
        public Item_beans getItem_beans(String item_cd)
        {
            Connection cn;
            Conexion con = new Conexion();
            cn =  con.conectar();
            
            
            Item_beans item_uno = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            try{
                String sql = "call V_ITEM_UNO(?)";
                pst = cn.prepareCall(sql);
                pst.setString(1,item_cd);
                rs = pst.executeQuery();
                while(rs.next())
                {
                    item_uno = new Item_beans(rs.getString("item_cd"),rs.getString("item_ds"),rs.getString("itemtype_cd"),rs.getString("item_cur_cd"),rs.getDouble("item_unit_price_va"),rs.getDouble("item_stock_va"),rs.getInt("item_web_fg"),rs.getDouble("item_tax_pe"));
                }

            }catch (Exception e) {

            } finally {
                    try{
                        if(rs != null){ rs.close();}
                        if(pst !=null){pst.close();}
                      

                    }catch (Exception e){

                    }
            }

           return item_uno; 
        }
    
    
    
    
}
