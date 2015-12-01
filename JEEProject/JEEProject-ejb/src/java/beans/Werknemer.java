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
@Table(name = "Werknemer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Werknemer.findAll", query = "SELECT w FROM Werknemer w"),
    @NamedQuery(name = "Werknemer.findByWnr", query = "SELECT w FROM Werknemer w WHERE w.wnr = :wnr"),
    @NamedQuery(name = "Werknemer.findByPnr", query = "SELECT w FROM Werknemer w WHERE w.pnr = :pnr"),
    @NamedQuery(name = "Werknemer.findByFnr", query = "SELECT w FROM Werknemer w WHERE w.fnr = :fnr")})
public class Werknemer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wnr")
    private Integer wnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pnr")
    private int pnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fnr")
    private int fnr;

    public Werknemer() {
    }

    public Werknemer(Integer wnr) {
        this.wnr = wnr;
    }

    public Werknemer(Integer wnr, int pnr, int fnr) {
        this.wnr = wnr;
        this.pnr = pnr;
        this.fnr = fnr;
    }

    public Integer getWnr() {
        return wnr;
    }

    public void setWnr(Integer wnr) {
        this.wnr = wnr;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wnr != null ? wnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Werknemer)) {
            return false;
        }
        Werknemer other = (Werknemer) object;
        if ((this.wnr == null && other.wnr != null) || (this.wnr != null && !this.wnr.equals(other.wnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Werknemer[ wnr=" + wnr + " ]";
    }
    
}
