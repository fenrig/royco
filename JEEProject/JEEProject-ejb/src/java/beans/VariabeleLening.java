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
@Table(name = "Variabele Lening")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VariabeleLening.findAll", query = "SELECT v FROM VariabeleLening v"),
    @NamedQuery(name = "VariabeleLening.findByVarnr", query = "SELECT v FROM VariabeleLening v WHERE v.varnr = :varnr"),
    @NamedQuery(name = "VariabeleLening.findByLnr", query = "SELECT v FROM VariabeleLening v WHERE v.lnr = :lnr"),
    @NamedQuery(name = "VariabeleLening.findByMaxrente", query = "SELECT v FROM VariabeleLening v WHERE v.maxrente = :maxrente")})
public class VariabeleLening implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "varnr")
    private Integer varnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lnr")
    private int lnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxrente")
    private double maxrente;

    public VariabeleLening() {
    }

    public VariabeleLening(Integer varnr) {
        this.varnr = varnr;
    }

    public VariabeleLening(Integer varnr, int lnr, double maxrente) {
        this.varnr = varnr;
        this.lnr = lnr;
        this.maxrente = maxrente;
    }

    public Integer getVarnr() {
        return varnr;
    }

    public void setVarnr(Integer varnr) {
        this.varnr = varnr;
    }

    public int getLnr() {
        return lnr;
    }

    public void setLnr(int lnr) {
        this.lnr = lnr;
    }

    public double getMaxrente() {
        return maxrente;
    }

    public void setMaxrente(double maxrente) {
        this.maxrente = maxrente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (varnr != null ? varnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VariabeleLening)) {
            return false;
        }
        VariabeleLening other = (VariabeleLening) object;
        if ((this.varnr == null && other.varnr != null) || (this.varnr != null && !this.varnr.equals(other.varnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.VariabeleLening[ varnr=" + varnr + " ]";
    }
    
}
