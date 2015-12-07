package controller;

import beans.*;
import static controller.controller.*;
import java.io.IOException;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author fenrig
 */
public class bankController extends HttpServlet
{
    @EJB
    private localStatelessBeanLocal localBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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

        session.setAttribute("persoon", localBean.getPersoon(request.getRemoteUser()));

        forwardPage("filiaalRekeningen.jsp", request, response);
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
//        processRequest(request, response);
       // request.getParameter("firstName");
        switch(request.getParameter("postOrigin")){
            case "klantToevoegen.jsp":
                klantToevoegen(request, response);
                break;
            default:
                forwardPage("ErrorPagina.jsp", request, response);
                break;
        }
    }
    
    protected void klantToevoegen(HttpServletRequest request, HttpServletResponse response){
        Adres adr = new Adres();
        String straatnaam = request.getParameter("straatnaam");
        String straatnr = request.getParameter("straatnr");
        int postcode = Integer.decode(request.getParameter("postcode"));
        // TODO: validatie in het model steken + validatie trachten te integreren
        adr.setStraatnaam(straatnaam);
        adr.setStraatnr(straatnr);
        adr.setPostcode(postcode);
        this.localBean.addAdres(adr);
        //-----------------
        Persoon pers = new Persoon();
        String pvoornaam = request.getParameter("pvoornaam");
        String pachternaam = request.getParameter("pachternaam");
        String username = request.getParameter("username");
        String userpass = "default";
        String usergroup = "klant";
        
        pers.setPvoornaam(pvoornaam);
        pers.setPachternaam(pachternaam);
        pers.setUsername(username);
        pers.setUserpass(userpass);
        pers.setUsergroup(usergroup);
        this.localBean.addPersoon(pers);
        
        //-------------------
        Klant klant = new Klant();
        klant.setAnr(adr);
        klant.setPnr(pers);
        klant.setFnr(((Persoon) request.getSession().getAttribute("persoon")).getWerknemer().getFnr());
        this.localBean.addKlant(klant);
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
