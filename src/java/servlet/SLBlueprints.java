/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import calculator.LiftedRoof;
import facade.Facade;
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
 * @author alexander
 */
@WebServlet(name = "SLBlueprints", urlPatterns = {"/SLBlueprints"})
public class SLBlueprints extends HttpServlet {

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
        
        //Getting length and width from input.jsp
        int length = Integer.parseInt(request.getParameter("ddLength"));
        int width = Integer.parseInt(request.getParameter("ddWidth"));
        int angle = Integer.parseInt(request.getParameter("angle"));
        
        //Session sets
        
        
        Facade facade = new Facade();
        
        boolean rejsning;
        String roof = "rejst";
        if (roof.equalsIgnoreCase(request.getParameter("ddRoof")))
            rejsning = true;
        else
            rejsning = false;
        
        // TODO: Get roof height from Martin
        int roofHeight = (int) Math.round(LiftedRoof.hypotenuse(length, angle));
        
        boolean shed;
        String shedString = "yes";
        if (shedString.equalsIgnoreCase(request.getParameter("choice")))
            shed = true;
        else
            shed = false;
        
        
        //create Sessions
        HttpSession session = request.getSession();
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("roof", rejsning);
        session.setAttribute("angle", angle);
        session.setAttribute("shed", shed);
        
        
        
        // Total width will change if a shed is chosen
        int totalWidth = width;
        
        // Adding shed and changeing total width to fit a shed
        if(shed == true) {
            totalWidth += 220;
            String shedOutline = facade.shedOutline(length, totalWidth, rejsning);
            request.setAttribute("shedOutline", shedOutline);
            String shedStolper = facade.shedStolper(length, totalWidth, rejsning);
            request.setAttribute("shedStolper", shedStolper);
            ArrayList<String> shedSide = facade.shedSide(totalWidth, rejsning, roofHeight);
            request.setAttribute("shedSide", shedSide);
            
        }
        
        String outline = facade.outlineTop(length, totalWidth);
        request.setAttribute("outline", outline);
        
        
        if (rejsning == true) {
            // *** TOP ***
            // Creating stem
            String stem = facade.stem(length, totalWidth);
            request.setAttribute("stem", stem);
            // Creating taglaegter up 
            ArrayList<String> tlUp = facade.taglaegteUp(length, totalWidth);
            request.setAttribute("tlUp", tlUp);
            // Creating taglaegter down
            ArrayList<String> tlDown = facade.taglaegteDown(length, totalWidth);
            request.setAttribute("tlDown", tlDown);
            // Creating spaer
            ArrayList<String> spaer = facade.createSpaerRejsning(length, totalWidth);
            request.setAttribute("spaer", spaer);
            // Creating the top bjaelke
            String bjaelkeTop = facade.bjaelkeTopRejsning(totalWidth);
            request.setAttribute("bjaelkeTop", bjaelkeTop);
            // Creating the bottom bjaelke
            String bjaelkeBund = facade.bjaelkeBottomRejsning(totalWidth, length);
            request.setAttribute("bjaelkeBund", bjaelkeBund);
            // Creating top posts
            ArrayList<String> postsTop = facade.postsTop(width, rejsning, shed);
            request.setAttribute("postsTop", postsTop);
            // Creating bottom posts
            ArrayList<String> postsBottom = facade.postsBottom(length, width, rejsning, shed); 
            request.setAttribute("postsBottom", postsBottom);
            
            // *** SIDE ***
            
            ArrayList<String> posts = facade.supportPosts(width, rejsning, shed, roofHeight);
            request.setAttribute("supportPosts", posts);
            ArrayList<String> roofBoards = facade.roofboards(totalWidth, roofHeight);
            request.setAttribute("roofBoards", roofBoards);
            String roofHorizontal = facade.roofHorizontal(totalWidth, roofHeight);
            request.setAttribute("roofHorizontal", roofHorizontal);
            String roofEnds = facade.roofEnds(totalWidth, roofHeight);
            request.setAttribute("roofEnds", roofEnds);
            
            
        }
        else {
            // *** TOP ***
            // Creating vindkryds
            String vindkryds = facade.vindkryds(length, width);
            request.setAttribute("vindkryds", vindkryds);
            ArrayList<String> spaer = facade.createSpaerFlat(length, totalWidth);
            request.setAttribute("spaer", spaer);
            // Creating the top bjaelke
            String bjaelkeTop = facade.bjaelkeTopFlat(totalWidth);
            request.setAttribute("bjaelkeTop", bjaelkeTop);
            // Creating the bottom bjaelke
            String bjaelkeBund = facade.bjaelkeBottomFlat(totalWidth, length);
            request.setAttribute("bjaelkeBund", bjaelkeBund);
            // Creating top posts
            ArrayList<String> postsTop = facade.postsTop(width, rejsning, shed);
            request.setAttribute("postsTop", postsTop);
            // Creating bottom posts
            ArrayList<String> postsBottom = facade.postsBottom(length, width, rejsning, shed); 
            request.setAttribute("postsBottom", postsBottom);
            
            // *** SIDE ***
            String sideFlatRoof = facade.sideFlatRoof(totalWidth);
            request.setAttribute("sideFlatRoof", sideFlatRoof);
            String sideFlatRoof2 = facade.sideFlatRoof2(totalWidth);
            request.setAttribute("sideFlatRoof2", sideFlatRoof2);
            ArrayList<String> posts = facade.supportPosts(width, rejsning, shed, roofHeight);
            request.setAttribute("supportPosts", posts);
        }
        
        ArrayList<String> measurementsSide = facade.getMeasurementsSide();
        ArrayList<String> measurementsTop = facade.getMeasurementsTop();
        
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
