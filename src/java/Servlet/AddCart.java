/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.Articulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LAB07-01
 */
@WebServlet(name = "AddCart", urlPatterns = {"/AddCart"})
public class AddCart extends HttpServlet {

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
        
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String idproducto = request.getParameter("idproducto");
        int indice =  Integer.parseInt(request.getParameter("indice"));
        
        HttpSession sesion = request.getSession(true);
//        ArrayList<Articulo> carritoCompra;
//        if(sesion.getAttribute("carrito") == null){
//            carritoCompra = new ArrayList<Articulo>();
//        }else{
//            carritoCompra = (ArrayList<Articulo>)sesion.getAttribute("carrito");
//        }
        Articulo ar = new Articulo();

        ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
        
//        boolean flag = false;        
//        if(articulos.size() > 0){
//            for (Articulo a : articulos){
//                if(idproducto == a.getIdProducto()){
//                    a.setCantidad(a.getCantidad() + cantidad);
//                    //a.setLi_no(indice + indice);
//                        
//                    flag = true;
//                    break;
//                }
//            }
//        }
//         
//        
//        if(!flag){
            
          articulos.add(new Articulo(idproducto,cantidad,indice));
            
        //}
        
        sesion.setAttribute("carrito", articulos);  
        response.sendRedirect("cart.jsp");

        
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
