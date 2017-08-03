/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.Articulo;
import Beans.so_hea_beans;
import Conexion.Conexion;
import Models.so_hea_models;
        
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marco
 */

public class Registrar_venta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("accion");
            
//                int p = Integer.parseInt(request.getParameter("so_no"));
//            out.println(p);
    
            if(accion.equals("RegistrarVenta"))
            {   out.print(accion);
                RegistrarVenta(request, response);
            }
            else
            {
                throw new AssertionError();
            }
            
            
        }
    }
private void RegistrarVenta(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
{
    
    
 
    
    HttpSession sesion = request.getSession();
    ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
    
    Connection cn;
    Conexion con = new Conexion();
    cn =  con.conectar();
    
       
    so_hea_beans shb = new so_hea_beans();
    shb.setSo_no(Integer.parseInt(request.getParameter("so_no")));
    shb.setCus_id(request.getParameter("cus_id"));
    shb.setZone_cd(request.getParameter("region"));
    shb.setPaymet_cd(request.getParameter("paymet"));
    shb.setRegion_cd(Integer.parseInt(request.getParameter("pais_r")));
    
     boolean resp = so_hea_models.Reg_so_hea(shb);
     
        if(resp){
            // Regostrar detalle vemta
            int so_no = Integer.parseInt(request.getParameter("so_no"));
            //String so_no = request.getParameter("so_no");
            String li_no[] = request.getParameterValues("li_no");
            String item_cd[] = request.getParameterValues("item_cd");
            String cant[] = request.getParameterValues("quantity");
            String pre_uni[] = request.getParameterValues("item_unit_p");
            String tax_pe[] = request.getParameterValues("item_tax_pe");
            String tax_va[] = request.getParameterValues("impuesto");

              
            for(int i=0;i<cant.length;i++){
                try{
                    CallableStatement cs = cn.prepareCall("CALL I_SO_DET (?,?,?,?,?,?,?)");
//                    cs.setString(1, so_no);
                    cs.setInt(1, so_no);
                    cs.setString(2, li_no[i]);
                    cs.setString(3, item_cd[i]);
                    cs.setString(4, cant[i]);
                    cs.setString(5, pre_uni[i]);
                    cs.setString(6, tax_pe[i]);
                    cs.setString(7, tax_va[i]);
                    int j = cs.executeUpdate();
                    if(j==1){
                       
                        request.getSession().setAttribute("p_so_no",so_no);
                        response.sendRedirect("checkout.jsp");
                        articulos.clear();
                        //request.getRequestDispatcher("/shop.jsp").forward(request, response);
                        //request.getRequestDispatcher("/params.jsp").forward(request, response);
//...

                    }else{
                       
                        response.sendRedirect("shop.jsp?mens='Error al registrar su compra'");
                    }
                }catch(Exception e){System.out.println(e);}
            }
        }else{
            
            response.sendRedirect("/shop.jsp?mens='Error al registrar su compra'");
        }

    
    
}
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
