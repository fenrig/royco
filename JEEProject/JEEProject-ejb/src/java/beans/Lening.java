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
@Table(name = "Lening")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lening.findAll", query = "SELECT l FROM Lening l"),
    @NamedQuery(name = "Lening.findByLnr", query = "SELECT l FROM Lening l WHERE l.lnr = :lnr"),
    @NamedQuery(name = "Lening.findByAnr", query = "SELECT l FROM Lening l WHERE l.anr = :anr"),
    @NamedQuery(name = "Lening.findByKnr", query = "SELECT l FROM Lening l WHERE l.knr = :knr"),
    @NamedQuery(name = "Lening.findByInterest", query = "SELECT l FROM Lening l WHERE l.interest = :interest"),
    @NamedQuery(name = "Lening.findBySaldo", query = "SELECT l FROM Lening l WHERE l.saldo = :saldo")})
public class Lening implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lnr")
    private Integer lnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anr")
    private int anr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "knr")
    private int knr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interest")
    private double interest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private double saldo;

    public Lening() {
    }

    public Lening(Integer lnr) {
        this.lnr = lnr;
    }

    public Lening(Integer lnr, int anr, int knr, double interest, double saldo) {
        this.lnr = lnr;
        this.anr = anr;
        this.knr = knr;
        this.interest = interest;
        this.saldo = saldo;
    }

    public Integer getLnr() {
        return lnr;
    }

    public void setLnr(Integer lnr) {
        this.lnr = lnr;
    }

    public int getAnr() {
        return anr;
    }

    public void setAnr(int anr) {
        this.anr = anr;
    }

    public int getKnr() {
        return knr;
    }

    public void setKnr(int knr) {
        this.knr = knr;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lnr != null ? lnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lening)) {
            return false;
        }
        Lening other = (Lening) object;
        if ((this.lnr == null && other.lnr != null) || (this.lnr != null && !this.lnr.equals(other.lnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Lening[ lnr=" + lnr + " ]";
    }
    
}
