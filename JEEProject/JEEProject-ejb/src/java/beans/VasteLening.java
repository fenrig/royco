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
@Table(name = "Vaste Lening")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "VasteLening.findAll", query = "SELECT v FROM VasteLening v"),
    @NamedQuery(name = "VasteLening.findByVastnr", query = "SELECT v FROM VasteLening v WHERE v.vastnr = :vastnr")
})
public class VasteLening implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vastnr")
    private Integer vastnr;
    @JoinColumn(name = "lnr", referencedColumnName = "lnr")
    @OneToOne(optional = false)
    private Lening lnr;

    public VasteLening()
    {
    }

    public VasteLening(Integer vastnr)
    {
        this.vastnr = vastnr;
    }

    public Integer getVastnr()
    {
        return vastnr;
    }

    public void setVastnr(Integer vastnr)
    {
        this.vastnr = vastnr;
    }

    public Lening getLnr()
    {
        return lnr;
    }

    public void setLnr(Lening lnr)
    {
        this.lnr = lnr;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (vastnr != null ? vastnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VasteLening))
        {
            return false;
        }
        VasteLening other = (VasteLening)object;
        if ((this.vastnr == null && other.vastnr != null) || (this.vastnr != null && !this.vastnr.equals(other.vastnr)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "beans.VasteLening[ vastnr=" + vastnr + " ]";
    }
    
}
