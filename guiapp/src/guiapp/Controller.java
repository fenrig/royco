/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiapp;
import beans.Lening;
import javax.ejb.EJB;
import beans.*;
import java.util.List;
/**
 *
 * @author fenrig
 */
public class Controller {
    @EJB private static localStatelessBeanLocal localbean;
    public Controller(){
        mainUI gui = new mainUI(this);
        gui.setVisible(true);
    }
    
    public String werkIntrestvoetenbij(){
        List<Lening> lenlist = this.localbean.getAllLeningen();
        System.out.print(lenlist);
        Double saldo;
        Double interest;
        String ret = "";
        for(Lening lenI : lenlist){
            saldo = lenI.getSaldo();
            interest = lenI.getInterest();
            ret += Integer.toString(lenI.getLnr()) + ": saldo: " + Double.toString(saldo) + "| interest: " + Double.toString(interest) + "\n";           
            saldo += saldo * interest;
            ret += "Nieuw saldo: " + Double.toString(saldo);
            lenI.setSaldo(saldo);
            localbean.modLening(lenI);
        }
        return ret;
    }
   
}
