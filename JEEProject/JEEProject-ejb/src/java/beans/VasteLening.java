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
@Table(name = "Vaste Lening")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VasteLening.findAll", query = "SELECT v FROM VasteLening v"),
    @NamedQuery(name = "VasteLening.findByVastnr", query = "SELECT v FROM VasteLening v WHERE v.vastnr = :vastnr"),
    @NamedQuery(name = "VasteLening.findByLnr", query = "SELECT v FROM VasteLening v WHERE v.lnr = :lnr")})
public class VasteLening implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vastnr")
    private Integer vastnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lnr")
    private int lnr;

    public VasteLening() {
    }

    public VasteLening(Integer vastnr) {
        this.vastnr = vastnr;
    }

    public VasteLening(Integer vastnr, int lnr) {
        this.vastnr = vastnr;
        this.lnr = lnr;
    }

    public Integer getVastnr() {
        return vastnr;
    }

    public void setVastnr(Integer vastnr) {
        this.vastnr = vastnr;
    }

    public int getLnr() {
        return lnr;
    }

    public void setLnr(int lnr) {
        this.lnr = lnr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vastnr != null ? vastnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VasteLening)) {
            return false;
        }
        VasteLening other = (VasteLening) object;
        if ((this.vastnr == null && other.vastnr != null) || (this.vastnr != null && !this.vastnr.equals(other.vastnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.VasteLening[ vastnr=" + vastnr + " ]";
    }
    
}
