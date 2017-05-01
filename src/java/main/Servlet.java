/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import blueprints.GenerateBlueprints;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexander
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

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
        
        //Getting height and width from input.jsp
        int height = Integer.parseInt(request.getParameter("height"));
        int width = Integer.parseInt(request.getParameter("width"));
        
        blueprints.GenerateBlueprints gb = new blueprints.GenerateBlueprints();
       
        //Width and height is switched because it's going to be sideways
        ArrayList<String> spærList = gb.createSpær(height, width);
        
        String midTop = gb.midTop(width,height);
        String midBottom = gb.midBottom(width,height);
        
        request.setAttribute("height", height);
        request.setAttribute("width", width);
        request.setAttribute("spær", spærList);
        //*Height becomes width*
        request.setAttribute("bjælkeBund", (height + 100) - 30);
        request.setAttribute("midTop", midTop);
        //*Width becomes height*
        request.setAttribute("stolpeXBack", (width + 100) - 50);
        request.setAttribute("midBottom", midBottom);
         
        ArrayList<String> spær = gb.createSpær(height, width);
        String sideFlatRoof = gb.sideFlatRoof(width);
        String sideFlatRoof2 = gb.sideFlatRoof2(width);
        ArrayList<String> posts = gb.supportPosts(width, height);
        

        request.setAttribute("spær", spær);
        request.setAttribute("bjælkeBund", width - 30);
        request.setAttribute("sideFlatRoof", sideFlatRoof);
        request.setAttribute("sideFlatRoof2", sideFlatRoof2);
        request.setAttribute("supportPosts", posts);
        
        RequestDispatcher rd = request.getRequestDispatcher("/blueprints.jsp");
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
