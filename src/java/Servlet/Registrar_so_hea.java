/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.so_hea_models;
import Beans.so_hea_beans;

/**
 *
 * @author Marco
 */
@WebServlet(name = "Registrar_so_hea", urlPatterns = {"/Registrar_so_hea"})
public class Registrar_so_hea extends HttpServlet {

     so_hea_models obj;
     
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
         protected void Registar_so_header(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             obj = new so_hea_models();
             
        so_hea_beans shb = new so_hea_beans();
        
        shb.setSo_no(Integer.parseInt(request.getParameter("so_no")));
        shb.setCus_id(request.getParameter("cus_id"));
        shb.setZone_cd(request.getParameter("paymet"));
        shb.setPaymet_cd(request.getParameter("region"));
        obj.Reg_so_hea(shb);
        String pag = "/shop.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
