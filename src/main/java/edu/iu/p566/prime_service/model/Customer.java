package edu.iu.p566.prime_service.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table

@Entity

public class Customer {
    @Id
    private String username;
    private String password;

    public Customer(){

    }
    public Customer(String username,String password){
        this.password=password;
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
