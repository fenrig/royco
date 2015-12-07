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
    public List<Klant> getLeningenByFnr();
    public void VeranderKlantGegevens(Persoon persoon, String voornaam, String achternaam);
    public void VeranderKlantPass(Persoon persoon, String password);
}
