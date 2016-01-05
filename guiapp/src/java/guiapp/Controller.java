/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapp;

import beans.*;
import java.util.logging.*;
import javax.naming.*;

/**
 *
 * @author fenrig
 */
public class Controller
{
    RemoteBeanRemote remBean;

    public Controller()
    {
        remBean = lookupRemoteBeanRemote();
        mainUI gui = new mainUI(this);
        gui.setVisible(true);
    }

    public String werkIntrestvoetenbij()
    {
        return remBean.werkInterestVoetenBij();

        /*
         List<Lening> lenlist = this.localbean.getAllLeningen();
         System.out.print(lenlist);
         Double saldo;
         Double interest;
        
         for(Lening lenI : lenlist){
         saldo = lenI.getSaldo();
         interest = lenI.getInterest();
         ret += Integer.toString(lenI.getLnr()) + ": saldo: " + Double.toString(saldo) + "| interest: " + Double.toString(interest) + "\n";           
         saldo += saldo * interest;
         ret += "Nieuw saldo: " + Double.toString(saldo);
         lenI.setSaldo(saldo);
         localbean.modLening(lenI);
         } 
         */
    }

    private RemoteBeanRemote lookupRemoteBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (RemoteBeanRemote)c.lookup("java:comp/env/RemoteBean");
        }
        catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
