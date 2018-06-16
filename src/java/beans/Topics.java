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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "topics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topics.findAll", query = "SELECT t FROM Topics t")
    , @NamedQuery(name = "Topics.findByTopicsId", query = "SELECT t FROM Topics t WHERE t.topicsId = :topicsId")
    , @NamedQuery(name = "Topics.findByTopicsName", query = "SELECT t FROM Topics t WHERE t.topicsName = :topicsName")})
public class Topics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOPICS_ID")
    private Integer topicsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TOPICS_NAME")
    private String topicsName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "TOPICS_CONTENT")
    private String topicsContent;
    @JoinColumn(name = "ADMIN_ID", referencedColumnName = "ADMIN_ID")
    @ManyToOne
    private Admin adminId;

    public Topics() {
    }

    public Topics(Integer topicsId) {
        this.topicsId = topicsId;
    }

    public Topics(Integer topicsId, String topicsName, String topicsContent) {
        this.topicsId = topicsId;
        this.topicsName = topicsName;
        this.topicsContent = topicsContent;
    }

    public Integer getTopicsId() {
        return topicsId;
    }

    public void setTopicsId(Integer topicsId) {
        this.topicsId = topicsId;
    }

    public String getTopicsName() {
        return topicsName;
    }

    public void setTopicsName(String topicsName) {
        this.topicsName = topicsName;
    }

    public String getTopicsContent() {
        return topicsContent;
    }

    public void setTopicsContent(String topicsContent) {
        this.topicsContent = topicsContent;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (topicsId != null ? topicsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topics)) {
            return false;
        }
        Topics other = (Topics) object;
        if ((this.topicsId == null && other.topicsId != null) || (this.topicsId != null && !this.topicsId.equals(other.topicsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Topics[ topicsId=" + topicsId + " ]";
    }
    
}
