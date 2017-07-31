/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.Articulo;
import Beans.so_hea_beans;
import Models.Conexion;
import Models.so_hea_models;
        
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
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
@WebServlet(name = "Registrar_venta", urlPatterns = {"/Registrar_venta"})
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
            out.print(accion);
                int p = Integer.parseInt(request.getParameter("so_no"));
            out.println(p);
    
            if(accion.equals("RegistrarVenta"))
            {
                this.RegistrarVenta(request, response);
            }
            
            
        }
    }
private void RegistrarVenta(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
{
      String accion = request.getParameter("accion");
         System.out.println(accion);
    
    HttpSession sesion = request.getSession();
    ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
    
    Conexion cn;
    Conexion con = new Conexion();
    cn = (Conexion) con.getConnection();
    
    int p = Integer.parseInt(request.getParameter("so_no"));
    System.out.println(p);
    
    so_hea_beans shb = new so_hea_beans();
    shb.setSo_no(Integer.parseInt(request.getParameter("so_no")));
    shb.setCus_id(request.getParameter("cus_id"));
    shb.setZone_cd(request.getParameter("region"));
    shb.setPaymet_cd(request.getParameter("paymet"));
    
     boolean resp = so_hea_models.Reg_so_hea(shb);
     
        if(resp){
            // Regostrar detalle vemta
            int so_no = Integer.parseInt(request.getParameter("so_no"));
            String li_no[] = request.getParameterValues("li_no");
            String item_cd[] = request.getParameterValues("item_cd");
            String cant[] = request.getParameterValues("quantity");
            String tax_pe[] = request.getParameterValues("item_tax_pe");
            String tax_va[] = request.getParameterValues("impuesto");

              
            for(int i=0; i<item_cd.length;i++){
                try{
                    CallableStatement cs = cn.getConnection().prepareCall("CALL I_SO_DET (?,?,?,?,?,?)");
                    cs.setInt(1, so_no);
                    cs.setString(2, li_no[i]);
                    cs.setString(3, item_cd[i]);
                    cs.setString(4, cant[i]);
                    cs.setString(5, tax_pe[i]);
                    cs.setString(6, tax_va[i]);
                    int j = cs.executeUpdate();
                    if(j==1){
                        response.sendRedirect("shop.jsp?mens='Se ha registrado su compra correctamente'"); 
                        articulos.clear();
                    }else{
                        response.sendRedirect("shop.jsp?mens='Error al registrar su compra'");
                    }
                }catch(Exception e){System.out.println(e);}
            }
        }else{
            response.sendRedirect("shop.jsp?mens='Error al registrar su compra'");
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
