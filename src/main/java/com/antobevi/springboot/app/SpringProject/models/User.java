package com.antobevi.springboot.app.SpringProject.models;

// La idea de esta clase es que no este acoplada a ningún framework o componente externo
public class User {
    private String name;
    private String surname;
    private String email;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() { return email; }

}
