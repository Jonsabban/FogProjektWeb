/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classes.Category;
import classes.Material;
import data.DataAccessObject;
import facade.DBFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vfgya_000
 */
@WebServlet(name = "SLPrint", urlPatterns
        = {
            "/SLPrint"
        })
public class SLPrint extends HttpServlet {

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

        
        DBFacade facade = new DBFacade();

        // variabler med arraylisterne
        ArrayList<Category> CAL = facade.getAllCategories();
        ArrayList<Material> MAL = facade.getAllMaterials();

        // Sessions
        HttpSession session = request.getSession();
        int width = (int) session.getAttribute("length");
        int length = (int) session.getAttribute("width");
        boolean rooftype = (boolean) session.getAttribute("roof");
        int angle = (int) session.getAttribute("angle");
        boolean shed = (boolean) session.getAttribute("shed");
        
        int skurW = 210;
        int skurL = 360;
        
        if (shed == false)
        {
            skurW = 0;
            skurL = 0;
        }

        result.Calculator cl = new result.Calculator();
        if (rooftype == true) {
            cl.calculateResultLifted(MAL, length, width, angle, shed, skurW, skurL);
        } else {
            cl.calculateResultFlat(MAL, length, width, shed, skurW, skurL);
        }

        // setter arraylisternes attributer
        request.setAttribute("allC", CAL);
        request.setAttribute("allM", MAL);

        // henviser til printList siden
        RequestDispatcher rd = request.getRequestDispatcher("/printList.jsp");
        rd.forward(request, response);
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
