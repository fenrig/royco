/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.*;
import javax.ejb.Local;

/**
 *
 * @author student
 */
@Local
public interface localStatelessBeanLocal
{
    public Persoon getPersoon(String pUserNaam);
    public void VeranderKlantGegevens(Persoon persoon, String voornaam, String achternaam, String straatnaam, String straatnummer, int postcode);
    public void VeranderKlantPass(Persoon persoon, String password);
          
    public Adres addAdres(Adres adr) throws validationException;
    public void removeAdres(Adres adr);
    public Adres getAdres(int anr);
    public Adres getVoidAdres();
    
    public Persoon addPersoon(Persoon pers) throws validationException, notuniqueException;
    public void removePersoon(Persoon pers);
    
    public Klant addKlant(Klant klant) throws validationException;
    public Klant getKlant(int knr);
    public void removeKlant(Klant klant);
    
    public VasteLening addLening(Lening lening, VasteLening vaslening) throws validationException;
    public VariabeleLening addLening(Lening lening, VariabeleLening varlening) throws validationException;
    public Lening modLening(Lening lening);
    public Lening getLening(int lnr);
    public void removeLening(Lening lening);
    public List<Lening> getAllLeningen();
}
