package com.antobevi.springboot.app.SpringProject.models;

// La idea de esta clase es que no este acoplada a ningún framework o componente externo
public class User {
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

}
