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
@Table(name = "Variabele Lening")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "VariabeleLening.findAll", query = "SELECT v FROM VariabeleLening v"),
    @NamedQuery(name = "VariabeleLening.findByVarnr", query = "SELECT v FROM VariabeleLening v WHERE v.varnr = :varnr"),
    @NamedQuery(name = "VariabeleLening.findByMaxrente", query = "SELECT v FROM VariabeleLening v WHERE v.maxrente = :maxrente")
})
public class VariabeleLening implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "varnr")
    private Integer varnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxrente")
    private double maxrente;
    @JoinColumn(name = "lnr", referencedColumnName = "lnr")
    @OneToOne(optional = false)
    private Lening lnr;

    public VariabeleLening()
    {
    }

    public VariabeleLening(Integer varnr)
    {
        this.varnr = varnr;
    }

    public VariabeleLening(Integer varnr, double maxrente)
    {
        this.varnr = varnr;
        this.maxrente = maxrente;
    }

    public Integer getVarnr()
    {
        return varnr;
    }

    public void setVarnr(Integer varnr)
    {
        this.varnr = varnr;
    }

    public double getMaxrente()
    {
        return maxrente;
    }

    public void setMaxrente(double maxrente)
    {
        this.maxrente = maxrente;
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
        hash += (varnr != null ? varnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VariabeleLening))
        {
            return false;
        }
        VariabeleLening other = (VariabeleLening)object;
        if ((this.varnr == null && other.varnr != null) || (this.varnr != null && !this.varnr.equals(other.varnr)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "beans.VariabeleLening[ varnr=" + varnr + " ]";
    }
    
}
