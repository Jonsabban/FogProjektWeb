/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classes.Category;
import classes.Material;
import data.DataAccessObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vfgya_000
 */
@WebServlet(name = "SLPrint", urlPatterns =
{
    "/SLPrint"
})
public class SLPrint extends HttpServlet
{

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
            throws ServletException, IOException
    {
        data.DataAccessObject dao = new data.ImplDataAccess();

        // T = træ, TT = træ og tagplader, TP = tagpakken, BS = beslag og Skruer
        ArrayList<Material> getTMaterials = dao.getALlMaterialsByCatId(1);
        ArrayList<Material> getTTMaterials = dao.getALlMaterialsByCatId(2);
        ArrayList<Material> getTPMaterials = dao.getALlMaterialsByCatId(3);
        ArrayList<Material> getBSMaterials = dao.getALlMaterialsByCatId(4);

        // setter deres parameter
        request.setAttribute("Tmaterials", getTMaterials);
        request.setAttribute("TTmaterials", getTTMaterials);
        request.setAttribute("TPmaterials", getTPMaterials);
        request.setAttribute("BSmaterials", getBSMaterials);

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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}