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
@Table(name = "Filiaal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filiaal.findAll", query = "SELECT f FROM Filiaal f"),
    @NamedQuery(name = "Filiaal.findByFnr", query = "SELECT f FROM Filiaal f WHERE f.fnr = :fnr"),
    @NamedQuery(name = "Filiaal.findByFnaam", query = "SELECT f FROM Filiaal f WHERE f.fnaam = :fnaam")})
public class Filiaal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fnr")
    private Integer fnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "fnaam")
    private String fnaam;

    public Filiaal() {
    }

    public Filiaal(Integer fnr) {
        this.fnr = fnr;
    }

    public Filiaal(Integer fnr, String fnaam) {
        this.fnr = fnr;
        this.fnaam = fnaam;
    }

    public Integer getFnr() {
        return fnr;
    }

    public void setFnr(Integer fnr) {
        this.fnr = fnr;
    }

    public String getFnaam() {
        return fnaam;
    }

    public void setFnaam(String fnaam) {
        this.fnaam = fnaam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fnr != null ? fnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filiaal)) {
            return false;
        }
        Filiaal other = (Filiaal) object;
        if ((this.fnr == null && other.fnr != null) || (this.fnr != null && !this.fnr.equals(other.fnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Filiaal[ fnr=" + fnr + " ]";
    }
    
}
