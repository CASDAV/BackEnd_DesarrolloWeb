package com.backend.projectodesarrolloweb.laesquinadigital.dtos;

import java.util.Date;

public class UserDTO {
    
    protected Long id;

    protected String firstName;

    protected String lastName;

    protected Date birthDate;

    protected String email;

    protected String password;

    protected String  userType;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, Date birthDate, String email, String password,
            String userType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }


    public UserDTO(String firstName, String lastName, Date birthDate, String email, String password, String userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    
}
