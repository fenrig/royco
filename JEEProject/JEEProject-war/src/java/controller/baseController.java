/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import beans.Persoon;
import beans.localStatelessBeanLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fenrig
 */
public class baseController extends HttpServlet
{
    @EJB
    protected localStatelessBeanLocal localBean;
    protected String defaultForwardPage;
    
    protected void setDefaultForwardPage(String defaultforwardpage){
        this.defaultForwardPage = defaultforwardpage;
    }
    
    public baseController(String defaultforwardpage){
        this.setDefaultForwardPage(defaultforwardpage);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {    
    }
    
    protected void forwardToDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        baseController.forwardPage(this.defaultForwardPage, request, response);
    }

    public static void forwardPage(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher(response.encodeURL(page)).forward(request, response);
    }

    public static void redirectPage(String page, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendRedirect(response.encodeURL(page));
    }
    
    protected Persoon setSessionPersoon(HttpServletRequest request){
        HttpSession session = request.getSession();
        Persoon ret = localBean.getPersoon(request.getRemoteUser());
        session.setAttribute("persoon", ret);
        return ret;
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
