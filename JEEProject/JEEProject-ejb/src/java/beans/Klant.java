/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "Klant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klant.findAll", query = "SELECT k FROM Klant k"),
    @NamedQuery(name = "Klant.findByKnr", query = "SELECT k FROM Klant k WHERE k.knr = :knr"),
    @NamedQuery(name = "Klant.findByPnr", query = "SELECT k FROM Klant k WHERE k.pnr = :pnr"),
    @NamedQuery(name = "Klant.findByFnr", query = "SELECT k FROM Klant k WHERE k.fnr = :fnr"),
    @NamedQuery(name = "Klant.findByAnr", query = "SELECT k FROM Klant k WHERE k.anr = :anr")})
public class Klant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "knr")
    private Integer knr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pnr")
    private int pnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fnr")
    private int fnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anr")
    private int anr;

    public Klant() {
    }

    public Klant(Integer knr) {
        this.knr = knr;
    }

    public Klant(Integer knr, int pnr, int fnr, int anr) {
        this.knr = knr;
        this.pnr = pnr;
        this.fnr = fnr;
        this.anr = anr;
    }

    public Integer getKnr() {
        return knr;
    }

    public void setKnr(Integer knr) {
        this.knr = knr;
    }

    public int getPnr() {
        return pnr;
    }

    public void setPnr(int pnr) {
        this.pnr = pnr;
    }

    public int getFnr() {
        return fnr;
    }

    public void setFnr(int fnr) {
        this.fnr = fnr;
    }

    public int getAnr() {
        return anr;
    }

    public void setAnr(int anr) {
        this.anr = anr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (knr != null ? knr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klant)) {
            return false;
        }
        Klant other = (Klant) object;
        if ((this.knr == null && other.knr != null) || (this.knr != null && !this.knr.equals(other.knr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Klant[ knr=" + knr + " ]";
    }
    
}
