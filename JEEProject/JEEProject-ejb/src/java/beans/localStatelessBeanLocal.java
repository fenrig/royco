/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.math.BigDecimal;
import javax.ejb.Local;

/**
 *
 * @author student
 */
@Local
public interface localStatelessBeanLocal {

    public Persoon getPersoon(String pUserNaam);
    public Klant getKlant(Persoon persoon);
    
}