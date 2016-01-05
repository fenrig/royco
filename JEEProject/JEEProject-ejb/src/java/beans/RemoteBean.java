/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.*;
import javax.ejb.*;

/**
 *
 * @author Roy Scheerens
 */
@Stateless
public class RemoteBean implements RemoteBeanRemote
{
    @EJB
    private localStatelessBeanLocal localStatelessBean;

    @Override
    public String werkInterestVoetenBij()
    {
        List<Lening> leningen = localStatelessBean.getAllLeningen();
        StringBuilder result = new StringBuilder();

        for (Lening lening : leningen)
        {
            double saldo = lening.getSaldo();
            double interest = lening.getInterest();
            double nieuw = saldo * (1 + interest);
            
            result.append("lening van ");
            result.append(lening.getKnr().getPnr().getPvoornaam());
            result.append(" ");
            result.append(lening.getKnr().getPnr().getPachternaam());
            result.append("; huidig saldo: ");
            result.append(saldo);
            result.append("; interest: ");
            result.append(interest);
            result.append("; nieuw saldo: ");
            result.append(nieuw);
            result.append("\n");
            
            lening.setSaldo(nieuw);
        }

        return result.toString();
    }
}
