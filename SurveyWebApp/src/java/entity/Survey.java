/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;

/**
 *
 * @author Josh
 */
@Entity
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private Date date;
    private String friendliness;
    private String speed;
    private String taste;
    private String cleanliness;
    private String likelihood;
  
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getFriendliness() {
        return friendliness;
    }

    public void setFriendliness(String friendliness) {
        this.friendliness = friendliness;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }

    public String getLikelihood() {
        return likelihood;
    }

    public void setLikelihood(String likelihood) {
        this.likelihood = likelihood;
    }

    

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Survey)) {
            return false;
        }
        Survey other = (Survey) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Survey[ id=" + id + " ]";
    }
    
}
