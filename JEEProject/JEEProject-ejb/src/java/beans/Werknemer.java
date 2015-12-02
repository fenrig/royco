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
@Table(name = "Werknemer")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Werknemer.findAll", query = "SELECT w FROM Werknemer w"),
    @NamedQuery(name = "Werknemer.findByWnr", query = "SELECT w FROM Werknemer w WHERE w.wnr = :wnr")
})
public class Werknemer implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wnr")
    private Integer wnr;
    @JoinColumn(name = "fnr", referencedColumnName = "fnr")
    @ManyToOne(optional = false)
    private Filiaal fnr;
    @JoinColumn(name = "pnr", referencedColumnName = "pnr")
    @OneToOne(optional = false)
    private Persoon pnr;

    public Werknemer()
    {
    }

    public Werknemer(Integer wnr)
    {
        this.wnr = wnr;
    }

    public Integer getWnr()
    {
        return wnr;
    }

    public void setWnr(Integer wnr)
    {
        this.wnr = wnr;
    }

    public Filiaal getFnr()
    {
        return fnr;
    }

    public void setFnr(Filiaal fnr)
    {
        this.fnr = fnr;
    }

    public Persoon getPnr()
    {
        return pnr;
    }

    public void setPnr(Persoon pnr)
    {
        this.pnr = pnr;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (wnr != null ? wnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Werknemer))
        {
            return false;
        }
        Werknemer other = (Werknemer)object;
        if ((this.wnr == null && other.wnr != null) || (this.wnr != null && !this.wnr.equals(other.wnr)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "beans.Werknemer[ wnr=" + wnr + " ]";
    }
    
}
