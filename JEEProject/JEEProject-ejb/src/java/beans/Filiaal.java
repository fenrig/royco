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
@Table(name = "Filiaal")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Filiaal.findAll", query = "SELECT f FROM Filiaal f"),
    @NamedQuery(name = "Filiaal.findByFnr", query = "SELECT f FROM Filiaal f WHERE f.fnr = :fnr"),
    @NamedQuery(name = "Filiaal.findByFnaam", query = "SELECT f FROM Filiaal f WHERE f.fnaam = :fnaam")
})
public class Filiaal implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fnr")
    private Integer fnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "fnaam")
    private String fnaam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fnr")
    private List<Klant> klantList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fnr")
    private List<Werknemer> werknemerList;

    public Filiaal()
    {
    }

    public Filiaal(Integer fnr)
    {
        this.fnr = fnr;
    }

    public Filiaal(Integer fnr, String fnaam)
    {
        this.fnr = fnr;
        this.fnaam = fnaam;
    }

    public Integer getFnr()
    {
        return fnr;
    }

    public void setFnr(Integer fnr)
    {
        this.fnr = fnr;
    }

    public String getFnaam()
    {
        return fnaam;
    }

    public void setFnaam(String fnaam)
    {
        this.fnaam = fnaam;
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
    public List<Werknemer> getWerknemerList()
    {
        return werknemerList;
    }

    public void setWerknemerList(List<Werknemer> werknemerList)
    {
        this.werknemerList = werknemerList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (fnr != null ? fnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filiaal))
        {
            return false;
        }
        Filiaal other = (Filiaal)object;
        if ((this.fnr == null && other.fnr != null) || (this.fnr != null && !this.fnr.equals(other.fnr)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "beans.Filiaal[ fnr=" + fnr + " ]";
    }
    
}
