package controller;

import beans.*;
import static controller.controller.*;
import java.io.IOException;
import java.text.*;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Roy Scheerens
 */
public class klantController extends baseController
{
    public klantController()
    {
        super("klantLeningen.jsp");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods. s
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        String state = request.getParameter("state");
        state = (state == null) ? "" : state;

        Persoon persoon = this.setSessionPersoon(request);

        if (state.equals("gegevensAanpassing"))
        {
            int postcode;
            
            try
            {
                postcode = Integer.parseInt(request.getParameter("postcode"));
            }
            catch (NumberFormatException ex)
            {
                postcode = persoon.getKlant().getAnr().getPostcode();
            }

            localBean.VeranderKlantGegevens(persoon, request.getParameter("pvoornaam"), request.getParameter("pachternaam"), request.getParameter("straatnaam"), request.getParameter("straatnummer"), postcode);
        }

        this.forwardToDefaultPage(request, response);
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
