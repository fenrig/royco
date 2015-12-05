package beans;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Roy Scheerens
 */
@Entity
@Table(name = "Klant")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Klant.findAll", query = "SELECT k FROM Klant k"),
    @NamedQuery(name = "Klant.findByKnr", query = "SELECT k FROM Klant k WHERE k.knr = :knr"),
    @NamedQuery(name = "Klant.findByFnr", query = "SELECT k FROM Klant k WHERE k.fnr = :fnr")
})
public class Klant implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "knr")
    private Integer knr;
    @JoinColumn(name = "pnr", referencedColumnName = "pnr")
    @OneToOne(optional = false)
    private Persoon pnr;
    @JoinColumn(name = "fnr", referencedColumnName = "fnr")
    @ManyToOne(optional = false)
    private Filiaal fnr;
    @JoinColumn(name = "anr", referencedColumnName = "anr")
    @ManyToOne(optional = false)
    private Adres anr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "knr")
    private List<Lening> leningList;

    public Klant()
    {
    }

    public Klant(Integer knr)
    {
        this.knr = knr;
    }

    public Integer getKnr()
    {
        return knr;
    }

    public void setKnr(Integer knr)
    {
        this.knr = knr;
    }

    public Persoon getPnr()
    {
        return pnr;
    }

    public void setPnr(Persoon pnr)
    {
        this.pnr = pnr;
    }

    public Filiaal getFnr()
    {
        return fnr;
    }

    public void setFnr(Filiaal fnr)
    {
        this.fnr = fnr;
    }

    public Adres getAnr()
    {
        return anr;
    }

    public void setAnr(Adres anr)
    {
        this.anr = anr;
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
        hash += (knr != null ? knr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klant))
        {
            return false;
        }
        Klant other = (Klant)object;
        if ((this.knr == null && other.knr != null) || (this.knr != null && !this.knr.equals(other.knr)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "beans.Klant[ knr=" + knr + " ]";
    }
    
}
