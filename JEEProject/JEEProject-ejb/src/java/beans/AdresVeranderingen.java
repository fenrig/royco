package beans;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Roy Scheerens
 */
@Entity
@Table(name = "AdresVeranderingen")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "AdresVeranderingen.findAll", query = "SELECT a FROM AdresVeranderingen a"),
    @NamedQuery(name = "AdresVeranderingen.findByPnr", query = "SELECT a FROM AdresVeranderingen a WHERE a.pnr = :pnr")
})
public class AdresVeranderingen implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pnr")
    private Integer pnr;
    @JoinColumn(name = "pnr", referencedColumnName = "pnr", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persoon persoon;
    @JoinColumn(name = "anr", referencedColumnName = "anr")
    @OneToOne(optional = false)
    private Adres anr;

    public AdresVeranderingen()
    {
    }

    public AdresVeranderingen(Integer pnr)
    {
        this.pnr = pnr;
    }

    public Integer getPnr()
    {
        return pnr;
    }

    public void setPnr(Integer pnr)
    {
        this.pnr = pnr;
    }

    public Persoon getPersoon()
    {
        return persoon;
    }

    public void setPersoon(Persoon persoon)
    {
        this.persoon = persoon;
    }

    public Adres getAnr()
    {
        return anr;
    }

    public void setAnr(Adres anr)
    {
        this.anr = anr;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (pnr != null ? pnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdresVeranderingen))
        {
            return false;
        }
        AdresVeranderingen other = (AdresVeranderingen)object;
        if ((this.pnr == null && other.pnr != null) || (this.pnr != null && !this.pnr.equals(other.pnr)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "beans.AdresVeranderingen[ pnr=" + pnr + " ]";
    }
    
}
