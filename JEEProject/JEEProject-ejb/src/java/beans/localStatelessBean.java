/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.*;
import java.util.List;
import javax.annotation.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

/**
 *
 * @author student
 */
@Stateless
public class localStatelessBean implements localStatelessBeanLocal
{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Persoon getPersoon(String pUserNaam)
    {
        return (Persoon)em.createNamedQuery("Persoon.findByUsername").setParameter("username", pUserNaam).getSingleResult();
    }

    @Override
    public List<Klant> getLeningenByFnr()
    {
        List<Lening> leningenLijst;
        Persoon pers;
        Filiaal filObject = (Filiaal)em.createNamedQuery("Filiaal.findByFnr").setParameter("fnr", 1).getSingleResult();
        List<Klant> ret = (List)em.createNamedQuery("Klant.findByFnr").setParameter("fnr", filObject).getResultList();
        //^^dit is niet nodig, gebruik: pers.getWerknemer().getFnr().getKlantList();

        /*        for(Klant kI : ret){
         leningenLijst = (List)em.createNamedQuery("Lening.findByKnr").setParameter("knr", kI).getResultList();
         kI.setLeningList(leningenLijst);
         //           pers = (Persoon) em.createNamedQuery("Persoon.findByPnr").setParameter("pnr", kI.getPnr()).getSingleResult();
         //           kI.setPnr(pers);
         }
         */
        return ret;
    }

    @Override
    public void VeranderKlantGegevens(Persoon persoon, String voornaam, String achternaam)
    {
        em.createNamedQuery("Persoon.update").setParameter("pachternaam", achternaam).setParameter("pvoornaam", voornaam).setParameter("pnr", persoon.getPnr()).executeUpdate();
        persoon.setPachternaam(achternaam);
        persoon.setPvoornaam(voornaam);
    }

    @Override
    public void VeranderKlantPass(Persoon persoon, String password)
    {
        if (!password.isEmpty())
        {
            em.createNamedQuery("Persoon.updatePass").setParameter("userpass", password).setParameter("pnr", persoon.getPnr()).executeUpdate();
        }
    }

}
