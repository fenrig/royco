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
@Table(name = "Adres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a"),
    @NamedQuery(name = "Adres.findByAnr", query = "SELECT a FROM Adres a WHERE a.anr = :anr"),
    @NamedQuery(name = "Adres.findByStraatnaam", query = "SELECT a FROM Adres a WHERE a.straatnaam = :straatnaam"),
    @NamedQuery(name = "Adres.findByStraatnr", query = "SELECT a FROM Adres a WHERE a.straatnr = :straatnr"),
    @NamedQuery(name = "Adres.findByPostcode", query = "SELECT a FROM Adres a WHERE a.postcode = :postcode")})
public class Adres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "anr")
    private Integer anr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "straatnaam")
    private String straatnaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "straatnr")
    private String straatnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postcode")
    private int postcode;

    public Adres() {
    }

    public Adres(Integer anr) {
        this.anr = anr;
    }

    public Adres(Integer anr, String straatnaam, String straatnr, int postcode) {
        this.anr = anr;
        this.straatnaam = straatnaam;
        this.straatnr = straatnr;
        this.postcode = postcode;
    }

    public Integer getAnr() {
        return anr;
    }

    public void setAnr(Integer anr) {
        this.anr = anr;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public String getStraatnr() {
        return straatnr;
    }

    public void setStraatnr(String straatnr) {
        this.straatnr = straatnr;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anr != null ? anr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if ((this.anr == null && other.anr != null) || (this.anr != null && !this.anr.equals(other.anr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Adres[ anr=" + anr + " ]";
    }
    
}
