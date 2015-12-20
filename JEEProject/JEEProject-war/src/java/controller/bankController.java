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
public class bankController extends baseController
{    
    public bankController(){
        super("filiaalRekeningen.jsp");
    }
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
        this.setSessionPersoon(request);

         this.forwardToDefaultPage(request, response);
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
                this.klantToevoegen(request, response);
                break;
            case "filiaalLeningToevoegen.jsp":
                this.leningToevoegen(request, response);
                break;
            default:
                forwardPage("ErrorPagina.jsp", request, response);
                return;
        }
    }
    
    protected void leningToevoegen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Adres adr = null;
        int knr;
        double saldo;
        String hypo;
        Klant klant;
        double interestvoet;
        double maxinterestvoet;
        
        int soortrek;
        
        try{
            knr = Integer.decode(request.getParameter("klantnr"));
            klant = this.localBean.getKlant(knr);
            if(klant == null){
                request.setAttribute("errorstring", "Deze klant bestaat niet!");
                forwardPage("bankError.jsp", request, response);
                return;
            }
        }catch(NumberFormatException e){
            String emsg = "U heeft de verkeerde klant (knr) gekozen";
            request.setAttribute("errorstring", emsg);
            request.setAttribute("exception", e);
            forwardPage("bankError.jsp", request, response);
            return;
        }
        try{
            saldo = Double.parseDouble(request.getParameter("leenbedrag"));
        }catch(NumberFormatException e){
            String emsg = "U heeft de het verkeerde leenbedrag gekozen";
            request.setAttribute("errorstring", emsg);
            request.setAttribute("exception", e);
            forwardPage("bankError.jsp", request, response);
            return;
        }
        try{
            interestvoet = Double.parseDouble(request.getParameter("interestvoet"));
        }catch(NumberFormatException e){
            String emsg = "U heeft de verkeerde interestvoet gekozen";
            request.setAttribute("errorstring", emsg);
            request.setAttribute("exception", e);
            forwardPage("bankError.jsp", request, response);
            return;
        }
        
        try{
            soortrek = Integer.decode(request.getParameter("soortrek"));
            System.out.print(soortrek);
            System.out.print(soortRekening.valueOf("VariabeleLening").hashCode());
            System.out.print(soortRekening.valueOf("VasteLening").hashCode());
        }catch(NumberFormatException e){
            String emsg = "U heeft geen hashcode meegegeven";
            request.setAttribute("errorstring", emsg);
            request.setAttribute("exception", e);
            forwardPage("bankError.jsp", request, response);
            return;
        }
        
        hypo = request.getParameter("hypothecaireLening");
        if(hypo != null && hypo.equals("on")){
            String adresF = request.getParameter("adres");
            if(adresF.equals("0")){
                adr = klant.getAnr();
            }else{
                adr = new Adres();
                String straatnaam = request.getParameter("straatnaam");
                String straatnr = request.getParameter("straatnr");
                int postcode = -9999;
                try{
                    postcode = Integer.decode(request.getParameter("postcode"));
                }catch(NumberFormatException e){
                        String emsg = "U heeft postcode verkeerd ingevuld";
                        request.setAttribute("errorstring", emsg);
                        request.setAttribute("exception", e);
                        forwardPage("bankError.jsp", request, response);
                        return;
                }
                adr.setStraatnaam(straatnaam);
                adr.setStraatnr(straatnr);
                adr.setPostcode(postcode);
                try{
                    this.localBean.addAdres(adr);
                }catch(validationException e){
                        String emsg = "U heeft " + e.getMessage() + " verkeerd ingevuld";
                        request.setAttribute("errorstring", emsg);
                        request.setAttribute("exception", e);
                        forwardPage("bankError.jsp", request, response);
                        return;
                }
            }
        }
        
        Lening len = new Lening();
        len.setAnr(adr);
        len.setKnr(klant);
        len.setInterest(interestvoet);
        len.setSaldo(saldo);
        
        if(soortRekening.valueOf("VariabeleLening").hashCode() == soortrek ){
            try{
                maxinterestvoet = Double.parseDouble(request.getParameter("maxinterestvoet"));
            }catch(NumberFormatException e){
                if(adr != null && ! adr.equals(klant.getAnr()))
                    this.localBean.removeAdres(adr);
                String emsg = "U heeft de verkeerde max interestvoet gekozen";
                request.setAttribute("errorstring", emsg);
                request.setAttribute("exception", e);
                forwardPage("bankError.jsp", request, response);
                return;
            }
            VariabeleLening varl = new VariabeleLening();
            varl.setMaxrente(maxinterestvoet);
            try{
                this.localBean.addLening(len, varl);
            }catch(validationException e){
                if(adr != null && ! adr.equals(klant.getAnr()))
                    this.localBean.removeAdres(adr);
                String emsg = "U heeft " + e.getMessage() + " verkeerd ingevuld";
                request.setAttribute("errorstring", emsg);
                request.setAttribute("exception", e);
                forwardPage("bankError.jsp", request, response);
                return;
            }
        }else if(soortRekening.valueOf("VasteLening").hashCode() == soortrek){
            VasteLening vasl = new VasteLening();
            try{
                this.localBean.addLening(len, vasl);
            }catch(validationException e){
                if(adr != null && ! adr.equals(klant.getAnr()))
                    this.localBean.removeAdres(adr);
                String emsg = "U heeft " + e.getMessage() + " verkeerd ingevuld";
                request.setAttribute("errorstring", emsg);
                request.setAttribute("exception", e);
                forwardPage("bankError.jsp", request, response);
                return;
            }
        }else{
            if(adr != null && ! adr.equals(klant.getAnr()))
                    this.localBean.removeAdres(adr);
            request.setAttribute("errorstring", "U heeft geen (juiste) lening gekozen");
            forwardPage("bankError.jsp", request, response);
            return;
        }
        
    }
    
    protected void klantToevoegen(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        Adres adr = new Adres();
        String straatnaam = request.getParameter("straatnaam");
        String straatnr = request.getParameter("straatnr");
        int postcode = -9999;
        try{
            postcode = Integer.decode(request.getParameter("postcode"));
        }catch(NumberFormatException e){
                String emsg = "U heeft postcode verkeerd ingevuld";
                request.setAttribute("errorstring", emsg);
                request.setAttribute("exception", e);
                forwardPage("bankError.jsp", request, response);
                return;
        }
        adr.setStraatnaam(straatnaam);
        adr.setStraatnr(straatnr);
        adr.setPostcode(postcode);
        
        try{
            this.localBean.addAdres(adr);
        }catch(validationException e){
                String emsg = "U heeft " + e.getMessage() + " verkeerd ingevuld";
                request.setAttribute("errorstring", emsg);
                request.setAttribute("exception", e);
                forwardPage("bankError.jsp", request, response);
                return;
        }
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
        
        try{
            this.localBean.addPersoon(pers);
        }catch(validationException e){
                this.localBean.removeAdres(adr);
                
                String emsg = "U heeft " + e.getMessage() + " verkeerd ingevuld";
                request.setAttribute("errorstring", emsg);
                request.setAttribute("exception", e);
                forwardPage("bankError.jsp", request, response);
                return;
        }catch(notuniqueException e){
                this.localBean.removeAdres(adr);
                
                String emsg = "De username die u heeft gekozen (" + e.getMessage() + ") is al reeds gebruikt";
                request.setAttribute("errorstring", emsg);
                request.setAttribute("exception", e);
                forwardPage("bankError.jsp", request, response);
                return;
        }
        //-------------------
        Klant klant = new Klant();
        klant.setAnr(adr);
        klant.setPnr(pers);
        klant.setFnr(((Persoon) request.getSession().getAttribute("persoon")).getWerknemer().getFnr());
        
        try{
            this.localBean.addKlant(klant);
        }catch(validationException e){
                this.localBean.removeAdres(adr);
                this.localBean.removePersoon(pers);
                
                String emsg = "U heeft " + e.getMessage() + " verkeerd ingevuld";
                request.setAttribute("errorstring", emsg);
                request.setAttribute("exception", e);
                forwardPage("bankError.jsp", request, response);
                return;
        }
        this.setSessionPersoon(request);
        this.forwardToDefaultPage(request, response);
    }

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
        String a = request.getParameter("a");
        if(a == null){
            processRequest(request, response);
            return;
        }else{
            switch(a){
                case "delUser":
                    klantVerwijderen(request, response);
                    break;
                default:
                    // TODO: add error
                    return;
            }
        }
        this.forwardToDefaultPage(request, response);
    }
    
    private void klantVerwijderen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int knr = Integer.decode(request.getParameter("knr"));
        Klant kla = this.localBean.getKlant(knr);
        if(kla != null){
            Werknemer werknemer = ((Persoon)request.getSession().getAttribute("persoon")).getWerknemer();
            if(kla.getFnr().equals(werknemer.getFnr())){
                if(kla.getLeningList().isEmpty()){
                    this.localBean.removeKlant(kla);
                    this.setSessionPersoon(request);
                }else{
                    Persoon klantpers = kla.getPnr();
                    request.setAttribute("errorstring", klantpers.getPachternaam() + " " +  klantpers.getPvoornaam() + " heeft nog openstaande rekeningen");
                    forwardPage("bankError.jsp", request, response);
                }
                
            }else{
                Persoon klantpers = kla.getPnr();
                request.setAttribute("errorstring", klantpers.getPachternaam() + " " +  klantpers.getPvoornaam() + " hoort niet bij uw filiaal (klant: " + kla.getFnr().getFnaam() + "| medewerker: " + werknemer.getFnr().getFnaam());
                forwardPage("bankError.jsp", request, response);

            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
