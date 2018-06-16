/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "system")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "System.findAll", query = "SELECT s FROM System s")
    , @NamedQuery(name = "System.findBySystemId", query = "SELECT s FROM System s WHERE s.systemId = :systemId")})
public class System implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SYSTEM_ID")
    private String systemId;
    @OneToMany(mappedBy = "systemId")
    private List<Student> studentList;
    @OneToMany(mappedBy = "systemId")
    private List<Admin> adminList;
    @OneToMany(mappedBy = "systemId")
    private List<Course> courseList;

    public System() {
    }

    public System(String systemId) {
        this.systemId = systemId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @XmlTransient
    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemId != null ? systemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof System)) {
            return false;
        }
        System other = (System) object;
        if ((this.systemId == null && other.systemId != null) || (this.systemId != null && !this.systemId.equals(other.systemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.System[ systemId=" + systemId + " ]";
    }
    
}
