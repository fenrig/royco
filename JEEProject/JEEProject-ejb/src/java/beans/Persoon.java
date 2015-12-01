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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "Persoon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persoon.findAll", query = "SELECT p FROM Persoon p"),
    @NamedQuery(name = "Persoon.findByPnr", query = "SELECT p FROM Persoon p WHERE p.pnr = :pnr"),
    @NamedQuery(name = "Persoon.findByPvoornaam", query = "SELECT p FROM Persoon p WHERE p.pvoornaam = :pvoornaam"),
    @NamedQuery(name = "Persoon.findByPachternaam", query = "SELECT p FROM Persoon p WHERE p.pachternaam = :pachternaam"),
    @NamedQuery(name = "Persoon.findByUsername", query = "SELECT p FROM Persoon p WHERE p.username = :username"),
    @NamedQuery(name = "Persoon.findByUserpass", query = "SELECT p FROM Persoon p WHERE p.userpass = :userpass"),
    @NamedQuery(name = "Persoon.findByUsergroup", query = "SELECT p FROM Persoon p WHERE p.usergroup = :usergroup")})
public class Persoon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pnr")
    private Integer pnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "pvoornaam")
    private String pvoornaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "pachternaam")
    private String pachternaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "userpass")
    private String userpass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usergroup")
    private String usergroup;

    public Persoon() {
    }

    public Persoon(Integer pnr) {
        this.pnr = pnr;
    }

    public Persoon(Integer pnr, String pvoornaam, String pachternaam, String username, String userpass, String usergroup) {
        this.pnr = pnr;
        this.pvoornaam = pvoornaam;
        this.pachternaam = pachternaam;
        this.username = username;
        this.userpass = userpass;
        this.usergroup = usergroup;
    }

    public Integer getPnr() {
        return pnr;
    }

    public void setPnr(Integer pnr) {
        this.pnr = pnr;
    }

    public String getPvoornaam() {
        return pvoornaam;
    }

    public void setPvoornaam(String pvoornaam) {
        this.pvoornaam = pvoornaam;
    }

    public String getPachternaam() {
        return pachternaam;
    }

    public void setPachternaam(String pachternaam) {
        this.pachternaam = pachternaam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pnr != null ? pnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persoon)) {
            return false;
        }
        Persoon other = (Persoon) object;
        if ((this.pnr == null && other.pnr != null) || (this.pnr != null && !this.pnr.equals(other.pnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Persoon[ pnr=" + pnr + " ]";
    }
    
}
