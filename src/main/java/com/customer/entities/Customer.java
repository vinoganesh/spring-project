package com.cust.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "hexa_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;
    @NotBlank(message = "Location cannot be blank")
    private String location;
    @NotBlank(message = "Email cannot be blank")
    @Email
    private String email;
    
    public Customer() {
    }
    
    public Customer(Long cid, String firstName, String lastName, String location, String email) {
        this.cid = cid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.email = email;
    }
    public Long getCid() {
        return cid;
    }
    public void setCid(Long cid) {
        this.cid = cid;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer [cid=" + cid + ", firstName=" + firstName + ", lastName=" + lastName + ", location=" + location
                + ", email=" + email + "]";
    }
    
}
