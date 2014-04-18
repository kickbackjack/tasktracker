/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tasktracker.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Jack
 */
@Entity
@Table(name = "user_account")
public class UserAccount implements Serializable {

    private Integer id;
    @NotNull
    private String name;
    @NotNull
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,6})$", message = "Email address given is invalid")
    private String email;
//    @NotNull
//    @Pattern(regexp = "^[_A-Za-z0-9-\\+]{5,32}$", message = "Password needs to between 5 and 32 characters long")
//    private String password;
    @NotNull
    private boolean active;
    @NotNull
    private String fullname;
    private String windowsName;
    private String unixName;

    public UserAccount() {
        active = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//    
//    @Column(name="password")
//    public String getPassword() {
//        return this.password;
//    }
//    
//    public void setPassword(String password) {
//        this.password = password;
//    }

    @Column(name = "windowsname")
    public String getWindowsName() {
        return windowsName;
    }

    public void setWindowsName(String windowsName) {
        this.windowsName = windowsName;
    }

    @Column(name = "unixname")
    public String getUnixName() {
        return unixName;
    }

    public void setUnixName(String unixName) {
        this.unixName = unixName;
    }

    @Column(name = "active")
    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Column(name = "fullname")
    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "UserAccount{" + "id=" + id + ", name=" + name + ", email=" + email + ", active=" + active + ", fullname=" + fullname + ", windowsName=" + windowsName + ", unixName=" + unixName + '}';
    }
}
