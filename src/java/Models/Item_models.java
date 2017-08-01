/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.Item_beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class Item_models  extends Conexion{
    
    public ArrayList<Item_beans> getAllItem_models()
    {
        ArrayList<Item_beans> Items = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
        {
            String sql = "call V_ITEM()";
            pst =getConnection().prepareCall(sql);
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
                if(getConnection() != null) getConnection().close();
            } catch (Exception e){    
            }
        
        }
        
        return Items;
    }
    
        public Item_beans getItem_beans(String item_cd)
        {
            Item_beans item_uno = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            try{
                String sql = "call V_ITEM_UNO(?)";
                pst = getConnection().prepareCall(sql);
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
                        if(getConnection() != null) getConnection().close();

                    }catch (Exception e){

                    }
            }

           return item_uno; 
        }
    
    
    
    
}
