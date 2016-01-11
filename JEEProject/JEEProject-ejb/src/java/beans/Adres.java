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
@Table(name = "Adres")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a"),
    @NamedQuery(name = "Adres.findByAnr", query = "SELECT a FROM Adres a WHERE a.anr = :anr"),
    @NamedQuery(name = "Adres.findByStraatnaam", query = "SELECT a FROM Adres a WHERE a.straatnaam = :straatnaam"),
    @NamedQuery(name = "Adres.findByStraatnr", query = "SELECT a FROM Adres a WHERE a.straatnr = :straatnr"),
    @NamedQuery(name = "Adres.findByPostcode", query = "SELECT a FROM Adres a WHERE a.postcode = :postcode")
})
public class Adres implements Serializable
{
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "anr")
    private AdresVeranderingen adresVeranderingen;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "anr")
    private Integer anr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "straatnaam")
    private String straatnaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "straatnr")
    private String straatnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postcode")
    private int postcode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anr")
    private List<Klant> klantList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anr")
    private List<Lening> leningList;

    public Adres()
    {
    }

    public Adres(Integer anr)
    {
        this.anr = anr;
    }

    public Adres(Integer anr, String straatnaam, String straatnr, int postcode)
    {
        this.anr = anr;
        this.straatnaam = straatnaam;
        this.straatnr = straatnr;
        this.postcode = postcode;
    }

    public Integer getAnr()
    {
        return anr;
    }

    public void setAnr(Integer anr)
    {
        this.anr = anr;
    }

    public String getStraatnaam()
    {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam)
    {
        this.straatnaam = straatnaam;
    }

    public String getStraatnr()
    {
        return straatnr;
    }

    public void setStraatnr(String straatnr)
    {
        this.straatnr = straatnr;
    }

    public int getPostcode()
    {
        return postcode;
    }

    public void setPostcode(int postcode)
    {
        this.postcode = postcode;
    }

    @XmlTransient
    public List<Klant> getKlantList()
    {
        return klantList;
    }

    public void setKlantList(List<Klant> klantList)
    {
        this.klantList = klantList;
    }

    @XmlTransient
    public List<Lening> getLeningList()
    {
        return leningList;
    }

    public void setLeningList(List<Lening> leningList)
    {
        this.leningList = leningList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (anr != null ? anr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adres))
        {
            return false;
        }
        Adres other = (Adres)object;
        if ((this.anr == null && other.anr != null) || (this.anr != null && !this.anr.equals(other.anr)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return Integer.toString(this.postcode) + " " + this.straatnaam + " " + this.straatnr;
    }
    
    public String print(){
        return toString();
    }

    public AdresVeranderingen getAdresVeranderingen()
    {
        return adresVeranderingen;
    }

    public void setAdresVeranderingen(AdresVeranderingen adresVeranderingen)
    {
        this.adresVeranderingen = adresVeranderingen;
    }
    
}
