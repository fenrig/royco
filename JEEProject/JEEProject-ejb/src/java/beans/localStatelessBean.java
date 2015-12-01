/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author student
 */
@Stateless
public class localStatelessBean implements localStatelessBeanLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Persoon getPersoon(String pUserNaam) {
        return (Persoon)em.createNamedQuery("Persoon.findByUsername").setParameter("username", pUserNaam).getSingleResult();
    }
    
    @Override
    public Klant getKlant(Persoon persoon) {
        return (Klant)em.createNamedQuery("Klant.findByPnr").setParameter("pnr", persoon.getPnr()).getSingleResult();
    }
}
