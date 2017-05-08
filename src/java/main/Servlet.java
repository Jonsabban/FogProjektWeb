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

        request.setAttribute("height", height);
        request.setAttribute("width", width);
        
        String outline = gb.outlineTop(height, width);
        request.setAttribute("outline", outline);
        
        // TODO: get boolean input from input.jsp
        boolean rejsning = false;
        // TODO: get boolean input from input.jsp
        boolean skur = false;
        // Total width will change if a skur is chosen
        int totalWidth = width;
        
//        if(skur = true) {
//              String skurOutline = gb.skurOutline(height, totalWidth); 
//        }
        // Top
        if (rejsning == true) {
            // Creating stem
            String stem = gb.stem(height, width);
            request.setAttribute("stem", stem);
            // Creating taglaegter up 
            ArrayList<String> tlUp = gb.taglaegteUp(height, width);
            request.setAttribute("tlUp", tlUp);
            // Creating taglaegter down
            ArrayList<String> tlDown = gb.taglaegteDown(height, width);
            request.setAttribute("tlDown", tlDown);
            // Creating spaer
            ArrayList<String> spaer = gb.createSpaerRejsning(height, width);
            request.setAttribute("spaer", spaer);
            // Creating the top bjaelke
            String bjaelkeTop = gb.bjaelkeTopRejsning(width);
            request.setAttribute("bjaelkeTop", bjaelkeTop);
            // Creating the bottom bjaelke
            String bjaelkeBund = gb.bjaelkeBottomRejsning(width, height);
            request.setAttribute("bjaelkeBund", bjaelkeBund);
            // Creating top stolper
            ArrayList<String> stolperTop = gb.stolperTop(width, rejsning);
            request.setAttribute("stolperTop", stolperTop);
            // Creating bottom stolper
            ArrayList<String> stolperBottom = gb.stolperBottom(height, width, rejsning); 
            request.setAttribute("stolperBottom", stolperBottom);
        }
        else {
            // Creating vindkryds
            String vindkryds = gb.vindkryds(height, width);
            request.setAttribute("vindkryds", vindkryds);
            ArrayList<String> spaer = gb.createSpaerFlat(height, width);
            request.setAttribute("spaer", spaer);
            // Creating the top bjaelke
            String bjaelkeTop = gb.bjaelkeTopFlat(width);
            request.setAttribute("bjaelkeTop", bjaelkeTop);
            // Creating the bottom bjaelke
            String bjaelkeBund = gb.bjaelkeBottomFlat(width, height);
            request.setAttribute("bjaelkeBund", bjaelkeBund);
            // Creating top stolper
            ArrayList<String> stolperTop = gb.stolperTop(width, rejsning);
            request.setAttribute("stolperTop", stolperTop);
            // Creating bottom stolper
            ArrayList<String> stolperBottom = gb.stolperBottom(height, width, rejsning); 
            request.setAttribute("stolperBottom", stolperBottom);
        }
        
        //Side
        String sideFlatRoof = gb.sideFlatRoof(width);
        String sideFlatRoof2 = gb.sideFlatRoof2(width);
        ArrayList<String> posts = gb.supportPosts(width, height);
        ArrayList<String> measurementsSide = gb.getMeasurementsSide();
        ArrayList<String> measurementsTop = gb.getMeasurementsTop();
        
        request.setAttribute("sideFlatRoof", sideFlatRoof);
        request.setAttribute("sideFlatRoof2", sideFlatRoof2);
        request.setAttribute("supportPosts", posts);
        request.setAttribute("measurementsSide", measurementsSide);
        request.setAttribute("measurementsTop", measurementsTop);
        
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
