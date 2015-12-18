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
    
    public Persoon addPersoon(Persoon pers) throws validationException, notuniqueException;
    public void removePersoon(Persoon pers);
    
    public Klant addKlant(Klant klant) throws validationException;
    public Klant getKlant(int knr);
    public void removeKlant(Klant klant);
    
    public VasteLening leningToevoegen(Lening lening, VasteLening vaslening);
    public VariabeleLening leningToevoegen(Lening lening, VariabeleLening varlening);
    
}
