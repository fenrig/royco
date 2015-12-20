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
import javax.persistence.NoResultException;
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
        return (Persoon) em.createNamedQuery("Persoon.findByUsername").setParameter("username", pUserNaam).getSingleResult();
    }

    @Override
    public void VeranderKlantGegevens(Persoon persoon, String voornaam, String achternaam, String straatnaam, String straatnummer, int postcode)
    {
        Adres adres = persoon.getKlant().getAnr();

        persoon.setPachternaam(achternaam);
        persoon.setPvoornaam(voornaam);
        em.merge(persoon);

        if (!adres.getLeningList().isEmpty() && (adres.getPostcode() != postcode || !adres.getStraatnaam().equals(straatnaam) || !adres.getStraatnr().equals(straatnummer)))
        {
            //???
        }
        
        adres.setStraatnaam(straatnaam);
        adres.setStraatnr(straatnummer);
        adres.setPostcode(postcode);
        em.merge(adres);
    }

    @Override
    public void VeranderKlantPass(Persoon persoon, String password)
    {
        if (!password.isEmpty())
        {
            em.createNamedQuery("Persoon.updatePass").setParameter("userpass", password).setParameter("pnr", persoon.getPnr()).executeUpdate();
        }
    }

    @Override
    public Adres addAdres(Adres adr) throws validationException
    {
        int postcode = adr.getPostcode();
        String straatnr = adr.getStraatnr();
        String straatnaam = adr.getStraatnaam();
        if (postcode < 1000 || postcode > 9999)
        {
            throw new validationException("postcode");
        }
        if (straatnaam == null || straatnaam.isEmpty())
        {
            throw new validationException("straatnaam");
        }
        if (straatnr == null || straatnr.isEmpty())
        {
            throw new validationException("straatnr");
        }
        em.persist(adr);
        return adr;
    }

    @Override
    public void removeAdres(Adres adr)
    {
        Adres r = em.merge(adr);
        em.remove(r);
    }
    
    @Override
    public Adres getAdres(int anr){
        Adres ret;
        try{
            ret = (Adres) em.createNamedQuery("Adres.findByAnr").setParameter("anr", anr).getSingleResult();
        }catch(NoResultException e){
            ret = null;
        }
        return ret;
    }
    
    @Override
    public Adres getVoidAdres(){
        return this.getAdres(0);
    }

    @Override
    public Persoon addPersoon(Persoon pers) throws validationException, notuniqueException
    {
        String achternaam = pers.getPachternaam();
        String voornaam = pers.getPvoornaam();
        String username = pers.getUsername();
        String userpass = pers.getUserpass();
        String usergroup = pers.getUsergroup();

        if (voornaam == null || voornaam.isEmpty())
        {
            throw new validationException("voornaam");
        }
        if (achternaam == null || achternaam.isEmpty())
        {
            throw new validationException("achternaam");
        }
        if (username == null || username.isEmpty())
        {
            throw new validationException("username");
        }
        List<Persoon> perslist = em.createNamedQuery("Persoon.findByUsername").setParameter("username", username).getResultList();
        if (!perslist.isEmpty())
        {
            throw new notuniqueException("username");
        }
        if (userpass == null || userpass.isEmpty())
        {
            throw new validationException("userpass");
        }
        if (!usergroup.equals("klant") && !usergroup.equals("medewerker"))
        {
            throw new validationException("usergroup");
        }
        em.persist(pers);
        return pers;
    }

    @Override
    public void removePersoon(Persoon pers)
    {
        Persoon r = em.merge(pers);
        em.remove(r);
    }

    @Override
    public Klant addKlant(Klant klant) throws validationException
    {
        if (klant.getPnr() == null)
        {
            throw new validationException("pnr");
        }
        if (klant.getFnr() == null)
        {
            throw new validationException("fnr");
        }
        if (klant.getAnr() == null)
        {
            throw new validationException("anr");
        }
        em.persist(klant);
        return klant;
    }

    @Override
    public void removeKlant(Klant klant)
    {
        Klant r = em.merge(klant);
        em.remove(r);
    }
    
    @Override
    public Klant getKlant(int knr){
        Klant ret;
        try{
            ret = (Klant) em.createNamedQuery("Klant.findByKnr").setParameter("knr", knr).getSingleResult();
        }catch(NoResultException e){
            ret = null;
        }
        return ret;
    }
    
    @Override
    public VasteLening addLening(Lening lening, VasteLening vaslening) throws validationException{
        this.addLening(lening);
        vaslening.setLnr(lening);
        em.persist(lening);
        em.persist(vaslening);
        return vaslening;
    }
    
    @Override
    public VariabeleLening addLening(Lening lening, VariabeleLening varlening) throws validationException{
        this.addLening(lening);
        double maxinterestvoet = varlening.getMaxrente();
        if(maxinterestvoet <= 0 || maxinterestvoet >= 1){
            throw new validationException("maximum interestvoet");
        }
        if(maxinterestvoet < lening.getInterest()){
            throw new validationException("maximum interestvoet en toegepaste interest");
        }
        
        varlening.setLnr(lening);
        
        em.persist(lening);
        em.persist(varlening);
        return varlening;
    }
    
    private Lening addLening(Lening lening) throws validationException{
        double interestvoet;
        if(lening.getAnr() == null){
            lening.setAnr(this.getVoidAdres());
        }
        if(lening.getKnr() == null){
            throw new validationException("knr");
        }
        interestvoet = lening.getInterest();
        if(interestvoet <= 0 || interestvoet >= 1){
            throw new validationException("interestvoet");
        }
        if(lening.getSaldo() <= 0){
            throw new validationException("saldo");
        }
        return lening;
    }

}