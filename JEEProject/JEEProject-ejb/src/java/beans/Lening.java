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
@Table(name = "Lening")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Lening.findAll", query = "SELECT l FROM Lening l"),
    @NamedQuery(name = "Lening.findByLnr", query = "SELECT l FROM Lening l WHERE l.lnr = :lnr"),
    @NamedQuery(name = "Lening.findByInterest", query = "SELECT l FROM Lening l WHERE l.interest = :interest"),
    @NamedQuery(name = "Lening.findBySaldo", query = "SELECT l FROM Lening l WHERE l.saldo = :saldo")
})
public class Lening implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lnr")
    private Integer lnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interest")
    private double interest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private double saldo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lnr")
    private VasteLening vasteLening;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lnr")
    private VariabeleLening variabeleLening;
    @JoinColumn(name = "knr", referencedColumnName = "knr")
    @ManyToOne(optional = false)
    private Klant knr;
    @JoinColumn(name = "anr", referencedColumnName = "anr")
    @ManyToOne(optional = false)
    private Adres anr;

    public Lening()
    {
    }

    public Lening(Integer lnr)
    {
        this.lnr = lnr;
    }

    public Lening(Integer lnr, double interest, double saldo)
    {
        this.lnr = lnr;
        this.interest = interest;
        this.saldo = saldo;
    }

    public Integer getLnr()
    {
        return lnr;
    }

    public void setLnr(Integer lnr)
    {
        this.lnr = lnr;
    }

    public double getInterest()
    {
        return interest;
    }

    public void setInterest(double interest)
    {
        this.interest = interest;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public VasteLening getVasteLening()
    {
        return vasteLening;
    }

    public void setVasteLening(VasteLening vasteLening)
    {
        this.vasteLening = vasteLening;
    }

    public VariabeleLening getVariabeleLening()
    {
        return variabeleLening;
    }

    public void setVariabeleLening(VariabeleLening variabeleLening)
    {
        this.variabeleLening = variabeleLening;
    }

    public Klant getKnr()
    {
        return knr;
    }

    public void setKnr(Klant knr)
    {
        this.knr = knr;
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
        hash += (lnr != null ? lnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lening))
        {
            return false;
        }
        Lening other = (Lening)object;
        if ((this.lnr == null && other.lnr != null) || (this.lnr != null && !this.lnr.equals(other.lnr)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "beans.Lening[ lnr=" + lnr + " ]";
    }
    
}
